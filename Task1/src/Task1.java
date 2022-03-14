import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Enter number A:");
            String inpA = reader.readLine();
            int A = Integer.parseInt(inpA);

            System.out.println("Enter number B:");
            String inpB = reader.readLine();
            int B = Integer.parseInt(inpB);

            System.out.println("Choose one of the following operation: +, -, *, /");
            String opr = reader.readLine();

            switch (opr) {
                case "+":
                    System.out.println(A + " + " + B + " = " + (A + B));
                    break;
                case "-":
                    System.out.println(A + " - " + B + " = " + (A - B));
                    break;
                case "*":
                    System.out.println(A + " * " + B + " = " + (A * B));
                    break;
                case "/":
                    System.out.println(String.format("%d / %d = %.2f", A, B, ((double) A / (double)B)));
                    break;
                default:
                    System.out.println("Choose a valid operation!");
                    break;
            }

        } catch (NumberFormatException exception) {
            System.out.println("Enter a valid number");
        }

    }
}
