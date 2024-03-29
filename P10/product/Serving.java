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
        this.topping = new ArrayList<>();
        int numMixIns = Integer.parseInt(in.readLine());
        while (numMixIns-- > 0)
            this.topping.add(new MixIn(in));
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String separator = " with ";
        result.append(container.name() + " " + separator + " a scoop of ");
        int len = scoop.size();
        for (Scoop sc : scoop) {
            result.append(sc.toString());
            if ((len - 1) != 0)
                result.append(",");
            len--;
        }
        return result.toString();
    }

}
