import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DigitFactorialCalculator extends ComputerEngineImpl {

    private String filePath;
    private String[] numberStrings;

    public DigitFactorialCalculator(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "document.csv";
        DigitFactorialCalculator calculator = new DigitFactorialCalculator(filePath);
        calculator.receiveDataForComputation();
        long[][] results = calculator.performDigitFactorial();
        calculator.printResults(results);
    }

    @Override
    public void receiveDataForComputation() throws FileNotFoundException {
        Scanner sc = new Scanner(new File(this.filePath));
        if (sc.hasNextLine()) {
            String line = sc.nextLine();
            this.numberStrings = line.split(",");
        }
        sc.close();
    }

    @Override
    public long[][] performDigitFactorial() {
        long[][] results = new long[2][this.numberStrings.length];
        // To remove the BOM
        if (numberStrings.length > 0 && !numberStrings[0].isEmpty() && numberStrings[0].charAt(0) == '\uFEFF') {
            numberStrings[0] = numberStrings[0].substring(1);
        }
        for (int i = 0; i < numberStrings.length; i++) {
            try {
                System.out.println("Parsing number: '" + numberStrings[i] + "'");
                results[0][i] = Long.parseLong(numberStrings[i]);
                results[0][i] = Long.parseLong(numberStrings[i]);
                results[1][i] = digitFactorialSum(numberStrings[i]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format " + e.getMessage());
                results[0][i] = 0;
                results[1][i] = -1;
            }
        }
        return results;
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

    public void printResults(long[][] results) {
        System.out.println("Original Number | Sum of Digit Factorials");
        System.out.println("-----------------------------------------");
        for (int i = 0; i < results[0].length; i++) {
            System.out.printf("%15d | %24d%n", results[0][i], results[1][i]);
        }
    }

}
