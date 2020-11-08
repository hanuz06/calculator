public class CalculationMethods {

  public static int calculate(int[] numbers, String operator) {
      int res = 0;
      if (numbers.length == 2) {
          switch (operator) {
              case "+":
                  res = numbers[0] + numbers[1];
                  break;
              case "-":
                  res = numbers[0] - numbers[1];
                  break;
              case "*":
                  res = numbers[0] * numbers[1];
                  break;
              case "/":
                  res = numbers[0] / numbers[1];
                  break;
              default:
                  res = -1000;
          }
      }
      return res;
  }

}