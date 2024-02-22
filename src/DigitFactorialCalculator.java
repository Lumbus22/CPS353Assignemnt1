import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DigitFactorialCalculator extends ComputerEngineImpl {

    private String sourceFilePath;
    private String[] numberStrings;

    public DigitFactorialCalculator(String sourceFilePath) {
        this.sourceFilePath = sourceFilePath;
    }

    public static void main(String[] args) throws IOException {
        String sourceFilePath = "/Users/davidvenuto/Desktop/ComputerEngine/document2.csv";
        DigitFactorialCalculator calculator = new DigitFactorialCalculator(sourceFilePath);
        calculator.receiveDataForComputation();
        long[][] results = calculator.performDigitFactorial();
        calculator.printResults(results);
    }

    @Override
    public void receiveDataForComputation() throws IOException {
        System.out.println(System.getProperty("user.dir"));
        try (BufferedReader reader = new BufferedReader(new FileReader(this.sourceFilePath))) {
            String line = reader.readLine();
            if (line != null) {
                this.numberStrings = line.split(",");
            }
        }
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

    // Will remove at some point, just here for testing purposes
    public void printResults(long[][] results) {
        System.out.println("Original Number | Sum of Digit Factorials");
        System.out.println("-----------------------------------------");
        for (int i = 0; i < results[0].length; i++) {
            System.out.printf("%15d | %24d%n", results[0][i], results[1][i]);
        }
    }

}
