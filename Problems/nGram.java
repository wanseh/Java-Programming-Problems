

import java.util.Scanner;

public class nGram {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int testcase = read.nextInt();
        String [] words = new String [testcase];
        int [] Ngram = new int [testcase];
        StringBuilder res;

        getUserInput(words, Ngram, read);

        for(int index = 0; index < testcase; index++){
           res = new StringBuilder();
            for (int i = 0; i < words[index].length() - Ngram[index] + 1; i++){
              res.append(words[index], i, i + Ngram[index]).append(" ");
            }
            System.out.println("Case #" + (index + 1) +": " + Ngram[index] + " " + res);
        }


    }

    public static void getUserInput(String [] words, int [] Ngram, Scanner sc){
        int length = words.length;
        for(int i = 0; i < length; i++){
            words[i] = sc.next();
            Ngram[i] = sc.nextInt();
        }
    }



}
