package engine;
import java.sql.*;

import javax.swing.JOptionPane; 
public class MathGameCreateDatabase {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/";
		String uname = "root";
		String pass = "password";
		String query_to_create_database = "CREATE DATABASE IF NOT EXISTS mathgame;";
		String query_to_use_database = "USE mathgame;";
		String query_to_create_table = "CREATE TABLE IF NOT EXISTS userdata1 (username varchar(255) PRIMARY KEY, password varchar(255), score int DEFAULT 0);";
		
	      try(Connection conn = DriverManager.getConnection(url, uname, pass);
	         Statement stmt = conn.createStatement();
	      ) {	
	    	  
	         stmt.executeUpdate(query_to_create_database);
	         System.out.println("Database created successfully...");   	 
	         
	         stmt.executeUpdate(query_to_use_database);
	         System.out.println("Using database..."); 
	         
	         stmt.executeUpdate(query_to_create_table);
	         System.out.println("Table created successfully..."); 
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
    }
	
	public void addUser(String userText, String pwdText) {
		String url = "jdbc:mysql://localhost:3306/";
		String uname = "root";
		String pass = "password";
		String query_to_use_database = "USE mathgame;";
		String query_to_add_user = "INSERT INTO userdata1 VALUES("+ "'"+userText+"'" +","+ "'"+pwdText+"'"+",0);";
		System.out.println(query_to_add_user);
		try(Connection conn = DriverManager.getConnection(url, uname, pass);
		         Statement stmt = conn.createStatement();
		      ) {	
		    	  
				stmt.executeUpdate(query_to_use_database);
				System.out.println("Using database..."); 
		         stmt.executeUpdate(query_to_add_user);
		         System.out.println("User added successfully...");   	 
		         
		      } catch (SQLException e) {
		    	  System.out.println("User already exiss!");
		      } 
	}
	
	public String getScores() {
		String url = "jdbc:mysql://localhost:3306/";
		String uname = "root";
		String pass = "password";
		String query_to_use_database = "USE mathgame;";
		String query_to_get_score = "SELECT username, score FROM userdata1;";
		System.out.println(query_to_get_score);
		try(Connection conn = DriverManager.getConnection(url, uname, pass);
		         Statement stmt = conn.createStatement();
		      ) {	
		    	  
				stmt.executeUpdate(query_to_use_database);
				System.out.println("Using database..."); 
				
				ResultSet rs = stmt.executeQuery(query_to_get_score);
				String data = "";
				while(rs.next()){
					data += "User name: " + rs.getString("username") + " Score: " + rs.getInt("score") + "\n";
		         }
		          	 
		         return data;
		      } catch (SQLException e) {
		    	  System.out.println("No entries");
		      } 
		return "";
	}
	
	public boolean validateUser(String userText, String pwdText) {
		boolean success = false;
		String url = "jdbc:mysql://localhost:3306/";
		String uname = "root";
		String pass = "password";
		String query_to_use_database = "USE mathgame;";
		String query_to_validate = "SELECT username, password FROM userdata1 WHERE " + "username=" + "'"+userText+"' AND " + "password=" + "'" + pwdText +"';";
		System.out.println(query_to_validate);
		
		try(Connection conn = DriverManager.getConnection(url, uname, pass);
		         Statement stmt = conn.createStatement();
		      ) {	
		    	  
				stmt.executeUpdate(query_to_use_database);
				System.out.println("Using database..."); 
				
				ResultSet rs = stmt.executeQuery(query_to_validate);
				System.out.println(rs);
				while(rs.next()){
					success = true;
		         }
		          	 
		      } catch (SQLException e) {
		    	  System.out.println("No entries");
		      } 
		
		return success;
	}
	
	public void updateScore(String userText, int score) {
		String url = "jdbc:mysql://localhost:3306/";
		String uname = "root";
		String pass = "password";
		String query_to_use_database = "USE mathgame;";
		String query_to_update_score = "UPDATE userdata1 SET score="+ score + " WHERE username=" + "'"+userText+"';";
		System.out.println(query_to_update_score);
		
		try(Connection conn = DriverManager.getConnection(url, uname, pass);
		         Statement stmt = conn.createStatement();
		      ) {	
		    	  
				stmt.executeUpdate(query_to_use_database);
				System.out.println("Using database..."); 
				
				stmt.executeUpdate(query_to_update_score);
		
		      } catch (SQLException e) {
		    	  System.out.println("Error occured");
		      } 
			}
}






