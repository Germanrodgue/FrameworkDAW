package exer3_1.Modules.Users.Model.Classes.Order;

import java.util.Comparator;

import exer3_1.Modules.Users.Model.Classes.Client;
import exer3_1.Modules.Users.Model.Classes.User;


public class Order_Purchases implements Comparator <User>  {
	public int compare (User u1, User u2) {
//		if(((Client)u1).getPurchasesString().compareTo(((Client)u2).getPurchasesString())>0)
//			return 1;
//		if(((Client)u1).getPurchasesString().compareTo(((Client)u2).getPurchasesString())<0)
//			return -1;
//		return 0;
		
		
		if(((Client) u1).getPurchases()>(((Client) u2).getPurchases()))
			return 1;
		if(((Client) u1).getPurchases()<(((Client) u2).getPurchases()))
			return -1;
		return 0;
	}
}
