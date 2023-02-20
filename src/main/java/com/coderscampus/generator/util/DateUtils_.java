package com.coderscampus.generator.util;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Some but not all of this was originally from JLicense, modified and
 * refactored.
 *
 * @author Pete Carapetyan
 * @author Samuel Chen
 */

public class DateUtils_ {

	private static final int MS_A_DAY = 24 * 3600 * 1000;
	private static final int MS_HALF_HOUR = 1800 * 1000;

	public static boolean isDateWithin30Minutes(Date date1, Date date2) {
		long compareTo = date1.getTime() + MS_HALF_HOUR;
		long second = date2.getTime();
		boolean returnValue = false;
		if (compareTo > second) {
			returnValue = true;
		}
		return returnValue;
	}

	public static Date toUtilDate(String yyyy_MM_dd) {
		Date date = null;
		DateFormat formater;
		try {
			formater = new java.text.SimpleDateFormat("yyyy-MM-dd");
			date = formater.parse(yyyy_MM_dd);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				formater = new java.text.SimpleDateFormat("MM/dd/yyyy");
				date = formater.parse(yyyy_MM_dd);
			} catch (Exception e2) {
				e2.printStackTrace();
				// give up!
			}
		}
		return date;
	}

	public static Date getDateFromYyyyMMdd(String yyyyMMdd) {
		Date date = null;
		DateFormat formater;
		try {
			formater = new java.text.SimpleDateFormat("yyyyMMdd");
			date = formater.parse(yyyyMMdd);
		} catch (Exception e) {
			throw new IllegalArgumentException("Was given a date '" + yyyyMMdd
					+ "' which does not evaluate to a yyyyMMdd date");
		}
		return date;
	}

	public static Date getDateFromYyMMdd(String yyMMdd) {
		Date date = null;
		DateFormat formater;
		try {
			formater = new java.text.SimpleDateFormat("yyMMdd");
			date = formater.parse(yyMMdd);
		} catch (Exception e) {
			throw new IllegalArgumentException("Was given a date '" + yyMMdd
					+ "' which does not evaluate to a yyyyMMdd date");
		}
		return date;
	}

	public static Date getDateFromMmDashDdDashYy(String MmDashDdDashYy) {
		Date date = null;
		DateFormat formater;
		try {
			formater = new java.text.SimpleDateFormat("MM-dd-yy");
			date = formater.parse(MmDashDdDashYy);
		} catch (Exception e) {
			throw new IllegalArgumentException("Was given a date '"
					+ MmDashDdDashYy
					+ "' which does not evaluate to a MmDashDdDashYy date");
		}
		return date;
	}

	public static Date getDateFromYyyyMMddHHmmss(String yyyyMMddHHmmss) {
		Date date = null;
		DateFormat formater;
		try {
			formater = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
			date = formater.parse(yyyyMMddHHmmss);
		} catch (Exception e) {
			throw new IllegalArgumentException("Was given a date '"
					+ yyyyMMddHHmmss
					+ "' which does not evaluate to a yyyyMMddHHmmss date");
		}
		return date;
	}

	public static Date getDateFromYyyyMMddHHmmssZeroHours(String yyyyMMddHHmmss) {
		Date date = null;
		DateFormat formater;
		try {
			formater = new java.text.SimpleDateFormat("yyyyMMdd");
			date = formater.parse(yyyyMMddHHmmss.substring(0, 8));
		} catch (Exception e) {
			throw new IllegalArgumentException("Was given a date '"
					+ yyyyMMddHHmmss
					+ "' which does not evaluate to a yyyyMMddHHmmss date");
		}
		return date;
	}

	public static Date getDateFromdd_MMM_yy(String dd_MMM_yy) {
		Date date = null;
		DateFormat formater;
		try {
			formater = new java.text.SimpleDateFormat("dd-MMM-yy");
			date = formater.parse(dd_MMM_yy);
		} catch (Exception e) {
			throw new IllegalArgumentException("Was given a date '" + dd_MMM_yy
					+ "' which does not evaluate to a dd_MMM_yy date");
		}
		return date;
	}

	/**
	 * @param date
	 *            is java.util.Date
	 * @return java.sql.Date Convert a java.util.Date to java.sql.Date
	 */
	public static java.sql.Date toSqlDate(java.util.Date date) {
		if (date == null) {
			return null;
		} else {
			return new java.sql.Date(date.getTime());
		}
	}

	public static java.sql.Date toSqlDate(String dateStr) {
		return DateUtils_.toSqlDate(DateUtils_.toUtilDate(dateStr));
	}

	/**
	 * @return string year
	 */
	public static String getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		return Integer.toString(year);
	}

	/**
	 * @return The previous year, same date
	 */
	public static Date retreatYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		calendar.set(Calendar.YEAR, year - 1);
		Date returnDate = calendar.getTime();
		return returnDate;
	}

	/**
	 * @return last two digital part of the year
	 */
	public static String getXXYear(Date date) {
		return getYear(date).substring(2, 4);
	}

	/**
	 * @return the month of the year
	 */
	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * @return the day of the month
	 */
	public static int getDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * @return the day of the month
	 */
	public static int getDayOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	// DateUtils parser = new DateUtils(args[0]);
	// System.print.println("year=" + parser.getYear());
	// System.print.println("year2=" + parser.getXXYear());
	// System.print.println("month=" + parser.getMonth());
	// System.print.println("day=" + parser.getDayOfMonth());
	// System.print.println("week=" + parser.getDayOfWeek());
	// System.print.println("SUNDAY="+Calendar.SUNDAY);
	// System.print.println("JANUARY="+Calendar.JANUARY);

	public static int getNumberDaysFromToday(Date date) {
		int numberDaysFromToday = -1;
		long time = date.getTime() - System.currentTimeMillis();
		numberDaysFromToday = 1 + (int) (time / MS_A_DAY);
		return numberDaysFromToday;
	}

	public static long dateSecondsDifference(String yyyyMMddHHmmss) {
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = getCurrentTimeStamp();
		String yyyy = yyyyMMddHHmmss.substring(0, 4);
		String MM = yyyyMMddHHmmss.substring(4, 6);
		String dd = yyyyMMddHHmmss.substring(6, 8);
		String HH = yyyyMMddHHmmss.substring(8, 10);
		String mm = yyyyMMddHHmmss.substring(10, 12);
		String ss = yyyyMMddHHmmss.substring(12, 14);
		calendar1.set(Integer.parseInt(yyyy), Integer.parseInt(MM),
				Integer.parseInt(dd), Integer.parseInt(HH),
				Integer.parseInt(mm), Integer.parseInt(ss));
		long milliseconds1 = calendar1.getTimeInMillis();
		long milliseconds2 = calendar2.getTimeInMillis();
		long diff = milliseconds2 - milliseconds1;
		long diffSeconds = diff / 1000;
		long diffMinutes = diff / (60 * 1000);
		long diffHours = diff / (60 * 60 * 1000);
		long diffDays = diff / (24 * 60 * 60 * 1000);
		// System.print.println("\nThe Date Different Example");
		// System.print.println("Time in milliseconds: " + diff +
		// " milliseconds.");
		// System.print.println("Time in seconds: " + diffSeconds + " seconds.");
		// System.print.println("Time in minutes: " + diffMinutes + " minutes.");
		// System.print.println("Time in hours: " + diffHours + " hours.");
		// System.print.println("Time in days: " + diffDays + " days.");
		// System.print.println("Time in years: " + diffDays / 365 + " years.");
		return diffSeconds;

	}

	public static Calendar getCurrentTimeStamp() {
		// this is a supremely goofy way to do this but derives from failures to
		// do it the easier ways. Rather than understand it I'm just doing what
		// works.
		String yyyyMMddHHmmss = StringUtils_.yyyyMMddHHmmss(new Date());
		Calendar calendar = Calendar.getInstance();
		String yyyy = yyyyMMddHHmmss.substring(0, 4);
		String MM = yyyyMMddHHmmss.substring(4, 6);
		String dd = yyyyMMddHHmmss.substring(6, 8);
		String HH = yyyyMMddHHmmss.substring(8, 10);
		String mm = yyyyMMddHHmmss.substring(10, 12);
		String ss = yyyyMMddHHmmss.substring(12, 14);
		// System.print.println("yyyy" + yyyy);
		// System.print.println("MM" + MM);
		// System.print.println("dd" + dd);
		// System.print.println("HH" + HH);
		// System.print.println("mm" + mm);
		// System.print.println("ss" + ss);
		calendar.set(Integer.parseInt(yyyy), Integer.parseInt(MM),
				Integer.parseInt(dd), Integer.parseInt(HH),
				Integer.parseInt(mm), Integer.parseInt(ss));
		return calendar;
	}

	public static Date followingDay(Date date, int howManyDaysFollowing) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int day = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.set(Calendar.DAY_OF_YEAR, day + howManyDaysFollowing);
		Date returnDate = calendar.getTime();
		return returnDate;
	}

	public static Date nHoursLater(Date date, int n) throws Exception {
		if (n > 11) {
			throw new RuntimeException(
					"Cannot do "
							+ n
							+ " hours later, or any number of hours later greater than 11");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		calendar.set(Calendar.HOUR_OF_DAY, hour + n);
		Date returnDate = calendar.getTime();
		return returnDate;
	}

	public static Date getMidnight(Date date) {
		Calendar cal = Calendar.getInstance(); // get calendar instance
		cal.setTime(date); // set cal to date
		cal.set(Calendar.HOUR_OF_DAY, 0); // set hour to midnight
		cal.set(Calendar.MINUTE, 0); // set minute in hour
		cal.set(Calendar.SECOND, 0); // set second in minute
		cal.set(Calendar.MILLISECOND, 0); // set millis in second
		Date zeroedDate = cal.getTime();
		return zeroedDate;
	}

	public static long getMidnight(long dateTime) {
		Date date = new Date(dateTime);
		return getMidnight(date).getTime();
	}

	public static Date prefixedWithYyMMdd(String prefixedWithYyMMdd) {
		Date date = null;
		DateFormat formater;
		String mightBeDate = null;
		if (null != prefixedWithYyMMdd && prefixedWithYyMMdd.length() > 8) {
			mightBeDate = prefixedWithYyMMdd.substring(0, 6);
			if (mightBeDate.startsWith("1") || mightBeDate.startsWith("0")) {
				try {
					formater = new java.text.SimpleDateFormat("yyMMdd");
					date = formater.parse(mightBeDate);
					if (prefixedWithYyMMdd.toUpperCase().endsWith(".TXT")) {
						date = nHoursLater(date, 7);
					} else if (prefixedWithYyMMdd.toUpperCase().endsWith(".MM")) {
						date = nHoursLater(date, 8);
					} else {
						date = nHoursLater(date, 6);
					}
				} catch (Exception e) {
					date = null;
					// do nothing, lousy programming but effective
				}
			}
		}
		return date;
	}

}
