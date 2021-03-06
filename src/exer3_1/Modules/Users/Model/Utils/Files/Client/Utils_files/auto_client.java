package exer3_1.Modules.Users.Model.Utils.Files.Client.Utils_files;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import exer3_1.Modules.Users.Model.Classes.Client;
import exer3_1.Modules.Users.Model.Classes.Singleton;


public class auto_client {

	public static void Json_save_client() {
		String PATH = null;
		try {
			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/exer3_1/Modules/Users/Model/Utils/Files/Client/Files/Json_Client.json";

		} catch (IOException s) {
			s.printStackTrace();
		}
		if (Singleton.clientuser.size() > 0) {
			try {
				XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
				xstreamjson.setMode(XStream.NO_REFERENCES);
				xstreamjson.alias("Client", Client.class);

				Gson gson = new Gson();
				String json = gson.toJson(Singleton.clientuser);
				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(json.toString());
				fileXml.close();
			} catch (Exception e) {
				System.out.println("2");
			}
		} else {
			File path = new File(PATH);

			path.delete();
		}
	}

	public static void Json_open_client() {
		String PATH = null;
		Client c2 = new Client("");

		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);

			xstream.alias("Client", Client.class);

			try {
				PATH = new java.io.File(".").getCanonicalPath()
						+ "/src/exer3_1/Modules/Users/Model/Utils/Files/Client/Files/Json_Client.json";
			} catch (IOException s) {
				s.printStackTrace();
			}

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

		} catch (Exception e) {
		}
		

	}

	private static final String ENCODING = "UTF-8";

	public static void Xml_save_client() {
		String PATH = null;

		try {
			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/exer3_1/Modules/Users/Model/Utils/Files/Client/Files/Xml_Client.xml";
		} catch (IOException s) {
			s.printStackTrace();
		}
		if (Singleton.clientuser.size() > 0) {
			try {
				OutputStream os = new ByteArrayOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				XStream xstream = new XStream();
				Annotations.configureAliases(xstream, Client.class);
				String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
				xstream.toXML(Singleton.clientuser, osw);
				StringBuffer xml = new StringBuffer();
				xml.append(header);
				xml.append(os.toString());
				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(xml.toString());
				fileXml.close();
				osw.close();
				os.close();
			} catch (IOException e) {
				// JOptionPane.showMessageDialog(null, "Error al grabar el XML",
				// "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			File path = new File(PATH);

			path.delete();
		}
	}

	public static void Xml_open_client() {
		String PATH = null;
		try {
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, Client.class);

			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/exer3_1/Modules/Users/Model/Utils/Files/Client/Files/Xml_Client.xml";
			Singleton.clientuser = (ArrayList<Client>) xstream.fromXML(new FileReader(PATH));

		} catch (Exception e1) {
			
		}
	}
	public static void Txt_save_client() {
		String PATH = null;
		try {
			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/exer3_1/Modules/Users/Model/Utils/Files/Client/Files/Txt_Client.txt";
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		if (Singleton.clientuser.size() > 0) {
			try {
				File f;

				f = new File(PATH);

				FileOutputStream fo = new FileOutputStream(f);
				ObjectOutputStream o = new ObjectOutputStream(fo);
				o.writeObject(Singleton.clientuser);
				o.close();
				

			} catch (Exception e) {

			}
		} else {
			File path = new File(PATH);

			path.delete();
		}
	}

	public static void Txt_open_client() {
		String PATH = null;

		try {
			File f;
			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/exer3_1/Modules/Users/Model/Utils/Files/Client/Files/Txt_Client.txt";
			f = new File(PATH);

			FileInputStream fi = new FileInputStream(f);
			ObjectInputStream oi = new ObjectInputStream(fi);
			Singleton.clientuser = (ArrayList<Client>) oi.readObject();
			oi.close();

		} catch (Exception e) {

		}

	}

}
