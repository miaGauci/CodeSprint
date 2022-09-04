

public class StringUtils
{
   public static String process(String s){
       char temp[] = s.toCharArray();
       char t = temp[0]; 
       for(int i=1; i<temp.length; i++){
           temp[i-1] = temp[i]; 
        }
        temp[temp.length-1] = t; 
        return new String(temp);
   } 
}
