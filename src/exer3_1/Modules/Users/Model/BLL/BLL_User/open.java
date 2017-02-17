package exer3_1.Modules.Users.Model.BLL.BLL_User;

import exer3_1.Modules.Users.Model.Utils.Files.Admin.Utils_files.auto_admin;
import exer3_1.Modules.Users.Model.Utils.Files.Client.Utils_files.auto_client;
import exer3_1.Modules.Users.Model.Utils.Files.NormalUser.Utils_files.auto_normal;

public class open {
	public static void auto() {
		auto_admin.Json_open_admin();
		auto_client.Json_open_client();
		auto_normal.Json_open_nuser();
		
		auto_admin.Xml_open_admin();
		auto_client.Xml_open_client();
		auto_normal.Xml_open_nuser();
		
		auto_admin.Txt_open_admin();
		auto_client.Txt_open_client();
		auto_normal.Txt_open_normal();
	}
	
}
