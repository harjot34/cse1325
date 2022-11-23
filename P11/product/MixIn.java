package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class MixIn {
    public MixIn(MixInFlavor flavor, MixInAmount amount) {
        this.flavor = flavor;
        this.amount = amount;
    }

    public MixIn(BufferedReader br) throws IOException {
        amount = MixInAmount.valueOf(br.readLine());
        flavor = new MixInFlavor(br);
    }

    public void save(BufferedWriter bw) throws IOException {
        bw.write(amount.toString() + '\n');
        flavor.save(bw);
    }

    @Override
    public String toString() {
        return flavor.toString() + (!amount.equals(MixInAmount.Normal)
                ? " (" + amount + ") "
                : " ");
    }

    public double getPrice() {
        double price = 1.0; // same price for all flavors
        if (amount.equals(MixInAmount.Light))
            price = flavor.price() + 0.50;
        else if (amount.equals(MixInAmount.Normal))
            price = flavor.price() + 1.00;
        else if (amount.equals(MixInAmount.Extra))
            price = flavor.price() + 1.50;
        else if (amount.equals(MixInAmount.Drenched))
            price = flavor.price() + 2.00;

        return price;
    }

    private MixInFlavor flavor;
    private MixInAmount amount;
}