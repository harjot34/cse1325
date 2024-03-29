package product;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Scoop {

    private IceCreamFlavor flavor;
    private ArrayList<MixIn> mixins;

    public Scoop(IceCreamFlavor flavor) {
        this.flavor = flavor;
        this.mixins = new ArrayList<>();
    }

    public Scoop(BufferedReader br) throws IOException {
        // this.flavor = new IceCreamFlavor(br);
        this.mixins = new ArrayList<>();
        int numMixIns = Integer.parseInt(br.readLine());
        while (numMixIns-- > 0)
            mixins.add(new MixIn(br));
    }

    public void save(BufferedWriter bw) throws IOException {
        flavor.save(bw);
        bw.write("" + mixins.size() + '\n');
        for (MixIn mi : mixins)
            mi.save(bw);
    }

    public void addMixIn(MixIn mixin) {
        mixins.add(mixin);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(flavor.toString());
        if (mixins.size() > 0) {
            String separator = " and topped with ";
            for (MixIn m : mixins) {
                result.append(separator + m.toString());
            }
        }
        return result.toString();
    }

    public double getPrice() {
        double price = 0.0;
        for (MixIn m : mixins) {
            price = flavor.price() + m.getPrice();
        }
        return price;
    }

}