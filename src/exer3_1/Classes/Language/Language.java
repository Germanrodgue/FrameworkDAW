package exer3_1.Classes.Language;

import java.io.IOException;
import java.util.Properties;

import exer3_1.Classes.Settings;

public class Language extends Properties {

	private static Language instance;
	private static final long serialVersionUID = 1L;
	private String lang;

	public Language(String lang) {
		this.lang = lang;
		String langu = Settings.getInstance().getLanguage();

		if (((langu.equals("Spanish"))) || (langu.equals("Español")) || (langu.equals("Espanyol"))) {
			getLang("esp.properties");
			System.out.println(langu);
		} else if (((langu.equals("Valencian"))) || (langu.equals("Valenciano")) || (langu.equals("Valencia"))) {
			getLang("val.properties");
		} else {
			getLang("eng.properties");
		}

	}

	public Language() {
		String langu = Settings.getInstance().getLanguage();
		if (((langu.equals("Spanish"))) || (langu.equals("Español")) || (langu.equals("Espanyol"))) {
			getLang("esp.properties");
		} else if (((langu.equals("Valencian"))) || (langu.equals("Valenciano")) || (langu.equals("Valencia"))) {
			getLang("val.properties");
		} else {
			getLang("eng.properties");
		}
	}

	public String getLanguage() {
		return lang;
	}

	public static Language getInstance() {
		if (instance == null) {
			instance = new Language();
		}
		return instance;
	}

	public void setLanguage() {
		String langu = Settings.getInstance().getLanguage();
		System.out.println(langu+"XD");
		if (((langu.equals("Spanish"))) || (langu.equals("Español")) || (langu.equals("Espanyol"))) {
			getLang("esp.properties");
		} else if (((langu.equals("Valencian"))) || (langu.equals("Valenciano")) || (langu.equals("Valencia"))) {
			getLang("val.properties");
		} else {
			getLang("eng.properties");
		}
	}

	public void getLang(String lang) {
		try {
			this.load(getClass().getResourceAsStream(lang));
		} catch (IOException ex) {
		}
	}

}
