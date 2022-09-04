import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int hour;
        int min;
        int sec;
        Scanner in = new Scanner(System.in);
        System.out.print("Hour? ");
        hour = in.nextInt();
        System.out.print("Minute? ");
        min = in.nextInt();
        System.out.print("Second? ");
        sec = in.nextInt();
        in.close(); // to prevent memory leak

        // Instantiate Class Clock and pass hour, min, sec in constructor
        Clock obj = new Clock(hour, min, sec);
        // call method toString() of Clock
        System.out.println(obj.toString());

    }

}
