package generator;

import java.text.DecimalFormat;

/**
 * Converts a given int into capitalized word form. Original: https://www.rgagnon.com/javadetails/java-0426.html
 */
public class NumToWordConverter {

    private static final String[] tensNames = { "", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty",
            " Seventy", " Eighty", " Ninety" };

    private static final String[] numNames = { "", " One", " Two", " Three", " Four", " Five", " Six", " Seven",
            " Eight", " Nine", " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen",
            " Seventeen", " Eighteen", " Nineteen" };

    private NumToWordConverter() {
    }

    private static String convertLessThanOneThousand(int number) {
        String soFar;

        if (number % 100 < 20) {
            soFar = numNames[number % 100];
            number /= 100;
        } else {
            soFar = numNames[number % 10];
            number /= 10;

            // dashes in numbers like Twenty-Three are added here
            if (soFar.length() > 1) {
                soFar =  tensNames[number % 10] + "-" + soFar.substring(1);
            } else {
                soFar =  tensNames[number % 10] + soFar;
            }
            number /= 10;
        }
        if (number == 0) {
            return soFar;
        }
        return numNames[number] + " Hundred" + soFar;
    }

    public static String convertNegative(long number) {
        return "Negative " + convert(Math.abs(number));
    }
    
    public static String convert(long number) {
        // -999 999 999 999 to 999 999 999 999
        if (number == 0) {
            return "Zero";
        }
        
        if (number < 0) {
            return convertNegative(number);
        }

        String snumber = Long.toString(number);

        // pad with "0"
        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(number);

        // XXXnnnnnnnnn
        int billions = Integer.parseInt(snumber.substring(0, 3));
        // nnnXXXnnnnnn
        int millions = Integer.parseInt(snumber.substring(3, 6));
        // nnnnnnXXXnnn
        int hundredThousands = Integer.parseInt(snumber.substring(6, 9));
        // nnnnnnnnnXXX
        int thousands = Integer.parseInt(snumber.substring(9, 12));

        String tradBillions;
        switch (billions) {
            case 0:
                tradBillions = "";
                break;
            case 1:
                tradBillions = convertLessThanOneThousand(billions) + " Billion ";
                break;
            default:
                tradBillions = convertLessThanOneThousand(billions) + " Billion ";
        }
        String result = tradBillions;

        String tradMillions;
        switch (millions) {
            case 0:
                tradMillions = "";
                break;
            case 1:
                tradMillions = convertLessThanOneThousand(millions) + " Million ";
                break;
            default:
                tradMillions = convertLessThanOneThousand(millions) + " Million ";
        }
        result = result + tradMillions;

        String tradHundredThousands;
        switch (hundredThousands) {
            case 0:
                tradHundredThousands = "";
                break;
            case 1:
                tradHundredThousands = "One Thousand ";
                break;
            default:
                tradHundredThousands = convertLessThanOneThousand(hundredThousands) + " Thousand ";
        }
        result = result + tradHundredThousands;

        String tradThousand;
        tradThousand = convertLessThanOneThousand(thousands);
        result = result + tradThousand;

        // remove extra spaces!
        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }
    

    /**
     * Used for testing.
     * 
     * @param args This method does not accept any arguments.
     */
    public static void main(String[] args) {
        int zero = 0;
        System.out.println("Got: " + convert(-123456));
        System.out.println("Got: " + convert(-12));
        System.out.println("Got: " + convert(zero));
        System.out.println("Got: " + convert(1));
        System.out.println("Got: " + convert(8));
        System.out.println("Got: " + convert(16));
        System.out.println("Got: " + convert(72));
        System.out.println("Got: " + convert(133));
        System.out.println("Got: " + convert(100));
        System.out.println("Got: " + convert(118));
        System.out.println("Got: " + convert(200));
        System.out.println("Got: " + convert(219));
        System.out.println("Got: " + convert(800));
        System.out.println("Got: " + convert(801));
        System.out.println("Got: " + convert(1316));
        System.out.println("Got: " + convert(1000000));
        System.out.println("Got: " + convert(2000000));
        System.out.println("Got: " + convert(3000200));
        System.out.println("Got: " + convert(700000));
        System.out.println("Got: " + convert(9000000));
        System.out.println("Got: " + convert(9001000));
        System.out.println("Got: " + convert(123456789));
        System.out.println("Got: " + convert(2147483647));
        System.out.println("Got: " + convert(3000000010L));
    }
}
