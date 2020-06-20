

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class LargestAliquotDivisor {
    public static void main(String[] args){
      List<Integer> posInt = new ArrayList<>();
        String fileNameDir = "C:\\Users\\Lance Parantar\\AppData\\Roaming\\JetBrains\\IdeaIC2020.1\\scratches\\DivisorTestCase.txt";
        ReadFromTextFile(posInt,fileNameDir);
        for (int i = 0; i < posInt.size(); i++) {
           solveAliquotDivisor(i,posInt.get(i),posInt);
        }
        posInt.forEach(System.out::println);
    }

    public static void solveAliquotDivisor(int index,int num, List <Integer> list){
        int LargestDivisor = 1;
        for(int i = 1; i < num ; i++){
            if(num % i == 0)
                LargestDivisor = i;
        }
        list.set(index, LargestDivisor);
    }

    public static void ReadFromTextFile(List<Integer> list, String FileDirectory){
        try{
            Scanner reader = new Scanner(new FileReader(FileDirectory));
           while (reader.hasNextInt()){
               int posNum = reader.nextInt();
               list.add(posNum);
           }
        }catch(Exception e){
            System.out.println("FileNotFound");
        }
    }

}
