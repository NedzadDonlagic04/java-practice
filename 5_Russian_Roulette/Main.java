import java.util.Scanner;
import java.util.Random;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean repeat;

        do{
            repeat = false;

            System.out.print("Do you wish to play russian roulette?\n(Yes/No): ");
            String option = scanner.nextLine();
            
            if(option.equals("No"))
            {
                System.out.println("Smart");
            }
            else if(option.equals("Yes"))
            {
                int hole = random.nextInt(6);
    
                if(hole > 0)
                {
                    System.out.println("You lived!");
                }
                else
                {
                    System.out.println(":(");
                }
            }
            else
            {
                System.out.println("Wrong input!");
                repeat = true;
            }
        }while(repeat);

        scanner.close();
    }
}