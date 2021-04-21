import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JWindow;

public class ButtonInstance extends JButton {
	
	static final int WIDTH = 100;
	static final int HEIGHT = 30;
	JTextField title;
	private int mouseX = 0;
	private int mouseY = 0;
	private int x = 0;
	private int y = 0;
	private int dx = 0;
	private int dy = 0;
	
	ButtonInstance() {
		title = new JTextField();
		title.setOpaque(false);
		title.setBorder(null);
		title.setText("Button");
		title.setSize(60, 30);
		title.setHorizontalAlignment(JTextField.CENTER);
		this.setSize(WIDTH, HEIGHT);
		this.setLayout(null);
		this.add(title);
		title.setLocation(20, 0);
		title.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getXOnScreen();
				mouseY = e.getYOnScreen();
				x = getX();
				y = getY();
			}
		});
		title.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				dx = e.getXOnScreen() - mouseX;
				dy = e.getYOnScreen() - mouseY;
				setLocation(x+dx, y+dy);
			}
		});
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getXOnScreen();
				mouseY = e.getYOnScreen();
				x = getX();
				y = getY();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (title.getText().toLowerCase().equals("login") && Main.username.length() > 0 && Main.password && Main.captcha) {
					JDialog popup = new JDialog(Main.frame);
					popup.setTitle("Success");
					JLabel success = new JLabel("Logged in as " + Main.username + " successfully!");
					success.setHorizontalAlignment(JLabel.CENTER);
					success.setFont(Main.comicsans);
					success.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
					popup.add(success);
					popup.pack();
					popup.setLocationRelativeTo(Main.frame);
					popup.setVisible(true);
				}
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
