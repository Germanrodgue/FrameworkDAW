package exer3_1.Modules.Users.Model.Classes.Language;

import java.io.IOException;
import java.util.Properties;
import exer3_1.Classes.Settings;

public class Language_user extends Properties {

	private static Language_user instance;
	private static final long serialVersionUID = 1L;
	private String lang;

	public Language_user(String lang) {
		this.lang = lang;
		String langu = Settings.getInstance().getLanguage();

		if (((langu.equals("Spanish"))) || (langu.equals("Español")) || (langu.equals("Espanyol"))) {
			getLang("esp_user.properties");
			System.out.println(langu);
		} else if (((langu.equals("Valencian"))) || (langu.equals("Valenciano")) || (langu.equals("Valencia"))) {
			getLang("val_user.properties");
		} else {
			getLang("eng_user.properties");
		}

	}

	public Language_user() {
		String langu = Settings.getInstance().getLanguage();
		if (((langu.equals("Spanish"))) || (langu.equals("Español")) || (langu.equals("Espanyol"))) {
			getLang("esp_user.properties");
		} else if (((langu.equals("Valencian"))) || (langu.equals("Valenciano")) || (langu.equals("Valencia"))) {
			getLang("val_user.properties");
		} else {
			getLang("eng_user.properties");
		}
	}

	public String getLanguage() {
		return lang;
	}

	public static Language_user getInstance() {
		if (instance == null) {
			instance = new Language_user();
		}
		return instance;
	}

	public void setLanguage() {
		String langu = Settings.getInstance().getLanguage();
		System.out.println(langu + "XD");
		if (((langu.equals("Spanish"))) || (langu.equals("Español")) || (langu.equals("Espanyol"))) {
			getLang("esp_user.properties");
		} else if (((langu.equals("Valencian"))) || (langu.equals("Valenciano")) || (langu.equals("Valencia"))) {
			getLang("val_user.properties");
		} else {
			getLang("eng_user.properties");
		}
	}

	public void getLang(String lang) {
		try {
			this.load(getClass().getResourceAsStream(lang));
		} catch (IOException ex) {
		}
	}

}
