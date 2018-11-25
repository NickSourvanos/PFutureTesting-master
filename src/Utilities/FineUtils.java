package Utilities;

public class FineUtils {

    public static double getTotalFineCost(double fineCost, int numberOfUninsVehicles){

        double totalFineCost = fineCost * numberOfUninsVehicles;

        return totalFineCost;
    }
}
