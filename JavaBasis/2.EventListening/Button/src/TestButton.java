import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class MyFrame extends Frame{
	TextField t1;
	Button b1;
	MyFrame(){
		setLayout(new FlowLayout());
		t1 = new TextField();
		b1 = new Button("Hide");
		b1.setActionCommand("hide_t1");
		b1.addActionListener(new hide_action());
		add(t1);
		add(b1);
		setBounds(100,100,200,200);
		setVisible(true);
		validate();
	}
	
	class hide_action implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand().equals("hide_t1"))
				t1.setVisible(false);
		}
	}
}

public class TestButton {
	public static void main(String[] args){
		MyFrame myframe = new MyFrame();
	}
}
