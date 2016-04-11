
public class OuterClass {
	InnerClass in = new InnerClass();
	public void ouf(){
		in.inf();
	}
	
	class InnerClass{
		InnerClass(){}
		public void inf(){}
		private int x = 1;		
	}
	
	public InnerClass doit(){
		in.x = 4;
		return in;
	}
	
	public static void main(String[] args){
		OuterClass outer = new OuterClass();
		OuterClass.InnerClass inner = outer.doit();
	}
}
