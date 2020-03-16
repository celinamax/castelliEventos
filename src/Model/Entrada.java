
package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Mapeia classe em tabela
@Table(name="codigoconvite")
public class Entrada {
    
    @Id @GeneratedValue // Mapeia chave primária ou composta
    protected int id;
    
    @Column(name ="codConvite", nullable=true,length=120) // Mapeia coluna
    private String codigoContive;
    
    @Column(name ="validaConvite", nullable=true,length=120) // Mapeia coluna
    private String validaConvite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValidaConvite() {
        return validaConvite;
    }

    public void setValidaConvite(String validaConvite) {
        this.validaConvite = validaConvite;
    }
    
    public String getCodigoContive() {
        return codigoContive;
    }

    public void setCodigoContive(String codigoContive) {
        this.codigoContive = codigoContive;
    }    
}
