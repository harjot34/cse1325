package product;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import person.Customer;

public class Order {

    private Customer customer;
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
        customer.save(out);
        out.write("" + servings.size() + '\n');
        for (Serving mi : servings)
            mi.save(out);
    }

    public void addServing(Serving serving) {
        servings.add(serving);
    }

    public void addCustomer(Customer customer) {
        this.customer = customer;
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

    public Customer getCustomer() {
        return customer;
    }

    public double getPrice() {
        double price = 0.0;
        for (Serving m : servings) {
            price = price + m.getPrice();
        }
        return price;
    }

}
