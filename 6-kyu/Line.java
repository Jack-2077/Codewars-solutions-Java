public class Line {
  public static String Tickets(int[] input)
  {
    int bills25 = 0, bills50 = 0;
    for(int i : input) {
      if (i == 25)
        ++bills25;

      else if (i == 50) {
        ++bills50;
        --bills25;
      } 
      
      else if (i == 100) {
        if (bills50 > 0) {
          --bills50;
          --bills25;
        } 
      else
         bills25 -= 3;

    }
      if (bills25 < 0 || bills50 < 0)
        return "NO";
    }
    return "YES"; }}
