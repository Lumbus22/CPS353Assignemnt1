package Implementations;

import java.io.IOException;

import JavaAPIs.ComputerEngineImpl;

public class ComputationImpl extends ComputerEngineImpl {
    private DataSystem dataSystem;

    public ComputationImpl(String sourceFilePath) {
        this.dataSystem = new DataSystem("test/dataTests/testInput.csv", "test/dataTests/testoutput.csv");
    }

    public void setDataSystem(DataSystem dataSystem) {
        this.dataSystem = dataSystem;
    }
    
    public static void main(String[] args) throws IOException {
        String sourceFilePath = "test/dataTests/testInput.csv";
        ComputationImpl calculator = new ComputationImpl(sourceFilePath);
        String[] numberStrings = calculator.receiveDataForComputation();
        long[][] results = calculator.performDigitFactorial(numberStrings);
        calculator.printResults(results);
    }
    
    public String[] receiveDataForComputation() throws IOException {
        dataSystem.readFromFile();
        return dataSystem.getNumberStrings();
    }

    public long[][] performDigitFactorial(String[] numberStrings) {
        long[][] results = new long[2][numberStrings.length];
        //** REMOVE BOM FROM INPUT FILE IF NECESSARY **//
        if (numberStrings.length > 0 && !numberStrings[0].isEmpty() && numberStrings[0].charAt(0) == '\uFEFF') {
            numberStrings[0] = numberStrings[0].substring(1);
        }
        for (int i = 0; i < numberStrings.length; i++) {
            try {
                System.out.println("Parsing number: '" + numberStrings[i] + "'");
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

    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

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
