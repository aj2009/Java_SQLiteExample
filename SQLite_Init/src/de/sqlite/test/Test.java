package de.sqlite.test;

import java.io.File;
import java.sql.ResultSet;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import de.sqlite.Connect;
import de.sqlite.SQLite_Convert;

public class Test {

	public static void main(String[] args) 
	{	
		String path = get_Path();
		Connect conn = new Connect();
		conn.setPath(path);
		
		int size = conn.getCount();
		
		SQLite_Convert convert = new SQLite_Convert();
		
		
		ResultSet rs = conn.get_Result();
		String[] senderliste = convert.toString(rs, size);
		
		for(int i=0;i<senderliste.length;i++) {
			System.out.println(senderliste[i]);
		}

		conn.Connection_Close();
	}
	public static String get_Path()
	{
		final JFileChooser chooser = new JFileChooser();
		chooser.setDialogType(JFileChooser.OPEN_DIALOG);
		final File file = new File("E:/");
		
		FileFilter filter = new FileFilter() {
			@Override
			public boolean accept(File f) {
				if (f.isDirectory())
					return true;
				return f.getName().toLowerCase().endsWith(".db");
			}

			@Override
			public String getDescription() {
				return "sqlite Datenbank";
			}
		};
		
		chooser.setFileFilter(filter);
		chooser.setCurrentDirectory(file);
		
		chooser.setVisible(true);
		final int result = chooser.showOpenDialog(null);
		String inputVerzStr = null;
		if (result == JFileChooser.APPROVE_OPTION)
		{
			File inputVerzFile = chooser.getSelectedFile();
			inputVerzStr = inputVerzFile.getPath();
			System.out.println(inputVerzStr);
		}
		chooser.setVisible(false);
		System.out.println(inputVerzStr);
		return inputVerzStr;
	}

}
