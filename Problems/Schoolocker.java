

import java.util.Arrays;
import java.util.Scanner;

public class Schoolocker {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int testcase = read.nextInt();
        int [] testCase = new int [testcase];
        int [] res = new int [testcase];

        for (int i = 0; i < testcase;i++) {
            testCase[i] = read.nextInt();
            res[i] = solveSchool_Locker(testCase, i);
        }

        for(int k = 0; k < res.length; k++)
        {
            if(res[k] <= 1)
                System.out.println("Case #" + (k + 1) + ": " + res[k]+ " locker open");
            else
                System.out.println("Case #" + (k + 1) + ": " + res[k]+ " lockers open");
        }

    }

    public static int solveSchool_Locker(int [] arr, int index){
         boolean [] School_Lockers = new boolean[arr[index] + 1];
         init_ArrayTrue(School_Lockers);
         int ctr = 0;

    for( int i = 2; i < arr[index] + 1; i++) {
        if(i == 2) {
            for (int j = i; j < arr[index] + 1; j++) {
                if (j % 2 == 0)
                    School_Lockers[j] = false;
            }
        }

        if (i > 2) {
            for (int j = i; j < arr[index] + 1; j++) {
                if (j % i == 0)
                    School_Lockers[j] = !School_Lockers[j];
            }
        }
    }

        for(int j = 1; j <  arr[index] + 1; j++)
            if(School_Lockers[j])
                ctr++;

        return ctr;
    }

    public static void init_ArrayTrue(boolean [] arr){
        Arrays.fill(arr, true );
    }





}
