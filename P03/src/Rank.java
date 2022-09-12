public class Rank {

    // fields
    private int rank;
    public static final int MIN = 0;
    public static final int MAX = 9;

    // constructor
    public Rank(int rank) {
        this.rank = rank;

    }

    public String toString() {
        return String.valueOf(rank);
    }

}
