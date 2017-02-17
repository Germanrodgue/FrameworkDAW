package exer3_1.Utils;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import exer3_1.Classes.Settings;


public class Functions_theme {
public static void theme (){
		
	System.out.println(Settings.getInstance().getTheme());
		try {
			switch (Settings.getInstance().getTheme()){
				
			case "Metal":// Metal - Predeterminado JAVA
				System.out.println("aaaa");
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
				break;

			case "GTK":// GTK
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				break;

			case "Motif":// Motif
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
				break;

			case "Ninbus":

				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				break;	
				
			case "Windows95":// WINDOWS 95
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
				break;
				
			case "Windows":// WINDOWS
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				break;
			}
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "", "", JOptionPane.ERROR_MESSAGE);
		}
	}
}
