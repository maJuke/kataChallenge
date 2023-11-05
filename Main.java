import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) {

        String operation = input.replaceAll("[0-9]", "")
                .replaceAll("[A-Za-z]", "").trim();
        String firstNumber;
        String secondNumber;
        String res;
        boolean needTranslate = false;

        try {
            firstNumber = input.substring(0, input.indexOf(operation)).trim();
            secondNumber = input.substring(input.indexOf(operation) + 1).trim();
        } catch (Exception e) {
            return "Format is incorrect! / Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)!";
        }


        if (firstNumber.matches(".*[A-Za-z]+.*") && secondNumber.matches(".*[A-Za-z]+.*")) {
            firstNumber = String.valueOf(TranslateRoman.romanToInt(firstNumber));
            secondNumber = String.valueOf(TranslateRoman.romanToInt(secondNumber));
            needTranslate = true;
            if (operation.equals("-") && Integer.parseInt(secondNumber) > Integer.parseInt(firstNumber))
                return "There are no negative numbers in Roman number system! / В римской системе нет отрицательных чисел!";
        }

        if ((Integer.parseInt(firstNumber) > 10 || Integer.parseInt(secondNumber) > 10)
            || (Integer.parseInt(firstNumber) < 1 || Integer.parseInt(secondNumber) < 1))
            return "Input number must be greater than 1 and lower or equal 10! / Введенные числа могут быть только от 1 до 10 включительно!";

        try {
            res = switch (operation) {
                case ("+") -> String.valueOf(Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber));
                case ("-") -> String.valueOf(Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber));
                case ("*") -> String.valueOf(Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber));
                case ("/") -> String.valueOf(Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber));
                default -> "Operation has not been found! / Cтрока не является математической операцией!";
            };
        } catch (Exception e) {
            return "Using different types of counting measures! / Используются одновременно разные системы счисления!";
        }

        if (needTranslate)
            res = TranslateRoman.intToRoman(Integer.parseInt(res));


        return res;
    }
}