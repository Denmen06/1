import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение в формате a + b, a - b, a * b, a / b. В работе используйте" +
                " целые арабские или римские цифры от 1 до 10 (от I до X) и математечисеские знаки +, -, *, /");
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }
    public static String calc(String input) {
        int a;
        int b;
        int result = 0;
        String finalRes = null;
        String[] inputString = input.split(" ");
        if(inputString.length > 3) {
            System.out.println("Неверное выражение!");
            System.exit(0);
        }else {
            try {
                a = Integer.parseInt(inputString[0]);
                b = Integer.parseInt(inputString[2]);
                if (a > 10 || a < 0 || b < 0 || b > 10) {
                    System.out.println("Неверное выражение!");
                    System.exit(0);
                } else {
                    switch (inputString[1]) {
                        case "+" -> result = a + b;
                        case "-" -> result = a - b;
                        case "/" -> result = a / b;
                        case "*" -> result = a * b;
                    }
                    finalRes = "Результат: " + Integer.toString(result);
                }
            } catch (NumberFormatException e) {
                try {
                    RimNum rimNum1 = RimNum.valueOf(inputString[0]);
                    RimNum rimNum2 = RimNum.valueOf(inputString[2]);
                    a = rimNum1.getArNum();
                    b = rimNum2.getArNum();
                    if (a > 10 || a < 0 || b < 0 || b > 10) {
                        System.out.println("Неверное выражение!");
                        System.exit(0);
                    } else {
                        switch (inputString[1]) {
                            case "+" -> result = a + b;
                            case "-" -> result = a - b;
                            case "/" -> result = a / b;
                            case "*" -> result = a * b;
                        }
                    }
                    if (result < 1) {
                        System.out.println("Римские цифры могут иметь только положиельное значение!");
                        System.exit(0);
                    } else {
                        RimNum[] rimNums = RimNum.values();
                        finalRes = "Результат: " + String.valueOf(rimNums[result - 1]);
                    }
                } catch (IllegalArgumentException z) {
                    System.out.println("Неверное выражение!");
                    System.exit(0);
                }
            }
        }
        return finalRes;
    }
}
