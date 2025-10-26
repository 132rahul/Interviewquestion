import java.util.Optional;

public class TestNullEmpty {
    public static void main(String[] args) {
        //DataDemo demo=null;
        //DataDemo dee= new DataDemo();
        //Optional<String> optional2 = Optional.ofNullable(null);
        Optional<DataDemo1> opd= Optional.empty();
        DataDemo1 demo=null;
        if(opd.isPresent()){
            demo= new DataDemo1();
            demo.setPpk("pp11");
        }
        if (demo.getPpk() != "statusStr") {
            System.out.println("yes");
        }
    }
}
class DataDemo1 {
    public String getPpk() {
        return ppk;
    }

    public void setPpk(String ppk) {
        this.ppk = ppk;
    }

    public String getTtk() {
        return ttk;
    }

    public void setTtk(String ttk) {
        this.ttk = ttk;
    }

    String ppk;
    String ttk;
}
