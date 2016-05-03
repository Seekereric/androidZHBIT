class ThrowsDemo{
	public void throwsMethod(int n1, int n2) throws ArithmeticException{
		int result = n1/n2;
	}
}
public class ExceptionDemo5 {
	public static void main(String[] args){
		ThrowsDemo t = new ThrowsDemo();
		try{
			t.throwsMethod(10,0);
		}catch(ArithmeticException e){
			System.out.println("error");
		}
	}
}
