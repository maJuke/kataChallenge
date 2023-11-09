package kataChallenge;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {

        String operation = input.replaceAll("[0-9]", "")
                .replaceAll("[A-Za-z]", "").trim();
        String firstNumber;
        String secondNumber;
        String res = "";
        boolean needTranslate = false;

        try {
            firstNumber = input.substring(0, input.indexOf(operation)).trim();
            secondNumber = input.substring(input.indexOf(operation) + 1).trim();
        } catch (Exception e) {
            throw new Exception("Format is incorrect! / Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)!");
        }


        if (firstNumber.matches(".*[A-Za-z]+.*") && secondNumber.matches(".*[A-Za-z]+.*")) {
            firstNumber = String.valueOf(TranslateRoman.romanToInt(firstNumber));
            secondNumber = String.valueOf(TranslateRoman.romanToInt(secondNumber));
            needTranslate = true;
            if (operation.equals("-") && Integer.parseInt(secondNumber) > Integer.parseInt(firstNumber))
                throw new Exception("There are no negative numbers in Roman number system! / В римской системе нет отрицательных чисел!");
        }

        try {
            res = switch (operation) {
                case ("+") -> String.valueOf(Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber));
                case ("-") -> String.valueOf(Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber));
                case ("*") -> String.valueOf(Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber));
                case ("/") -> String.valueOf(Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber));
                default -> {
                    res = "EMPTY";
                    throw new Exception();
                }
            };
        } catch (Exception e) {
            if (res.equals("EMPTY"))
                throw new Exception("Operation has not been found! / Cтрока не является математической операцией!");
            else
                throw new Exception("Using different types of counting measures! / Используются одновременно разные системы счисления!");
        }

        if ((Integer.parseInt(firstNumber) > 10 || Integer.parseInt(secondNumber) > 10)
                || (Integer.parseInt(firstNumber) < 1 || Integer.parseInt(secondNumber) < 1))
            throw new Exception("Input number must be greater than 1 and lower or equal 10! / Введенные числа могут быть только от 1 до 10 включительно!");

        if (needTranslate)
            res = TranslateRoman.intToRoman(Integer.parseInt(res));


        return res;
    }
}