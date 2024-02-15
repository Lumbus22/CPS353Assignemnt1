import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DigitFactorialCalculator implements ComputerEngine {

    
    public static void main() {
        String filePath = "path_to_your_input_file.csv"; // Replace with the actual file path
        processFile(filePath);
    }}

    @Override
    public Data receiveDataForComputation() {
        return dataForComputation;
    }

    @Override
    public Request performDigitFactorial() {
        return digitFactorial;
    }

    @Override
    public Response returnDigitFactorial(String outputURL) {
        return digitFactorial;
    }

  }

    // Calculate the factorial for each int string
    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Sum the factorials for each string of numbers
    private static long digitFactorialSum(String numberString) {
        long sum = 0;
        for (char digit : numberString.toCharArray()) {
            int digitValue = Character.getNumericValue(digit);
            sum += factorial(digitValue);
        }
        return sum;
    }

    // Read and process the file. Example F:\\CSVDemo.csv
    public static void processFile(String filePath) {
      Scanner sc = new Scanner(new File(filePath));
      String line = sc.nextLine();
      sc.close();

        String[] numberStrings = line.split(",");
        long[][] results = new long[2][numberStrings.length];

        for (int i = 0; i < numberStrings.length; i++) {
            results[0][i] = Long.parseLong(numberStrings[i]);
            results[1][i] = digitFactorialSum(numberStrings[i]); 
        }

        return results;

}
