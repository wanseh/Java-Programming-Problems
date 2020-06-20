

import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class TicTacToeMachine {
    final static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        String moves;
        int c = reader.nextInt();
        int[] testcase = new int[c];
        int[][] checkPlayer = new int[3][3];
        String[][] TicTacToeBoard = new String[3][3];
        String[] resultsForEachCase = new String[c];

        putLetterDesignation(TicTacToeBoard);

        for (int i = 0; i < testcase.length; i++) {
             moves = reader.next().toUpperCase();
            resultsForEachCase[i] = solveTicTacToe(TicTacToeBoard, moves, checkPlayer);
        }
       //printBoard(checkPlayer);
        for (String res : resultsForEachCase)
            System.out.println(res);


    }

    public static void putLetterDesignation(String[][] board) { //Initialize TicTacToe board
        String letters = "ABCDEFGHI";
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                char letter = letters.charAt(0);
                board[row][col] = Character.toString(letter);
                letters = charRemoveAt(letters);
            }
        }
    }

    public static String charRemoveAt(String letter) {
        StringBuilder sb = new StringBuilder(letter);
        sb.deleteCharAt(0);
        return sb.toString();
    }

    public static String solveTicTacToe(String[][] board, String playersMoves, int[][] checkBoard) {
        InitializeCheckBoard(checkBoard);
        Set<String> playMoves = new HashSet<>();
        boolean checkDuplicate;
        int player;
        String ans = "";

        checkDuplicate = findDuplicate(playersMoves , playMoves);
        if (checkDuplicate)
            return "Invalid Move.";

        InitializeAlternatingMoves(checkBoard,board,playersMoves); //Convert ABC into 121

        player = checkVertical(checkBoard);

        switch (player){
            case 0:
                ans = checkDrawOrNotFinished(checkBoard);
                break;
            case 1:
                ans = "First Player Wins.";
                break;
            case 2:
                ans = "Second Player Wins.";
                break;
            case 3:
                ans = "Extended Game.";
                break;
        }
        return ans;
    }


    //fills the array with 0
    public static void InitializeCheckBoard(int[][] board) {
        for (int[] ints : board) {
            Arrays.fill(ints, 0);
        }
    }

    public static void InitializeAlternatingMoves(int [][] checkBoard,String [][] board, String playersMoves){
        int PlayerOne = 1;
        int PlayerTwo = 2;
        int counterIndex = 1;
        do {
            for (int row = 0; row < board.length; row++) {
                if (playersMoves.length() == 0)
                    break;
                char oneLetter = playersMoves.charAt(0);
                for (int col = 0; col < board[row].length; col++) {
                    if (checkBoard[row][col] == 1 || checkBoard[row][col] == 2)
                        continue;
                    if (Character.toString(oneLetter).equals(board[row][col])) {
                        if (counterIndex % 2 != 0)
                            checkBoard[row][col] = PlayerOne;
                        else
                            checkBoard[row][col] = PlayerTwo;
                        counterIndex++;
                        playersMoves = charRemoveAt(playersMoves);
                    }
                }
            }

        } while (playersMoves.length() != 0);
    }


    public static void printBoard(int[][] board) { //just for printing the board
        for (int[] letter : board) {
            for (int ch : letter) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    public static String checkDrawOrNotFinished(int [][] board){ //checks if the board has still 0s in it;
        boolean notMissingTrace = true;
        for (int [] ints : board) {
            if (!notMissingTrace)
                break;
            for (int anInt : ints) {
                if (anInt == 0) {
                    notMissingTrace = false;
                    break;
                }
            }
        }
        if (notMissingTrace)
            return "Draw.";

        return "Not Finished.";
    }

    //checks vertical
    public static int checkVertical(int[][] board) {
        int lastTemp;
        int nextTemp;
        int count = 0;
        int whichPlayer = 0;
        for (int[] ints : board) {
            if (count == 3)
                break;
            for (int col = 0; col < ints.length; col++) {
                lastTemp = ints[col];
                if (col == 2) {
                    nextTemp = ints[col];
                    lastTemp = ints[col - 1];
                } else
                    nextTemp = ints[col + 1];

                if (nextTemp == lastTemp && nextTemp != 0) {
                    count++;
                    whichPlayer = lastTemp;
                }else count = 0;
            }
        }
        if (count == 3) {
            if (whichPlayer == 1)
                return whichPlayer;
            else if (whichPlayer == 2)
                return whichPlayer;
        }else if(count == 0) {
            whichPlayer = checkDiagonal(board);  //if count is 0 it means that there's is no winner in the vertical side of the array
        }
        if( whichPlayer == 0)
            whichPlayer = checkHorizontal(board);  //if whichPLayer is 0 it means that there's no winner in the diagonal side of the array then proceed to check the horizontal side
        return whichPlayer;
    }
    //check diagonal
    public static int checkDiagonal(int [][] board){
        int countPrimaryOne = 0;
        int countPrimaryTwo = 0;
        int countSecondaryOne = 0;
        int countSecondaryTwo = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // Condition for principal diagonal
                if (i == j) {
                    if (board[i][j] == 1)
                        countPrimaryOne++;
                    else
                        countPrimaryOne = 0;

                    if (board[i][j] == 2)
                        countPrimaryTwo++;
                    else
                        countPrimaryTwo = 0;
                }
                //condition for secondary diagonal
                if ((i + j) == (board.length - 1)) {
                    if (board[i][j] == 1)
                        countSecondaryOne++;
                    else
                        countSecondaryOne = 0;

                    if (board[i][j] == 2)
                        countSecondaryTwo++;
                    else
                        countSecondaryTwo = 0;
                }
            }
        }

        if (countPrimaryOne == 3 && countSecondaryOne == 3)
            return 3;
        if (countPrimaryTwo == 3 && countSecondaryTwo == 3)
            return 3;

        if (countPrimaryOne == 3 || countSecondaryOne == 3)
            return 1;
        if (countPrimaryTwo == 3 || countSecondaryTwo == 3)
            return 2;

        return 0;
    }

    public static int  checkHorizontal(int [][] board) {
        int lastTemp;
        int nextTemp;
        int count = 0;
        int whichPlayer = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                lastTemp = board[col][row];
                if (col == 2) {
                    nextTemp = board[col][row];
                    lastTemp = board[col - 1][row];
                } else
                    nextTemp = board[col + 1][row];
                if (count == 3)
                    break;
                if (nextTemp == lastTemp) {
                    count++;
                    whichPlayer = lastTemp;
                } else count = 0;
            }
        }
        if (count == 3) {
            if (whichPlayer == 1)
                return whichPlayer;
            else if (whichPlayer == 2)
                return whichPlayer;
        }
        //it returns 0 if there is no winner in the horizontal side of the array
        return 0;
    }

    //it checks whether if the moveSets by the player has duplicate Like "ABCDEB"
    public static boolean findDuplicate(String moves, Set<String> playMoves) {
        for (String letter : moves.split("")){
            if(!playMoves.add(letter)){
                return true;
            }
        }
    return false;
    }

}



