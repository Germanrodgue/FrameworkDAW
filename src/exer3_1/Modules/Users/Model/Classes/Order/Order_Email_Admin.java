package exer3_1.Modules.Users.Model.Classes.Order;

import java.util.Comparator;

import exer3_1.Modules.Users.Model.Classes.Admin;
import exer3_1.Modules.Users.Model.Classes.User;


public class Order_Email_Admin implements Comparator <User>  {
	
	public int compare (User u1, User u2) {
	if(((Admin)u1).getEmail().compareTo(((Admin)u2).getEmail())>0)
		return 1;
	if(((Admin)u1).getEmail().compareTo(((Admin)u2).getEmail())<0)
		return -1;
	return 0;
	
	}
}
