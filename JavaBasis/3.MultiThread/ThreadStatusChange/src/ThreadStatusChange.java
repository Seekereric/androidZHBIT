
public class ThreadStatusChange {
	public static void main(String[] args){
		Runner r = new Runner();
		Thread tr = new Thread(r);
		tr.start();
	}
}

class Runner implements Runnable{
	public void run(){
		try{
			for(int i = 0; i < 20; i++){
				if(i%5 == 0 && i != 0){
					Thread.sleep(2000);
				}
				System.out.println("No." + i);
			}
		}catch(InterruptedException e){
		}
		
	}
}
