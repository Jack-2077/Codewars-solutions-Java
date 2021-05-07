public class BraceChecker {
  public boolean isValid(String input) {
  int len = input.length();
      if(len%2 != 0)
        return false;
      for(int i = 0; i < len; ++i) {
        input = input.replace("{}", "").replace("[]", "").replace("()", "");
        if(input.isEmpty())
             return true;
       }
      return false; }}
