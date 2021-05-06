import java.util.ArrayList;
public class PangramChecker {
  public boolean check(String str)
  {
    str = str.trim().toLowerCase();
     if(str.length() >= 26)
    {
      ArrayList<Character> list = new ArrayList<>();
      for(int i = 0; i < str.length(); ++i) {
        if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
          if(!list.contains(str.charAt(i)))
            list.add(str.charAt(i));
          }
        }
      if(list.size() == 26)
        return true;
   }
    return false;
}}
