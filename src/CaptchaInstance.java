import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CaptchaInstance extends JLabel {
	
	static final int WIDTH = 123;
	static final int HEIGHT = 40;
	private int mouseX = 0;
	private int mouseY = 0;
	private int x = 0;
	private int y = 0;
	private int dx = 0;
	private int dy = 0;
	
	public CaptchaInstance() {
		super(new ImageIcon("captchas/captcha1.png"));
		this.setSize(WIDTH, HEIGHT);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getXOnScreen();
				mouseY = e.getYOnScreen();
				x = getX();
				y = getY();
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				dx = e.getXOnScreen() - mouseX;
				dy = e.getYOnScreen() - mouseY;
				setLocation(x+dx, y+dy);
			}
		});
	}


}
