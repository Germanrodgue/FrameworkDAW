package exer3_1.Modules.Users.Model.Classes.Order;

import java.text.ParseException;
import java.util.Comparator;

import exer3_1.Modules.Users.Model.Classes.User;


public class Order_Birthday implements Comparator <User> {
	public int compare (User u1, User u2) {
		
			try {
				return u1.getBirthdate().compareDates2(u2.getBirthdate());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
			
		
	}

}
