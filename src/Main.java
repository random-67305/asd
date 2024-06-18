import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("введите число");
        String primer = input.nextLine();
        String[] viraj = primer.split(" ");
        String q = viraj[0];
        char ch = q.charAt(0);
        String qq = viraj[2];
        char chch = qq.charAt(0);
        String op;
        boolean d;
        int c;
        if (Character.isDigit(ch) && Character.isDigit(chch)) {
            int a = Integer.parseInt(viraj[0]);
            op = viraj[1];
            int b = Integer.parseInt(viraj[2]);
            d = false;
            if (viraj.length != 3) {
                throw new IllegalArgumentException("Unexpected value: " + primer);
            }

            if (a < 0 || a > 10 || b < 0 || b > 10) {
                throw new IllegalStateException("Unexpected value: " + primer);
            }

            switch (op) {
                case "+":
                    c = a + b;
                    System.out.println(c);
                    break;
                case "-":
                    c = a - b;
                    System.out.println(c);
                    break;
                case "*":
                    c = a * b;
                    System.out.println(c);
                    break;
                case "/":
                    c = a / b;
                    System.out.println(c);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + primer);
            }
        } else {
            RomeNumber num1 = RomeNumber.valueOf(viraj[0]);
            op = viraj[1];
            RomeNumber num2 = RomeNumber.valueOf(viraj[2]);
            d = false;
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
                    c = num1.ordinal() / num2.ordinal();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + primer);
            }

            if (c > 100 || c < 0) {
                throw new IllegalStateException("Unexpected value: " + primer);
            }

            System.out.println(RomeNumber.values()[c]);
        }
    }
}