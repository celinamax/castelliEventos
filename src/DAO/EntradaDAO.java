package DAO;

import Model.Entrada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Timer;

public class EntradaDAO {

    private final Connection connection;
    private PreparedStatement stmt;
    private ResultSet result;
    Timer temporizador;

    public EntradaDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean conviteExiste(String entrada) throws SQLException {
        String sql = "SELECT codConvite,validaConvite FROM codigoconvite WHERE codConvite = ? AND validaConvite = ''";
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, entrada);
        stmt.execute();
        result = stmt.getResultSet();
        return result.next();

    }

    public Entrada validaConvite(String entrada) throws SQLException, InterruptedException {

        String sql = "UPDATE codigoconvite SET validaConvite = 'usado' WHERE codConvite = ?";
        Entrada valida = null;

        stmt = connection.prepareStatement(sql);
        stmt.setString(1, entrada);
        stmt.execute();
        return valida;
    }
}