class MyException extends Exception{
	MyException(){
		super("hello");
	}
}
public class ExceptionDemo6 {
	public static void main(String[] args){
		int n1 = 8;
		int n2 = 0;
		try{
			if(n2 == 0 || n2 == 1)
				throw new MyException();
			System.out.println("result:" + n1/n2);
		}catch(MyException e){
			System.out.println(e.getMessage());
		}
	}
}
