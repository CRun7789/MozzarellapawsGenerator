package generator;

import java.util.Scanner;

/**
 * Taken from GitHub of Raikes freshman CS course semester 1. I love stea- I mean repurposing code!
 */
public class InputValidation {

    /**
     * The string to add after the prompt, so the cursor moves forward some number of spaces.
     */
    private static final String AFTER_PROMPT_SPACE = " ";
    private static final String DEFAULT_REPROMPT_MESSAGE = "...um, did you mean to type that? I'm not sure that's what I asked for. Please try again!";
    private static final int[] BOOLEAN_OPTIONS = { 0, 1 };

    public static boolean queryBool(Scanner scnr, String promptMessage) {
        int answer = queryIntFromOptions(BOOLEAN_OPTIONS, scnr, promptMessage);
        if (answer == 1) {
            return true;
        }
        return false;
    }
    
    /**
     * Prompts a user for an integer value and ensures that the user provides viable input. Caller must provide the
     * initial user prompt message (e.g., "Please enter an integer.") and the user re-prompt message (e.g., "That wasn't
     * an integer. Please try again.").
     *
     * @param  scnr            The buffer from which to pull the input.
     * @param  promptMessage   The initial message the function should use to request the desired input from the user.
     * @param  repromptMessage The message to be used to request input when their previous input is not parse-able.
     * @return                 a user-provided int
     */
    public static int queryInt(Scanner scnr, String promptMessage, String repromptMessage) {
        System.out.print(promptMessage + AFTER_PROMPT_SPACE);
        String response = scnr.nextLine();

        while (!canParseInt(response)) {
            System.out.print(repromptMessage + AFTER_PROMPT_SPACE);
            response = scnr.nextLine();
        }

        return Integer.parseInt(response);
    }

    /**
     * Prompts a user for an integer value and ensures that the user provides viable input. Caller must provide the
     * initial user prompt message (e.g., "Please enter an integer."). The default reprompt message will be used if
     * necessary.
     *
     * @param  scnr          The buffer from which to pull the input.
     * @param  promptMessage The initial message the function should use to request the desired input from the user.
     * @return               a user-provided int
     */
    public static int queryInt(Scanner scnr, String promptMessage) {
        return queryInt(scnr, promptMessage, DEFAULT_REPROMPT_MESSAGE);
    }

    /**
     * Requests an integer from the console user. Prompts a user for an integer value and ensures that the user provides
     * viable input. Caller must provide the initial user prompt message (e.g., "Please enter an integer.") and the user
     * re-prompt message (e.g., "That wasn't an integer. Please try again."). Additionally, this function ensures that
     * the user's int is included in an array of acceptable values. If their input is not in the list, the user will be
     * re-prompted.
     *
     * @param  options         The list of acceptable int values (any user inputted int not in this list will be
     *                         rejected)
     * @param  scnr            The buffer from which to pull the input.
     * @param  promptMessage   The initial message the function should use to request the desired input from the user.
     * @param  repromptMessage The message to be used to request input when their previous input is not parse-able.
     * @return                 a user-provided integer
     */
    public static int queryIntFromOptions(int[] options, Scanner scnr, String promptMessage, String repromptMessage) {
        int queriedInt = queryInt(scnr, promptMessage, repromptMessage);

        while (!valueIsInArray(options, queriedInt)) {
            queriedInt = queryInt(scnr, repromptMessage, repromptMessage);
        }

        return queriedInt;
    }

    /**
     * Prompts a user for an integer value and ensures that the user provides viable input. Caller must provide the
     * initial user prompt message (e.g., "Please enter an integer."). The default reprompt message will be used if
     * necessary. Additionally, this function ensures that the user's integer is included in an array of acceptable
     * values. If their input is not in the list, the user will be re-prompted.
     *
     * @param  options       The list of acceptable integer values (any user inputted integer not in this list will be
     *                       rejected)
     * @param  scnr          The buffer from which to pull the input.
     * @param  promptMessage The initial message the function should use to request the desired input from the user.
     * @return               a user-provided integer
     */
    public static int queryIntFromOptions(int[] options, Scanner scnr, String promptMessage) {
        return queryIntFromOptions(options, scnr, promptMessage, DEFAULT_REPROMPT_MESSAGE);
    }

    /**
     * Prompts a user for a char value and ensures that the user provides viable input. Caller must provide the initial
     * user prompt message (e.g., "Please enter a character.") and the user re-prompt message (e.g., "That wasn't a
     * single character. Please try again.").
     *
     * @param  scnr            The buffer from which to pull the input.
     * @param  promptMessage   The initial message the function should use to request the desired input from the user.
     * @param  repromptMessage The message to be used to request input when their previous input is not parse-able.
     * @return                 a user-provided char
     */
    public static char queryChar(Scanner scnr, String promptMessage, String repromptMessage) {
        System.out.print(promptMessage + AFTER_PROMPT_SPACE);
        String response = scnr.nextLine();
        char queriedChar = response.charAt(0);

        while (!canParseChar(response)) {
            System.out.print(repromptMessage + AFTER_PROMPT_SPACE);
            response = scnr.nextLine();
            queriedChar = response.charAt(0);
        }

        return queriedChar;
    }

    /**
     * Prompts a user for a char value and ensures that the user provides viable input. Caller must provide the initial
     * user prompt message (e.g., "Please enter a single character."). If necessary, the default re-prompt message will
     * be used.
     *
     * @param  scnr          The buffer from which to pull the input.
     * @param  promptMessage The initial message the function should use to request the desired input from the user.
     * @return               a user-provided char
     */
    public static char queryChar(Scanner scnr, String promptMessage) {
        return queryChar(scnr, promptMessage, DEFAULT_REPROMPT_MESSAGE);
    }

    /**
     * Requests a char from the console user. Prompts a user for a char value and ensures that the user provides viable
     * input. Caller must provide the initial user prompt message (e.g., "Please enter a character.") and the user
     * re-prompt message (e.g., "That wasn't a single character. Please try again."). Additionally, this function
     * ensures that the user's char is included in an array of acceptable values. If their input is not in the list, the
     * user will be re-prompted.
     *
     * @param  options         The list of acceptable char values (any user inputted char not in this list will be
     *                         rejected)
     * @param  scnr            The buffer from which to pull the input.
     * @param  promptMessage   The initial message the function should use to request the desired input from the user.
     * @param  repromptMessage The message to be used to request input when their previous input is not parse-able.
     * @return                 a user-provided char
     */
    public static char queryCharFromOptions(char[] options, Scanner scnr, String promptMessage,
            String repromptMessage) {
        char queriedChar = queryChar(scnr, promptMessage, repromptMessage);

        while (!valueIsInArray(options, queriedChar)) {
            queriedChar = queryChar(scnr, repromptMessage, repromptMessage);
        }

        return queriedChar;
    }

    /**
     * Prompts a user for a char value and ensures that the user provides viable input. Caller must provide the initial
     * user prompt message (e.g., "Please enter a character."). If necessary, the default re-prompt message will be
     * used. Additionally, this function ensures that the user's char is included in an array of acceptable values. If
     * their input is not in the list, the user will be re-prompted.
     *
     * @param  options       The list of acceptable char values (any user inputted char not in this list will be
     *                       rejected)
     * @param  scnr          The buffer from which to pull the input.
     * @param  promptMessage The initial message the function should use to request the desired input from the user.
     * @return               a user-provided char
     */
    public static char queryCharFromOptions(char[] options, Scanner scnr, String promptMessage) {
        return queryCharFromOptions(options, scnr, promptMessage, DEFAULT_REPROMPT_MESSAGE);
    }

    /**
     * Prompts a user for a double value and ensures that the user provides viable input. Caller must provide the
     * initial user prompt message (e.g., "Please enter a number.") and the user re-prompt message (e.g., "That wasn't a
     * number. Please try again.").
     *
     * @param  scnr            The buffer from which to pull the input.
     * @param  promptMessage   The initial message the function should use to request the desired input from the user.
     * @param  repromptMessage The message to be used to request input when their previous input is not parse-able.
     * @return                 a user-provided double
     */
    public static double queryDouble(Scanner scnr, String promptMessage, String repromptMessage) {
        System.out.print(promptMessage + AFTER_PROMPT_SPACE);
        String response = scnr.nextLine();

        while (!canParseDouble(response)) {
            System.out.print(repromptMessage + AFTER_PROMPT_SPACE);
            response = scnr.nextLine();
        }

        return Double.parseDouble(response);
    }

    /**
     * Prompts a user for a double value and ensures that the user provides viable input. Caller must provide the
     * initial user prompt message (e.g., "Please enter a number."). The default reprompt message will be used if
     * necessary.
     *
     * @param  scnr          The buffer from which to pull the input.
     * @param  promptMessage The initial message the function should use to request the desired input from the user.
     * @return               a user-provided double
     */
    public static double queryDouble(Scanner scnr, String promptMessage) {
        return queryDouble(scnr, promptMessage, DEFAULT_REPROMPT_MESSAGE);
    }

    /**
     * Requests a double from the console user. Prompts a user for a double value and ensures that the user provides
     * viable input. Caller must provide the initial user prompt message (e.g., "Please enter a double.") and the user
     * re-prompt message (e.g., "That wasn't a valid double. Please try again."). Additionally, this function ensures
     * that the user's double is included in an array of acceptable values. If their input is not in the list, the user
     * will be re-prompted.
     *
     * @param  options         The list of acceptable double values (any user inputted double not in this list will be
     *                         rejected)
     * @param  scnr            The buffer from which to pull the input.
     * @param  promptMessage   The initial message the function should use to request the desired input from the user.
     * @param  reprompt        The reprompt message.
     * @param  repromptMessage The message to be used to request input when their previous input is not parse-able.
     * @return                 a user-provided double
     */
    public static double queryDoubleFromOptions(double[] options, Scanner scnr, String promptMessage,
            String repromptMessage) {
        double queriedDouble = queryDouble(scnr, promptMessage, repromptMessage);

        while (!valueIsInArray(options, queriedDouble)) {
            queriedDouble = queryDouble(scnr, repromptMessage, repromptMessage);
        }

        return queriedDouble;
    }

    /**
     * Prompts a user for a double value and ensures that the user provides viable input. Caller must provide the
     * initial user prompt message (e.g., "Please enter a number."). The default reprompt message will be used if
     * necessary. Additionally, this function ensures that the user's double is included in an array of acceptable
     * values. If their input is not in the list, the user will be re-prompted.
     *
     * @param  options       The list of acceptable double values (any user inputted double not in this list will be
     *                       rejected)
     * @param  scnr          The buffer from which to pull the input.
     * @param  promptMessage The initial message the function should use to request the desired input from the user.
     * @return               a user-provided double
     */
    public static double queryDoubleFromOptions(double[] options, Scanner scnr, String promptMessage) {
        return queryDoubleFromOptions(options, scnr, promptMessage, DEFAULT_REPROMPT_MESSAGE);
    }

    /**
     * Prompts a user for a string value and ensures that the user provides viable input. Caller must provide the
     * initial user prompt message (e.g., "Please enter a string.").
     *
     * @param  scnr          The buffer from which to pull the input.
     * @param  promptMessage The initial message the function should use to request the desired input from the user.
     * @return               a user-provided string
     */
    public static String queryString(Scanner scnr, String promptMessage) {
        System.out.print(promptMessage + AFTER_PROMPT_SPACE);
        return scnr.nextLine();
    }

    /**
     * Requests a string from the console user. Prompts a user for a string value and ensures that the user provides
     * viable input. Caller must provide the initial user prompt message (e.g., "Please enter a string.") and the user
     * re-prompt message (e.g., "That wasn't a valid option. Please try again."). Additionally, this function ensures
     * that the user's string is included in an array of acceptable values. If their input is not in the list, the user
     * will be re-prompted.
     *
     * @param  options         The list of acceptable string values (any user inputted string not in this list will be
     *                         rejected)
     * @param  scnr            The buffer from which to pull the input.
     * @param  promptMessage   The initial message the function should use to request the desired input from the user.
     * @param  repromptMessage The message to be used to request input when their previous input is not parse-able.
     * @return                 a user-provided string
     */
    public static String queryStringFromOptions(String[] options, Scanner scnr, String promptMessage,
            String repromptMessage) {
        String queriedString = queryString(scnr, promptMessage);

        while (!valueIsInArray(options, queriedString)) {
            queriedString = queryString(scnr, repromptMessage);
        }

        return queriedString;
    }

    /**
     * Prompts a user for a string value and ensures that the user provides viable input. Caller must provide the
     * initial user prompt message (e.g., "Please enter a string."). If necessary, the default re-prompt message will be
     * used. Additionally, this function ensures that the user's string is included in an array of acceptable values. If
     * their input is not in the list, the user will be re-prompted.
     *
     * @param  options       The list of acceptable string values (any user inputted string in this list will be
     *                       rejected)
     * @param  scnr          The buffer from which to pull the input.
     * @param  promptMessage The initial message the function should use to request the desired input from the user.
     * @return               a user-provided string
     */
    public static String queryStringFromOptions(String[] options, Scanner scnr, String promptMessage) {
        return queryStringFromOptions(options, scnr, promptMessage, DEFAULT_REPROMPT_MESSAGE);
    }

    /**
     * Determines whether a given String is made up entirely of digits with an optional '-' in the first position.
     *
     * @param  s the string whose parse-ability is in question
     * @return   true if s is made up entirely of digits, with an optional '-' in the first position, false otherwise
     */
    public static boolean canParseInt(String s) {
        boolean emptyString = s.length() == 0;
        boolean dashOnly = "-".equals(s);
        if (emptyString || dashOnly) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            boolean isDigit = Character.isDigit(s.charAt(i));
            boolean isNegative = i == 0 && s.charAt(i) == '-';
            if (!isDigit && !isNegative) {
                return false;
            }
        }

        return true;
    }

    /**
     * Determines whether a given String is made up entirely of digits with an optional '.'.
     *
     * @param  s the string whose parse-ability is in question
     * @return   true if s is made up entirely of digits, with an optional '.', false otherwise
     */
    public static boolean canParseDouble(String s) {
        boolean emptyString = s.length() == 0;
        boolean dashOnly = "-".equals(s);
        if (emptyString || dashOnly) {
            return false;
        }

        boolean hasDecimalPoint = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean isDigit = Character.isDigit(c);
            boolean isDecimalPoint = c == '.';

            if (isDecimalPoint) {
                if (hasDecimalPoint) {
                    return false; // can't have more than one decimal point
                }
                hasDecimalPoint = true;
            } else if (!isDigit && !(i == 0 && c == '-')) {
                return false;
            }
        }

        return true;
    }

    /**
     * Determines whether a given String is length 1 and not a number.
     *
     * @param  s the string whose parse-ability is in question
     * @return   true if s is length 1 and not a number, false otherwise
     */
    public static boolean canParseChar(String s) {
        boolean notCharLength = s.length() != 1;
        boolean isDigit = Character.isDigit(s.charAt(0));
        return !notCharLength && !isDigit;
    }

    /**
     * Searches an array to determine if a given value is included. Private because this function is helpful internally,
     * but does not relate to the library's public area of responsibility.
     *
     * @param  haystack The array to search
     * @param  needle   The value to search for
     * @return          true if the value is in the array, false otherwise
     */
    static boolean valueIsInArray(int[] haystack, int needle) {
        for (int item : haystack) {
            if (item == needle) {
                return true;
            }
        }
        return false;
    }

    /**
     * Searches an array to determine if a given value is included. Private because this function is helpful internally,
     * but does not relate to the library's public area of responsibility.
     *
     * @param  haystack The array to search
     * @param  needle   The value to search for
     * @return          true if the value is in the array, false otherwise
     */
    private static boolean valueIsInArray(char[] haystack, char needle) {
        for (char item : haystack) {
            if (item == needle) {
                return true;
            }
        }
        return false;
    }

    /**
     * Searches an array to determine if a given value is included. Private because this function is helpful internally,
     * but does not relate to the library's public area of responsibility.
     *
     * @param  haystack The array to search
     * @param  needle   The value to search for
     * @return          true if the value is in the array, false otherwise
     */
    private static boolean valueIsInArray(double[] haystack, double needle) {
        for (double item : haystack) {
            if (item == needle) {
                return true;
            }
        }
        return false;
    }

    /**
     * Searches an array to determine if a given value is included. Private because this function is helpful internally,
     * but does not relate to the library's public area of responsibility.
     *
     * @param  haystack The array to search
     * @param  needle   The value to search for
     * @return          true if the value is in the array, false otherwise
     */
    private static boolean valueIsInArray(String[] haystack, String needle) {
        for (String item : haystack) {
            if (item.equals(needle)) {
                return true;
            }
        }
        return false;
    }

}
