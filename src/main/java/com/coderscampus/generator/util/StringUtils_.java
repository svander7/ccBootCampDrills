package com.coderscampus.generator.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 *
 * <h2>PMStringUtils</h2> A collection of various string utilities. <br>
 * <br>
 * These are used throughout the various patternmachine projects
 *
 * @author Pete Carapetyan pete@datafundamentals.com
 */

public class StringUtils_ {
	public StringUtils_() {
		super();
	}

	public static synchronized String camelCaseConvertToConstant(String string) {
		char aChar;
		StringBuffer sb = new StringBuffer(string.length() + 5);
		for (int x = 0; x < string.length();) {
			aChar = string.charAt(x++);
			int oneNumber = new Integer(aChar).intValue();
			if ((oneNumber >= 65) && (oneNumber <= 90)) {
				sb.append("_" + (char) oneNumber);
			} else if ((oneNumber >= 97) && (oneNumber <= 122)) {
				sb.append((char) (oneNumber - 32));
			} else if ((oneNumber >= 48) && (oneNumber <= 57)) {
				sb.append((char) oneNumber);
			} else {
				throw new IllegalArgumentException("Cannot convert letter '"
						+ aChar + "' because it is not a number or a letter");
			}
		}
		String returnValue = sb.toString();
		if (returnValue.startsWith("_")) {
			returnValue = returnValue.substring(1, returnValue.length());
		}
		return returnValue;
	}

	public static String getFrontFilledFixedLengthString(String string,
			char backFill, int length, boolean errorOnWidth,
			boolean errorIfNotNumeric) {
		String returnValue = string;
		if (null == string) {
			throw new IllegalArgumentException("cannot backfill a null value");
		}
		if (errorIfNotNumeric) {
			try {
				double temp = Double.parseDouble(string);
			} catch (NumberFormatException e) {
				throw new NumberFormatException(
						"Was asked to throw a NumberFormatException if given a value that is not numeric, which '"
								+ string + "' seems to be");
			}
		}
		if (errorOnWidth) {
			if (returnValue.length() > length) {
				throw new IllegalArgumentException(
						"Was asked to throw an error if given a string longer than "
								+ length + " charachters");
			}
		}
		while (returnValue.length() < length) {
			returnValue = backFill + returnValue;
		}
		return returnValue;
	}

	/**
	 * @param String
	 *            such as com.myurl.folder
	 * @return String such as com/myurl/folder
	 */
	public static synchronized String dotPathToSlashPath(String path) {
		return replace(path, ".", "/");
	}

	/**
	 * can't figure out what this does
	 *
	 * @param String
	 *            s
	 * @return String
	 */
	// public static synchronized String packageRootReturn(String value) {
	// try {
	// StringTokenizer stk= new StringTokenizer(value, ".");
	// String packageName= "";
	// boolean firstToken= true;
	// while (stk.hasMoreTokens()) {
	// if (firstToken) {
	// packageName= stk.nextToken();
	// firstToken= false;
	// } else {
	// packageName= stk.nextToken() + "." + packageName;
	// }
	// }
	// return packageName.toLowerCase();
	// } catch (Exception e) {
	// e.printStackTrace();
	// e.getCause().printStackTrace();
	// throw new RuntimeException(e.getMessage(), e);
	// }
	// }
	public static String timeFileName(String ending) {
		return "0" + new Date().getTime() + "." + ending;
	}

	/**
	 * @param String
	 * @return String
	 */
	public static synchronized void printProperties(Properties properties) {
		try {
			StringTokenizer stk = new StringTokenizer(properties.toString(),
					" ");
			String packageName = "";
			boolean firstToken = true;
			while (stk.hasMoreTokens()) {
				System.out.println(stk.nextToken());
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause().printStackTrace();
		}
	}

	/**
	 * This is copied from somewhere but did not write down, credit is due that
	 * source Hope it wasn't SCO. <br>
	 * <br>
	 * used to print a custom error message along with throwing an appropriate
	 * error
	 *
	 * @param String
	 *            an argument to be tested
	 * @param String
	 *            message - a message to be printed with the error thrown
	 */
	public static void assertNotBlank(String theString, String theMessage) {
		if (theString == null) {
			throw new IllegalArgumentException(":Null argument not allowed"
					+ theMessage);
		}
		if (theString.trim().equals("")) {
			throw new IllegalArgumentException(":Blank argument not allowed:"
					+ theMessage);
		}
	}

	/**
	 * @param String
	 * @return String
	 */
	public static String notNull(String theString) {
		if (theString == null) {
			return new String("");
		}
		return theString;
	}

	/**
	 * @param String
	 * @return String
	 */
	public static synchronized String lastToken(String value, char delimiter) {
		StringTokenizer stk = new StringTokenizer(value,
				String.valueOf(delimiter));
		String lastToken = "";
		while (stk.hasMoreTokens()) {
			lastToken = stk.nextToken();
		}
		return lastToken;
	}

	public static String getClassNameLikeFromDelimited(String var,
			char delimiter) {
		StringTokenizer stk = null;
		String token = null;
		String returnValue = "";
		stk = new StringTokenizer(var, String.valueOf(delimiter));
		while (stk.hasMoreTokens()) {
			token = stk.nextToken();
			token = token.substring(0, 1).toUpperCase()
					+ token.substring(1, token.length()).toLowerCase();
			returnValue = returnValue + token;
		}
		return returnValue;
	}

	/**
	 * @param String
	 * @return String
	 */
	public static String getMethodNameLikeFromDelimited(String var,
			char delimiter) {
		StringTokenizer stk = null;
		String token = null;
		String returnValue = "";
		boolean first = true;
		stk = new StringTokenizer(var, String.valueOf(delimiter));
		while (stk.hasMoreTokens()) {
			token = stk.nextToken();
			if (first) {
				token = token.substring(0, token.length()).toLowerCase();
				first = false;
			} else {
				token = token.substring(0, 1).toUpperCase()
						+ token.substring(1, token.length()).toLowerCase();
			}
			returnValue = returnValue + token;
		}
		return returnValue;
	}

	/**
	 * This method is useful for creating lists that use letters instead of
	 * numbers, such as a, b, c, d...instead of 1, 2, 3, 4. Valid numbers are
	 * from 1 to 26, corresponding to the 26 letters of the alphabet. By
	 * default, the letter is returned as a lowercase, but if the boolean
	 * upperCaseFlag is true, the letter will be returned as an uppercase.
	 * Creation date: (5/11/00 12:52:23 PM)
	 *
	 * @author: Adam Rossi
	 * @return java.lang.String
	 * @param number
	 *            int
	 */
	public static String numberToLetter(int number, boolean upperCaseFlag)
			throws Exception {
		// add nine to bring the numbers into the right range (in java, a= 10, z
		// = 35)
		if (number < 1 || number > 26) {
			throw new Exception(
					"The number is out of the proper range (1 to 26) to be converted to a letter.");
		}
		int modnumber = number + 9;
		char thechar = Character.forDigit(modnumber, 36);
		if (upperCaseFlag) {
			thechar = Character.toUpperCase(thechar);
		}
		return "" + thechar;
	}

	/**
	 * replace substrings within string. It is odd to need this but I find that
	 * there are some String.replace() situations that don't work, and I had
	 * already developed this so I just use it when the other doesn't work.
	 */
	public static String replace(String s, String sub, String with) {
		int c = 0;
		int i = s.indexOf(sub, c);
		if (i == -1)
			return s;
		StringBuffer buf = new StringBuffer(s.length() + with.length());
		do {

			buf.append(s.substring(c, i));
			buf.append(with);
			c = i + sub.length();
		} while ((i = s.indexOf(sub, c)) != -1);
		if (c < s.length())
			buf.append(s.substring(c, s.length()));
		return buf.toString();
	}

	/**
	 * @param String
	 * @return String
	 */

	public static String upLow(String var) {
		if (var == null | var.equals("")) {
			return " ";
		}
		String start = var.substring(0, 1);
		String finish = var.substring(1, var.length()).toLowerCase();
		return start.toUpperCase() + finish;
	}

	/**
	 * @param String
	 * @return String
	 */

	public static String upStart(String var) {
		if (var == null | var.equals("")) {
			return " ";
		}
		String start = var.substring(0, 1);
		String finish = var.substring(1, var.length());
		return start.toUpperCase() + finish;
	}

	/**
	 * @param String
	 * @return String
	 */
	public static String lowStart(String var) {
		if (var == null | var.equals("")) {
			return " ";
		}
		String start = var.substring(0, 1);
		String finish = var.substring(1, var.length());
		return start.toLowerCase() + finish;
	}

	/**
	 * @param String
	 * @return String
	 */
	public static String trimJavaPeteCStyle(String line) {
		String newLine = replace(line, "\t", "  ");
		while (newLine.endsWith(" ")) {
			newLine = newLine.substring(0, newLine.length() - 1);
		}
		return newLine;
	}

	/**
	 * @param String
	 * @return String
	 */
	public static synchronized boolean isYesNo(String values, String delimiter) {
		ArrayList valuesList = (ArrayList) listFromDelimited(values, delimiter);
		return isYesNo(valuesList);
	}

	/**
	 * @param String
	 * @return String
	 */
	public static synchronized boolean isYesNo(List valuesList) {
		boolean isYesNo = false;
		String value = null;
		for (Iterator iter = valuesList.iterator(); iter.hasNext();) {
			value = (String) iter.next();
			if (trueTest(value) & falseTest(value)) {
				isYesNo = true;
			}
		}
		return isYesNo;
	}

	/**
	 * @param String
	 * @return String
	 */
	public static synchronized boolean trueTest(String val) {
		if (val.equalsIgnoreCase("true") || val.equalsIgnoreCase("Yes")
				|| val.equalsIgnoreCase("Y") || val.equalsIgnoreCase("checked")) {
			return true;
		}
		return false;
	}

	/**
	 * @param String
	 * @return String
	 */
	/**
	 * returns "true" if given Yes, YES, yes, Y or y <br>
	 * returns "false" if given No, NO, no, n, or N <br>
	 * returns null if given anything else
	 *
	 * @param val
	 * @return
	 */
	public static synchronized String yesNoToTrueFalse(String val) {
		String yesNoToTrueFalse = null;
		if (val.equalsIgnoreCase("yes") || val.equalsIgnoreCase("Y")) {
			yesNoToTrueFalse = "true";
		} else if (val.equalsIgnoreCase("no") || val.equalsIgnoreCase("N")) {
			yesNoToTrueFalse = "false";
		}
		return yesNoToTrueFalse;
	}

	/**
	 * @param String
	 * @return String
	 */
	public static synchronized List listFromDelimited(String values,
			String delimiter) {
		ArrayList valuesList = new ArrayList();
		StringTokenizer stk = new StringTokenizer(values, delimiter);
		while (stk.hasMoreTokens()) {
			valuesList.add(stk.nextToken());
		}
		return valuesList;
	}

	/**
	 * @param String
	 * @return String
	 */
	public static synchronized boolean falseTest(String val) {
		if (val.equalsIgnoreCase("false") || val.equalsIgnoreCase("no")
				|| val.equalsIgnoreCase("n")) {
			return true;
		}
		return false;
	}

	/**
	 * @param String
	 * @return String
	 */
	public static synchronized String booleanStringReturn(String val) {
		if (trueTest(val)) {
			return "true";
		} else {
			return "false";
		}
	}

	/**
	 * @param String
	 * @return String
	 */
	public static synchronized boolean isNull(String var) {
		if (var == null || var.equalsIgnoreCase("null")
				|| var.trim().equals("") || var.length() <= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param String
	 * @return String
	 */
	public static synchronized ArrayList splitStringList(String s, int length) {
		try {
			StringTokenizer stk = new StringTokenizer(s, " ");
			ArrayList lines = new ArrayList(2);
			StringBuffer currentLine = new StringBuffer(length);
			String insert = null;
			int lengthBuffer = 0;
			boolean done = false;
			while (stk.hasMoreTokens()) {
				insert = stk.nextToken();
				if ((lengthBuffer + insert.length()) < length) {
					currentLine.append(" " + insert);
					lengthBuffer = lengthBuffer + insert.length();
				} else {
					lengthBuffer = 0;
					lines.add(currentLine.toString().trim());
					currentLine.delete(0, currentLine.length());
					currentLine.append(insert);
					lengthBuffer = lengthBuffer + insert.length();
				}
			}
			lines.add(currentLine.toString().trim());
			return lines;
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause().printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * @param String
	 * @return String
	 */
	public static synchronized ArrayList splitStringListDelimiter(String s,
			int length, String delimiter) {
		try {
			StringTokenizer stk = new StringTokenizer(s, delimiter);
			ArrayList lines = new ArrayList(2);
			StringBuffer currentLine = new StringBuffer(length);
			String insert = null;
			int lengthBuffer = 0;
			boolean done = false;
			while (stk.hasMoreTokens()) {
				insert = stk.nextToken();
				if ((lengthBuffer + insert.length()) < length) {
					currentLine.append(" " + insert);
					lengthBuffer = lengthBuffer + insert.length();
				} else {
					lengthBuffer = 0;
					lines.add(currentLine.toString().trim());
					currentLine.delete(0, currentLine.length());
					currentLine.append(insert);
					lengthBuffer = lengthBuffer + insert.length();
				}
			}
			lines.add(currentLine.toString().trim());
			return lines;
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause().printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * @param String
	 * @return String
	 */
	public static synchronized String splitString(String stringToSplit,
			int length) {
		try {
			if (stringToSplit == null) {
				return "";
			} else if (stringToSplit.length() < 1) {
				return "";
			} else {
				StringBuffer sb = new StringBuffer(300);
				ArrayList textList = splitStringList(stringToSplit, length);
				Iterator stringIterator = textList.iterator();
				while (stringIterator.hasNext()) {
					sb.append((String) stringIterator.next() + "\n");
				}
				return sb.toString();
			}
		} catch (Exception e) {
			throw new RuntimeException("splitString(String) " + e.getMessage());
		}
	}

	/**
	 * @param String
	 * @return String
	 */
	public static synchronized String splitStringWithDelimiter(
			String stringToSplit, int length, String delimiter) {
		try {
			if (stringToSplit == null) {
				return "";
			} else if (stringToSplit.length() < 1) {
				return "";
			} else {
				StringBuffer sb = new StringBuffer(300);
				ArrayList textList = splitStringListDelimiter(stringToSplit,
						length, delimiter);
				Iterator stringIterator = textList.iterator();
				while (stringIterator.hasNext()) {
					sb.append((String) stringIterator.next() + "\n");
				}
				return sb.toString();
			}
		} catch (Exception e) {
			throw new RuntimeException("splitString(String) " + e.getMessage());
		}
	}

	/**
	 * @param String
	 * @return String
	 */
	public static synchronized String splitStringForcedDelimiter(
			String stringToSplit, int length, String delimiter) {
		String testString = null;
		try {
			if (stringToSplit == null) {
				return "";
			} else if (stringToSplit.length() < 1) {
				return "";
			} else {
				StringBuffer sb = new StringBuffer(300);
				ArrayList textList = splitStringList(stringToSplit, length);
				Iterator stringIterator = textList.iterator();
				while (stringIterator.hasNext()) {
					testString = (String) stringIterator.next();
					if (testString.length() > length) {
						testString = splitStringWithDelimiter(testString,
								length, delimiter);
					}
					sb.append(testString + "\n");
				}
				return sb.toString();
			}
		} catch (Exception e) {
			throw new RuntimeException("splitString(String) " + e.getMessage());
		}
	}

	/**
	 * Derived from a similar method in the Expresso User class
	 * http://jcorporate.com
	 */

	public static String nuProjectHash() {
		return randomString(3, false).toLowerCase();
	}

	public static String randomString(int stringLength, boolean numericToo) {
		StringBuffer newString = new StringBuffer("");
		double oneNumber = 0;
		char oneChar;
		int iterations = 0;
		String propValue = "";
		while ((newString.length() < stringLength) && (iterations < 200)) {
			iterations++;
			while (!okNumber(oneNumber, numericToo)) {
				oneNumber = Math.random() * 170;
			}
			oneChar = (char) new Double(oneNumber).intValue();
			newString.append(oneChar);
			oneNumber = 0;
		}

		return newString.toString();
	}

	public static String username(int stringLength) {
		StringBuffer newString = new StringBuffer("");
		double oneNumber = 0;
		char oneChar;
		int iterations = 0;
		String propValue = "";
		while ((newString.length() < stringLength) && (iterations < 200)) {
			iterations++;
			while (!someLower(oneNumber)) {
				oneNumber = Math.random() * 170;
			}
			oneChar = (char) new Double(oneNumber).intValue();
			newString.append(oneChar);
			oneNumber = 0;
		}

		return newString.toString();
	}

	public static String randomNumberString(int stringLength) {
		StringBuffer newString = new StringBuffer("");
		double oneNumber = 0;
		char oneChar;
		int iterations = 0;
		String propValue = "";
		while ((newString.length() < stringLength) && (iterations < 200)) {
			iterations++;
			while (!numberOnly(oneNumber)) {
				oneNumber = Math.random() * 170;
			}
			oneChar = (char) new Double(oneNumber).intValue();
			newString.append(oneChar);
			oneNumber = 0;
		}

		return newString.toString();
	}

	/**
	 * Check if the given number is in the range of letters and digits that we
	 * want to use for generating a string Previously in
	 * com.jcorporate.expresso.ext.servlet.RegisterUser.java
	 *
	 * @param x
	 * @return
	 */
	private static boolean okNumber(double x, boolean numericToo) {
		int oneNumber = new Double(x).intValue();
		if ((oneNumber >= 65) && (oneNumber <= 90)) {
			return true;
		}

		if ((oneNumber >= 48) && (oneNumber <= 57) && numericToo) {
			return true;
		}

		if ((oneNumber >= 97) && (oneNumber <= 122)) {
			return true;
		}

		return false;
	}

	private static boolean someLower(double x) {
		int i = new Double(x).intValue();
		if ((i >= 97) && (i <= 107)) {
			return true;
		}
		if ((i >= 109) && (i <= 122)) {
			return true;
		}

		return false;
	}

	/**
	 * Check if the given number is in the range of letters and digits that we
	 * want to use for generating a string Previously in
	 * com.jcorporate.expresso.ext.servlet.RegisterUser.java
	 *
	 * @param x
	 * @return
	 */
	private static boolean numberOnly(double x) {
		int oneNumber = new Double(x).intValue();
		if ((oneNumber >= 48) && (oneNumber <= 57)) {
			return true;
		}
		return false;
	}

	/**
	 * @param String
	 * @return String
	 */
	public static String datePrint() {
		Date date = new Date();
		return yyyy_MM_dd(date);
	}

	/**
	 * @param String
	 * @return String
	 */
	public static String yyMMddHHmmssPrint() {
		Date date = new Date();
		return yyMMddHHmmss(date);
	}

	/**
	 * @param String
	 * @return String
	 */
	public static String yyMMddHHmmPrint() {
		Date date = new Date();
		return yyMMddHHmmss(date).substring(0, 10);
	}

	/**
	 * @param String
	 * @return String
	 */
	public static String yyyy_MM_dd(Date date) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyyy_MM_dd");
		return formatter.format(date);
	}

	public static String dayMonthYear(Date date) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("EEE, MMM d, yyyy");
		return formatter.format(date);
	}

	/**
	 * @param String
	 * @return String
	 */
	public static String yyyyDashMMDashdd(Date date) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}

	public static String getDd_MMM_yyDate(String dd_MMM_yy) {
		Date date = DateUtils_.getDateFromYyyyMMdd(dd_MMM_yy);
		String dateString = dd_MMM_yy(date);
		return dateString;
	}

	/**
	 * @param String
	 * @return String
	 */
	public static String dd_MMM_yy(Date date) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("dd-MMM-yy");
		return formatter.format(date);
	}

	/**
	 * @param String
	 * @return String
	 */
	public static String yyyyMMdd(Date date) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyyyMMdd");
		return formatter.format(date);
	}

	/**
	 * @param String
	 * @return String
	 */
	public static String yyMMddHHmmss(Date date) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyMMddHHmmss");
		return formatter.format(date);
	}

	/**
	 * @param String
	 * @return String
	 */
	public static String yyMMdd(Date date) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyMMdd");
		return formatter.format(date);
	}

	public static String MMddyyyy(Date date) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("MM/dd/yyyy");
		return formatter.format(date);
	}

	/**
	 * @param String
	 * @return String
	 */
	public static String yyyyMMddHHmmss(Date date) {
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		return formatter.format(date);
	}

	/**
	 * @param String
	 * @return String
	 */
	public static String endSingleSlash(String fileFolderPath) {
		while (fileFolderPath.endsWith("/") || fileFolderPath.endsWith("\\")) {
			fileFolderPath = fileFolderPath.substring(0,
					fileFolderPath.length() - 1);
		}
		fileFolderPath = fileFolderPath + "/";
		return fileFolderPath;
	}

	/**
	 * @param String
	 * @return String
	 */
	public static synchronized String removeLineHavingValue(String text,
			String value) {
		StringBuffer sb = new StringBuffer();
		try {
			StringTokenizer stk = new StringTokenizer(text, "\n");
			String lineToAppend = null;
			while (stk.hasMoreTokens()) {
				lineToAppend = stk.nextToken();
				if (lineToAppend.indexOf(value) < 0) {
					sb.append(lineToAppend + "\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause().printStackTrace();
			throw new RuntimeException(e.getMessage(), e);
		}
		return sb.toString();
	}

	/**
	 * @param String
	 * @return String
	 */
	public static synchronized String removeEmptyLines(String text) {
		StringBuffer sb = new StringBuffer();
		try {
			StringTokenizer stk = new StringTokenizer(text, "\n");
			String lineToAppend = null;
			while (stk.hasMoreTokens()) {
				lineToAppend = stk.nextToken();
				if (lineToAppend.trim().length() > 0) {
					sb.append(lineToAppend + "\n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause().printStackTrace();
			throw new RuntimeException(e.getMessage(), e);
		}
		return sb.toString();
	}

	/**
	 * @param String
	 * @return String
	 */
	public static synchronized String orderLinesByAlpha(String text) {
		StringBuffer sb = new StringBuffer();
		ArrayList linesList = new ArrayList();
		SortedSet orderedLinesList = null;
		try {
			StringTokenizer stk = new StringTokenizer(text, "\n");
			String lineToAppend = null;
			while (stk.hasMoreTokens()) {
				lineToAppend = stk.nextToken();
				if (lineToAppend.trim().length() > 0) {
					linesList.add(lineToAppend);
				}
			}
			orderedLinesList = new TreeSet(linesList);
			for (Iterator iter = orderedLinesList.iterator(); iter.hasNext();) {
				sb.append((String) iter.next() + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause().printStackTrace();
			throw new RuntimeException(e.getMessage(), e);
		}
		return sb.toString();
	}

	public static synchronized boolean asciiIsInTextRange(double x,
			boolean numericToo) {
		int oneNumber = new Double(x).intValue();

		if ((oneNumber >= 65) && (oneNumber <= 90)) {
			return true;
		}

		if ((oneNumber >= 48) && (oneNumber <= 57) && numericToo) {
			return true;
		}

		if ((oneNumber >= 97) && (oneNumber <= 122)) {
			return true;
		}

		return false;
	}

	/*
	 * Copied from JLicense FileUtil.java which in turn had this comment: Copied
	 * from JDK 1.4 Properties Converts encoded &#92;uxxxx to unicode chars and
	 * changes special saved chars to their original forms
	 */
	public static synchronized String loadConvert(String theString) {
		char aChar;
		int len = theString.length();
		StringBuffer outBuffer = new StringBuffer(len);

		for (int x = 0; x < len;) {
			aChar = theString.charAt(x++);
			if (aChar == '\\') {
				aChar = theString.charAt(x++);
				if (aChar == 'u') {
					// Read the xxxx
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = theString.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException(
									"Malformed \\uxxxx encoding.");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't')
						aChar = '\t';
					else if (aChar == 'r')
						aChar = '\r';
					else if (aChar == 'n')
						aChar = '\n';
					else if (aChar == 'f')
						aChar = '\f';
					outBuffer.append(aChar);
				}
			} else {
				outBuffer.append(aChar);
			}
		}
		return outBuffer.toString();
	}

	public static synchronized String shift6(String string) {
		byte[] byteArray = string.getBytes();
		byte[] newByteArray = new byte[byteArray.length];
		// byte[] one = new byte[1];
		// byte[] two = new byte[1];
		for (int i = 0; i < byteArray.length; i++) {
			newByteArray[i] = add6(byteArray[i]);
			// one[0] = byteArray[i];
			// two[0] = newByteArray[i];
			// System.print.println("" + i + " = " + byteArray[i] + " or "
			// + newByteArray[i] + " or '" + new String(one)
			// + "' converted to '" + new String(two) + "'");
		}
		return new String(newByteArray);
	}

	public static synchronized String shift6back(String string) {
		byte[] byteArray = string.getBytes();
		byte[] newByteArray = new byte[byteArray.length];
		// byte[] one = new byte[1];
		// byte[] two = new byte[1];
		for (int i = 0; i < byteArray.length; i++) {
			newByteArray[i] = subtract6(byteArray[i]);
			// one[0] = byteArray[i];
			// two[0] = newByteArray[i];
			// System.print.println("" + i + " = " + byteArray[i] + " or "
			// + newByteArray[i] + " or '" + new String(one)
			// + "' converted to '" + new String(two) + "'");
		}
		return new String(newByteArray);
	}

	private static byte subtract6(byte byteToConvert) {
		int byteValue = (int) byteToConvert;
		if (byteValue > 37) {
			byteValue = byteValue - 6;
		} else if (byteValue > 31 && byteValue < 38) {
			byteValue = byteValue + 120 - 30;
		}
		// else {
		// byteValue = byteValue - 120 + 30;
		// }
		return (byte) byteValue;
	}

	private static byte add6(byte byteToConvert) {
		int byteValue = (int) byteToConvert;
		if (byteValue > 121) {
			byteValue = byteValue - 120 + 30;
		} else if (byteValue == 10 || byteValue == 9) {
			// do nothing
		} else {
			byteValue = byteValue + 6;
		}
		return (byte) byteValue;
	}

	public static synchronized String getPaddedString(String stringToPad,
			int desiredLength, char paddingCharachter,
			boolean ifLongerReturnAnyway) {
		StringBuffer paddedResult = new StringBuffer();
		if (null == stringToPad) {
			throw new IllegalArgumentException("Cannot pad a null string");
		}
		if (stringToPad.length() > desiredLength && !ifLongerReturnAnyway) {
			throw new IllegalArgumentException("Was asked to pad a string '"
					+ stringToPad
					+ "' which is longer than the total lentgth padded of "
					+ desiredLength);
		}
		paddedResult.append(stringToPad);
		while (paddedResult.toString().length() < desiredLength) {
			paddedResult.append(paddingCharachter);
		}
		return paddedResult.toString();
	}

	public static synchronized String getPrePaddedString(String stringToPad,
			int desiredLength, char paddingCharachter,
			boolean ifLongerReturnAnyway) {
		if (null == stringToPad) {
			throw new IllegalArgumentException("Cannot pad a null string");
		}
		if (stringToPad.length() > desiredLength && !ifLongerReturnAnyway) {
			throw new IllegalArgumentException(
					"Was asked to pad a string which is longer than the total lentgth padded");
		}
		while (stringToPad.length() < desiredLength) {
			stringToPad = paddingCharachter + stringToPad;
		}
		return stringToPad;
	}

	public static synchronized String removeEndPaddingFromString(
			String stringToClean, char paddingCharachter) {
		while (stringToClean.endsWith("" + paddingCharachter)) {
			stringToClean = stringToClean.substring(0,
					stringToClean.length() - 1);
		}
		return stringToClean;
	}

	public static synchronized String removeMultipleWhiteSpaceCharachters(
			String string) {
		string = string.trim();
		// the idea is to see if the current and next charachter are both
		// whitespaces. If they are, then the current one is thrown away. If the
		// current one is a whitespace character but not a space, it is replaced
		// with a space.
		char aChar, bChar;
		int len = string.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = string.charAt(x++);
			if (x <= len - 1) {
				bChar = string.charAt(x);
				if (isWhiteSpace(aChar) && isWhiteSpace(bChar)) {
					// do nothing
				} else if (isWhiteSpace(aChar) && !isWhiteSpace(bChar)) {
					// System.print.print('_');
					outBuffer.append(' ');
				} else if (!isWhiteSpace(aChar)) {
					// System.print.print(aChar);
					outBuffer.append(aChar);
				}
			} else {
				outBuffer.append(aChar);
			}
		}
		return outBuffer.toString();
	}

	public static boolean isWhiteSpace(char char1) {
		if (char1 == '\n' || char1 == '\t' || char1 == ' ' || char1 == '\r'
				|| char1 == '\f') {
			return true;
		}
		return false;
	}

	public static String generatePassword(int length, boolean filterIl1oO) {
		if (length < 6) {
			throw new IllegalArgumentException(
					"Requires at least 6 charachters to generate a reasonable password");
		}
		PasswordCharachteristics passwordCharachteristics = new PasswordCharachteristics();
		StringBuffer newString = new StringBuffer("");
		double oneNumber = 0;
		char oneChar = ' ';
		int iterations = 0;
		String propValue = "";
		int digit = 1;
		while ((newString.length() < length) && (iterations < 200)) {
			iterations++;
			while (!isOkForPasswordRun(oneChar, passwordCharachteristics,
					digit, filterIl1oO)) {
				oneNumber = Math.random() * 170;
				oneChar = (char) new Double(oneNumber).intValue();
			}
			newString.append(oneChar);
			oneChar = ' ';
			digit++;
			oneNumber = 0;
		}

		return newString.toString();
	}

	private static boolean isOkForPasswordRun(char oneChar,
			PasswordCharachteristics passwordCharachteristics, int digit,
			boolean filterIl1oO) {
		boolean returnValue = false;
		int oneNumber = new Integer(oneChar).intValue();
		if (filterIl1oO && notIl10O(oneNumber)) {
			if ((oneNumber >= 65) && (oneNumber <= 90)
					&& (!passwordCharachteristics.hasUpper || digit > 4)) {
				passwordCharachteristics.hasUpper = true;
				return true;
			}
			if ((oneNumber >= 100) && (oneNumber <= 122)
					&& (!passwordCharachteristics.hasLower || digit > 4)) {
				passwordCharachteristics.hasLower = true;
				return true;
			}

			if ((oneNumber >= 48) && (oneNumber <= 57)
					&& (!passwordCharachteristics.hasNumber || digit > 4)) {
				passwordCharachteristics.hasNumber = true;
				return true;
			}

			if (isApprovedNonCharNonNumeric(oneNumber)
					&& !passwordCharachteristics.hasNotNumberOrText) {
				passwordCharachteristics.hasNotNumberOrText = true;
				return true;
			}
		}
		return returnValue;
	}

	private static boolean notIl10O(int i) {
		/*
		 * 48=0 49=1 73=I 79=O 108=l
		 */
		boolean approved = true;
		switch (i) {
		case 48:
			approved = false;
			break;
		case 49:
			approved = false;
			break;
		case 73:
			approved = false;
			break;
		case 79:
			approved = false;
			break;
		case 108:
			approved = false;
			break;
		}
		return approved;
	}

	static class PasswordCharachteristics {
		boolean hasUpper;
		boolean hasLower;
		boolean hasNotNumberOrText;
		boolean hasNumber;
	}

	private static boolean isApprovedNonCharNonNumeric(int i) {
		/*
		 * 33=! 35=# 36=$ 37=% 38=& 42=* 43=+ 45=- 60=< 62=> 64=@ 91=[ 93=] 94=^
		 */
		boolean approved = false;
		switch (i) {
		case 33:
			approved = true;
			break;
		case 35:
			approved = true;
			break;
		case 36:
			approved = true;
			break;
		case 37:
			approved = true;
			break;
		case 42:
			approved = true;
			break;
		case 43:
			approved = true;
			break;
		case 45:
			approved = true;
			break;
		case 60:
			approved = true;
			break;
		case 62:
			approved = true;
			break;
		case 64:
			approved = true;
			break;
		case 91:
			approved = true;
			break;
		case 93:
			approved = true;
			break;
		case 94:
			approved = true;
			break;
		default:
			approved = false;
			break;
		}
		return approved;
	}

	public static boolean isSameCharachterRepeated4TimeMinimum(String line) {
		boolean isSeparator = false;
		if (line.trim().length() > 3) {
			String myLine = line.trim();
			char thisChar = line.charAt(0);
			for (int i = 0; i < myLine.length(); i++) {
				if (thisChar == myLine.charAt(i)) {
					isSeparator = true;
				} else {
					isSeparator = false;
					break;
				}
			}
		}
		return isSeparator;
	}

	public static boolean isWhiteSpace(String line) {
		if (line.trim().equals("")) {
			return true;
		} else {
			return false;
		}
	}

	public static String notNullSingleCharachter(String string) {
		String returnValue = "0";
		if (null == string) {
			// do nothing
		} else if (string.trim().length() == 0) {
			// do nothing
		} else if (string.trim().length() == 1) {
			returnValue = string.trim();
		} else if (string.trim().length() > 1) {
			returnValue = string.trim().substring(0, 1);
		} else {
			throw new IllegalStateException("woops");
		}
		return returnValue;
	}

	public static char notNullChar(String string) {
		char returnValue = '0';
		if (null == string) {
			// do nothing
		} else if (string.trim().length() == 0) {
			// do nothing
		} else if (string.trim().length() == 1) {
			returnValue = string.trim().charAt(0);
		} else if (string.trim().length() > 1) {
			returnValue = string.trim().substring(0, 1).charAt(0);
		} else {
			throw new IllegalStateException("woops");
		}
		return returnValue;
	}
}
