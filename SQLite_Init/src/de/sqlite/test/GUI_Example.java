package de.sqlite.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class GUI_Example extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Example frame = new GUI_Example();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_Example() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);
		
		JMenuItem mntmffnen = new JMenuItem("\u00D6ffnen");
		mnDatei.add(mntmffnen);
		
		JMenuItem mntmBeenden = new JMenuItem("Beenden");
		mnDatei.add(mntmBeenden);
		
		JMenu mnBearbeiten = new JMenu("Bearbeiten");
		menuBar.add(mnBearbeiten);
		
		JMenuItem mntmAktuelisieren = new JMenuItem("Aktuelisieren");
		mnBearbeiten.add(mntmAktuelisieren);
		
		JMenu mnExportieren = new JMenu("Exportieren");
		mnBearbeiten.add(mnExportieren);
		
		JMenuItem mntmExcel = new JMenuItem("Excel");
		mnExportieren.add(mntmExcel);
		
		JMenuItem mntmWeitereFormate = new JMenuItem("Weitere Formate");
		mnExportieren.add(mntmWeitereFormate);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}

}
