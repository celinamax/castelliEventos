/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HMS
 */
public class EntradaDAO {
    
    private final Connection connection;
    private PreparedStatement stmt;
    private ResultSet result;  

    public EntradaDAO(Connection connection) {
        this.connection = connection;
    }
    
    public boolean conviteExiste(String convite) throws SQLException{
        String sql = "SELECT * FROM codigoconvite WHERE codConvite = '"+convite+"'";
        stmt = connection.prepareStatement(sql);
        stmt.execute();
        result = stmt.getResultSet();      
        return result.next();   
    }
}
