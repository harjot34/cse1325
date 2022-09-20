package vehicles;

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
        if (Double.compare(fuelConsumed, kwhInBattery) > 0) {
            throw new ArithmeticException(
                    "FuelConsumed:" + fuelConsumed + " is greater than fuel in tank:" + kwhInBattery);
        }
        return fuelConsumed;
    }

    @Override
    public double dollarsToTravel(double miles) {
        double dollarsToTravel = fuelConsumed(miles) * (centsPerKwhOfElectricity / 100);
        return dollarsToTravel;
    }

}
