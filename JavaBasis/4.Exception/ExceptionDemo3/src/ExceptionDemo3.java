import java.io.*;

public class ExceptionDemo3 {
	public static void main(String[] args){
		RandomAccessFile file;
		try{
			file = new RandomAccessFile("abc.txt","r");
			for(int i = 0; i<20; i++){
				System.out.println((char)file.readByte());
			}
			}catch(FileNotFoundException e1){
				e1.printStackTrace();
			}catch(IOException e2){
				e2.printStackTrace();
			}
	}
}
