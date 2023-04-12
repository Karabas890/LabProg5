package parsers;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class DateValidator
{
    public static boolean isValidDateFormat(String dateStr) {
        try {
            LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MMM-dd").withLocale(Locale.ENGLISH));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
