
public class PingPong extends Thread{
	private int delay;
	private String message;
	
	public PingPong(int d, String m){
		delay = d;
		message = m;
	}
	
	public void run(){
		try{
			while(true){
				System.out.println(message);
				Thread.sleep(delay);
			}
		}catch(InterruptedException e){
			return;
		}
	}
	
	public static void main(String[] args){
		PingPong ping = new PingPong(500, "Ping");
		PingPong pong = new PingPong(500, "Pong");
		
		ping.start();
		pong.start();
	}
}
