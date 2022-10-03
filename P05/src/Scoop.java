import java.util.ArrayList;

public class Scoop {
    private IceCreamFlavor flavor;
    private ArrayList<MixIn> mixinsls = new ArrayList<>();

    public Scoop(IceCreamFlavor flavor) {
        this.flavor = flavor;
    }

    public void addMixIn(MixIn mixin) {
        // Add mixin to above array
        mixinsls.add(mixin);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(flavor + " with ");
        for (MixIn mx : mixinsls) {
            sb.append(mx);
        }
        return sb.toString();
    }

}
