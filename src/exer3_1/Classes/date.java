package exer3_1.Classes;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import com.thoughtworks.xstream.annotations.XStreamAlias;


public class date implements Serializable{
	
	private static final long serialVersionUID = 8050937851476090768L;
	////Attributes/////
	@XStreamAlias("day")
	private int day = 0;
	@XStreamAlias("month")
	private int month = 0;
	@XStreamAlias("year")
	private int year = 0;
	@XStreamAlias("date")
	private String date;
	@XStreamAlias("data")
	String[] data = new String[3];
	////Methods////

	////Constructor////
	public date(String date) {

		if (Settings.getInstance().getDateformat().equals("yyyy-mm-dd")) {
			data = date.split("-");
			this.day = Integer.parseInt(data[2]);
			this.month = Integer.parseInt(data[1]);
			this.year = Integer.parseInt(data[0]);
			this.date = date;
		}

		if (Settings.getInstance().getDateformat().equals("yyyy/mm/dd")) {
			data = date.split("/");
			this.day = Integer.parseInt(data[2]);
			this.month = Integer.parseInt(data[1]);
			this.year = Integer.parseInt(data[0]);
			this.date = date;
		}

		if (Settings.getInstance().getDateformat().equals("dd/mm/yyyy")) {
			data = date.split("/");
			this.day = Integer.parseInt(data[0]);
			this.month = Integer.parseInt(data[1]);
			this.year = Integer.parseInt(data[2]);
			this.date = date;
		}

		if (Settings.getInstance().getDateformat().equals("dd-mm-yyyy")) {
			data = date.split("-");
			this.day = Integer.parseInt(data[0]);
			this.month = Integer.parseInt(data[1]);
			this.year = Integer.parseInt(data[2]);
			this.date = date;
		}
	}
	
	public date (int day, int month, int year) {
		this.day=day;
		this.month=month;
		this.year=year;
		if (Settings.getInstance().getDateformat().equals("yyyy-mm-dd")) {
		this.date=day+"-"+month+"-"+year;
		} else if (Settings.getInstance().getDateformat().equals("yyyy/mm/dd")) {
			this.date=year+"/"+month+"/"+day;
		} else if (Settings.getInstance().getDateformat().equals("dd/mm/yyyy")) {
			this.date=day+"/"+month+"/"+year;
		} else if (Settings.getInstance().getDateformat().equals("dd-mm-yyyy")) {
			this.date=day+"-"+month+"-"+year;
		}
		
	}
	
	////Current date dd/mm/yyyy////
	public String currentdate() {
		int year = 0;
		int day = 0;
		int month = 0;
		String ch = "";
		Calendar date = new GregorianCalendar();

		year = date.get(Calendar.YEAR);
		day = date.get(Calendar.DAY_OF_MONTH);
		month = date.get(Calendar.MONTH);
		month = month + 1;

		if (Settings.getInstance().getDateformat().equals("yyyy-mm-dd")) {
			ch = ch + year + ("-") + month + ("-") + day;
		}
		if (Settings.getInstance().getDateformat().equals("yyyy/mm/dd")) {
			ch = ch + year + ("/") + month + ("/") + day;
		}
		if (Settings.getInstance().getDateformat().equals("dd/mm/yyyy")) {
			ch = ch + day + ("/") + month + ("/") + year;
		}
		if (Settings.getInstance().getDateformat().equals("dd-mm-yyyy")) {
			ch = ch + day + ("-") + month + ("-") + year;
		}
		return ch;
	}

	////Current year (yyyy)////
	public int currentyear() {
		int year = 0;
		Calendar date = new GregorianCalendar();

		year = date.get(Calendar.YEAR);
		return year;
	}

	////Current day////
	public int currentday() {
		int day = 0;
		Calendar date = new GregorianCalendar();

		day = date.get(Calendar.DAY_OF_MONTH);
		return day;
	}

	////Current month////
	public int currentmonth() {
		int month = 0;
		Calendar date = new GregorianCalendar();

		month = date.get(Calendar.MONTH);
		return month;
	}

	public int CalculateAge() {
		int diff, y1, m1, d1, day, months, years;
		Calendar cal1 = new GregorianCalendar();

		day = this.day;
		months = this.month;
		years = this.year;
		y1 = cal1.get(Calendar.YEAR);
		m1 = cal1.get(Calendar.MONTH);
		m1 = m1 + 1;
		d1 = cal1.get(Calendar.DAY_OF_MONTH);

		System.out.println("dia " + day + "mes " + months + "year " + years);
		System.out.println("dia " + d1 + "mes " + m1 + "year " + y1);
		if ((day > d1) && (months == m1)) {

			years = years + 1;

			System.out.println(years + "1");

		} else if ((day < d1) && (months > m1)) {

			years = years + 1;

			System.out.println(years + "2");

		} else if ((day > d1) && (months > m1)) {

			years = years + 1;

			System.out.println(years + "3");
		}

		diff = y1 - years;

		return diff;

	}

	////Substract a date to get the age or the antiquity////
	public int SubstractDates() {
		int diff, y1, m1, months, years;
		Calendar cal1 = new GregorianCalendar();

		months = this.month;
		years = this.year;
		y1 = cal1.get(Calendar.YEAR);
		m1 = cal1.get(Calendar.MONTH);

		if (m1 < months) {
			y1 = y1 - 1;
		}

		diff = y1 - years;

		return diff;
	}

	////Check if the date is correct.////
	public boolean CheckDate() {
		int month, day, year;
		month = this.month;
		day = this.day;
		year = this.year;

		int febMax = 0;
		int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if ((month <= 0) || (month > 12)) {
			return false;
		}

		if ((year < 1930) || (year > 2100)) {
			return false;
		}
		month = month - 1;

		if (month == 1) {
			febMax = 28;
			if (((year % 4) == 0) && ((year % 100) != 0) || ((year % 400) == 0)) {
				febMax = 29;
			}
			if ((day < 1) || (day > febMax)) {
				return false;
			}

		} else if ((day <= 0) || (day > months[month])) {
			return false;
		}

		return true;
	}

	////Compare a date to check if its before or after the current date////
	public int compareDates_currentyear(date f) throws ParseException {

		Calendar cal1 = this.StringToCalendar(f.currentdate());
		Calendar cal2 = this.StringToCalendar(f.getDate());

		if (cal1.before(cal2)) {
			return 1;
		} else if (cal1.after(cal2)) {
			return 2;
		} else {
			return 3;
		}
	}

	public int compareDates2(date f) throws ParseException {

		Calendar cal1 = this.StringToCalendar(this.date);
		Calendar cal2 = this.StringToCalendar(f.getDate());

		if (cal1.before(cal2)) {
			return 1;
		} else if (cal1.after(cal2)) {
			return -1;
		} else {
			return 0;
		}

	}

	////Compare 2 dates if the first one is before or after the second date////
	public int compareDates(date f) throws ParseException {

		Calendar cal1 = this.StringToCalendar(this.date);
		Calendar cal2 = this.StringToCalendar(f.getDate());

		if (cal1.before(cal2)) {
			return 1;
		} else if (cal1.after(cal2)) {
			return 2;
		} else {
			return 3;
		}

	}

	public Calendar StringToCalendar(String fecha) throws ParseException {

		Calendar cal = Calendar.getInstance();

		if (Settings.getInstance().getDateformat().equals("yyyy/mm/dd")) {
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			cal.setTime(df.parse(fecha));
			return cal;
		} else if (Settings.getInstance().getDateformat().equals("yyyy-mm-dd")) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			cal.setTime(df.parse(fecha));
			return cal;
		} else if (Settings.getInstance().getDateformat().equals("dd/mm/yyyy")) {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			cal.setTime(df.parse(fecha));
			return cal;
		} else if (Settings.getInstance().getDateformat().equals("dd-mm-yyyy")) {
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

			cal.setTime(df.parse(fecha));
			return cal;
		}

		return cal;
	}

	////Get////
	public String getDate() {
		String ch = "";

		if (Settings.getInstance().getDateformat().equals("yyyy-mm-dd")) {
			ch = ch + this.year + ("-") + this.month + ("-") + this.day;
		}
		if (Settings.getInstance().getDateformat().equals("yyyy/mm/dd")) {
			ch = ch + this.year + ("/") + this.month + ("/") + this.day;
		}
		if (Settings.getInstance().getDateformat().equals("dd/mm/yyyy")) {
			ch = ch + this.day + ("/") + this.month + ("/") + this.year;
		}
		if (Settings.getInstance().getDateformat().equals("dd-mm-yyyy")) {
			ch = ch + this.day + ("-") + this.month + ("-") + this.year;
		}

		return ch;
	}

	public String getDatearray(int op) {
		String str1 = "";

		if (op == 0) {
			str1 = this.data[0];
		}
		if (op == 1) {
			str1 = this.data[1];
		}
		if (op == 2) {
			str1 = this.data[2];
		}

		return str1;
	}

	public int getyear() {

		return this.year;
	}

	public int getday() {

		return this.day;
	}

	public int getmonth() {

		return this.month;

	}

}
