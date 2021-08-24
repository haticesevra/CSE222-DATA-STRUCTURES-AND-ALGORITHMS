import java.io.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("CHOOSE HOW YOU WANT TO TEST THE CODE");
        System.out.println("1- With Driver Code");
        System.out.println("2- With User Input");
        System.out.print("Choose... ");
        int choose = input.nextInt();


        if(choose == 1){
            Driver driver = new Driver();		// runs by itself
        }
        else if(choose == 2){
            Interactive interactive = new Interactive(); // gets input from the user
        }
        else
            System.out.println("Invalid choice");

    }


}
