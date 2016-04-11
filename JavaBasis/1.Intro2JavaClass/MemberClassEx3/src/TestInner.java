class Outer{
	private int i = 0;
	Outer(int i){
		this.i = i;
	}
	public void print(){
		System.out.println("Outer:" + i);
	}
	
	class Inner{
		private int j = 0;
		Inner(int j){
			this.j = j;
		}
		public void print(){
			System.out.println("Inner:" + j);
		}
	}
}
public class TestInner {
	public static void main(String[] args){
		Outer outer = new Outer(10);
		outer.print();
		
		Outer.Inner inner = outer.new Inner(20);
		inner.print();
	}
}
