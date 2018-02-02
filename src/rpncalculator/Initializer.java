package rpncalculator;

import java.util.Scanner;

public class Initializer
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Calculator calc = new Calculator();
        
        while (true)
        {
            String input = scan.nextLine();
            calc.feedInput(input);
        }
    }
}
