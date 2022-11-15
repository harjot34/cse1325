package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Serving {
    private Container container;
    private ArrayList<Scoop> scoop;
    private ArrayList<MixIn> topping;

    public Serving(Container container) {
        this.container = container;
        topping = new ArrayList<>();
        scoop = new ArrayList<>();
    }

    public Serving(BufferedReader in) throws IOException {
        // this.mixins = new ArrayList<>();
        // int numMixIns = Integer.parseInt(in.readLine());
        // while (numMixIns-- > 0)
        // mixins.add(new MixIn(br));
    }

    public void save(BufferedWriter out) throws IOException {
        container.save(out);
        out.write("" + scoop.size() + '\n');
        for (Scoop mi : scoop)
            mi.save(out);
    }

    public void addScoop(Scoop scoop) {
        this.scoop.add(scoop);
    }

    public void addTopping(MixIn topping) {
        this.topping.add(topping);
    }

}
