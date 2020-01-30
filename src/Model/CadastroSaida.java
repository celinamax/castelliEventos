
package Model;

public class CadastroSaida {
    
    protected int id;
    protected String nome;
    protected String documento;
    protected byte digital;
    protected byte foto;

    public CadastroSaida(String nome, String documento) {        
        this.nome = nome;
        this.documento = documento;
    }
    
        
    public CadastroSaida(int id, String nome, String documento, byte digital, byte foto){
        this.id = id;
        this.nome = nome;
        this.documento = documento;
//        this.digital = digital;
//        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

//    public byte getDigital() {
//        return digital;
//    }
//
//    public void setDigital(byte digital) {
//        this.digital = digital;
//    }
//
//    public byte getFoto() {
//        return foto;
//    }
//
//    public void setFoto(byte foto) {
//        this.foto = foto;
//    }   
    
    
}
