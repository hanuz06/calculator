import java.util.Scanner;

public class Calculator extends CalculationMethods {

    public static void main(String[] args) {
        CalculationMethods calculationOutput = new CalculationMethods();
        RomanNumbers romanNumbers = new RomanNumbers();
        boolean isFirstNumberRoman = false;
        boolean isSecondNumberRoman = false;
        String[] userInputNumbers;
        int[] numbers = new int[2];
        int[] romanToDecimalNumbers = new int[2];

        Scanner myObj = new Scanner(System.in);
        System.out.println("What do you want to calculate: ");
        System.out.println("Input:");

        String userInput = myObj.nextLine().toLowerCase().replaceAll("\\s", "");
        String operator = userInput.replaceAll("[0-9|A-Za-z]", "");

        if (operator.length() != 1) {
            System.out.println("Please check if numbers are positive and integers are from 1 to 10. Operator can be only addition, subtraction, division or multiplication");
            return;
        }

        userInputNumbers = userInput.split("[" + operator + "]");

        if (userInputNumbers.length == 2) {

            isFirstNumberRoman = romanNumbers.isValid(userInputNumbers[0]);
            isSecondNumberRoman = romanNumbers.isValid(userInputNumbers[1]);

            if ((isFirstNumberRoman == true && isSecondNumberRoman == false) || (isFirstNumberRoman == false && isSecondNumberRoman == true)) {
                System.out.println("Both numbers should be either roman or arabic");
                return;
            }

            for (int i = 0; i < userInputNumbers.length; i++) {
                int iNum = 0;

                if (isFirstNumberRoman == true && isSecondNumberRoman == true) {
                    romanToDecimalNumbers[i] = romanNumbers.romanToDecimal(userInputNumbers[i]);
                    if (romanToDecimalNumbers[i] == -1) {
                        System.out.println("The entered digits should be anything between 1 and 10");
                        return;
                    }
                    iNum = romanToDecimalNumbers[i];
                } else {
                    iNum = Integer.parseInt(userInputNumbers[i]);
                    if (iNum < 1 || iNum > 10) {
                        System.out.println("The entered digits should be anything between 1 and 10");
                        return;
                    }
                }
                numbers[i] = iNum;
            }
        } else {
            System.out.println("There should be at least/only 2 numbers");
            return;
        }

        int calculatedResult = calculationOutput.calculate(numbers, operator);

        System.out.println("Output:");
        if (calculatedResult == -1000) {
            System.out.println("Please enter correct operator");
            return;
        }

        if (isFirstNumberRoman == true && isSecondNumberRoman == true) {
            System.out.println(romanNumbers.decimalToRoman(calculatedResult));
        } else {
            System.out.println(calculatedResult);
        }
    }
}