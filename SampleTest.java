import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;


public class SampleTest {


    public static void main(String[] args) {
        Instant start = Instant.now();
        int n = 10;
        for (int i = 0; i < 10000; i++) {
            n = i + n + i;
            for (int j = i; j < 10000; j++) {
                n = i + n + i;
            }
        }
        Instant end = Instant.now();
        System.out.println(start);
        System.out.println(end);

        System.out.println(Duration.between(start, end).getSeconds());
        long ppk=Duration.between(start, end).getSeconds();
        System.out.println(ppk);

        String time1 = "16:00:00";
        String time2 = "19:00:00";

        long seconds = Duration.between(LocalTime.parse(time1), LocalTime.parse(time2)).getSeconds();
        System.out.println(seconds);

        int a=25;
        if(a>50 && a>20){
            System.out.println("hi");
        }
        else {
            System.out.println("no");
        }
    }


}
