package product;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Order {

    private ArrayList<Serving> servings = new ArrayList<>();

    public Order() {
    }

    public Order(BufferedReader in) throws IOException {
        this.servings = new ArrayList<>();
        int orders = Integer.parseInt(in.readLine());
        while (orders-- > 0)
            servings.add(new Serving(in));
    }

    public void save(BufferedWriter out) throws IOException {
        out.write("" + servings.size() + '\n');
        for (Serving mi : servings)
            mi.save(out);
    }

    public void addServing(Serving serving) {
        servings.add(serving);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (servings.size() > 0) {
            for (Serving m : servings) {
                result.append(m.toString());
            }
        }
        return result.toString();
    }

}
