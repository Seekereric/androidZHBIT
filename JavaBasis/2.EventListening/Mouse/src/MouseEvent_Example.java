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
				System.out.println("����������");
			}
			
			public void mouseExited(MouseEvent e){
				System.out.println("����Ƴ����");
			}
			
			public void mousePressed(MouseEvent e){
				System.out.print("��갴�������£�");
				int i = e.getButton();
				if(i == MouseEvent.BUTTON1)
					System.out.println("���µ���������");
				if(i == MouseEvent.BUTTON2)
					System.out.println("���µ�������м�");
				if(i == MouseEvent.BUTTON3)
					System.out.println("���µ�������Ҽ�");
			}
			
			public void mouseReleased(MouseEvent e){
				System.out.print("��갴�����ͷţ�");
				int i = e.getButton();
				if(i == MouseEvent.BUTTON1)
					System.out.println("�ͷŵ���������");
				if (i == MouseEvent.BUTTON2)
					System.out.println("�ͷŵ���������");
				if (i == MouseEvent.BUTTON3)
					System.out.println("�ͷŵ�������Ҽ�");
			}
			
			public void mouseClicked(MouseEvent e){
				System.out.print("��������갴����");
				int i = e.getButton();
				if (i == MouseEvent.BUTTON1)
					System.out.print("����������������");
				if (i == MouseEvent.BUTTON2)
					System.out.print("�������������֣�");
				if (i == MouseEvent.BUTTON3)
					System.out.print("������������Ҽ���");	
				int clickCount = e.getClickCount();
				System.out.println("��������Ϊ" + clickCount + "��");
			}
		});
		getContentPane().add(label, BorderLayout.CENTER);
	}
}
