import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	
	static final int FWIDTH = 700;
	static final int FHEIGHT = 500;
	static String username = "";
	static boolean password = false;
	static boolean captcha = false;
	static Random random = new Random();
	static JFrame frame;
	static Font comicsans = new Font("Comic Sans MS", Font.ITALIC, 14);

	public static void main(String[] args) {
		frame = new JFrame("Please login");
		frame.setLayout(null);
		JLabel factory = new JLabel("Let there be UI");
		factory.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
		factory.setSize(160, 40);
		factory.setHorizontalAlignment(JLabel.CENTER);
		factory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rnd = random.nextInt(3);
				if (rnd < 1) {
					FieldInstance inst = new FieldInstance();
					frame.add(inst);
					inst.setLocation((FWIDTH-inst.WIDTH)/2, 3*(FHEIGHT-inst.HEIGHT)/5);
				} else if (rnd < 2) {
					ButtonInstance inst = new ButtonInstance();
					frame.add(inst);
					inst.setLocation((FWIDTH-inst.WIDTH)/2, 3*(FHEIGHT-inst.HEIGHT)/5);
				} else {
					CaptchaInstance inst = new CaptchaInstance();
					frame.add(inst);
					inst.setLocation((FWIDTH-inst.WIDTH)/2, 3*(FHEIGHT-inst.HEIGHT)/5);
				}
				frame.revalidate();
			}
		});
		
		frame.add(factory);
		factory.setLocation(270, 30);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FWIDTH, FHEIGHT);
		frame.setVisible(true);
	}
	
}
