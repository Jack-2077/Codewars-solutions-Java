import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class ObservedPin {

    public static List<String> getPINs(String observed) {
       
        HashMap<String, String[]> adjacents = new HashMap<>();
        adjacents.put("1", new String[]{"1", "2", "4"});
        adjacents.put("2", new String[]{"1", "2", "3", "5"});
        adjacents.put("3", new String[]{"2", "3", "6"});
        adjacents.put("4", new String[]{"1", "4", "5", "7"});
        adjacents.put("5", new String[]{"2", "4", "5", "6", "8"});
        adjacents.put("6", new String[]{"3", "5", "6", "9"});
        adjacents.put("7", new String[]{"4", "7", "8"});
        adjacents.put("8", new String[]{"5", "7", "8", "9", "0"});
        adjacents.put("9", new String[]{"6", "8", "9"});
        adjacents.put("0", new String[]{"0", "8"});

        StringBuilder pinBuilder = new StringBuilder(observed);

        char[] observedPin = observed.toCharArray();

        String[] firstPositionValues = adjacents.get(String.valueOf(observedPin[0]));

        List<String> pins = new ArrayList<>();

        for (String value : firstPositionValues) {

            //This outer loop is to set the first value
            pinBuilder.setCharAt(0, value.charAt(0));

            int currentDigit = 1; //Start from the first digit after the first
            int[] currentPermutation = new int[observedPin.length]; //Keeps track of how many potential permutations for a given number

            if (observedPin.length > 1) {

                //Loop through the rest of the pin checking each possible permutation
                while (currentDigit != observedPin.length && currentDigit > 0) {

                    //Get all the possible alternative values for the current digit in the pin
                    String[] values = adjacents.get(String.valueOf(observedPin[currentDigit]));

                    if (currentDigit == observedPin.length - 1) {

                        //if the current permutation is less than the possible values
                        if (currentPermutation[currentDigit] < values.length) {

                            for (String val : values) {

                                pinBuilder.setCharAt(currentDigit, val.charAt(0));

                                if (currentPermutation[currentDigit] < values.length) {
                                    currentPermutation[currentDigit]++;
                                }

                                //Don't add duplicates
                                if (pins.indexOf(pinBuilder.toString()) == -1) {
                                    pins.add(pinBuilder.toString());
                                }

                            }
                        } else {
                            currentPermutation[currentDigit] = 0;
                            currentDigit = currentDigit - 1;
                        }


                    } else {

                        if (currentPermutation[currentDigit] < values.length) {
                            pinBuilder.setCharAt(currentDigit, values[currentPermutation[currentDigit]].charAt(0));
                            currentPermutation[currentDigit]++;
                            currentDigit++;
                        }
                        else {
                            currentPermutation[currentDigit] = 0;
                            currentDigit = currentDigit - 1;
                        }
                    }
                }
            }

            if (pins.indexOf(pinBuilder.toString()) == -1) {
                pins.add(pinBuilder.toString());
            }
        }

        System.out.println("There are : " + pins.size()+  " possible pins");
        return pins;
      
      
    } // getPINs

} // ObservedPin
