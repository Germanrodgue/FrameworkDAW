package exer3_1.Modules.Users.Model.Utils.Files.Admin.Utils_files;

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
import java.io.PrintWriter;
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
import com.thoughtworks.xstream.annotations.Annotations;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import exer3_1.Modules.Users.Model.Classes.Admin;
import exer3_1.Modules.Users.Model.Classes.Singleton;

public class auto_admin {
	public static void Json_save_admin() {
		String PATH = null;
		try {
			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/exer3_1/Modules/Users/Model/Utils/Files/Admin/Files/Json_Admin.json";

		} catch (IOException s) {
			s.printStackTrace();
		}

		if (Singleton.adminuser.size() > 0) {
			try {
				XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
				xstreamjson.setMode(XStream.NO_REFERENCES);
				xstreamjson.alias("Admin", Admin.class);
				Gson gson = new Gson();
				String json = gson.toJson(Singleton.adminuser);
				FileWriter fileJson = new FileWriter(PATH);
				fileJson.write(json.toString());
				fileJson.close();

			} catch (Exception e) {

			}
		} else {
			File path = new File(PATH);

			path.delete();
		}
	}

	public static void Json_open_admin() {
		String PATH = null;
		Admin a2 = new Admin("");

		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);

			xstream.alias("Admin", Admin.class);
			try {
				PATH = new java.io.File(".").getCanonicalPath()
						+ "/src/exer3_1/Modules/Users/Model/Utils/Files/Admin/Files/Json_Admin.json";
			} catch (IOException s) {
				s.printStackTrace();
			}

			Singleton.adminuser.clear();
			JsonReader reader = new JsonReader(new FileReader(PATH));
			JsonParser parser = new JsonParser();
			JsonElement root = parser.parse(reader);
			Gson json = new Gson();
			JsonArray list = root.getAsJsonArray();
			for (JsonElement element : list) {
				a2 = json.fromJson(element, Admin.class);
				Singleton.adminuser.add(a2);
			}

		} catch (Exception e) {
		}

	}

	private static final String ENCODING = "UTF-8";

	public static void Xml_save_admin() {
		String PATH = null;

		try {
			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/exer3_1/Modules/Users/Model/Utils/Files/Admin/Files/Xml_Admin.xml";
		} catch (IOException s) {
			s.printStackTrace();
		}
		if (Singleton.adminuser.size() > 0) {
			try {
				OutputStream os = new ByteArrayOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				XStream xstream = new XStream();
				Annotations.configureAliases(xstream, Admin.class);
				String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
				xstream.toXML(Singleton.adminuser, osw);
				StringBuffer xml = new StringBuffer();
				xml.append(header);
				xml.append(os.toString());

				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(xml.toString());
				fileXml.close();
				osw.close();
				os.close();
			} catch (IOException e) {

			}
		} else {
			File path = new File(PATH);

			path.delete();
		}
	}

	public static void Xml_open_admin() {
		String PATH = null;
		try {
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, Admin.class);

			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/exer3_1/Modules/Users/Model/Utils/Files/Admin/Files/Xml_Admin.xml";
			Singleton.adminuser = (ArrayList<Admin>) xstream.fromXML(new FileReader(PATH));

		} catch (Exception e1) {

		}

	}

	public static void Txt_save_admin() {
		String PATH = null;
		try {
			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/exer3_1/Modules/Users/Model/Utils/Files/Admin/Files/Txt_Admin.txt";
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		if (Singleton.adminuser.size() > 0) {
			try {
				File f;

				f = new File(PATH);

				FileOutputStream fo = new FileOutputStream(f);
				ObjectOutputStream o = new ObjectOutputStream(fo);
				o.writeObject(Singleton.adminuser);
				o.close();

			} catch (Exception e) {

			}
		} else {
			File path = new File(PATH);

			path.delete();
		}
	}

	public static void Txt_open_admin() {
		String PATH = null;

		try {
			File f;
			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/exer3_1/Modules/Users/Model/Utils/Files/Admin/Files/Txt_Admin.txt";
			f = new File(PATH);

			FileInputStream fi = new FileInputStream(f);
			ObjectInputStream oi = new ObjectInputStream(fi);
			Singleton.adminuser = (ArrayList<Admin>) oi.readObject();
			oi.close();

		} catch (Exception e) {

		}

	}

}
