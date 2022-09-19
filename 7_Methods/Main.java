// Importing all the needed classes
import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) 
    {
        // Scanner instance used to get input
        Scanner scanner = new Scanner(System.in);

        // Booleans used for game state conditions
        boolean gameOngoing = true, tie = false;
        
        // The board on which the game will be displayed as well as the players and signs
        char[] board = new char[9];
        char currentPlayer = '2', currentSign = 'O';

        // Used to place the input onto the board
        int index = 0;

        // Used to check is the board full
        int count = 0;

        // Making the board empty at the start
        Arrays.fill(board, ' ');

        // The game's event loop
        while(gameOngoing)
        {
            // Switch the player and sign each loop
            currentPlayer = switchPlayer(currentPlayer);
            currentSign = switchSign(currentSign);
    
            // Get input from the user
            index = userInput(scanner, board, currentPlayer, currentSign);

            // Place the sign on the given spot
            board[index] = currentSign;

            // Checks if there is a winner
            gameOngoing = checkWinner(board, currentSign);

            
            // Check if the board is full
            count = isBoardFull(board);

            // If the board is full and there is no winner have a tier happen
            if(gameOngoing != false && count == 9)
            {
                tie = true;
                gameOngoing = false;
            }

        }

        // Outputs the board
        boardOutput(board);

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

    // Used to switch the current player
    static char switchPlayer(char player)
    {
        return (player == '1')? '2' : '1';
    }

    // Used to switch the current sign
    static char switchSign(char sign)
    {
        return (sign == 'X')? 'O' : 'X';
    }

    // Used to output the board
    static void boardOutput(char[] board)
    {
        // Outputs the board
        for(int i=0; i<board.length; i+=3)
        {
            System.out.printf("%c | %c | %c", board[i], board[i+1], board[i+2] );
                    
            if(i != 6)
            {
                System.out.println("\n---------");
            }
        }
    }

    // Used to get input from user
    static int userInput(Scanner scanner, char[] board, char player, char sign)
    {
        boolean repeater;
        String position;
        int index = 0;

        do{
            // Outputs the board
            boardOutput(board);

            // We assume the input will be correct so there's no need to loop again
            repeater = false;

            // Take the input
            System.out.printf("\nPlayer %c enter the position to place %c: ", player, sign);
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

        return index;
    }

    // Used to check if there is a winner of the game
    static boolean checkWinner(char[] board, char sign)
    {
        // Check has there been a match of the same 3 signs horizontally
        for(int i=0; i<board.length; i+=3)
        {
            if(board[i] == sign && board[i+1] == sign && board[i+2] == sign)
            {
                return false;
            }
        }
        
        // Check has there been a match of the same 3 signs vertically
        for(int i=0; i<3; i++)
        {
            if(board[i] == sign && board[i+3] == sign && board[i+6] == sign)
            {
                return false;
            }
        }
        
        // Check has there been a match of the same 3 signs on both diagonals
        if(board[0] == sign && board[4] == sign && board[8] == sign)
        {
            return false;
        }
        else if(board[2] == sign && board[4] == sign && board[6] == sign)
        {
            return false;
        }
        
        return true;
    }

    // Used to check is the board full
    static int isBoardFull(char[] board)
    {
        int count = 0;

        for(int i=0; i<board.length; i++)
        {
            if(board[i] == ' ')
            {
                break;
            }
            count++;
        }
        
        return count;
    }
}
