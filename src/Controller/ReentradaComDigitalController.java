package Controller;

import DAO.Conexao;
import DAO.ReentradaDigitalDocumentoDAO;
import Helper.ReentradaComDigitalHelper;
import Model.CadastroSaida;
import com.zkteco.biometric.FingerprintSensorErrorCode;
import com.zkteco.biometric.FingerprintSensorEx;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import view.ReentradaView;
import com.zkteco.biometric.FingerprintSensorErrorCode;
import com.zkteco.biometric.FingerprintSensorEx;

public class ReentradaComDigitalController {

    private final ReentradaView view;
    private final ReentradaComDigitalHelper helper;

    JButton btnImg = null;
    FingerprintSensorEx ex;
    FingerprintSensorErrorCode erro;

    //the width of fingerprint image
    int fpWidth = 0;
    //the height of fingerprint image
    int fpHeight = 0;
    //for verify test
    private byte[] lastRegTemp = new byte[2048];
    //the length of lastRegTemp
    private int cbRegTemp = 0;
    //pre-register template
    private byte[][] regtemparray = new byte[3][2048];
    //Register
    private boolean bRegister = false;
    //Identify
    private boolean bIdentify = true;
    
    private int nFakeFunOn = 1;
    //must be 3
    static final int enroll_cnt = 3;
    //the index of pre-register function
    private int enroll_idx = 0;

    private byte[] imgbuf = null;
    private byte[] template = new byte[2048];
    private int[] templateLen = new int[1];

    private boolean mbStop = true;
    private long mhDevice = 0;
    private long mhDB = 0;
    private WorkThread workThread = null;

    public ReentradaComDigitalController(ReentradaView view) {
        this.view = view;
        this.helper = new ReentradaComDigitalHelper(view);

    }

    public void validarDigital() throws SQLException, IOException {

        BufferedImage imagem = new BufferedImage(view.getjLabelDigital().getIcon().getIconWidth(), view.getjLabelDigital().getIcon().getIconHeight(), BufferedImage.TYPE_INT_RGB);
        ByteArrayOutputStream imagemByte = new ByteArrayOutputStream();
        ImageIO.write(imagem, "JPG", imagemByte);

        byte[] reentrada = imagemByte.toByteArray();

        Connection conexao = new Conexao().getConnection();
        ReentradaDigitalDocumentoDAO reentradaDAO = new ReentradaDigitalDocumentoDAO(conexao);

        CadastroSaida cs = reentradaDAO.digitalExiste(reentrada);
        if (cs != null) {
            view.getjLabelFoto().setIcon(new ImageIcon(cs.getFoto()));
            view.getjLabelDocumento().setText(cs.getDocumento());
            view.getjLabelNome().setText(cs.getNome());
            view.getjLabelMessageTela().setText("ENTRADA LIBERADA!");
        } else {
            view.getjLabelMessageTela().setText("ENTRADA BARRADA!");
        }
                                                                                              
    }

    public void fecharBiometria() {
        FreeSensor();
    }

    public void abrirBiometria() {

        int ret = erro.ZKFP_ERR_OK;
        cbRegTemp = 1;
        bRegister = false;
        bIdentify = false;
        enroll_idx = 0;

        if (erro.ZKFP_ERR_OK != ex.Init()) {
            JOptionPane.showMessageDialog(null, "Iniciação falhou!\n");
            return;
        }
        ret = ex.GetDeviceCount();
        if (ret < 0) {
            JOptionPane.showMessageDialog(null, "Nenhum dispositivo conectado!\n");
            FreeSensor();
            return;
        }
        if (0 == (mhDevice = ex.OpenDevice(0))) {;
            JOptionPane.showMessageDialog(null, "Falha no dispositivo aberto, ret = " + ret + "!\n");
            FreeSensor();
            return;
        }

        if (0 == (mhDB = ex.DBInit())) {
            JOptionPane.showMessageDialog(null, "Falha no banco de dados inicial, ret = " + ret + "!\n");
            FreeSensor();
            return;
        }

        int nFmt = 0;
        ex.DBSetParameter(mhDB, 5010, nFmt);
        byte[] paramValue = new byte[4];
        int[] size = new int[1];
        size[0] = 4;
        ex.GetParameters(mhDevice, 1, paramValue, size);
        fpWidth = byteArrayToInt(paramValue);
        size[0] = 4;
        ex.GetParameters(mhDevice, 2, paramValue, size);
        fpHeight = byteArrayToInt(paramValue);
        imgbuf = new byte[fpWidth * fpHeight];
        mbStop = false;
        workThread = new WorkThread();
        workThread.start();
    }

    private class WorkThread extends Thread {

        @Override
        public void run() {
            super.run();
            int ret = 0;
            while (!mbStop) {
                templateLen[0] = 2048;
                if (0 == (ret
                        = ex.AcquireFingerprint(mhDevice, imgbuf, template, templateLen))) {
                    if (nFakeFunOn == 1) {
                        byte[] paramValue = new byte[4];
                        int[] size = new int[1];
                        size[0] = 4;
                        int nFakeStatus = 0;
                        //GetFakeStatus
                        ret = ex.GetParameters(mhDevice, 2004, paramValue, size);
                        nFakeStatus = byteArrayToInt(paramValue);
                        System.out.println("ret = " + ret + ",nFakeStatus=" + nFakeStatus);
                        if (0 == ret && (byte) (nFakeStatus & 31) != 31) {
                            JOptionPane.showMessageDialog(null, "É um dedo falso?\n");
                            return;
                        }
                    }
                    OnCatpureOK(imgbuf);
                    bRegister = true;
                    OnExtractOK(template, templateLen[0]);

                }
                try {

                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private void FreeSensor() {
        mbStop = true;
        try {		//wait for thread stopping
            Thread.sleep(0);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (0 != mhDB) {
            ex.DBFree(mhDB);
            mhDB = 0;
        }
        if (0 != mhDevice) {
            ex.CloseDevice(mhDevice);
            mhDevice = 0;
        }
        ex.Terminate();
    }

    public static int byteArrayToInt(byte[] bytes) {
        int number = bytes[0] & 0xFF;
        number |= ((bytes[1] << 8) & 0xFF00);
        number |= ((bytes[2] << 16) & 0xFF0000);
        number |= ((bytes[3] << 24) & 0xFF000000);
        return number;
    }

    private void OnCatpureOK(byte[] imgBuf) {
        try {
            writeBitmap(imgBuf, fpWidth, fpHeight, "fingerprint.bmp");
            view.getjLabelDigital().setIcon(new ImageIcon(ImageIO.read(new File("fingerprint.bmp"))));

            BufferedImage imagem = new BufferedImage(view.getjLabelDigital().getIcon().getIconWidth(), view.getjLabelDigital().getIcon().getIconHeight(), BufferedImage.TYPE_INT_RGB);

            ByteArrayOutputStream imagemByte = new ByteArrayOutputStream();
            ImageIO.write(imagem, "JPG", imagemByte);
            view.setDigital(imagemByte.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeBitmap(byte[] imageBuf, int nWidth, int nHeight,
            String path) throws IOException {
        java.io.FileOutputStream fos = new java.io.FileOutputStream(path);
        java.io.DataOutputStream dos = new java.io.DataOutputStream(fos);

        int w = (((nWidth + 3) / 4) * 4);
        int bfType = 0x424d; // 位图文件类型（0—1字节）
        int bfSize = 54 + 1024 + w * nHeight;// bmp文件的大小（2—5字节）
        int bfReserved1 = 0;// 位图文件保留字，必须为0（6-7字节）
        int bfReserved2 = 0;// 位图文件保留字，必须为0（8-9字节）
        int bfOffBits = 54 + 1024;// 文件头开始到位图实际数据之间的字节的偏移量（10-13字节）

        dos.writeShort(bfType); // 输入位图文件类型'BM'
        dos.write(changeByte(bfSize), 0, 4); // 输入位图文件大小
        dos.write(changeByte(bfReserved1), 0, 2);// 输入位图文件保留字
        dos.write(changeByte(bfReserved2), 0, 2);// 输入位图文件保留字
        dos.write(changeByte(bfOffBits), 0, 4);// 输入位图文件偏移量

        int biSize = 40;// 信息头所需的字节数（14-17字节）
        int biWidth = nWidth;// 位图的宽（18-21字节）
        int biHeight = nHeight;// 位图的高（22-25字节）
        int biPlanes = 1; // 目标设备的级别，必须是1（26-27字节）
        int biBitcount = 8;// 每个像素所需的位数（28-29字节），必须是1位（双色）、4位（16色）、8位（256色）或者24位（真彩色）之一。
        int biCompression = 0;// 位图压缩类型，必须是0（不压缩）（30-33字节）、1（BI_RLEB压缩类型）或2（BI_RLE4压缩类型）之一。
        int biSizeImage = w * nHeight;// 实际位图图像的大小，即整个实际绘制的图像大小（34-37字节）
        int biXPelsPerMeter = 0;// 位图水平分辨率，每米像素数（38-41字节）这个数是系统默认值
        int biYPelsPerMeter = 0;// 位图垂直分辨率，每米像素数（42-45字节）这个数是系统默认值
        int biClrUsed = 0;// 位图实际使用的颜色表中的颜色数（46-49字节），如果为0的话，说明全部使用了
        int biClrImportant = 0;// 位图显示过程中重要的颜色数(50-53字节)，如果为0的话，说明全部重要

        dos.write(changeByte(biSize), 0, 4);// 输入信息头数据的总字节数
        dos.write(changeByte(biWidth), 0, 4);// 输入位图的宽
        dos.write(changeByte(biHeight), 0, 4);// 输入位图的高
        dos.write(changeByte(biPlanes), 0, 2);// 输入位图的目标设备级别
        dos.write(changeByte(biBitcount), 0, 2);// 输入每个像素占据的字节数
        dos.write(changeByte(biCompression), 0, 4);// 输入位图的压缩类型
        dos.write(changeByte(biSizeImage), 0, 4);// 输入位图的实际大小
        dos.write(changeByte(biXPelsPerMeter), 0, 4);// 输入位图的水平分辨率
        dos.write(changeByte(biYPelsPerMeter), 0, 4);// 输入位图的垂直分辨率
        dos.write(changeByte(biClrUsed), 0, 4);// 输入位图使用的总颜色数
        dos.write(changeByte(biClrImportant), 0, 4);// 输入位图使用过程中重要的颜色数

        for (int i = 0; i < 256; i++) {
            dos.writeByte(i);
            dos.writeByte(i);
            dos.writeByte(i);
            dos.writeByte(0);
        }

        byte[] filter = null;
        if (w > nWidth) {
            filter = new byte[w - nWidth];
        }

        for (int i = 0; i < nHeight; i++) {
            dos.write(imageBuf, (nHeight - 1 - i) * nWidth, nWidth);
            if (w > nWidth) {
                dos.write(filter, 0, w - nWidth);
            }
        }
        dos.flush();
        dos.close();
        fos.close();
    }

    public static byte[] changeByte(int data) {
        return intToByteArray(data);
    }

    public static byte[] intToByteArray(final int number) {
        byte[] abyte = new byte[4];
        abyte[0] = (byte) (0xff & number);
        abyte[1] = (byte) ((0xff00 & number) >> 8);
        abyte[2] = (byte) ((0xff0000 & number) >> 16);
        abyte[3] = (byte) ((0xff000000 & number) >> 24);
        return abyte;
    }

    private void OnExtractOK(byte[] template, int len) {
        if (bRegister) {
            int[] fid = new int[1];
            int[] score = new int[1];
            int ret = ex.DBIdentify(mhDB, template, fid, score);
            if (ret == 0) {
                JOptionPane.showMessageDialog(null, "o dedo já se inscrever por " + fid[0] + ",cancelar inscrição\n");
                bRegister = false;
                enroll_idx = 0;
                return;
            }
            System.arraycopy(template, 0, regtemparray[enroll_idx], 0, 2048);
            enroll_idx++;

            int[] _retLen = new int[1];
            _retLen[0] = 2048;
            byte[] regTemp = new byte[_retLen[0]];

       
            cbRegTemp = _retLen[0];
            System.arraycopy(regTemp, 0, lastRegTemp, 0, cbRegTemp);
            FreeSensor();
          

            bRegister = false;
        } else {
            if (bIdentify) {
                int[] fid = new int[1];
                int[] score = new int[1];
                int ret = ex.DBIdentify(mhDB, template, fid, score);
                if (ret == 0) {
                    JOptionPane.showMessageDialog(null, "Identifique sucesso, fid=" + fid[0] + ",ponto=" + score[0] + "\n");
                } else {
                    JOptionPane.showMessageDialog(null, "Identifique falha, código de erro=" + ret + "\n");
                }

            } else {
                if (cbRegTemp <= 0) {
                    JOptionPane.showMessageDialog(null, "Por favor,"
                            + " registre-se primeiro!\n");
                } else {
                    int ret = ex.DBMatch(mhDB, lastRegTemp, template);
                    if (ret > 0) {
                        JOptionPane.showMessageDialog(null, "Verificar sucesso, ponto=" + ret + "\n");
                        enroll_idx = 0;
                    } else {
                        JOptionPane.showMessageDialog(null, "Verificar falha, ret=" + ret + "\n");
                    }
                }
            }
        }
    }

}
