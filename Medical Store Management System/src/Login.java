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
import javax.swing.JOptionPane;
import javax.print.attribute.standard.JobKOctetsProcessed;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField name_textField;
	private JPasswordField password_textField;
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
		
		JLabel lblName = new JLabel("User Id:");
		lblName.setBounds(75, 126, 99, 28);
		lblName.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		contentPane.add(lblName);
		
		
		name_textField = new JTextField();
		name_textField.setBounds(184, 133, 237, 20);
		name_textField.setColumns(10);
		contentPane.add(name_textField);	
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(75, 175, 105, 28);
		lblPassword.setFont(new Font("Mongolian Baiti", Font.BOLD, 23));
		contentPane.add(lblPassword);
		
		password_textField = new JPasswordField();
		password_textField.setBounds(184, 182, 237, 20);
		contentPane.add(password_textField);
		
		
		
		JButton signinbtn = new JButton("SIGN IN");
		signinbtn.setBounds(184, 224, 93, 33);
		contentPane.add(signinbtn);
		contentPane.add(bgimg);
		signinbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				authenticate();
			}
		});

		
		
		
		
		
		
		
		
		
		
		
	}
	
	public void authenticate(){
		ConnectionToDB ct = new ConnectionToDB();
		ct.makeConnection();
		String s = String.format("Select upassword,uname,u_id from users where u_id = '%s'", name_textField.getText());
		
		ResultSet rs = ct.queryExecution(s);
		
		System.out.println(rs);
		
		try {
			rs.next();
			if(rs.getString("upassword").equals(password_textField.getText())){
				UserPage u = new UserPage();
				u.setVisible(true);
				u.showname(rs.getString("uname"),rs.getString("u_id"));
			}
			else{
				JOptionPane.showMessageDialog(null, "Invalid password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Invalid user id");
			e.printStackTrace();
		}
		
	}

}
