import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите число");
        String primer = input.nextLine();
        try {
            String result = calc(primer);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String calc(String input) {
        String[] viraj = input.split(" ");
        if (viraj.length != 3) {
            throw new IllegalArgumentException("Unexpected value: " + input);
        }

        String q = viraj[0];
        char ch = q.charAt(0);
        String qq = viraj[2];
        char chch = qq.charAt(0);
        String op = viraj[1];
        int c;

        if (Character.isDigit(ch) && Character.isDigit(chch)) {
            int a = Integer.parseInt(viraj[0]);
            int b = Integer.parseInt(viraj[2]);

            if (a < 0 || a > 10 || b < 0 || b > 10) {
                throw new IllegalStateException("Unexpected value: " + input);
            }

            switch (op) {
                case "+":
                    c = a + b;
                    break;
                case "-":
                    c = a - b;
                    break;
                case "*":
                    c = a * b;
                    break;
                case "/":
                    c = a / b;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + input);
            }
            return String.valueOf(c);
        } else {
            RomeNumber num1 = RomeNumber.valueOf(viraj[0]);
            RomeNumber num2 = RomeNumber.valueOf(viraj[2]);

            switch (op) {
                case "+":
                    c = num1.ordinal() + num2.ordinal();
                    break;
                case "-":
                    c = num1.ordinal() - num2.ordinal();
                    break;
                case "*":
                    c = num1.ordinal() * num2.ordinal();
                    break;
                case "/":
                    if (num2.ordinal() == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    c = num1.ordinal() / num2.ordinal();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + input);
            }

            if (c > 100 || c < 0) {
                throw new IllegalStateException("Unexpected value: " + input);
            }

            return RomeNumber.values()[c].name();
        }
    }
}
