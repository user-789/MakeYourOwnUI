import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class FieldInstance extends JPanel {
	
	static final int WIDTH = 150;
	static final int HEIGHT = 60;
	JTextField title;
	JPasswordField field;
	private int mouseX = 0;
	private int mouseY = 0;
	private int x = 0;
	private int y = 0;
	private int dx = 0;
	private int dy = 0;
	
	FieldInstance() {
		title = new JTextField();
		title.setOpaque(false);
		title.setBorder(null);
		title.setText("Field");
		field = new JPasswordField();
		field.setEchoChar((char)0);
		field.setText("Text goes here");
		this.setSize(WIDTH, HEIGHT);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(title);
		this.add(field);
		title.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent e) {detectPassword();}
			@Override
			public void insertUpdate(DocumentEvent e) {detectPassword();}
			@Override
			public void removeUpdate(DocumentEvent e) {detectPassword();}
			
			public void detectPassword() {
				if (title.getText().toLowerCase().equals("password")) {
					field.setEchoChar('*');
				} else {
					field.setEchoChar((char)0);
				}
				if (title.getText().toLowerCase().equals("username")) {
					Main.username = new String(field.getPassword());
				} else if (title.getText().toLowerCase().equals("password")) {
					Main.password = field.getPassword().length > 0;
				} else if (title.getText().toLowerCase().equals("captcha")) {
					Main.captcha = new String(field.getPassword()).equals("quxg4h");
				}
			}
			
		});
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
		field.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getXOnScreen();
				mouseY = e.getYOnScreen();
				x = getX();
				y = getY();
			}
		});
		field.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				dx = e.getXOnScreen() - mouseX;
				dy = e.getYOnScreen() - mouseY;
				setLocation(x+dx, y+dy);
			}
		});
		field.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent e) {read();}
			@Override
			public void insertUpdate(DocumentEvent e) {read();}
			@Override
			public void removeUpdate(DocumentEvent e) {read();}
			
			public void read() {
				if (title.getText().toLowerCase().equals("username")) {
					Main.username = new String(field.getPassword());
				} else if (title.getText().toLowerCase().equals("password")) {
					Main.password = field.getPassword().length > 0;
				} else if (title.getText().toLowerCase().equals("captcha")) {
					Main.captcha = new String(field.getPassword()).equals("quxg4h");
				}
			}
			
		});
	}
}
