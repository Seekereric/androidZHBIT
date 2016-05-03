
public class ExceptionDemo4 {
	static void throwException(int n1, int n2){
		try{
			if(n2==0)
				throw new ArithmeticException("error");	
			System.out.println("result:" + n1/n2);
		}catch(ArithmeticException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args){
		throwException(10,0);
	}
}
