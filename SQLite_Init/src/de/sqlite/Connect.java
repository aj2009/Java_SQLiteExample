package de.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect 
{
	private String path;
	private Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	void connection_open()
	{
		
		try{
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:" +path);
		} catch(Exception e){
			System.err.println(e.getClass().getName());
		}
	}

	void connection_close()
	{
		try{
			conn.close();
		} catch(SQLException e) {
			System.err.println(e.getStackTrace());
		}
		
	}

	void connection_test()
	{
		try { if (conn==null) {
			connection_open();
		} else if (conn.isClosed()) {
			connection_open();}
		else {
			
		}} catch(Exception e) {
			System.err.println(e.getStackTrace());}
	}
	
	public void setPath(String path)
	{
		this.path=path;
	}
	
	public ResultSet get_Result()
	{
		connection_test();
		
		try{
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM EuroDTVChanList");
//			stmt.close();
//			connection_close();
		} catch (SQLException e) {
			System.err.println(e.getStackTrace()+" " +e.getMessage());
		}
		return rs;
	}

	public void write_Result()
	{
		//TODO: Hier kommt der Code rein um die Datenbank zu manipulieren
	}
	
	public void Connection_Close()
	{
		try{
			stmt.close();
			rs.close();
			conn.close();
		} catch(Exception e){
			System.err.println(e.getMessage());
		}
		
	}

	public int getCount()
	{
		connection_test(); //TODO: Dieser Bereich muss dann wieder anders gelöst werden
		int size = 0;
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT (channel_label) COUNT,"
					+ "CAST(null as int)as MYINT FROM EuroDTVChanList");
			size = rs.getInt("COUNT"); 
		}catch(Exception e){
			System.out.println("Fehler in der getCount Methode");
			System.err.println(e.getMessage());
		}
		return size;
	}
}
