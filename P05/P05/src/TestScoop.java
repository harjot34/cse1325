import java.util.Scanner;

public class TestScoop {
    public IceCreamFlavor[] flavors;
    public MixInFlavor[] mixins;
    public Scoop[] scoops;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Create new (m)ixin, (i)ce cream flavor, or (q)uit?");
        System.out.println("Creating new Ice Cream Flavor!");
        System.out.println("Name? ");
        String st = in.nextLine();
        System.out.println("Description?");
        String er = in.nextLine();
        System.out.println("Price? ");
        String re = in.nextLine();
        System.out.println("Cost? ");
        String ty = in.nextLine();

        in.close();
    }
}
