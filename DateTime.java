import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateTime {
    public static void main(String[] args) {
        Date currentDate = new Date(124, 01, 29);
        System.out.println(currentDate);

        Date a = addMonthToCurrentDate(currentDate, 36L);
        Date b = getLastDateOfMonth(a);
        System.out.println("Now Date value rahul : "+b);

        Date currentDate1 = new Date();
        System.out.println("21212  "+currentDate1);

        LocalDateTime currentDateTimeForLineRenew = LocalDateTime
                .now(ZoneId.of("Asia/Tokyo"))
                .truncatedTo(ChronoUnit.SECONDS);
        Boolean dailyLineRenewFlag = false;
        int lineContractRenewalDate = 1;
        System.out.println("JST  : " + currentDateTimeForLineRenew );
        System.out.println("currentDateTimeForLineRenew outside: "+currentDateTimeForLineRenew.getDayOfMonth());

        if (dailyLineRenewFlag || currentDateTimeForLineRenew.getDayOfMonth() == lineContractRenewalDate) {
            System.out.println("In JST condition : " + currentDateTimeForLineRenew );
            System.out.println(" Last day of the month: " + currentDateTimeForLineRenew.getDayOfMonth());
        }
        System.out.println("----- Done ppk ------");


        System.out.println("UTC walla : "+ LocalDateTime
                .now(ZoneId.of("UTC"))
                .truncatedTo(ChronoUnit.SECONDS));

        System.out.println("IST "+ LocalDateTime
                .now(ZoneId.of("Asia/Kolkata"))
                .truncatedTo(ChronoUnit.SECONDS));


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(" submit prodeubt order "+ dtf.format(LocalDateTime.now()));

        String localDateTime1 = "2025-06-24T00:00:20";
        LocalDateTime localDateTime12 = LocalDateTime.parse(localDateTime1);
        System.out.println("localDateTime12 :" +localDateTime12);
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Rahul submit prodeubt 1 order "+ dtf1.format(localDateTime12));


        System.out.println(" submit prodeubt order JST "+dtf.format(LocalDateTime
                .now(ZoneId.of("Asia/Tokyo"))));

        LocalDateTime currentDateTimeForLineRenew01 = LocalDateTime
                .now(ZoneId.of("Asia/Tokyo"))
                .truncatedTo(ChronoUnit.SECONDS);
        int currentDayOfMonth = currentDateTimeForLineRenew01.getDayOfMonth();
        System.out.println("rahl lst of the month "+ currentDayOfMonth);
        System.out.println("rahl lst of the month  123  "+ currentDateTimeForLineRenew01);

    }

    public static Date addMonthToCurrentDate(Date currentDate, Long month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.MONTH, Math.toIntExact(month));
        return cal.getTime();
    }

    public static Date getLastDateOfMonth(Date activationDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(activationDate);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 14);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
