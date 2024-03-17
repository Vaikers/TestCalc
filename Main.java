import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (например, 2+3):");
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("В введенной строке не должно быть пробелов");
        }


        if (!input.matches(".*[+\\-*/].*")) {
            throw new IllegalArgumentException("Отсутствуют арифметические операции");
        }



        String[] tokens = input.split("[+\\-*/]");
        if (tokens.length != 2) {
            throw new IllegalArgumentException("Неправильный формат выражения");
        }

        try {
            int operand1 = Integer.parseInt(tokens[0]);
            int operand2 = Integer.parseInt(tokens[1]);
            char operator = input.charAt(tokens[0].length());


            if (operand1 < 1 || operand1 > 10 || operand2 < 1 || operand2 > 10) {
                throw new IllegalArgumentException("Числа должны быть от 1 до 10 включительно");
            }

            switch (operator) {
                case '+':
                    return String.valueOf(operand1 + operand2);
                case '-':
                    return String.valueOf(operand1 - operand2);
                case '*':
                    return String.valueOf(operand1 * operand2);
                case '/':
                    return String.valueOf(operand1 / operand2);
                default:
                    throw new IllegalArgumentException("Недопустимая арифметическая операция");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неправильный формат числа");
        }
    }
}
