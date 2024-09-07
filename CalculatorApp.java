import java.util.Scanner;
public class CalculatorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter First Number:");
            double a = sc.nextDouble();
            System.out.println("Enter Second Number:");
            double b = sc.nextDouble();
            System.out.println("Enter the operator (+, -, *, /");
            char operator = sc.next().charAt(0);
            double result;
            switch (operator) {
                case '+':
                    result = a + b;
                    break;
                case '-':
                    result = a - b;
                    break;
                case '*':
                    result = a * b;
                    break;
                case '/':
                    if (b==0) {
                        System.out.println("Division by zero is not allowed");
                    }
                    result = a / b;
                    break;
                default:
                    System.out.println("Invalid operator");
          return;
            }
            System.out.printf("The result of %.2f %c %.2f is %.2f%n", a,operator,b,result);
        } catch (Exception e) {
            System.out.println("Invalid input");
        } finally {
            sc.close();
        }
    }
}
