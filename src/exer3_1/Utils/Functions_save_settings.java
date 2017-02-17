package exer3_1.Utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import exer3_1.Classes.Settings;




public class Functions_save_settings {

	public static void save() {
        String PATH = null;
	     
        try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/exer3_1/File_settings/Settings_json.json";
        } catch (IOException e) {
            e.printStackTrace();
        }
        
	    try {
		    XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
		    xstreamjson.setMode(XStream.NO_REFERENCES);
		    xstreamjson.alias("Settings", Settings.class);
		    Gson gson = new Gson();
		    String json = gson.toJson(Settings.getInstance());
		    FileWriter fileXml = new FileWriter(PATH);
		    fileXml.write(json.toString());
		    fileXml.close();
		    
		    
	    } catch (Exception e) {
	     	JOptionPane.showMessageDialog(null, "", "", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public static void open() {
		String PATH = null;
		Settings config = null;
		
	    try {
	    	XStream xstream = new XStream(new JettisonMappedXmlDriver());
	        xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("Settings", Settings.class);
			
			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/exer3_1/File_settings/Settings_json.json";
	        
	        JsonReader reader = new JsonReader(new FileReader(PATH));
	        JsonParser parser = new JsonParser();
	        JsonElement root = parser.parse(reader);
	        
	        Gson json = new Gson();
	        config = json.fromJson(root, Settings.class);
	    	Settings.getInstance().setCoinformat(config.getCoinformat());
	    	Settings.getInstance().setDateformat(config.getDateformat());
	    	Settings.getInstance().setDecimalformat(config.getDecimalformat());
	    	Settings.getInstance().setFileformat(config.getFileformat());
	    	Settings.getInstance().setLanguage(config.getLanguage());
	    	Settings.getInstance().setTheme(config.getTheme());
	    	Settings.getInstance().setDummies(config.getDummies());
	        
	    } catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, "", "", JOptionPane.ERROR_MESSAGE);
	    }
	
	}
	
	public static void open_default() {
		String PATH = null;
		Settings config = null;
		
	    try {
	    	XStream xstream = new XStream(new JettisonMappedXmlDriver());
	        xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("Settings", Settings.class);
			
			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/exer3_1/File_settings/Settings_default.json";
	        
	        JsonReader reader = new JsonReader(new FileReader(PATH));
	        JsonParser parser = new JsonParser();
	        JsonElement root = parser.parse(reader);
	        
	        Gson json = new Gson();
	        config = json.fromJson(root, Settings.class);
	    	Settings.getInstance().setCoinformat(config.getCoinformat());
	    	Settings.getInstance().setDateformat(config.getDateformat());
	    	Settings.getInstance().setDecimalformat(config.getDecimalformat());
	    	Settings.getInstance().setFileformat(config.getFileformat());
	    	Settings.getInstance().setLanguage(config.getLanguage());
	    	Settings.getInstance().setTheme(config.getTheme());
	    	Settings.getInstance().setDummies(config.getDummies());
	        
	    } catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, "", "", JOptionPane.ERROR_MESSAGE);
	    }
	
	}
}
