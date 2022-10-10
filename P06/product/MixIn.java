public class MixIn {
    private MixInFlavor flavor;
    private MixInAmount amount;

    public MixIn(MixInFlavor flavor, MixInAmount amount) {
        this.flavor = flavor;
        this.amount = amount;

    }

    public String toString() {
        return " " + flavor.name() + " (" + amount.name() + ") ,";
    }

}