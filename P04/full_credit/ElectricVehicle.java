// import java.util.Scanner;

public class ElectricVehicle extends Vehicle {

    public static double centsPerKwhOfElectricity = Double.NaN;

    private double kwhInBattery;
    private double whPerMile;

    public ElectricVehicle(int year, String make, String model, BodyStyle bodystyle, double whPerMile,
            double kwhInBattery) {

        super(year, make, model, bodystyle);
        this.kwhInBattery = kwhInBattery;
        this.whPerMile = whPerMile;

    }

    @Override
    public double range() {
        double range = kwhInBattery / (whPerMile / 1000);
        return range;

    }

    @Override
    public double fuelConsumed(double miles) {
        double fuelConsumed = miles * (whPerMile / 1000);
        return fuelConsumed;
        // try {
        // Double.compare(result2, kwInBattery);
        // } catch (ArithmeticException obj) {
        // System.out.println("There is more energy than available");
        // }
    }

    public double dollarsToTravel(double miles) {
        double dollarsToTravel = fuelConsumed(miles) * (centsPerKwhOfElectricity / 100);
        return dollarsToTravel;
    }

}
