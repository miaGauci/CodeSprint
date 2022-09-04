import java.io.*;

public class Keyboard{
	
	public static String readString(){
		BufferedReader br;
		try{
			br = new BufferedReader(new InputStreamReader(System.in));
			return br.readLine();
			
		}catch(Exception e){
			
		}
		return null;
	}
	
	public static int readInt(){
		return Integer.parseInt(readString());
	}
	
	public static byte readByte(){
		return Byte.parseByte(readString());
	}
	
	public static short readShort(){
		return Short.parseShort(readString());
	}
	
	public static long readLong(){
		return Long.parseLong(readString());
	}
	
	public static float readFloat(){
		return Float.parseFloat(readString());
	}
	
	public static double readDouble(){
		return Double.parseDouble(readString());
	}
	
	public static boolean readBoolean(){
		return Boolean.parseBoolean(readString());
	}
	
	public static char readChar(){
		return readString().charAt(0);
	}
	
}