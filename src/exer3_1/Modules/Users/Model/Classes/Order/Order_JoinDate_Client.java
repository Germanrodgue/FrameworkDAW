package exer3_1.Modules.Users.Model.Classes.Order;

import java.text.ParseException;
import java.util.Comparator;

import exer3_1.Modules.Users.Model.Classes.Client;
import exer3_1.Modules.Users.Model.Classes.User;



public class Order_JoinDate_Client implements Comparator <User> {
	public int compare (User u1, User u2) {
		
		try {
			return ((Client)u1).getJoinDate().compareDates2(((Client)u2).getJoinDate());
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return 0;
		
	
}

}
