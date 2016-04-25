import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


public class Answer_2508 extends JFrame{
	private JTextField textField1;
	private JTextField textField2;
	
	public static void main(String[] args){
		try{
		Answer_2508 frame = new Answer_2508();
		frame.setVisible(true);
		}catch(Exception e){
			System.out.println("Error");
		}
	}
	
	public Answer_2508(){
		super();
		setTitle("25-8");
		setBounds(100,100,500,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JPanel panel1 = new JPanel();
		getContentPane().add(panel1, BorderLayout.NORTH);
		
		final JLabel label1 = new JLabel();
		label1.setText("Method 1");
		panel1.add(label1);
		
		textField1 = new JTextField();
		textField1.addKeyListener(new KeyListener(){
			int keyCode;
			
			public void keyPressed(KeyEvent e){
				keyCode = e.getKeyCode();
			}
			
			public void keyTyped(KeyEvent e){
				if(keyCode < KeyEvent.VK_0 || keyCode > KeyEvent.VK_9)
					e.consume();
			}
			
			public void keyReleased(KeyEvent e){
				
			}
		});
		textField1.setColumns(20);
		panel1.add(textField1);
		
		final JPanel panel2 = new JPanel();
		getContentPane().add(panel2,  BorderLayout.CENTER);
		
		final JLabel label2 = new JLabel();
		label2.setText("Method 2");
		panel2.add(label2);
		
		textField2 = new JTextField();
		textField2.addKeyListener(new KeyAdapter(){
			String num = "0123456789";
			
			public void keyTyped(KeyEvent e){
				if(num.indexOf(e.getKeyChar())<0)
					e.consume();
			}
		});
		textField2.setColumns(20);
		panel2.add(textField2);
	}
}
