package student.lab;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

/**
 * This class may provide assistance in terms of certain date manipulation
 * (Dates to Strings, Strings to Dates, etc). This Class mainly focuses JDK 8
 * date Classes, however, there may some instances of older API Date objects as
 * this Class develops further. 
 * Chris Gonzalez Version 1.0 10/23/2016
 *
 * @author Chris Gonzalez
 * <a href="mailto:cgonzalez15@my.wctc.edu">cgonzalez15@my.wctc.edu</a>
 */

public class DateUtilities {
    /**
     * Returns the Duration between two Temporal objects in Minutes.
     * @param startingTemporalObject Starting Temporal object
     * @param endingTemporalObject Ending Temporal object
     * @return Duration object representing difference between two Temporal 
     * objects
     * @throws IllegalArgumentException checks if any provided Temporal objects
     * are null
     */
    public static Duration timeDifferenceInMinutes(Temporal 
            startingTemporalObject, Temporal endingTemporalObject) throws 
            IllegalArgumentException {
        if(startingTemporalObject == null || endingTemporalObject == null){
            throw new IllegalArgumentException("Only valid LocalTime objects "
                    + "accepted. ");
        }
        Duration difference = Duration.between(startingTemporalObject, 
                endingTemporalObject);
        return Duration.ofMinutes(difference.toMinutes());
    }
    /**
     * Returns a long representation of the time difference between two 
     * Temporal objects
     * @param startingTemporalObject Starting Temporal object
     * @param endingTemporalObject Ending Temporal object
     * @return long representation of the number of hours between the two
     * dates represented by the two provided Temporal objects.
     * @throws IllegalArgumentException checks if any provided Temporal objects
     * are null
     */
    public static long timeDifferenceInHours(Temporal 
            startingTemporalObject, Temporal endingTemporalObject){
        if(startingTemporalObject == null || endingTemporalObject == null){
            throw new IllegalArgumentException("Only valid LocalTime objects "
                    + "accepted. ");
        }
        return Duration.between(startingTemporalObject, 
                endingTemporalObject).toHours();
    }
    /**
     * Parses a String representation of a LocalDateTime object to an actual
     * LocalDateTime object
     * @param dateTimeFormat format required in order to parse
     * (Must use valid symbols and patterns used by DateTimeFormatter)
     * @param dateTimeToParse Representation to be parsed
     * @return parsed LocalDateTime object
     * @throws IllegalArgumentException checks if provided LocalDateTime object
     * is null and if provided String for format is empty or null. 
     */
    public static LocalDateTime toLocalDateTime(String dateTimeFormat, String 
            dateTimeToParse) throws IllegalArgumentException{
        if(dateTimeFormat.isEmpty() || dateTimeFormat == null || 
                dateTimeToParse.isEmpty()|| dateTimeToParse == null){
            throw new IllegalArgumentException("Provided Strings of DateTime "
                    + "format and DateTime to parse cannot be empty or null.");
        }
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern(dateTimeFormat);
        return LocalDateTime.parse(dateTimeToParse, formatter);
    }
    /**
     * Parses a String representation of a LocalDate object to an actual
     * LocalDate object
     * @param dateFormat format required in order to parse
     * (Must use valid symbols and patterns used by DateTimeFormatter)
     * @param dateToParse Representation to be parsed
     * @return parsed LocalDate object
     * @throws IllegalArgumentException checks if provided LocalDate object
     * is null and if provided String for format is empty or null. 
     */
    public static LocalDate toLocalDate(String dateFormat, String 
            dateToParse) throws IllegalArgumentException{
        if(dateFormat.isEmpty() || dateFormat == null || 
                dateToParse.isEmpty()|| dateToParse == null){
            throw new IllegalArgumentException("Provided Strings of Date "
                    + "format and Date to parse cannot be empty or null.");
        }
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern(dateFormat);
        return LocalDate.parse(dateToParse, formatter);
    }
    /**
     * Parses a String representation of a LocalTime object to an actual
     * LocalTime object
     * @param timeFormat format required in order to parse
     * (Must use valid symbols and patterns used by DateTimeFormatter)
     * @param timeToParse Representation to be parsed
     * @return parsed LocalTime object
     * @throws IllegalArgumentException checks if provided LocalTime object
     * is null and if provided String for format is empty or null. 
     */
    public static LocalTime toLocalTime(String timeFormat, String 
            timeToParse) throws IllegalArgumentException{
        if(timeFormat.isEmpty() || timeFormat == null || 
                timeToParse.isEmpty()|| timeToParse == null){
            throw new IllegalArgumentException("Provided Strings of Time "
                    + "format and Time to parse cannot be empty or null.");
        }
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern(timeFormat);
        return LocalTime.parse(timeToParse, formatter);
    }
    /**
     * Changes a provided LocalDateTime object to a formatted String 
     * representation, based on the format provided. 
     * @param localDateTime to be formatted
     * @param localDateTimeFormat format to use for LocalDateTime provided 
     * (Must use valid symbols and patterns used by DateTimeFormatter class)
     * Ex: "MM/dd/yyyy h:mm:ss a"
     * @return formatted String representation of LocalDateTime
     * @throws IllegalArgumentException checks to see if provided LocalDateTime
     * object is null and if the provided format String is null or empty.
     */
    public static String toFormattedLocalDateTime(LocalDateTime localDateTime,
            String localDateTimeFormat) throws IllegalArgumentException {
        if(localDateTime == null || localDateTimeFormat.isEmpty() || 
                localDateTimeFormat == null){
            throw new IllegalArgumentException("Provided LocalDateTime object"
                    + " cannot be null. Provided String for LocalDateTime "
                    + "format cannot be empty or null.");
        }
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern(localDateTimeFormat);
        return formatter.format(localDateTime);
    }
    /**
     * Changes a provided LocalDate object to a formatted String 
     * representation, based on the format provided. 
     * @param localDate to be formatted
     * @param localDateFormat format to use for LocalDate provided 
     * (Must use valid symbols and patterns used by DateTimeFormatter class)
     * Ex: "MM/dd/yyyy"
     * @return formatted String representation of LocalDate
     * @throws IllegalArgumentException checks to see if provided LocalDate
     * object is null and if the provided format String is null or empty.
     */
    public static String toFormattedLocalDate(LocalDate localDate,
            String localDateFormat) throws IllegalArgumentException {
        if(localDate == null || localDateFormat.isEmpty() || 
                localDateFormat == null){
            throw new IllegalArgumentException("Provided LocalDate object"
                    + " cannot be null. Provided String for LocalDate "
                    + "format cannot be empty or null.");
        }
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern(localDateFormat);
        return formatter.format(localDate);
    }
    /**
     * Changes a provided LocalTime object to a formatted String 
     * representation, based on the format provided. 
     * @param localTime to be formatted
     * @param localTimeFormat format to use for LocalDate provided 
     * (Must use valid symbols and patterns used by DateTimeFormatter class)
     * Ex: "H:mm:ss a"
     * @return formatted String representation of LocalTime
     * @throws IllegalArgumentException checks to see if provided LocalTime
     * object is null and if the provided format String is null or empty.
     */
    public static String toFormattedLocalTime(LocalTime localTime,
            String localTimeFormat) throws IllegalArgumentException {
        if(localTime == null || localTimeFormat.isEmpty() || 
                localTimeFormat == null){
            throw new IllegalArgumentException("Provided LocalTime object"
                    + " cannot be null. Provided String for LocalTime "
                    + "format cannot be empty or null.");
        }
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern(localTimeFormat);
        return formatter.format(localTime);
    }
    public static void main(String[] args) {
        System.out.println(DateUtilities.timeDifferenceInHours(
                LocalDateTime.now(), LocalDateTime.now().plusDays(3L)));
        
                
    }

}
