package entities;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import db.Db;

public class Relatorio {
    private String nomeArquivo;

    public Relatorio( String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
    Connection conn;
    public void gerarRelatorio() throws SQLException, IOException {
       
        conn=Db.getConnection();
      

   
        String query = "SELECT * FROM  dados" ;

        
        Statement stmt = conn.createStatement();

       
        ResultSet rs = stmt.executeQuery(query);


        ResultSetMetaData rsmd = rs.getMetaData();
        int numColunas = rsmd.getColumnCount();

       
        FileWriter writer = new FileWriter("relatorio");

       
        for (int i = 1; i <= numColunas; i++) {
            writer.write(rsmd.getColumnName(i) + "\t");
        }
        writer.write("\n");

    
        while (rs.next()) {
            for (int i = 1; i <= numColunas; i++) {
                writer.write(rs.getString(i) + "\t");
            }
            writer.write("\n");
        }

      
        rs.close();
        Db.closeStatement(stmt);
		Db.closeConnection(conn);
    
        writer.close();

        System.out.println("Relatório gerado com sucesso no arquivo " + nomeArquivo);
    }
}