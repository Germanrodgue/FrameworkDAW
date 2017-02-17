package exer3_1.Modules.Users.Model.Classes.Order;

import java.text.ParseException;
import java.util.Comparator;

import exer3_1.Modules.Users.Model.Classes.Admin;
import exer3_1.Modules.Users.Model.Classes.User;


public class Order_JoinDate_Admin implements Comparator <User> {
		public int compare (User u1, User u2) {
			
				try {
					return ((Admin)u1).getJoinDate().compareDates2(((Admin)u2).getJoinDate());
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
				return 0;
				
			
		}

}
