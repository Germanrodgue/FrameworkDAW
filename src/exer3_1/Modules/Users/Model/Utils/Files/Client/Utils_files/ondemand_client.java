package exer3_1.Modules.Users.Model.Utils.Files.Client.Utils_files;

import java.awt.HeadlessException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import exer3_1.Modules.Menu.Singleton_menu;
import exer3_1.Modules.Users.Model.Classes.Client;
import exer3_1.Modules.Users.Model.Classes.Singleton;
import exer3_1.Modules.Users.Model.Classes.Language.Language_user;


public class ondemand_client {

	public static void save_Json_client() {
		String PATH = null;

		try {
			XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
			xstreamjson.setMode(XStream.NO_REFERENCES);
			xstreamjson.alias("Client", Client.class);

			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
			int seleccion = fileChooser.showSaveDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".json";

				Gson gson = new Gson();
				String json = gson.toJson(Singleton.clientuser);
				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(json.toString());
				fileXml.close();

				JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("succsavejson"),
						Language_user.getInstance().getProperty("json"), JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("errsavejson"), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void open_Json_client() {
		String PATH = null;
		Client c2 = new Client("");

		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("Client", Client.class);

			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
			int seleccion = fileChooser.showOpenDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();

				Singleton.clientuser.clear();
				JsonReader reader = new JsonReader(new FileReader(PATH));
				JsonParser parser = new JsonParser();
				JsonElement root = parser.parse(reader);
				Gson json = new Gson();
				JsonArray list = root.getAsJsonArray();
				for (JsonElement element : list) {
					c2 = json.fromJson(element, Client.class);
					Singleton.clientuser.add(c2);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("erropenjson"), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private static final String ENCODING = "UTF-8";

	public static void save_Xml_client() {
		String PATH;

		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();

			String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
			xstream.toXML(Singleton.clientuser, osw);
			StringBuffer xml = new StringBuffer();
			xml.append(header);
			xml.append(os.toString());

			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));

			int seleccion = fileChooser.showSaveDialog(null);

			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();

				if (!PATH.endsWith(".xml")) {
					PATH = PATH + ".xml";
				}

				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(xml.toString());
				fileXml.close();
				osw.close();
				os.close();

				JOptionPane.showMessageDialog(null,Language_user.getInstance().getProperty("succsavexml"),
						Language_user.getInstance().getProperty("xml"), JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (HeadlessException | IOException e) {
			JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("errsavexml"), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void open_Xml_client() {
		String PATH = null;

		try {
			XStream xstream = new XStream();
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));

			int seleccion = fileChooser.showOpenDialog(null);

			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				Singleton.clientuser = (ArrayList<Client>) xstream.fromXML(new FileReader(PATH));

			}

		} catch (HeadlessException | FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("erropenxml"), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void save_Txt_client() {
		String PATH = null;
		try {
			File f;
			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("TXT (*.txt)", "txt"));
			int seleccion = fileChooser.showSaveDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".txt";
				f = new File(PATH);

				FileOutputStream fo = new FileOutputStream(f);
				ObjectOutputStream o = new ObjectOutputStream(fo);
				o.writeObject(Singleton.clientuser);
				o.close();
				JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("succsavetxt"),
						Language_user.getInstance().getProperty("txt"), JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("errsavetxt"), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void open_Txt_client() {
		String PATH = null;

		try {
			File f;
			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("TXT (*.txt)", "txt"));
			int seleccion = fileChooser.showOpenDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				f = new File(PATH);

				FileInputStream fi = new FileInputStream(f);
				ObjectInputStream oi = new ObjectInputStream(fi);
				Singleton.clientuser = (ArrayList<Client>) oi.readObject();
				oi.close();

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Language_user.getInstance().getProperty("erropentxt"), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}
}
