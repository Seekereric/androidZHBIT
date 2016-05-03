
public class ExceptionDemo2 {
	public static void main(String[] args){
		try{
			int n1 = 6;
			int n2 = 0;
			int n3 = n1 / n2;
			
			System.out.println("result:" + n3);
		}catch(ArithmeticException e){
			e.printStackTrace();
		}finally{
			System.out.println("finally print");
		}
	}
}
