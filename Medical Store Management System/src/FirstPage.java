import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FirstPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstPage window = new FirstPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FirstPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 153, 204));
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel title_panel = new JPanel();
		title_panel.setBackground(new Color(51, 204, 204));
		
		JPanel uar_panel = new JPanel();
		uar_panel.setBackground(new Color(153, 204, 204));
		
		JPanel b_panel = new JPanel();
		b_panel.setBackground(new Color(153, 204, 204));
		title_panel.setLayout(new GridLayout(1, 1, 0, 0));
		
		JLabel title_label = new JLabel("Welcome to Medical Store Management System\r\n");
		title_label.setBackground(new Color(0, 153, 51));
		title_label.setForeground(new Color(255, 0, 0));
		title_label.setFont(new Font("Poor Richard", Font.BOLD, 43));
		title_label.setHorizontalAlignment(SwingConstants.CENTER);
		title_panel.add(title_label);
		
		
		frame.getContentPane().add(title_panel);
		frame.getContentPane().add(uar_panel);
		uar_panel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel label_admin = new JLabel("");
		label_admin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Login login = new Login();
				login.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label_admin.setIcon(new ImageIcon(FirstPage.class.getResource("/images/adminloginhover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_admin.setIcon(new ImageIcon(FirstPage.class.getResource("/images/adminlogin.png")));
			}
		});
		label_admin.setIcon(new ImageIcon(FirstPage.class.getResource("/images/adminlogin.png")));
		uar_panel.add(label_admin);
		
		JLabel label_user = new JLabel("");
		label_user.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_user.setIcon(new ImageIcon(FirstPage.class.getResource("/images/userloginhover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_user.setIcon(new ImageIcon(FirstPage.class.getResource("/images/userlogin.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				Login login = new Login();
				login.setVisible(true);
			}
		});
		label_user.setIcon(new ImageIcon(FirstPage.class.getResource("/images/userlogin.png")));
		uar_panel.add(label_user);
		
		JLabel label_register = new JLabel("");
		label_register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_register.setIcon(new ImageIcon(FirstPage.class.getResource("/images/registerhover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label_register.setIcon(new ImageIcon(FirstPage.class.getResource("/images/register.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		label_register.setHorizontalAlignment(SwingConstants.RIGHT);
		label_register.setIcon(new ImageIcon(FirstPage.class.getResource("/images/register.png")));
		uar_panel.add(label_register);
		frame.getContentPane().add(b_panel);
		
		JButton about_btn = new JButton("ABOUT");
		about_btn.setFont(new Font("Sylfaen", Font.PLAIN, 45));
		about_btn.setBackground(new Color(65, 105, 225));
		about_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		FlowLayout fl_b_panel = new FlowLayout(FlowLayout.CENTER, 100, 15);
		fl_b_panel.setAlignOnBaseline(true);
		b_panel.setLayout(fl_b_panel);
		b_panel.add(about_btn);
		
		JButton exit_btn = new JButton("EXIT");
		exit_btn.setBackground(new Color(65, 105, 225));
		exit_btn.setFont(new Font("Sylfaen", Font.PLAIN, 45));
		b_panel.add(exit_btn);
		
		
		
		frame.setBounds(100, 100, 774, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
