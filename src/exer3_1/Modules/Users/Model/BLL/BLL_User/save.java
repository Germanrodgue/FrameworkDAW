package exer3_1.Modules.Users.Model.BLL.BLL_User;

import exer3_1.Modules.Users.Model.Utils.Files.Admin.Utils_files.auto_admin;
import exer3_1.Modules.Users.Model.Utils.Files.Client.Utils_files.auto_client;
import exer3_1.Modules.Users.Model.Utils.Files.NormalUser.Utils_files.auto_normal;

public class save {
	public static void auto() {
		auto_admin.Json_save_admin();
		auto_client.Json_save_client();
		auto_normal.Json_save_nuser();
		auto_admin.Xml_save_admin();
		auto_client.Xml_save_client();
		auto_normal.Xml_save_nuser();
		auto_admin.Txt_save_admin();
		auto_client.Txt_save_client();
		auto_normal.Txt_save_normal();
	}
}
