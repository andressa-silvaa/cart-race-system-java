package aplication;

import java.text.ParseException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entities.Relatorio;
import db.Db;
import entities.CapturaDeTela;
import entities.Cronometro;
import entities.Ranking;
import java.awt.AWTException;
import java.io.IOException;




public class Aps {

	public static void main(String[] args) throws ParseException {
		


		Connection conn = null;
		PreparedStatement st = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("BEM VINDO(A) A CORRIDA!");
		System.out.println();
		
		
		
		String horario1;
		String horario2;
		String nome;
		String result;
		char op;
		int soma=0;
		
		try {
            
            CapturaDeTela.capturarTelaComCamadaPreta();
            System.out.println("Captura de tela realizada com sucesso!");
        } catch (AWTException | IOException e) {
            System.err.println("Erro ao capturar tela: " + e.getMessage());
        }
		
		do {
		System.out.print("Digite o nome do carrinho ");
		nome = sc.next();
		System.out.println();
		System.out.print("Digite o primeiro horário (mm:ss): ");
	    horario1 = sc.next();
	    System.out.println();
	    System.out.print("Digite o segundo horário (mm:ss): ");
	    horario2 = sc.next();
	    System.out.println();
	    Cronometro h1 = new Cronometro(horario1);
	    Cronometro h2 = new Cronometro(horario2);

	    Cronometro resultado = h1.soma(h2);
	    result=String.valueOf(resultado);
	    System.out.print("Adicionar outro carrinho?[S/N]:");
	    op = sc.next().charAt(0);
		    try {
					conn = Db.getConnection();
			
					st = conn.prepareStatement(
							"INSERT INTO dados (NOME,volta1,volta2,total)" 
							+"VALUES"
							+ "(?,?,?,?)");
	
					
					st.setString(1,nome);
					st.setString(2,horario1);
					st.setString(3,horario2);
					st.setString(4,result);
					
					soma = soma + st.executeUpdate();
					
				}
		    catch (SQLException e) {
					e.printStackTrace();
				} 
			
	   
		}while(op!='N'&& op!='n');
		
		Ranking ranking;
		try {
			ranking = new Ranking(conn);
			System.out.println();
			System.out.println("Done! Rows affected: " + soma);
			System.out.println();
			System.out.println(ranking.toString());
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		try {
            Relatorio relatorio = new Relatorio( "relatorio.txt");
            relatorio.gerarRelatorio();
        } catch (SQLException | IOException e) {
            System.err.println("Erro ao gerar relatório: " + e.getMessage());
        }
	
		sc.close();
		Db.closeStatement(st);
		Db.closeConnection(conn);
    
	}
}