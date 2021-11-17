import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        compute();
    }

    public static List<Double> scanNumbers(Scanner scanner){
        List<Double> numbers = new ArrayList<>();
        while (scanner.hasNextDouble()) {
            double number = scanner.nextDouble();
            numbers.add(number);
        }
        return numbers;
    }

    public static double sum(List<Double> numbers){
        double sum = 0;
        for (double f : numbers) {
            sum += f;
        }
        return sum;
    }

    public static List<Double> normalize(List<Double> numbers, double sum){
        List<Double> normalized = new ArrayList<>();
        double mean = sum / numbers.size();
        double sumSquare = 0;
        for (double f : numbers) {
            double diff = f - mean;
            sumSquare += diff * diff;
        }
        double std = Math.sqrt(sumSquare / numbers.size());
        for (double f : numbers) {
            normalized.add((f - mean) / std);
        }
        return normalized;
    }

    public static void fileWrite(List<Double> normalized){
        try {
            FileWriter fw = new FileWriter("output");
            for (double n : normalized) {
                fw.write(Double.toString(n));
                fw.write("\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("Error writing output file");
        }

    }

    public static List<Double> compute() throws FileNotFoundException {
        File file = new File("data");
        Scanner scanner = new Scanner(file);
        List<Double> numbers = new ArrayList<>(scanNumbers(scanner));
        double sum = sum(numbers);
        List<Double> normalized = new ArrayList<>(normalize(numbers, sum));
        System.out.println(normalized);
        fileWrite(normalized);
        System.out.println("Wrote output file.");
        scanner.close();
        return normalized;
    }
}
