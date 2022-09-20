import java.util.Scanner;
import java.util.ArrayList;

public class TravelCost {
  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    System.out.println("What is the price of gallon per gas(dollars)?");
    String dollarsPerGallonOfGas = in.nextLine();
    System.out.println("What is the price per kWh of electricity(cents)?");
    String centsPerKwhOfElectricity = in.nextLine();
    System.out.println("How many miles is your trip?");
    String mileslongTrip = in.nextLine();
    in.close();
    ArrayList<Vehicle> vehicleList = new ArrayList<>();
    vehicleList.add(new ElectricVehicle(2022, "Telsa", "Model S Plaid", BodyStyle.Sedan, 297, 100));
    vehicleList.add(new ElectricVehicle(2022, "Telsa", "Model 3 LR", BodyStyle.Sedan, 242, 82));
    vehicleList.add(new ElectricVehicle(2022, "GM", "Bolt", BodyStyle.Hatchback, 286, 66));
    vehicleList.add(new ElectricVehicle(2022, "Nissan", "LEAF", BodyStyle.Hatchback, 269, 60));
    vehicleList.add(new ElectricVehicle(2022, "Ford", "Mustang Mach-E", BodyStyle.SUV, 347, 88));
    vehicleList.add(new ElectricVehicle(2022, "Ford", "F-150 Lightning", BodyStyle.Truck, 511, 131));
    vehicleList.add(new GasVehicle(2022, "Ford", "F-150", BodyStyle.Truck, 25, 23));
    vehicleList.add(new GasVehicle(2022, "Toyota", "Prius Hybrid", BodyStyle.Hatchback, 55, 11.4));
    vehicleList.add(new GasVehicle(2022, "Toyota", "RAV4", BodyStyle.Crossover, 31, 14.5));
    vehicleList.add(new GasVehicle(2022, "Nissan", "Rogue", BodyStyle.Hatchback, 33, 14.5));
    vehicleList.add(new GasVehicle(2022, "Chrysler", "Pacifica", BodyStyle.Minivan, 24, 19));
    vehicleList.add(new GasVehicle(2022, "Chrysler", "Pacifica Hybrid", BodyStyle.Minivan, 30, 16.5));

    for (Vehicle vehicleObj : vehicleList) {
      StringBuilder sb = new StringBuilder();
      if (vehicleObj instanceof ElectricVehicle) {
        ElectricVehicle.centsPerKwhOfElectricity = Double.parseDouble(centsPerKwhOfElectricity);
        sb.append(String.format("%s  %3.2f", "$", vehicleObj.fuelConsumed(Double.parseDouble(mileslongTrip))));
        sb.append(" (range " + vehicleObj.range() + ") ");
      } else if (vehicleObj instanceof GasVehicle) {
        GasVehicle.dollarsPerGallonOfGas = Double.parseDouble(dollarsPerGallonOfGas);
        sb.append(String.format("%s  %3.2f", "$", vehicleObj.fuelConsumed(Double.parseDouble(mileslongTrip))));
        sb.append(" (range " + vehicleObj.range() + ") ");
      }
      System.out.println(sb.toString() + vehicleObj.toString());
    }

  }

}