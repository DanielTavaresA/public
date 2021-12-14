package two;

import java.util.Scanner;

public class Greeter {

    private static final String FIRST_NAME_REQUEST = "Please enter your first name:";
    private static final String LAST_NAME_REQUEST = "Please enter your last name:";
    private static final String AGE_REQUEST = "Please enter your age:";
    private static final String ageFormat = "(%s years old)";

    

    public static String getRequest(String request){
        Scanner s = new Scanner(System.in);
        System.out.println(request);
        String input = s.next();
        return input;
    }
    public static void printGreatings(String... str){
        StringBuilder greating = new StringBuilder("Nice to meet you ");
        for (String s :
                str) {
            greating.append(s).append(" ");
        }
        System.out.println(greating.toString().strip());
    }

    // prints: Nice to meet you Willy
    public static void askForFirstName() {
        String firstName = getRequest(FIRST_NAME_REQUEST);
        printGreatings(firstName);
    }

    // prints: Nice to meet you Wonka
    public static void askForLastName() {
        String lastName = getRequest(LAST_NAME_REQUEST);
        printGreatings(lastName);
    }

    // prints: Nice to meet you Willy Wonka
    public static void askForFullName() {
        String firstName = getRequest(FIRST_NAME_REQUEST);
        String lastName = getRequest(LAST_NAME_REQUEST);
        printGreatings(firstName, lastName);
    }

    // prints: Nice to meet you Willy Wonka (23 years old)
    public static void askForFullNameAndAge() {
        String firstName = getRequest(FIRST_NAME_REQUEST);
        String lastName = getRequest(LAST_NAME_REQUEST);
        String age = getRequest(AGE_REQUEST);
        printGreatings(firstName, lastName,  String.format(ageFormat, age));
    }
}
