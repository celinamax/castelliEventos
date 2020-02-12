/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Conexao;
import DAO.EntradaDAO;
import Helper.EntradaHelper;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import view.EntradaView;

/**
 *
 * @author HMS
 */
public class EntradaController extends Thread{
    
    private final EntradaView view;
    private final EntradaHelper helper;
    Boolean liberado = false;

    public EntradaController(EntradaView view) {
        this.view = view;
        this.helper = new EntradaHelper(view);
    }
    
    public void validarEntrada() throws SQLException, IOException, InterruptedException{
        String entrada = helper.entrada();
        Connection conexao = new Conexao().getConnection();
        EntradaDAO eDao = new EntradaDAO(conexao);
        liberado = eDao.conviteExiste(entrada);
        Thread.sleep(1000);
        if (liberado) {
            helper.liberaEntrada();
            
        } else {
            helper.barraEntrada();
        }
        helper.limpaTela();        
    }
    
    
    
}
