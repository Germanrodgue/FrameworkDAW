package exer3_1.Modules.Users.Model.Classes.Order;

import java.util.Comparator;

import exer3_1.Modules.Users.Model.Classes.User;



public class Order_Age implements Comparator <User> {
	
	public int compare (User u1, User u2) {
				
		if(u1.getAge()>(u2.getAge()))
			return 1;
		if(u1.getAge()<(u2.getAge()))
			return -1;
		return 0;
	
	}
}
