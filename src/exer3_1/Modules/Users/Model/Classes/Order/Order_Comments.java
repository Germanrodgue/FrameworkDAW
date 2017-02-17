package exer3_1.Modules.Users.Model.Classes.Order;

import java.util.Comparator;

import exer3_1.Modules.Users.Model.Classes.NormalUser;
import exer3_1.Modules.Users.Model.Classes.User;

public class Order_Comments implements Comparator <User>{
	public int compare (User u1, User u2) {
		if(((NormalUser)u1).getComments()>(((NormalUser)u2).getComments()))
			return 1;
		if(((NormalUser)u1).getComments()<(((NormalUser)u2).getComments()))
			return -1;
		return 0;
	}
}
