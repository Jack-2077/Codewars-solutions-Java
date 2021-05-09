public class PrimeDecomp {
   
    public static String factors(int input) {
       StringBuilder output = new StringBuilder();
       int count = 0;

       for(int i = 2; i < input; ++i) {
          while (input % i == 0) {
            ++count;
            input /= i;
        } 
    output.append((count == 1) ? String.format("(%d)", i) : String.format("(%d**%d)", i, count));
    count = 0;
    }
   return output + "(" + input + ")";}}
