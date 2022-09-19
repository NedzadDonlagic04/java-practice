// Importing all the needed classes
import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        // Scanner instance used to get input
        Scanner scanner = new Scanner(System.in);

        // String used to get the input from the user
        String position;

        // Booleans used conditions
        boolean repeater, gameOngoing = true, tie = false;
        
        // The board on which the game will be displayed as well as the players and signs
        char[] board = new char[9];
        char currentPlayer = '2', currentSign = 'O';

        // Used to place the input onto the board
        int index = 0;

        // Making the board empty at the start
        Arrays.fill(board, ' ');

        // The game's event loop
        while(gameOngoing)
        {
            // Switch the player and sign each loop
            currentPlayer = (currentPlayer == '1')? '2' : '1';
            currentSign = (currentSign == 'X')? 'O' : 'X';

            do{
                // Outputs the board
                for(int i=0; i<board.length; i+=3)
                {
                    System.out.printf("%c | %c | %c", board[i], board[i+1], board[i+2] );
                    
                    if(i != 6)
                    {
                        System.out.println("\n---------");
                    }
                }

                // We assume the input will be correct so there's no need to loop again
                repeater = false;
    
                // Take the input
                System.out.printf("\nPlayer %c enter the position to place %c: ", currentPlayer, currentSign);
                position = scanner.nextLine();
                
                // Conditions used to determine does the input match the needed criteria
                if(position.matches("^[1-9]{1}$") == false)
                {
                    System.out.println("\nError! Input has to be a number from 1-9!");
                    repeater = true;
                }
                else
                {
                    index = Integer.parseInt(position) - 1;
                    if(board[index] != ' ')
                    {
                        System.out.println("\nError! Spot already taken!");
                        repeater = true;
                    }
                }

            }while(repeater);
    
            // Place the sign on the given spot
            board[index] = currentSign;

            // Check has there been a match of the same 3 signs horizontally
            for(int i=0; i<board.length; i+=3)
            {
                if(board[i] == currentSign && board[i+1] == currentSign && board[i+2] == currentSign)
                {
                    gameOngoing = false;
                }
            }

            // Check has there been a match of the same 3 signs vertically
            for(int i=0; i<3; i++)
            {
                if(board[i] == currentSign && board[i+3] == currentSign && board[i+6] == currentSign)
                {
                    gameOngoing = false;
                }
            }

            // Check has there been a match of the same 3 signs on both diagonals
            if(board[0] == currentSign && board[4] == currentSign && board[8] == currentSign)
            {
                gameOngoing = false;
            }
            else if(board[2] == currentSign && board[4] == currentSign && board[6] == currentSign)
            {
                gameOngoing = false;
            }

            // Check if the board is full
            int count = 0;
            for(int i=0; i<board.length; i++)
            {
                if(board[i] == ' ')
                {
                    break;
                }
                count++;
            }

            // If the board is full and there is no winner have a tier happen
            if(gameOngoing != false && count == 9)
            {
                tie = true;
                gameOngoing = false;
            }

        }

        // Outputs the board
        for(int i=0; i<board.length; i+=3)
        {
            System.out.printf("%c | %c | %c", board[i], board[i+1], board[i+2] );
            
            if(i != 6)
            {
                System.out.println("\n---------");
            }
        }

        // Outputting who is the winner (if there is one)
        if(tie)
        {
            System.out.println("\nIt's a tie!");
        }
        else
        {
            System.out.printf("\nPlayer %c won!\n", currentPlayer);
        }

        // Closing the scanner object
        scanner.close();
    }
}