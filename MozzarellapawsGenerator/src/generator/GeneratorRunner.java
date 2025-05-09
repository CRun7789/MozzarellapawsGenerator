package generator;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class GeneratorRunner {

    public static String myName;
    private static int min = 0;
    private static int max = 100;
    private static boolean useAllCheeses = false;
    private static boolean useAllBodyParts = false;

    /**
     * Generates an Eight-Mozzarellapaws-type name based on certain parameters.
     * 
     * @param  min             Minimum number of first name
     * @param  max             Maximum number of first name
     * @param  useAllCheeses   Whether to use list of all cheeses or just common ones
     * @param  useAllBodyParts Whether to use list of all body parts or just reasonable ones
     * @return                 a complete name
     */
    private static String generateName(int min, int max, boolean useAllCheeses, boolean useAllBodyParts) {
        StringBuilder name = new StringBuilder();

        name.append(OptionsHolder.getNumber(min, max));
        name.append(" ");
        name.append(OptionsHolder.getCheese(useAllCheeses));
        name.append(OptionsHolder.getBodyPart(useAllBodyParts));

        return name.toString();
    }

    /**
     * Generates an Eight-Mozzarellapaws-type name based on the same parameters as before, or defaults if no prior names
     * have been generated.
     * 
     * @return a complete name
     */
    private static String generateName() {
        return generateName(min, max, useAllCheeses, useAllBodyParts);
    }

    /**
     * Adds the generated name to the list of all previously generated names.
     */
    private static void addNameToTextFile() {
        String filepath = "./names_generated.txt";
        String nameToAdd = myName + "\n";
        try {
            Files.write(Paths.get(filepath), nameToAdd.getBytes(), StandardOpenOption.APPEND); // thanks stack overflow
        } catch (IOException e) {
            System.out.println("...Awww, but I can't add it to the list of all generated names right meow. Sad day :(");
        }
    }

    /**
     * Calls all the important stuff and walks the user through getting input. Separate from main so I can loop easier.
     * 
     * @param s System.in Scanner
     */
    private static void getParamsAndGenerateName(Scanner s) {
        System.out.println(
                "(If you wanna skip right to the final name with SIMPLE DEFAULTS (or whatever your prior conditions were), just press enter. To use SUGGESTED DEFAULTS, type '8'. To use the complicated ones, type '88'.)");
        System.out.println(
                "Otherwise, if you wanna put in parameters yourself, type something else! Anything! Get crazy with it! So long as it's not a newline. Or the number 8. Or 88.");

        String input = s.nextLine();
        if (input.length() < 1) {
            // no change - either previous parameters, or their simple defaults
        } else if (input.equals("8")) {
            // use suggested defaults
            min = 0;
            max = 100;
            useAllCheeses = false;
            useAllBodyParts = true;
        } else if (input.equals("88")) {
            // use complicated defaults
            min = -999999999;
            max = 999999999;
            useAllCheeses = true;
            useAllBodyParts = true;
        } else {
            // prompt for parameters
            System.out.println("Great, you're still here! That means you're looking for some customization!");
            min = InputValidation.queryInt(s,
                    "First off, I need the MINIMUM NUMBER for my first name. Negatives are allowed! But, uh, maybe don't put negative 999 william... that might be too high...");
            max = InputValidation.queryInt(s,
                    "Got it! Now, the MAXIMUM NUMBER (exclusive) my first name could be. Again, please not 999 william!!");

            System.out.println(
                    "\nFor my next two tricks- I mean, next parts of my name- I'm gonna need a boolean. '0' is gonna be FALSE/NO, and '1' is gonna stand for TRUE/YES.\n");
            System.out.println(
                    "In terms of CHEESE, I have two lists of options: the first has one william types of cheese from all around the world! There are a lot!!");
            System.out
                    .println("The second has types of cheeses that you're more likely to find in a US grocery store.");
            useAllCheeses = InputValidation.queryBool(s,
                    "Wanna use the GIANT LIST? Remember, '1' for YES or '0' for NO.");
            useAllBodyParts = InputValidation.queryBool(s,
                    "\nSwagalicious! Now for BODY PARTS. Shall I draw from the giant list (type '1'), or the reasonable one (type '0')?");
        }
        myName = generateName();

        System.out.println("\n\nOkay, time for the grand reveal! My new name is...\n\n");
        System.out.println("\n" + myName + "!\n");
        System.out.println(OptionsHolder.getReaction());

        addNameToTextFile();
    }

    /**
     * The typical main method - gets user input, calls all the methods, and presents the results to the user.
     * 
     * @param args This method does not accept any arguments.
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // greet user
        System.out.println(
                OptionsHolder.getGreeting() + " This is your host, an unnamed cat, and you're here to name me!");
        System.out.println(
                "...Well, at least to pick the conditions under which my name is randomly chosen. Close enough for me!");
        System.out.println(
                "\nSo, you've gotta enter some info for me. We're basing this name off the icomic amd imeffable Eight Mozzarellapaws!");
        System.out.println("Their name has three parts: a NUMBER, a CHEESE, and a BODY PART.");

        // create names as long as the user wants
        boolean again = true;
        while (again) {
            getParamsAndGenerateName(s);
            again = InputValidation.queryContinue(s,
                    "Wanna generate another? Type 0 for NO, or 1 for YES! Or just press enter for YES if you're in a hurry.");
        }

        // buh-bye
        System.out.println("It was fun playing with you! Bye-bye! :3");
        s.close();
    }

}
