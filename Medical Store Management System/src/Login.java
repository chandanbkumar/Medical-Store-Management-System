import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel bgimg;
	private ImageIcon ic;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 340);
		contentPane = new JPanel();
		bgimg = new JLabel();
		
		bgimg.setLocation(0, 0);
		bgimg.setSize(460,311);
		
		
		
		contentPane.setBorder(BorderFactory.createTitledBorder("Welcome To Store Management"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		bgimg.setIcon(new ImageIcon(Login.class.getResource("/images/mdcn.png")));
		
		JLabel lblLoginToStore = new JLabel("Login To Store");
		lblLoginToStore.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginToStore.setForeground(new Color(204, 0, 0));
		lblLoginToStore.setBounds(46, 40, 334, 47);
		lblLoginToStore.setFont(new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 45));
		contentPane.add(lblLoginToStore);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(75, 126, 72, 28);
		lblName.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		contentPane.add(lblName);
		
		
		textField = new JTextField();
		textField.setBounds(184, 133, 237, 20);
		textField.setColumns(10);
		contentPane.add(textField);	
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(75, 175, 105, 28);
		lblPassword.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(184, 182, 237, 20);
		contentPane.add(passwordField);
		
		
		
		JButton btnSignIn = new JButton("SIGN IN");
		btnSignIn.setBounds(184, 224, 71, 23);
		contentPane.add(btnSignIn);
		contentPane.add(bgimg);
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		
		
		
		
		
		
		
		
		
		
		
	}

}
