

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CampusSpeeding {
static int [] radarDetectionSetups;
static int [] HowManyVehicles;
static int [] vehicleSpeedRecorded;
static List <Boolean> SpeederOrNot = new ArrayList<>();
static int [] recordResults;
static int [] testCase;
final static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {

        int c = reader.nextInt();
        testCase = new int[c];
        recordResults = new int [c];
        int r,v;
        for (int i = 0;i < testCase.length; i++){
            r = reader.nextInt();
            takeRadarSpeed(r);
            v = reader.nextInt();
            recordResults[i] = v;
            takeHowManyVehicles(v);
        }
        printCampusSpeeding();
        reader.close();
    }

 
    public static void takeRadarSpeed(int r) {
         radarDetectionSetups = new int [r];
         for(int var = 0; var < radarDetectionSetups.length; var++)
             radarDetectionSetups[var] = reader.nextInt();
    }

    public static void takeHowManyVehicles(int v) {
        HowManyVehicles = new int [v];
        vehicleSpeedRecorded = new int [radarDetectionSetups.length];
        for(int var = 0; var < HowManyVehicles.length; var++){
            for(int k = 0; k < radarDetectionSetups.length; k++)
                vehicleSpeedRecorded[k] = reader.nextInt();
            SpeederOrNot.add(compareVehicleSpeedAndSpeedRadar(vehicleSpeedRecorded, radarDetectionSetups));
        }
    }

     public static boolean compareVehicleSpeedAndSpeedRadar(int [] VehicleSpeed, int [] RadarSpeed) {
        int length = VehicleSpeed.length;
            for (int var = 0; var < length; var++) {
                if (VehicleSpeed[var] > RadarSpeed[var])
                   return true;
            }
            return false;
    }

    public static void printCampusSpeeding() {
        for (int i = 0; i < testCase.length; i++) {
            System.out.println("\nCase #" + (i + 1) + ":");
            for (int index = 0; index < recordResults[i] ; index++) {
                if (SpeederOrNot.get(0))
                    System.out.println("     Vehicle " + (index + 1) + ": is a speeder");
                else if (!(SpeederOrNot.get(0)))
                    System.out.println("     Vehicle " + (index + 1) + ": is not a speeder");
                SpeederOrNot.remove(0);
            }
        }
    }
}
