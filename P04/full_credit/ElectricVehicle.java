
public class ElectricVehicle extends Vehicle {

    public static double centsPerKwhOfElectricity = Double.NaN;

    private double kwInBattery;
    private double whPerMile;

    public ElectricVehicle(int year, String make, String model, BodyStyle bodystyle, double whPerMile,
            double kwInBattery) {

        super(year, make, model, bodystyle);
        this.kwInBattery = kwInBattery;
        this.whPerMile = whPerMile;

    }

    public double range() {
        double result = kwInBattery / (whPerMile / 1000);
        return result;

    }

    public double fuelConsumed(double miles) {
        double result2 = miles * (whPerMile / 1000);
        return result2;

    }

    public double dollarsToTravel(double miles) {
        double result3 = fuelConsumed(miles) * (centsPerKwhOfElectricity / 100);
        return result3;
    }

}
