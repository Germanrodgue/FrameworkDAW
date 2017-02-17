package exer3_1.Modules.Users.Model.Classes.Order;

import java.util.Comparator;

import exer3_1.Modules.Users.Model.Classes.User;

public class Order_Name implements Comparator <User>{
	
	
	public int compare (User u1, User u2) {
		if(u1.getName().compareTo(u2.getName())>0)
			return 1;
		if(u1.getName().compareTo(u2.getName())<0)
			return -1;
		return 0;
	}
}
