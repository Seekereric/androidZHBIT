import java.awt.event.*;
import java.awt.*;


public class MultiListenerTest implements ActionListener, MouseListener, MouseMotionListener, WindowListener{
	public static void main(String[] args){
		MultiListenerTest m = new MultiListenerTest();
		m.Start();
	}
	
	Frame f = new Frame("MultiListener");
	Button b = new Button("exit");
	Label l = new Label("按下鼠标左键并拖动");
	TextField t = new TextField(40);
	
	public void Start(){
		b.addActionListener(this);
		f.addMouseListener(this);
		f.addMouseMotionListener(this);
		f.addWindowListener(this);
		f.add(l, BorderLayout.NORTH);
		f.add(t, BorderLayout.SOUTH);
		f.add(b, BorderLayout.EAST);
		f.setBackground(Color.cyan);
		f.setLocationByPlatform(true);
		f.setSize(400, 300);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		System.exit(1);
	}
	
	public void mouseDragged(MouseEvent e){
		String str = "x1 = " + e.getX() + ", y1 = " + e.getY();
		t.setText(str);
	}
	
	public void mouseMoved(MouseEvent e){
		String str = "x2 = " + e.getX() + ", y2 = " + e.getY();
		t.setText(str);
	}
	
	public void windowClosing(WindowEvent e){
		System.exit(0);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
