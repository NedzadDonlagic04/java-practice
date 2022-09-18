import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your surname: ");
        String surname = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your favorite food: ");
        String favFood = scanner.nextLine();

        System.out.println("\nYour name is " + name + ' ' + surname);
        System.out.println("You are " + age + " years old");
        System.out.println("Your favorite food is " + favFood);
    }
}
