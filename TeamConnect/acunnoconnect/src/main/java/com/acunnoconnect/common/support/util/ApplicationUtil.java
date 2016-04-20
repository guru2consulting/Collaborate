package com.acunnoconnect.common.support.util;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import com.acunnoconnect.web.utils.ApplicationConstants;
import com.mongodb.BasicDBObject;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationUtil.
 */
public class ApplicationUtil {

	/**
	 * Gets the email validation code.
	 *
	 * @return the email validation code
	 */
	public static String getEmailValidationCode() {

		Random emailValidationCode = new Random();
		Long someValue = emailValidationCode.nextLong();
		return String.valueOf(someValue);
	}

	/**
	 * Gets the todays date string.
	 *
	 * @return the todays date string
	 */
	public static String getTodaysDateString() {
		StringBuilder currentDateStringBuffer = new StringBuilder();
		Calendar gregCal = GregorianCalendar.getInstance();
		gregCal.setTime(new Date());
		String monthString = ApplicationConstants.BLANK;
		int monthInt = gregCal.get(GregorianCalendar.MONTH) + 1;
		int todaysDate = gregCal.get(GregorianCalendar.DAY_OF_MONTH);
		String todaysDateString = ApplicationConstants.BLANK;
		if (monthInt < 10) {
			monthString = ApplicationConstants.ZERO.concat(String
					.valueOf(monthInt));
		} else {
			monthString = String.valueOf(monthInt);
		}

		if (todaysDate < 10) {
			todaysDateString = ApplicationConstants.ZERO.concat(String
					.valueOf(todaysDate));
		} else {
			todaysDateString = String.valueOf(todaysDate);
		}

		currentDateStringBuffer
				.append(gregCal.get(GregorianCalendar.YEAR))
				.append(ApplicationConstants.HYPHEN)
				.append(monthString)
				.append(ApplicationConstants.HYPHEN)
				.append(todaysDateString)
				.append(ApplicationConstants.SPACE)
				.append(
						gregCal.get(GregorianCalendar.HOUR_OF_DAY) < 10 ? ApplicationConstants.ZERO
								+ String.valueOf(gregCal
										.get(GregorianCalendar.HOUR_OF_DAY))
								: gregCal.get(GregorianCalendar.HOUR_OF_DAY))
				.append(ApplicationConstants.COLON)
				.append(
						gregCal.get(GregorianCalendar.MINUTE) < 10 ? ApplicationConstants.ZERO
								+ String.valueOf(gregCal
										.get(GregorianCalendar.MINUTE))
								: gregCal.get(GregorianCalendar.MINUTE))
				.append(ApplicationConstants.COLON)
				.append(
						gregCal.get(GregorianCalendar.SECOND) < 10 ? ApplicationConstants.ZERO
								+ String.valueOf(gregCal
										.get(GregorianCalendar.SECOND))
								: gregCal.get(GregorianCalendar.SECOND));

		return currentDateStringBuffer.toString();
	}

	/**
	 * Gets the date string.
	 *
	 * @param passedDate the passed date
	 * @return the date string
	 */
	public static String getDateString(Date passedDate) {
		StringBuilder currentDateStringBuffer = new StringBuilder();
		Calendar gregCal = GregorianCalendar.getInstance();
		gregCal.setTime(passedDate);
		String monthString = ApplicationConstants.BLANK;
		int monthInt = gregCal.get(GregorianCalendar.MONTH) + 1;
		int dayOfMonth = gregCal.get(GregorianCalendar.DAY_OF_MONTH);
		String dateString = ApplicationConstants.BLANK;
		if (monthInt < 10) {
			monthString = ApplicationConstants.ZERO.concat(String
					.valueOf(monthInt));
		} else {
			monthString = String.valueOf(monthInt);
		}

		if (dayOfMonth < 10) {
			dateString = ApplicationConstants.ZERO.concat(String
					.valueOf(dayOfMonth));
		} else {
			dateString = String.valueOf(dayOfMonth);
		}
		currentDateStringBuffer.append(gregCal.get(GregorianCalendar.YEAR))
				.append(monthString).append(dateString);
		return currentDateStringBuffer.toString();
	}

	/**
	 * Gets the current time string.
	 *
	 * @return the current time string
	 */
	public static String getCurrentTimeString() {

		StringBuilder currentDateStringBuffer = new StringBuilder();
		Calendar gregCal = GregorianCalendar.getInstance();
		gregCal.setTime(new Date());
		int monthInt = gregCal.get(GregorianCalendar.MONTH);
		currentDateStringBuffer
				.append(getMonthString(monthInt))
				.append(ApplicationConstants.SPACE)
				.append(
						String.valueOf(gregCal
								.get(GregorianCalendar.DAY_OF_MONTH)))
				.append(ApplicationConstants.SPACE)
				.append(gregCal.get(GregorianCalendar.YEAR))
				.append(ApplicationConstants.SPACE)
				.append(gregCal.get(GregorianCalendar.HOUR))
				.append(ApplicationConstants.SPACE)
				.append(gregCal.get(GregorianCalendar.MINUTE))
				.append(
						gregCal.get(GregorianCalendar.AM_PM) == 1 ? ApplicationConstants.PM
								: ApplicationConstants.AM);

		return currentDateStringBuffer.toString();

	}

	/**
	 * Gets the month string.
	 *
	 * @param monthPassed the month passed
	 * @return the month string
	 */
	private static String getMonthString(int monthPassed) {
		String monthName = ApplicationConstants.BLANK;
		switch (monthPassed) {
		case 0:
			return ApplicationConstants.JAN;
		case 1:
			return ApplicationConstants.FEB;
		case 2:
			return ApplicationConstants.MAR;
		case 3:
			return ApplicationConstants.APR;
		case 4:
			return ApplicationConstants.MAY;
		case 5:
			return ApplicationConstants.JUN;
		case 6:
			return ApplicationConstants.JUL;
		case 7:
			return ApplicationConstants.AUG;
		case 8:
			return ApplicationConstants.SEP;
		case 9:
			return ApplicationConstants.OCT;
		case 10:
			return ApplicationConstants.NOV;
		case 11:
			return ApplicationConstants.DEC;
		}
		return monthName;
	}
	
	
	/**
	 * Gets the mongo db object.
	 *
	 * @param passedObject the passed object
	 * @return the mongo db object
	 */
	public static BasicDBObject getMongoDBObject(Object passedObject){
		BasicDBObject dbObject = new BasicDBObject();
		try
		{
			Class cls = Class.forName(passedObject.getClass().getName());
			Field[] fields = cls.getDeclaredFields();
			for( int i = 0 ; i < fields.length ; i++ )
			{
				fields[i].setAccessible(true);
				if(fields[i].get(passedObject)!=null){
				dbObject.put(fields[i].getName(), fields[i].get(passedObject));
				}
				
			}
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
		return dbObject;
	}
}
