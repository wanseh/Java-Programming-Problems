

import java.lang.Math;
import java.util.Scanner;
public class next {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int ovrN,ovrT;
        int n = read.nextInt();
        int [] cases = new int [n];
        int [] nInt = new int [4];
        int [] results = new int[n];
        int [] eachAppointTravel = new int[n];

        /*
         * nInt[0] = length of the appoinment
         * nInt[1] = time it will take Nathan to have his coffee (including travel to and from to cafeteria)
         * nInt[2] = most recent number called for an appointment
         * nInt[3] = Nathan's number
         */

        for(int ctr = 0; ctr < cases.length; ctr++){
            ovrT = 0;
            for(int counter = 0; counter < nInt.length; counter++){
                nInt[counter] = read.nextInt();
            }
            eachAppointTravel[ctr] = nInt[1];
            //Get the total amount of time of appointments. Main algorithm
            ovrN = Math.abs(nInt[2] - nInt[3]); //Gets the absolute value of the two numbers
            for(int k = 1; k <= ovrN; k++)
                ovrT += nInt[0];

            results[ctr] = ovrT;
        }
        read.close();
        System.out.println();
        for(int i = 0; i < n ; i++){
            if(eachAppointTravel[i] <= results[i])
                System.out.println("Case #" + (i + 1 ) +  ": Go for it!");
            else
                System.out.println("Case #" + (i + 1 ) +  ": Not enough time.");
        }
    }

}