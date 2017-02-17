package exer3_1.Utils;

import javax.swing.JOptionPane;

import exer3_1.Classes.Language.Language;

public class Functions {

	// Loop validate an INT
	public static int InsertInt(String message, String title, int op, String data) {
		String control = "";
		int control_validate = 0;
		int number = 0;
		boolean correct = true;

		if (op == 1) {
			do {
				try {
					control = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);

					if (control == null) {
						JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("exiting"),
								Language.getInstance().getProperty("exiting"), JOptionPane.INFORMATION_MESSAGE);

						System.exit(0);
					} else {
						number = Integer.parseInt(control);
						correct = true;
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("insertint"), "Error",
							JOptionPane.ERROR_MESSAGE);
					correct = false;
				}
			} while (correct == false);
		}
		if (op == 2) {
			do {
				try {
					control = data;

					if (control == null) {
						System.exit(0);
					} else {
						number = Integer.parseInt(control);
						control_validate = 1;
						correct = true;
					}

				} catch (Exception e) {
					control_validate = 0;
					correct = true;
				}
			} while (correct == false);
			if (control_validate == 1) {
				number = 1;
			} else {
				number = 0;
			}
		}
		return number;

	}

	// Loop validate a char
	public static int InsertChar(String message, String title) {
		String control = "";
		char ch = ' ';
		boolean correct = true;

		do {
			try {
				control = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
				if (control == null) {
					JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("exiting"),
							Language.getInstance().getProperty("exiting"), JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				} else {
					ch = control.charAt(0);
					correct = true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("insertint"), "Error",
						JOptionPane.ERROR_MESSAGE);
				correct = false;
			}
		} while (correct == false);

		return ch;
	}

	// Loop validate a Float
	public static float InsertFloat(String message, String title) {
		String control = "";
		float number = 0.0f;
		boolean correct = true;

		do {
			try {
				control = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
				System.out.println(control);
				if (control == null) {
					JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("exiting"),
							Language.getInstance().getProperty("exiting"), JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				} else {
					number = Float.parseFloat(control);
					correct = true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "You didn't insert a float", "Error", JOptionPane.ERROR_MESSAGE);
				correct = false;
			}
		} while (correct == false);

		return number;

	}

	// Loop Insert a String
	public static String InsertString(String message, String title, int op, String data) {
		String control = "";
		boolean correct = true;
		;

		if (op == 1) {
			do {
				try {

					control = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
					if (control == null) {

						correct = true;
					} else {
						correct = true;
					}
					if (control.equals("")) {
						JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("insertstring"),
								Language.getInstance().getProperty("exiting"), JOptionPane.ERROR_MESSAGE);
						correct = false;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, Language.getInstance().getProperty("insertstring"), "Error",
							JOptionPane.ERROR_MESSAGE);
					correct = false;
				}
			} while (correct == false);
		}
		if (op == 2) {
			do {
				try {
					control = data;
					if (control == null) {
						System.exit(0);
					} else {
						control = "true";
						correct = true;
					}
					if (control.equals("")) {
						control = "false";
						correct = true;
					}
				} catch (Exception e) {
					control = "false";
					correct = true;
				}
			} while (correct == false);
		}

		return control;

	}

	// ObjectToString
	public static String ConvertObjectToString(Object Obj) { // Converts an
																// object to a
																// string
		String Str = "";
		if (Obj != null) {
			Str = Obj.toString();
		}
		return Str;
	}

}
