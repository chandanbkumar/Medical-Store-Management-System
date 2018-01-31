import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class RegistrationForm extends JFrame {

	private JPanel contentPane;
	private JTextField name_textField;
	private JTextField age_textField;
	private JTextField email_textField;
	private JTextField phoneno_textField;
	private JTextField address_textField;
	private JPasswordField password_textField;
	private JPasswordField repeatpassword_textField;
	private JTextField city_textField;
	private JTextField state_textField;
	private JTextField country_textField;
	private JRadioButton male_rdbtn;
	private ButtonGroup b;
	private JRadioButton female_rdbtn;
	String uid;
	static RegistrationForm frame;
	JLabel id_label; String edit_id;
	JButton register_btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new RegistrationForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public RegistrationForm(String u_id){
		System.out.println("edit id is"+u_id);
		edit_id=u_id;
		RegistrationForm r = (new RegistrationForm());
		r.setVisible(true);
		r.editProfile(u_id);
	}
	
	
	/**
	 * Create the frame.
	 */
	public RegistrationForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 529);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 51));
		//contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Register Here", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][][][][][][][][]", "[][][][][][][][][][][][][][][][]"));
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registration Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		ConnectionToDB c = new ConnectionToDB();
		uid =c.createNewUserId(1);
		
		JLabel userid_label = new JLabel("User Id:");
		contentPane.add(userid_label, "cell 0 1,alignx trailing");
		
		 id_label = new JLabel("");
		id_label.setFont(new Font("Sitka Subheading", Font.PLAIN, 22));
		id_label.setHorizontalTextPosition(SwingConstants.CENTER);
		id_label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(id_label, "cell 1 1 7 1");
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(RegistrationForm.class.getResource("/images/Userreg.png")));
		contentPane.add(label, "cell 9 1 2 3");
		
		JLabel lblNewLabel = new JLabel("Personal Information");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 22));
		contentPane.add(lblNewLabel, "cell 0 3 5 1");
		
		JLabel name_label = new JLabel("Name: ");
		contentPane.add(name_label, "cell 0 4,alignx trailing");
		
		name_textField = new JTextField();
		contentPane.add(name_textField, "cell 1 4 8 1,growx,aligny center");
		name_textField.setColumns(10);
		
		JLabel age_label = new JLabel("Age:");
		contentPane.add(age_label, "cell 0 5,alignx trailing");
		
		age_textField = new JTextField();
		contentPane.add(age_textField, "cell 1 5,growx");
		age_textField.setColumns(10);
		
		JLabel sex_label = new JLabel("                    Sex:");
		contentPane.add(sex_label, "cell 0 6");
		
		b = new  ButtonGroup();
		male_rdbtn = new JRadioButton("Male");
		contentPane.add(male_rdbtn, "flowx,cell 1 6");
		b.add(male_rdbtn);
		female_rdbtn = new JRadioButton("Feamle");
		contentPane.add(female_rdbtn, "cell 1 6");
		b.add(female_rdbtn);
		
		JLabel email_label = new JLabel("Email:");
		contentPane.add(email_label, "cell 0 7,alignx trailing");
		
		
		email_textField = new JTextField();
		contentPane.add(email_textField, "cell 1 7 8 1,growx");
		email_textField.setColumns(10);
		
		JLabel phoneno_label = new JLabel("Phone No.:");
		contentPane.add(phoneno_label, "cell 0 8,alignx trailing");
		
		phoneno_textField = new JTextField(10);
		contentPane.add(phoneno_textField, "cell 1 8 8 1,growx");
		phoneno_textField.setColumns(10);
		
		JLabel address_label = new JLabel("Address:");
		contentPane.add(address_label, "cell 0 9,alignx trailing");
		
		address_textField = new JTextField();
		contentPane.add(address_textField, "cell 1 9 8 1,growx");
		address_textField.setColumns(10);
		
		JLabel city_label = new JLabel("City:");
		contentPane.add(city_label, "cell 0 10,alignx trailing");
		
		city_textField = new JTextField();
		contentPane.add(city_textField, "cell 1 10 2 1,growx");
		city_textField.setColumns(10);
		
		JLabel state_label = new JLabel("State:");
		contentPane.add(state_label, "cell 0 11,alignx trailing");
		
		state_textField = new JTextField();
		contentPane.add(state_textField, "cell 1 11 2 1,growx");
		state_textField.setColumns(10);
		
		JLabel country_label = new JLabel("Country: ");
		contentPane.add(country_label, "cell 0 12,alignx trailing");
		
		country_textField = new JTextField();
		contentPane.add(country_textField, "cell 1 12 2 1,growx");
		country_textField.setColumns(10);
		
		JLabel password_label = new JLabel("Password:");
		contentPane.add(password_label, "cell 0 13,alignx trailing,aligny baseline");
		
		password_textField = new JPasswordField();
		contentPane.add(password_textField, "cell 1 13 8 1,growx");
		
		JLabel repeatpassword_label = new JLabel("Repeat Password:");
		contentPane.add(repeatpassword_label, "cell 0 14,alignx trailing");
		
		repeatpassword_textField = new JPasswordField();
		contentPane.add(repeatpassword_textField, "cell 1 14 8 1,growx");
		
		
		System.out.println("id vreate"+uid);
		id_label.setText(uid);
		register_btn = new JButton("Register");contentPane.add(register_btn, "cell 2 15");
		register_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(register_btn.getText().equals("Register")){
					try{
						InsertToDB(e);
						//frame.dispose();
					}
					catch (Exception i) {
						System.out.println(i.getMessage()+"\n"+"");
						i.printStackTrace();
					}
				}
				else{
					updateToDB();
				}
			}
		});
		
		
	}
	
	@SuppressWarnings("deprecation")
	public void InsertToDB(ActionEvent regform) {
		
		
		String uname;
		int uage;
		String usex;
		String uphone;
		String uaddress;
		String ucity;
		String ustate;
		String ucountry;
		String upassword;
		String uemail;
		
		ConnectionToDB c = new ConnectionToDB();
		//String uid = c.createNewUserId();
		
		
		if(name_textField.getText().isEmpty()||age_textField.getText().isEmpty()||email_textField.getText().isEmpty()||address_textField.getText().isEmpty()
				||country_textField.getText().isEmpty()||city_textField.getText().isEmpty()||state_textField.getText().isEmpty()||password_textField.getText().isEmpty()
					||repeatpassword_textField.getText().isEmpty()||(!male_rdbtn.isSelected()&&!female_rdbtn.isSelected())||phoneno_textField.getText().isEmpty())
		{	
			
			JOptionPane.showMessageDialog(null, "Please Fill All the Fields");

		}
		
		else
		{
			
			uname=name_textField.getText();
			uage=Integer.parseInt(age_textField.getText());
			
			if(male_rdbtn.isSelected())
				usex="M";
			else
				usex="F";
			
			uemail = email_textField.getText();
			uphone =  phoneno_textField.getText();
			uaddress = address_textField.getText();
			ucity = city_textField.getText();
			ustate = state_textField.getText();
			ucountry = country_textField.getText();
			upassword = password_textField.getText();
			String urepeatpassword =repeatpassword_textField.getText();
			
			if(uid==null) 
				JOptionPane.showMessageDialog(null, "uid null de raha hai");
			else {
				
			}
			
			
			if(upassword.equals(urepeatpassword))
			{
				System.out.println("p="+upassword+"rp="+urepeatpassword);
				boolean checkConnection = c.makeConnection();
				String query = "insert into users values(?,?,?,?,?,?,?,?,?,?,?)";
				if(checkConnection)
				{
					int i = c.insertToUsers(query,uid, uname, uage, usex,uemail, uphone, uaddress, ucity, ustate, ucountry, upassword);
					c.closeConnection();
					
					if(i==1) 
						JOptionPane.showMessageDialog(null, "Registered Successfully");
					else	   
						JOptionPane.showMessageDialog(null, "Problem while Registering");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error Connecting to Database");
				}
			}
			
			else
				JOptionPane.showMessageDialog(null, "Password Do not Match");
		}
	}
		


	public void editProfile(String edit_id){
		this.edit_id=edit_id;
		id_label.setText(edit_id);
		String query = "Select * from users where u_id ='"+edit_id+"'";
		ConnectionToDB c = new ConnectionToDB();
		c.makeConnection();
		ResultSet resultSet = c.queryExecution(query);
		try {
			resultSet.next();
			name_textField.setText(resultSet.getString("uname"));
			age_textField.setText(resultSet.getInt("uage")+"");
			String sex = resultSet.getString("ugender");
			if(sex.equals("M")) male_rdbtn.setSelected(true);else female_rdbtn.setSelected(true);
			phoneno_textField.setText(resultSet.getString("uphone"));
			email_textField.setText(resultSet.getString("uemail"));
			state_textField.setText(resultSet.getString("ustate"));
			address_textField.setText(resultSet.getString("uaddress"));
			country_textField.setText(resultSet.getString("ucountry"));
			city_textField.setText(resultSet.getString("ucity"));
			password_textField.setText(resultSet.getString("upassword"));
			register_btn.setText("UPDATE");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.closeConnection();
	}
	
	public void updateToDB(){
		String query = "update users set u_id=?,uname=?,uage=?,ugender=?,uemail=?,uphone=?,uaddress=?,ucity=?,ustate=?,ucountry=?,upassword=? where u_id='"+edit_id+"'";
		String uname=name_textField.getText();
		String usex;
		int uage=Integer.parseInt(age_textField.getText());
		
		if(male_rdbtn.isSelected())
			usex="M";
		else
			usex="F";
		
		String uemail = email_textField.getText();
		String uphone =  phoneno_textField.getText();
		String uaddress = address_textField.getText();
		String ucity = city_textField.getText();
		String ustate = state_textField.getText();
		String ucountry = country_textField.getText();
		String upassword = password_textField.getText();
		String urepeatpassword =repeatpassword_textField.getText();
		ConnectionToDB c = new ConnectionToDB();
		int i=0;
		c.makeConnection();
		if(upassword.equals(urepeatpassword))
			i = c.insertToUsers(query, edit_id, uname, uage, usex, uemail, uphone, uaddress, ucity, ustate, ucountry, upassword);
		else
			JOptionPane.showMessageDialog(null, "Password do not match");
		if(i==1) 
			JOptionPane.showMessageDialog(null, "Updated Successfully");
		else	   
			JOptionPane.showMessageDialog(null, "Problem while Updating");
		c.closeConnection();
		
	}
}

