
public class ThreadInterruptDemo extends Thread{
	public void run(){
		System.out.println("Sleep Now");
		try{
			Thread.sleep(30000);
		}catch(InterruptedException e){
			System.out.println("Awake");
		}
	}
	public static void main(String[] args){
		ThreadInterruptDemo t = new ThreadInterruptDemo();
		t.start();
		t.interrupt();
	}
}
