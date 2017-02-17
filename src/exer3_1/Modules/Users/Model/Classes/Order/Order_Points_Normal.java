package exer3_1.Modules.Users.Model.Classes.Order;

import java.util.Comparator;

import exer3_1.Modules.Users.Model.Classes.NormalUser;
import exer3_1.Modules.Users.Model.Classes.User;



public class Order_Points_Normal implements Comparator <User>{
	public int compare (User u1, User u2) {
		if(((NormalUser)u1).getPoints()>(((NormalUser)u2).getPoints()))
			return 1;
		if(((NormalUser)u1).getPoints()<(((NormalUser)u2).getPoints()))
			return -1;
		return 0;
	}

}
