
public class SellOutClass {
	private String name;
	public SellOutClass(){
		name = "Apple";
	}
	
	public void sell(int price){
		class Apple{
			int innerPrice = 0;
			
			public Apple(int price){
				innerPrice = price;
			}
			
			public void print(){
				System.out.println("On sell: " + name);
				System.out.println("price: " + innerPrice);
			}
		}
		Apple apple = new Apple(price);
		apple.print();
	}
	public static void main(String[] args){
		SellOutClass sample = new SellOutClass();
		sample.sell(100);
	}
}
