public class MorseCodeDecoder {
    public static String decode(String input) {
   
      input = input.trim();
      String[] array = input.split(" ");
      String s = "";
      int count = 0;

    for( String j : array)
    {
      if(j.equals(""))
       {
        ++count;
        if(count % 2 == 0)
            s += " ";
        }
      else
       s += MorseCode.get(j);  
   }
    return s;}}
