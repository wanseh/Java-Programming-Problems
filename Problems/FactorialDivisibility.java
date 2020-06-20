
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FactorialDivisibility {
    public static void main(String[] args) {
        List<Integer> caseInputs = new ArrayList<>();
        Scanner read = new Scanner(System.in);
        int num = 0;
        int factorialOfNum;
        int quot;


        do{
            num = read.nextInt();
            caseInputs.add(num);
        }while(num != 0);



       for(Integer var : caseInputs){
           int counter = 0;
           if (var == 0){
               break;
           }else if (var == 1){
               System.out.println(var + " factorial is divisible by exactly 0 twos.");
           }
           factorialOfNum = getFactorial(var);
           quot = factorialOfNum;
         do{
                quot /= 2;
                counter++;
           }while(quot % 2 == 0);
           System.out.println(var + " factorial is divisible by exactly " + counter + " twos.");
       }
    }

    public static int getFactorial(int var){
        int product = 1;
        for (int i = 1; i <= var; i++){
            product *= i;
        }
        return product;
    }
}
