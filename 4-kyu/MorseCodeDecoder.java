public class MorseCodeDecoder {
    public static String decodeBits(String bits) {
      System.out.println(bits);
      int bitRate = detectBitRate(bits);
      System.out.println(bitRate);
      int scanner = 0;
      while(scanner < bits.length() && bits.charAt(scanner) == '0') scanner++; //skip zeros in front
      if(scanner == bits.length()) {
        return null;
      }
      
      StringBuffer buffer = new StringBuffer();
      Character last = '0';
      StringBuffer currentCodeBuffer = new StringBuffer();      
      while(scanner < bits.length() + bitRate)
      {      
        if(scanner < bits.length() && bits.charAt(scanner) == last){
          currentCodeBuffer.append(bits.charAt(scanner));          
        } else {                    
          currentCodeBuffer.append(last);
          String currentCode = currentCodeBuffer.toString();          
          if(currentCode.equals("1")) {            
            buffer.append(".");
          } else if(currentCode.equals("0")) {
            // no op
          } else if(currentCode.equals("000")) {
            buffer.append(" ");
          } else if(currentCode.equals("111")) {
            buffer.append("-");
          } else if(currentCode.equals("0000000")) {
            buffer.append("   ");
          }
          
          currentCodeBuffer.setLength(0);
        }
        if(scanner < bits.length()) {
          last = bits.charAt(scanner);
        }
        scanner += bitRate;
      }            
      
      return buffer.toString();
    }
    
    private static int detectBitRate(String bits) {
      
      int start = 0, end = bits.length() - 1;
      while(start < bits.length() && bits.charAt(start) == '0') start++;
      while(end >= 0 && bits.charAt(end) == '0') end --;
    
      if(bits.length() <= 1)
      {
        return 1;
      }
      
      int minOnesLength = Integer.MAX_VALUE;
      int minZerosLength = Integer.MAX_VALUE;
      
      for(int i = start; i<= end; i++)
      {
        if(i > 0 && bits.charAt(i) == '1' && bits.charAt(i - 1) == '0')
        {
          int count = 0;
          while(i <= end && bits.charAt(i) == '1'){ 
            count++; 
            i++;
          }
          
          if(count < minOnesLength)
          {
            minOnesLength = count;
          }
        }
      }
      
      for(int i = start; i<= end; i++)
      {
        if(i > 0 && bits.charAt(i) == '0' && bits.charAt(i - 1) == '1')
        {
          int count = 0;
          while(i <= end && bits.charAt(i) == '0'){ 
            count++; 
            i++;
          }
          
          if(count < minZerosLength)
          {
            minZerosLength = count;
          }
        }
      }          
      
      if(minOnesLength == Integer.MAX_VALUE && minZerosLength == Integer.MAX_VALUE)
      {
        return bits.length();
      }
      
      return Math.min(minOnesLength, minZerosLength);
    }
    
    public static String decodeMorse(String morseCode) {
      String[] words = morseCode.split("\\s{3}");    
      StringBuffer result = new StringBuffer();
      for(String word : words)
      {          
        String[] codes = word.split("\\s{1}");
        for(String code : codes)
        {          
          result.append(MorseCode.get(code));                    
        }        
        result.append(" ");
      }
            
      return result.toString().trim();
    }
}
