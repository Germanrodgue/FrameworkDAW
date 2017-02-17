package exer3_1.Modules.Users.Model.Classes;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import exer3_1.Classes.*;
import exer3_1.Modules.Users.Model.Classes.Language.Language_user;

/**
 * Class used to create, set, and get Normal User
 * 
 * @version 5.1, 15/2/2017
 * @author German Rodriguez
 *
 */

public class NormalUser extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1771857258889761263L;
	//// Attributes////
	@XStreamAlias("comments")
	private int comments;
	@XStreamAlias("karma")
	private String karma;

	/**
	 * Attribute of the normal users
	 * 
	 * @param points
	 *            Max points: 999 points
	 */
	//// Methods////

	//// Constructor////
	public NormalUser(String id, String name, String address, String gender, date birthdate,
			int comments) {
		super(id, name, address, gender, birthdate);

		this.comments = comments;

	}

	public NormalUser() {
		super();
	}

	public NormalUser(String id) {
		super(id);
	}

	//// Get/////
	public int getKarma_int() {
		int ret = 0;

		if ((this.getKarma().equals("Low")) || (this.getKarma().equals("Bajo")) || (this.getKarma().equals("Baix"))) {
			ret = 0;

		} else if ((this.getKarma().equals("Medium")) || (this.getKarma().equals("Medio"))
				|| (this.getKarma().equals("Mig"))) {
			ret = 1;

		} else if ((this.getKarma().equals("High")) || (this.getKarma().equals("Alto"))
				|| (this.getKarma().equals("Alt"))) {
			ret = 2;
		} else {
			ret = 0;

		}
		return ret;
	}

	public int getPoints() {
		int sum_points = 0;

		if ((this.getKarma().equals("Low")) || (this.getKarma().equals("Bajo")) || (this.getKarma().equals("Baix"))) {
			sum_points = 100;

		} else if ((this.getKarma().equals("Medium")) || (this.getKarma().equals("Medio"))
				|| (this.getKarma().equals("Mig"))) {
			sum_points = 250;

		} else if ((this.getKarma().equals("High")) || (this.getKarma().equals("Alto"))
				|| (this.getKarma().equals("Alt"))) {
			sum_points = 500;

		} else {
			sum_points = 0;

		}
		return sum_points;
	}

	public String getAvatar_icon() {
		String icon = "";

		if (this.getGender().equals("Male") || this.getGender().equals("Hombre") || this.getGender().equals("Home")) {
			icon = "icon";
		} else if (this.getGender().equals("Female") || this.getGender().equals("Mujer")
				|| this.getGender().equals("Dona")) {
			icon = "icon2";
		} else if (this.getGender().equals("Other") || this.getGender().equals("Otro")
				|| this.getGender().equals("Altre")) {
			icon = "icon3";
		}
		return icon;
	}

	public int getComments() {

		return this.comments;
	}

	public String getKarma() {

		if (this.getComments() > 0 && (this.getComments() <= 100)) {
			this.karma = Language_user.getInstance().getProperty("low");
		} else if (this.getComments() > 100 && (this.getComments() <= 200)) {
			this.karma = Language_user.getInstance().getProperty("medium");
		} else if (this.getComments() > 200) {
			this.karma = Language_user.getInstance().getProperty("high");
		} else {
			this.karma = Language_user.getInstance().getProperty("nokarma");
		}
		return this.karma;
	}

	//// Set////

	public void setComments(int comments) {
		this.comments = comments;
	}

	//// ToString/////
	public String toString() {
		String ch = "";

		ch = ch + " " + Language_user.getInstance().getProperty("theuser") + " ("
				+ Language_user.getInstance().getProperty("nuser") + ") "
				+ Language_user.getInstance().getProperty("called") + " " + this.getName();
		ch = ch + "\n " + Language_user.getInstance().getProperty("age") + this.getAge() + " "
				+ Language_user.getInstance().getProperty("yearsold");
		ch = ch + "\n " + Language_user.getInstance().getProperty("birthdate") + this.getBirthdate().getDate();
		ch = ch + "\n " + Language_user.getInstance().getProperty("gender_tostring") + this.getGender();
		ch = ch + "\n " + Language_user.getInstance().getProperty("comments_tostring") + this.getComments();
		ch = ch + "\n " + Language_user.getInstance().getProperty("karma") + this.getKarma();
		ch = ch + "\n " + Language_user.getInstance().getProperty("points_tostring") + this.getPoints();
		ch = ch + "\n " + Language_user.getInstance().getProperty("resolution_tostring")
				+ Settings.getInstance().getResolution();
		return ch;
	}

}