public abstract class Vehicle {
    private int year;
    private String make;
    private String model;
    private BodyStyle bodystyle;

    public Vehicle(int year, String make, String model, BodyStyle bodystyle) {

        // encapsulation
        this.year = year;
        this.make = make;
        this.model = model;
        this.bodystyle = bodystyle;

    }

    public abstract double range();

    public abstract double fuelConsumed(double miles);

    public abstract double dollarsToTravel(double miles);

    public String toString() {
        return this.year + " " + this.make + " " + this.model + " "
                + this.bodystyle.name();
    }
}
