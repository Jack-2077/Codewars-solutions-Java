public class Printer {
    public static String printerError(String s) {
      s = s.trim().toLowerCase();
    if (!s.equals("")) {
      int count = 0, length = s.length();
      for (int i = 0; i < length; ++i)
      {
        if(s.charAt(i) >= 'a' && s.charAt(i) <= 'm'){}
        else 
          ++count;
      }
      return String.format("%d/%d", count,length);
    }
return null; }}
