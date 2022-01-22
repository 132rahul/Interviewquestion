import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class GetlastDateOfTheMonth {
    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String DATE = "yyyy-MM-dd";
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
    public static void main(String args[]) {
       getMOnth();
    }

    private static void getMOnth() {

      //  String ppk="2021-06-16T13:36:35.552Z";
        String ppk="2018-08-19T10:01:06.769+00:00";
       // 2021-06-17T10:01:06.769+0000
        //System.out.println(ppk);
        /*ZonedDateTime calculatedDate = ZonedDateTime.parse(ppk1)
                 .plusMonths(3).minusDays(1);
        System.out.println(calculatedDate);*/

        LocalDate localDate = ZonedDateTime.parse(ppk).toLocalDate();
        LocalDate discountStartMonthEndDate  = getDateWithLastDayOfMonth(localDate.toString());

        System.out.println(discountStartMonthEndDate);

        LocalDate discountEndMonthDate  = LocalDate.parse(discountStartMonthEndDate .toString()).plusMonths(7)
                .minusMonths(1);

        System.out.println(discountEndMonthDate );

        LocalDate caluclatedLastDateOfMonth = getDateWithLastDayOfMonth(discountEndMonthDate.toString());

        System.out.println(caluclatedLastDateOfMonth);

        //ZonedDateTime discountEndDate  = caluclatedLastDateOfMonth.atStartOfDay(ZoneId.systemDefault());
       // ZonedDateTime eod = discountEndDate.with(LocalTime.of(23, 59, 59));
        ZonedDateTime discountEndDate = caluclatedLastDateOfMonth.atTime(23, 59, 59)
                .atZone(ZoneId.systemDefault());
        String computedDiscountEndDate = discountEndDate.format(formatter);
        System.out.println(computedDiscountEndDate);

        ZonedDateTime eod = discountEndDate.with(LocalTime.MAX);
        System.out.println(eod);
        String eed= eod.format(formatter);
        System.out.println(eed);

        /*ZonedDateTime zonedDateTime11 = ZonedDateTime.parse(ppk);
        LocalDate localDate = zonedDateTime11.toLocalDate();
        System.out.println(localDate + " : convert to localdatetime");
        LocalDate newDate=getDate(localDate.toString());
        System.out.println(newDate.toString());
        LocalDate calculatedDate = LocalDate.parse(newDate.toString())
                .plusMonths(7).minusDays(1);
        LocalDate newDate1=getDate(calculatedDate.toString());
        ZonedDateTime zonedDateTime1 = newDate1.atStartOfDay(ZoneId.systemDefault());
        String computedDiscountEndDate1 = zonedDateTime1.format(formatter);
        System.out.println("2nd test : "+computedDiscountEndDate1);*/

    }

    private static LocalDate getDateWithLastDayOfMonth(String Date) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(DATE, Locale.ENGLISH);
        LocalDate date = LocalDate.parse(Date, dateFormat);
        LocalDate newDate = date.withDayOfMonth(date.getMonth().length(date.isLeapYear()));
        return newDate;
    }
}
