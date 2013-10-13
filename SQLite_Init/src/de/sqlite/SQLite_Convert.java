package de.sqlite;

import java.sql.ResultSet;

public class SQLite_Convert
{
	String path;
	public String[] toString(ResultSet rs, int size) {
		String[] sender = new String[size];
		try{
			int i=0;
			while(rs.next()){
				sender[i]=rs.getString("channel_label");
				i++;
			}
		} catch (Exception e){
			System.out.println("Fehler in toString Schleife: ");
			System.err.println(e.getMessage());
		}
		return sender;
	}
	
}
