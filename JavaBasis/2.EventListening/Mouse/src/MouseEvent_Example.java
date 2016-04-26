import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class MouseEvent_Example extends JFrame {
	public static void main(String[] args){
		MouseEvent_Example frame = new MouseEvent_Example();
		frame.setVisible(true);
	}
	
	public MouseEvent_Example(){
		super();
		setTitle("MouseEvent");
		setBounds(100,100,500,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JLabel label = new JLabel();
		label.addMouseListener(new MouseListener(){
			
			public void mouseEntered(MouseEvent e){
				System.out.println("光标移入组件");
			}
			
			public void mouseExited(MouseEvent e){
				System.out.println("光标移出组件");
			}
			
			public void mousePressed(MouseEvent e){
				System.out.print("鼠标按键被按下，");
				int i = e.getButton();
				if(i == MouseEvent.BUTTON1)
					System.out.println("按下的是鼠标左键");
				if(i == MouseEvent.BUTTON2)
					System.out.println("按下的是鼠标中键");
				if(i == MouseEvent.BUTTON3)
					System.out.println("按下的是鼠标右键");
			}
			
			public void mouseReleased(MouseEvent e){
				System.out.print("鼠标按键被释放，");
				int i = e.getButton();
				if(i == MouseEvent.BUTTON1)
					System.out.println("释放的是鼠标左键");
				if (i == MouseEvent.BUTTON2)
					System.out.println("释放的是鼠标滚轮");
				if (i == MouseEvent.BUTTON3)
					System.out.println("释放的是鼠标右键");
			}
			
			public void mouseClicked(MouseEvent e){
				System.out.print("单击了鼠标按键，");
				int i = e.getButton();
				if (i == MouseEvent.BUTTON1)
					System.out.print("单击的是鼠标左键，");
				if (i == MouseEvent.BUTTON2)
					System.out.print("单击的是鼠标滚轮，");
				if (i == MouseEvent.BUTTON3)
					System.out.print("单击的是鼠标右键，");	
				int clickCount = e.getClickCount();
				System.out.println("单击次数为" + clickCount + "下");
			}
		});
		getContentPane().add(label, BorderLayout.CENTER);
	}
}
