package exer3_1.Classes;

import java.io.Serializable;
import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import exer3_1.Classes.Language.Language;
import exer3_1.Modules.Menu.Singleton_menu;
import exer3_1.Modules.Users.Model.BLL.BLL_User.open;
import exer3_1.Modules.Users.Model.Classes.Admin;
import exer3_1.Modules.Users.Model.Classes.Client;
import exer3_1.Modules.Users.Model.Classes.NormalUser;
import exer3_1.Modules.Users.Model.Classes.Singleton;
import exer3_1.Modules.Users.Model.Classes.Language.Language_user;
import exer3_1.Utils.Functions_save_settings;
import exer3_1.Utils.Functions_theme;


public class Settings implements Serializable {
	
	///Attributes////
	@XStreamAlias("dateformat")
	private String dateformat;
	@XStreamAlias("coinformat")
	private String coinformat;
	@XStreamAlias("decimalformat")
	private String decimalformat;
	@XStreamAlias("dummies")
	private String dummies;
	@XStreamAlias("resolution")
	private String resolution;
	@XStreamAlias("language")
	private String language;
	@XStreamAlias("fileformat")
	private String fileformat;
	@XStreamAlias("theme")
	private String theme;
	@XStreamAlias("instance")
	private static Settings instance;

	////Methods////

	////Constructor////
	public Settings(String dateformat, String coinformat, String decimalformat, String dummies, String resolution,
			String language, String fileformat, String theme) {

		this.dateformat = dateformat;
		this.coinformat = coinformat;
		this.decimalformat = decimalformat;
		this.dummies = dummies;
		this.resolution = resolution;
		this.language = language;
		this.fileformat = fileformat;
		this.theme = theme;
	}
	//Singleton_menu.settings = new Settings("dd/mm/yyyy", "Euro", ".0", "ON", "Default", "English", "Json", "GTK");
	protected Settings () {
		this.language = "English";
		this.dateformat = "dd/mm/yyyy";
		this.coinformat = "Euro";
		this.dummies = "ON";
		this.resolution = "Default";
		this.decimalformat = ".0";
		this.fileformat = "Json";
		this.theme = "GTK";
	}
	
	public static Settings getInstance () {
		if (instance == null){
			instance = new Settings ();

			Functions_theme.theme();
			Language.getInstance();
			Language_user.getInstance();
			
			Singleton.adminuser = new ArrayList <Admin>();
			Singleton.clientuser = new ArrayList <Client>();
			Singleton.normaluser = new ArrayList <NormalUser>();
			open.auto();
			Functions_save_settings.open();
		}
		return instance;
	}

	public String getDateformat() {
		return dateformat;
	}

	public String getCoinformat() {
		return coinformat;
	}

	public String getDecimalformat() {
		return decimalformat;
	}

	public String getDummies() {
		return dummies;
	}

	public String getResolution() {

		if (this.resolution.equals("Default") || (this.resolution.equals("Por defecto"))
				|| (this.resolution.equals("Per defecte"))) {

			if (this.language.equals("Español") || (this.language.equals("Spanish"))
					|| (this.language.equals("Espanyol"))) {
				resolution = "Por defecto";
			} else if (this.language.equals("Valenciano") || (this.language.equals("Valencian"))
					|| (this.language.equals("Valencia"))) {
				resolution = "Per defecte";
			} else {
				resolution = "Default";
			}
		}

		return resolution;
	}

	public String getLanguage() {
		return language;
	}
	public String getFileformat() {
		return fileformat;
	}
	public String getTheme() {
		return theme;
	}
	public void setDateformat(String dateformat) {
		this.dateformat = dateformat;
	}

	public void setCoinformat(String coinformat) {
		this.coinformat = coinformat;
	}

	public void setDecimalformat(String decimalformat) {
		this.decimalformat = decimalformat;
	}

	public void setDummies(String dummies) {
		this.dummies = dummies;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public void setLanguage(String language) {
		this.language = language;
		Language.getInstance().setLanguage();
		Language_user.getInstance().setLanguage();
		
	}
	public void setFileformat(String fileformat) {
		
		this.fileformat = fileformat;
	}
	
	public void setTheme(String theme) {
		this.theme = theme;
		Functions_theme.theme();
	}

	public String toString() {
		return "Settings [dateformat=" + dateformat + ", coinformat=" + coinformat + ", decimalformat=" + decimalformat
				+ ", dummies=" + dummies + ", resolution=" + resolution + ", language=" + language + "]";
	}

}
