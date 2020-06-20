

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class PNAS {

	final static Scanner read = new Scanner(System.in);

	public static void main(String[] args) {

		int numCase = read.nextInt();
		int [] numCases = new int [numCase];
		int [] coins;
		String [] result = new String[numCase];
		int amountOfChange,availTen,availFive,availOne,availCentavo;
		boolean canBeSub = false;
		for(int i = 0; i < numCases.length; i++){
			coins = new int[5];
			takeUserInput(coins);

			amountOfChange = coins[0];
			availTen =  coins[1];
			availFive = coins[2];
			availOne =  coins[3];
			availCentavo = convertCentavoToPeso(coins[4]);

			while(true){
				if (!(amountOfChange < 10) && availTen > 0 ){
					canBeSub = true;
					availTen -= 1;
					amountOfChange -= 10;
				}else if (!(amountOfChange < 5) && availFive > 0){
					canBeSub = true;
					availFive -= 1;
					amountOfChange -= 5;
				}else if (!(amountOfChange < 1)  && availOne > 0){
					canBeSub = true;
					availOne -= 1;
					amountOfChange -= 1;
				}else if (!(amountOfChange < 1)  && availCentavo > 0){
					canBeSub = true;
					availCentavo -= 1;
					amountOfChange -= 1;
				}
				if(!canBeSub)
					break;
				else
					canBeSub = false;
			}
			if(amountOfChange == 0)
				result[i] = "none";
			else
				result[i] = String.valueOf(amountOfChange);
		}
		printResult(result);
	}

	//Take user input
	public static void takeUserInput(int @NotNull [] arrCoins){
		for(int i = 0; i < arrCoins.length; i++){
			arrCoins[i] = read.nextInt();
		}
	}

	public static int convertCentavoToPeso(int cent){
		if (cent < 4)
			return 0;

		int Pesos = cent;
		int temp = 0;
		while(!(Pesos < temp)){
			temp++;
			Pesos -= 4;
		}

		return temp;
	}

	public static void printResult(String @NotNull [] arrRes){
		for(String var : arrRes)
			System.out.println(var);
	}




}

























