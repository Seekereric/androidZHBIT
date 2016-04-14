
public class Outer {
	static int x = 1;
	
	static class Nest{
		void print(){
			System.out.println("Nest " + x);
		}
	}
	
	public static void main(String[] args){
		Outer.Nest nest = new Outer.Nest();
		nest.print();
	}
}
