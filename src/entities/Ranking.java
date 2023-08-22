package entities;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import db.Db;

public class Ranking {

    private String[][] ranking;
    
    
   
    public Ranking(Connection conn) throws SQLException {
     
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM dados");
        rs.next();
      
        int numCompetidores = rs.getInt(1);

        ranking = new String[numCompetidores][2];
        

    
        rs = st.executeQuery("SELECT NOME, total FROM dados");
        int i = 0;
        while (rs.next()) {
        
            ranking[i][0] = rs.getString("NOME");
            ranking[i][1] = rs.getString("total");
            i++;
        }

        Arrays.sort(ranking, new Comparator<String[]>() {
            @Override
            
            public int compare(final String[] entrada1, final String[] entrada2) {
            
                final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
                
               
                try {
                    return sdf.parse(entrada1[1]).compareTo(sdf.parse(entrada2[1]));
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }
            }
         
        });

  
        Db.closeStatement(st);
        Db.closeResultSet(rs);
    }

 
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Ranking:\n");
        for (int i = 0; i < ranking.length; i++) {
            sb.append((i + 1)).append(". ").append(ranking[i][0]).append(" - ").append(ranking[i][1]).append("\n");
        }
        return sb.toString();
    }
}