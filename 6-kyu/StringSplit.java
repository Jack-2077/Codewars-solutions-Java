public class StringSplit {
    public static String[] solution(String input) {
     
      if(input.length() % 2 != 0)
        input +=  "_";

      int len = input.length();

      String[] list = new String[len/2];
      int j = -1;

      for(int i = 0; i < len/2; ++i)
        list[i] = "" + input.charAt(++j) + input.charAt(++j);    
      
      return list; }}
