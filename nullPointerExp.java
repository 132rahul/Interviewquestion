import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class nullPointerExp {
    public static void main(String[] args) {

        List<DataDemo> inputs1 = Arrays.asList(new DataDemo("11","pp"),new DataDemo("1","aa"));
        List<DataDemo> inputs = Arrays.asList(null,new DataDemo("111","oo"));
        List<DataDemo> inputs2 = Arrays.asList();
        System.out.println(inputs2);

        Optional<DataDemo> firstElement = inputs2.stream()
               // .filter(Objects::nonNull)
                .filter(s->s.getPpk()=="ppp")
                .findFirst();
        System.out.println(firstElement);

    }
}
