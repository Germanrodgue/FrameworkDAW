package exer3_1.Modules.Users.Model.Classes;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import exer3_1.Classes.date;
import exer3_1.Modules.Users.Model.Classes.Language.Language_user;

/**
 * Class User, subclasses: Client, Admin, Normal User
 * 
 * @version 5.1, 15/2/2017
 * @author German Rodriguez
 *
 */
public abstract class User implements Comparable<User>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6835915140955469769L;
	/**
	 * Attributes
	 * 
	 * @param id
	 *            12345678X - Spanish identification number.
	 * @param name
	 *            Only Words.
	 * @param addres
	 *            No restrictions, optional.
	 * @param type
	 *            Combobox that shows the type of user being created.
	 * @param birthdate
	 *            Example: 10/10/2010, for Clients/Normal Users must be +18 and
	 *            for Admins must be +16. Returned as an object of type "date".
	 */

	//// Attributes////
	@XStreamAlias("id")
	private String id;
	@XStreamAlias("name")
	private String name;
	@XStreamAlias("address")
	private String address;
	@XStreamAlias("gender")
	private String gender;
	@XStreamAlias("birthdate")
	private date birthdate;

	//// Methods////

	//// Constructor////
	public User(String id, String name, String address, String gender, date birthdate) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.birthdate = birthdate;

	}

	public User() {
	}

	public User(String id) {
		this.id = id;
	}

	//// Get/////
	public String getId() {

		return this.id;
	}

	public String getName() {

		return this.name;
	}

	public String getAddress() {

		if ((this.address.equals("")) || this.address.equals("No address") || this.address.equals("Sin direccion")
				|| this.address.equals("Sense direccio")) {
			this.address = Language_user.getInstance().getProperty("addressoff");
		}

		return this.address;
	}

	/**
	 * 
	 * @param age
	 *            It contains the age as int. Substracted from the birthdate and
	 *            the current year.
	 * @return age as an int
	 * 
	 */
	public int getAge() {
		int age = 0;

		age = this.birthdate.CalculateAge();

		return age;
	}

	public String getAgeString() {
		int age = 0;
		String a = "";

		age = this.birthdate.CalculateAge();
		a = String.valueOf(age);

		return a;
	}

	public String getGender() {
		String gender = "";

		if ((this.gender.equals("Male") || this.gender.equals("Hombre") || (this.gender.equals("Home")))) {
			gender = Language_user.getInstance().getProperty("male");
		} else if ((this.gender.equals("Female") || this.gender.equals("Mujer") || (this.gender.equals("Dona")))) {
			gender = Language_user.getInstance().getProperty("female");
		} else {
			gender = Language_user.getInstance().getProperty("other");
		}

		return gender;
	}


	public date getBirthdate() {

		return this.birthdate;
	}

	//// Set/////
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public void setBirthdate(date birthdate) {
		this.birthdate = birthdate;
	}

	public int compareTo(User param) { // To sort them by ID
		if (this.getId().compareTo(param.getId()) > 0)
			return 1;
		if (this.getId().compareTo(param.getId()) < 0)
			return -1;
		return 0;
	}

	public boolean equals_id(Object param) {
		return getId().equals(((User) param).getId());
	}

	//// ToString////
	public String toString() {
		String ch = "";

		return ch;
	}

}
