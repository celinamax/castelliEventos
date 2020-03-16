
package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Mapeia classe em tabela
@Table(name="cadastroSaida")
public class CadastroSaida {
    
    @Id @GeneratedValue // Mapeia chave primária ou composta
    protected int id;
    @Column(name ="nome", nullable=true,length=120) // Mapeia coluna
    protected String nome;
    @Column(name ="documento", nullable=true,length=50) // Mapeia coluna
    protected String documento;
    protected byte[] digital;
    protected byte[] foto;

    public CadastroSaida() {
    }   

    public CadastroSaida(String nome, String documento, byte[] digital, byte[] foto) {        
        this.nome = nome;
        this.documento = documento;
        this.digital = digital;
        this.foto = foto;
    }
      
    public CadastroSaida(int id, String nome, String documento, byte[] digital, byte[] foto){
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.digital = digital;
        this.foto = foto;
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

    public byte[] getDigital() {
        return digital;
    }

    public void setDigital(byte[] digital) {
        this.digital = digital;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }      
    
}
