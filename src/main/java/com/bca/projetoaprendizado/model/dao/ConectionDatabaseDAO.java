package com.bca.projetoaprendizado.model.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.bca.projetoaprendizado.util.MyException;

public class ConectionDatabaseDAO {

    protected Connection Con = null;
    protected Statement Stm = null;
    protected ResultSet Res = null;
    protected PreparedStatement Cmd = null;

    public ConectionDatabaseDAO() throws MyException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");

            Stm = Con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            String sErrorCuase;
            if (e instanceof SQLException) {
                sErrorCuase = "Banco de dados";
            }else{
                sErrorCuase = "Biblioteca";
            }
            throw new MyException("Não foi possivel conectar no banco. Erro de " + sErrorCuase);

        }
    }

}
