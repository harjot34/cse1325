public class GasVehicle extends Vehicle {
    public static double dollarsPerGallonOfGas = Double.NaN;
    private double milesPerGallon;
    private double gallonsInTank;

    public GasVehicle(int year, String make, String model, BodyStyle bodyStyle, double milesPerGallon,
            double gallonsInTank) {
        super(year, make, model, bodyStyle);
        this.milesPerGallon = milesPerGallon;
        this.gallonsInTank = gallonsInTank;

    }

    public double range() {
        double range = gallonsInTank * milesPerGallon;
        return range;
    }

    public double fuelConsumed(double miles) {
        double fuelConsumed = miles / milesPerGallon;
        return fuelConsumed;
        // throw exception

    }

    public double dollarsToTravel(double miles) {
        double dollarsToTravel = fuelConsumed(miles) * dollarsPerGallonOfGas;
        return dollarsToTravel;
    }

}
