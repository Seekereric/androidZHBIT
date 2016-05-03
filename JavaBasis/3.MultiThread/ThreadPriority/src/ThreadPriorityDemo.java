
public class ThreadPriorityDemo extends Thread {
	public void run(){
		for(int i = 0; i < 5; i++){
			System.out.println(getName() + ":" + i);
		}
	}
	
	public static void main(String[] args){
		ThreadPriorityDemo t1 = new ThreadPriorityDemo();
		ThreadPriorityDemo t2 = new ThreadPriorityDemo();
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
	}
}
