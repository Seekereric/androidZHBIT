interface pr{
	void print();
}
public class Main {
	
	public pr dest(){
		return new pr(){
			public void print(){
				System.out.println("hahahaha");
			}
		};
	}
	
	public static void main(String[] args){
		Main a = new Main();
		pr pr1 = a.dest();
		pr1.print();
	}
}
