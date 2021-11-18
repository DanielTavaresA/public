import java.util.Optional;
import java.util.Scanner;

import goolge.Goolge;
import model.Result;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a search phrase:");
        String line = scanner.nextLine().trim();
        if (!line.isEmpty()) {
            String[] keywords = line.split(" ");
            Optional<Result> result = Goolge.search(keywords);
            while (result.isPresent()) {
                System.out.println(result.get());
                System.out.println("...");
                scanner.nextLine();
                result = result.get().next();
            }
            System.out.println();
        }
    }
}