class Outer{
	private int x = 1;
	void print(){
		Inner inner = new Inner();
		inner.display();
	}
	class Inner{
		private int y = 2;
		void display(){
			System.out.println("Inner:" + x++);
		}
	}
}
public class NestedClasses {
	public static void main(String[] args){
		Outer outer = new Outer();
		outer.print();
	}
}
