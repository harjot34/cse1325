package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Container {
    private String name;
    private String description;
    private int maxScoops;

    public Container(String name, String description, int maxScoops) {
        this.name = name;
        this.description = description;
        this.maxScoops = maxScoops;
    }

    public Container(BufferedReader in) throws IOException {
        this.name = in.readLine();
        this.description = in.readLine();
        this.maxScoops = Integer.parseInt(in.readLine());
    }

    public void save(BufferedWriter out) throws IOException {
        out.write(name + '\n');
        out.write(description + '\n');
        out.write("" + maxScoops + '\n');
    }

    // xtra code if not used remove it
    public String name() {
        return name;
    }

    public String description() {
        return description;
    }

    public int maxScoops() {
        return maxScoops;
    }

    @Override
    public String toString() {
        return name;
    }

}
