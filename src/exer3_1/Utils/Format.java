package exer3_1.Utils;

import java.text.DecimalFormat;

import exer3_1.Classes.Settings;

public class Format {

	// Format €, $, £  + decimals.
	public static String Formatcoin(double COIN) {

		String decimal = "";

		if ((Settings.getInstance().getCoinformat().equals("Euros"))
				|| (Settings.getInstance().getCoinformat().equals("Euro"))) {

			decimal = Format.Formatdecimal(COIN);

			decimal = decimal + "€";
		} else if ((Settings.getInstance().getCoinformat().equals("Dollars"))
				|| (Settings.getInstance().getCoinformat().equals("Dolares"))
				|| (Settings.getInstance().getCoinformat().equals("Dolars"))) {

			COIN = COIN * 1.07558;
			decimal = Format.Formatdecimal(COIN);

			decimal = "$" + decimal;
		} else if ((Settings.getInstance().getCoinformat().equals("Pounds"))
				|| (Settings.getInstance().getCoinformat().equals("Libras"))
				|| (Settings.getInstance().getCoinformat().equals("Lliures"))) {

			COIN = COIN * 0.845294;
			decimal = Format.Formatdecimal(COIN);

			decimal = "£" + decimal;
		}

		return decimal;
	}

	///Only decimals
	public static String Formatdecimal(double decimal) {
		DecimalFormat format1 = new DecimalFormat(".#");

		if (Settings.getInstance().getDecimalformat().equals(".0")) {
			format1 = new DecimalFormat(".0");
			return format1.format(decimal);
		} else if (Settings.getInstance().getDecimalformat().equals(".00")) {
			format1 = new DecimalFormat(".00");

			return format1.format(decimal);
		} else if (Settings.getInstance().getDecimalformat().equals(".000")) {
			format1 = new DecimalFormat(".000");
			return format1.format(decimal);
		}

		return format1.format(decimal);
	}

}
