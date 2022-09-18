import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of side a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter the length of side b: ");
        double b = scanner.nextDouble();

        double c = Math.sqrt( Math.pow(a, 2) + Math.pow(b, 2) );

        System.out.println("\nSide a: " + a + "\nSide b: " + b + "\nHypotenuse: " + c);
    
        scanner.close();
    }
}