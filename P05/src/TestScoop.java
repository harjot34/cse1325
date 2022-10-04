import java.util.ArrayList;
import java.util.Scanner;

import javax.management.Descriptor;
import javax.swing.text.html.MinimalHTMLWriter;

public class TestScoop {
    public ArrayList<IceCreamFlavor> flavors = new ArrayList<>();
    public ArrayList<MixInFlavor> mixins = new ArrayList<>();
    public ArrayList<Scoop> scoops = new ArrayList<>();

    public static void main(String[] args) {
        TestScoop obj = new TestScoop();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println("");
            for (int j = 0; j < 16; j++) {
                System.out.print("=");
            }
            System.out.println("\nMICE Tester v0.1 ");
            for (int k = 0; k < 16; k++) {
                System.out.print("=");
            }
            System.out.print("\n\nCreate new (m)ixin, (i)ce cream flavor, (s)coop or (q)uit?");
            String selection = in.nextLine();
            Scoop sc = null;
            if (selection.equals("m")) {
                System.out.print("\nName? ");
                String name = in.nextLine();
                System.out.print("Description?");
                String description = in.nextLine();
                System.out.print("Price? ");
                int price = in.nextInt();
                System.out.print("Cost? ");
                int cost = in.nextInt();
                // create a mixin
                MixInFlavor minInflv = new MixInFlavor(name, description, cost, price);
                obj.mixins.add(minInflv); // add to mixin list
            } else if (selection.equals("i")) {
                System.out.print("\nName? ");
                String name = in.nextLine();
                System.out.print("Description?");
                String description = in.nextLine();
                System.out.print("Price? ");
                int price = in.nextInt();
                System.out.print("Cost? ");
                int cost = in.nextInt();
                // create icecream flavor object
                IceCreamFlavor icFlv = new IceCreamFlavor(name, description, cost, price);
                obj.flavors.add(icFlv); // add to list of icecream flv
            } else if (selection.equals("s")) {
                System.out.println("Creating a scoop of icecream!\n\n");
                obj.testScoops();
            } else if (selection.equals("q")) {
                System.exit(0);
            }
            in.nextLine();

        }

        in.close();
    }

    public void testScoops() {
        for (IceCreamFlavor icFlv : flavors) {

            Scoop sc = new Scoop(icFlv);

            for (MixInFlavor mx : mixins) {
                MixInAmount mxamt = MixInAmount.Light;
                MixIn mixIn = new MixIn(mx, mxamt);
                sc.addMixIn(mixIn);
            }
            this.scoops.add(sc); // add scoop to scoop list

            System.out.println(sc.toString());
        }
    }
}
