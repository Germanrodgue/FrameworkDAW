package exer3_1.Modules.Users.Model.Classes.Order;

import java.util.Comparator;

import exer3_1.Modules.Users.Model.Classes.NormalUser;
import exer3_1.Modules.Users.Model.Classes.User;

public class Order_Karma implements Comparator <User>{
	public int compare (User u1, User u2) {
		if(((NormalUser)u1).getKarma_int()>(((NormalUser)u2).getKarma_int()))
			return 1;
		if(((NormalUser)u1).getKarma_int()<(((NormalUser)u2).getKarma_int()))
			return -1;
		return 0;
	}

}
