//Tic-Tac-Toe coded in Java
//Date: February 18th, 2022
//Author: Nicole Fung

import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    //variable declaration
    char[] board = new char[9]; //the values for each cell in the board
    int currentTurn = 1; //keep track of which player is in play
    boolean gameOver = false; //switch to true when someone wins
    int position;

    //print instructions
    System.out.println("Tic-Tac-Toe\n");
    System.out.println("This is a 2 player game.");
    System.out.println("To play, enter the cell you want to play in numbered from 0 to 8 like so: ");
    System.out.println("-------\n|0|1|2|\n-------\n|3|4|5|\n-------\n|6|7|8|\n-------");
    System.out.println("For example, to play in the top left, input 0\n\n");

    Scanner scanner = new Scanner(System.in);

    //set all position in the board to ' '
    for(int i = 0; i<9; i++){
      board[i] = ' ';
    }

    //repeat until someone wins
    while(!gameOver){
      System.out.println("Current Board:");
      printBoard(board);
      gameOver = isGameOver(board);
      if(gameOver){
        break;
      }
      System.out.println("Player " + currentTurn + "\'s Turn:");

      //make sure the input is valid
      if(scanner.hasNextInt()){
        //get input on which spot to play in
        position = scanner.nextInt();
        if(position >= 0 && position <=8){
          if(board[position] == ' '){

            //if player 1's turn
            if(currentTurn == 1){
              board[position] = 'x';
              currentTurn = 2;
            }

            //if player 2's turn
            else{
              board[position] = 'o';
              currentTurn = 1;
            }
          }
          else{
            System.out.println("Sorry that spot is full. Please pick another.");
          }
        }
        else{
          System.out.println("Please enter an integer between 0 and 8");
        }
      }
      else{
        System.out.println("Please enter an integer between 0 and 8");
        scanner.next();
        
      }

      System.out.println();
    } 

    scanner.close();
  }

  //to print out the current board
  static void printBoard(char[] toPrint){
    int currentChar = 0;

    //repeat three times for each line
    for(int i = 0; i < 3; i++){
      System.out.println("-------");

      //repeat 3 times for each cell in a line
      for(int j = 0; j < 3; j++){
        System.out.print("|" + toPrint[currentChar]);
        currentChar++;
      }
      System.out.println("|");
      
    }
    
    System.out.println("-------");
  }

  //check for a win, and return the result
  static boolean isGameOver(char[] board){
    //check rows
    for(int i = 0; i < 9; i=i+3){
      if(board[i] != ' ' && board[i] == board[i+1] && board[i+1] == board[i+2]){
        System.out.println("Player " + board[i] + " wins!");
        return true;
      }
    }
    
    //check columns
    for(int i = 0; i < 3; i++){
      if(board[i] != ' ' && board[i] == board[i+3] && board[i+3] == board[i+6]){
        System.out.println("Player " + board[i] + " wins!");
        return true;
      }
    }
    
    //check diagonals
    if(board[0] != ' ' && board[0] == board[4] && board[4] == board[8]){
      System.out.println("Player " + board[0] + " wins!");
      return true;
    }
    if(board[2] != ' ' && board[2] == board[4] && board[4] == board[6]){
      System.out.println("Player " + board[2] + " wins!");
      return true;
    }

    //check if all spots are full
    for(int i = 0; i <= 9; i++){
      if(i == 9){
        System.out.println("It's a tie");
        return true;
      }
      if(board[i] == ' '){
        break;
      }
    }
      
    return false;
  }
}
