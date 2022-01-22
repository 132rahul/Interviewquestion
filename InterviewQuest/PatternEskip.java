package InterviewQuest;

public class PatternEskip {
public static void main(String[] args){
    int j=0;
    for(int i=1;i<6;i++){
        System.out.println(2*(j+i));
        j=j+i+1;
        System.out.println(2*(j+i));

    }
}
}
