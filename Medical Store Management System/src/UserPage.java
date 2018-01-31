import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class UserPage extends JFrame {

	private JPanel contentPane;
	private JTextField search_box;
	private JTable table;
	private JScrollPane scrollPane;
	JLabel lblUsernameName;
	JLabel useridlabbel;
	static JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPage frame = new UserPage();
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
	
	public UserPage(int dumm)
	{
		
	}
	public UserPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		search_box = new JTextField();
		search_box.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				queriesExecute(1,0,"");
			}
		});
		search_box.setBounds(27, 51, 575, 35);
		contentPane.add(search_box);
		search_box.setColumns(10);
		
		scrollPane = new JScrollPane();
		/*scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println( table.getSelectedRow());
			}
		});*/
		scrollPane.setBounds(27, 109, 577, 322);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("purchase history");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchaseHistory p = new PurchaseHistory();
				p.setVisible(true);
				p.showPurchaseHistory();
			}
		});
		btnNewButton.setBounds(628, 132, 128, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Receipts");
		btnNewButton_1.setBounds(628, 211, 128, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Edit Profile");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//editProfile();
				new RegistrationForm(useridlabbel.getText());
			}
		});
		btnNewButton_2.setBounds(628, 294, 128, 35);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserPage.frame.dispose();
			}
		});
		btnNewButton_3.setBounds(628, 378, 128, 35);
		contentPane.add(btnNewButton_3);
		
		queriesExecute(2,0,"");
		table.setEnabled(false);
		
		JButton btnViewDetails = new JButton("View Details");
		btnViewDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewDetails(search_box.getText());
			}
		});
		btnViewDetails.setBounds(634, 54, 122, 29);
		contentPane.add(btnViewDetails);
		
		lblUsernameName = new JLabel("username");
		lblUsernameName.setBounds(537, 11, 98, 29);
		contentPane.add(lblUsernameName);
		
		JLabel lblLoggedIn = new JLabel("Logged In");
		lblLoggedIn.setBounds(610, 13, 70, 25);
		contentPane.add(lblLoggedIn);
		
		useridlabbel = new JLabel("User Id:");
		useridlabbel.setBounds(451, 14, 74, 22);
		contentPane.add(useridlabbel);
		
		JLabel lblLastMedicinePurchased = new JLabel("Last Medicine Purchased Was ");
		lblLastMedicinePurchased.setBounds(27, 457, 185, 31);
		contentPane.add(lblLastMedicinePurchased);
		
		JLabel lblLastMedName = new JLabel("name");
		lblLastMedName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastMedName.setBounds(194, 457, 113, 31);
		contentPane.add(lblLastMedName);
		
		JLabel lblOn = new JLabel("on");
		lblOn.setBounds(317, 457, 30, 31);
		contentPane.add(lblOn);
		
		JLabel lblLastDateAndTime = new JLabel("date and time");
		lblLastDateAndTime.setBounds(345, 461, 169, 23);
		contentPane.add(lblLastDateAndTime);
		
		new PurchaseHistory().showPurchaseHistory();
		ArrayList l = PurchaseHistory.showLastPurchaseDetails();
		System.out.println(l.get(0)+"  "+l.get(1));
		lblLastMedName.setText((String)(l.get(0)));
		String date = new SimpleDateFormat().format(l.get(1));
		lblLastDateAndTime.setText(date);
		
	}
	
	protected void viewDetails(String text) {
		if(text.isEmpty()){
			JOptionPane.showMessageDialog(null, "Input medicine Name", "Error", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		queriesExecute(3,0,"");
		
		
	}


	public void queriesExecute(int flag,int qty,String mname){
		String query="";
		ConnectionToDB ctb = new ConnectionToDB();
		ctb.makeConnection();
		if(flag==1){
		query = "select mname,mtype,mdescription from medicines_stock where mname like '"+search_box.getText()+"%'";
		}
		if(flag==2){
		query = "select mname,mtype,mdescription from medicines_stock";
		}
		if(flag==3){
			query = "select * from medicines_stock";
			ResultSet rs = ctb.queryExecution(query);
			try {
				rs.next();
				String name=search_box.getText();
				String type = rs.getString("MTYPE");
				//String id = rs.getString("M_ID");
				float price = rs.getFloat("MPRICE");
				String stock = rs.getString("AVAILABLE");
				java.util.Date s = rs.getDate("MEXPIRY_DATE");
				String date = new SimpleDateFormat().format(s);
				String desc = rs.getString("MDESCRIPTION");
				MedicineDetails medicineDetails = new MedicineDetails();
				medicineDetails.setVisible(true);
				medicineDetails.setLabels(name,type,price,date,desc,stock);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(flag==4){
			ResultSet rss = ctb.queryExecution("Select * from medicines_stock where mname ='"+mname+"'");
			System.out.println(query);
			try {
				rss.next();
				query="update medicines_stock set MAVAL_QUANTITY=MAVAL_QUANTITY-"+qty+" where m_id='"+rss.getString("M_ID")+"'";
				int i = ctb.queryUpdation(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(query);
		ResultSet rs = ctb.queryExecution(query);
		try {
			rs.next();
			if(flag==2)
				table.setModel(DbUtils.resultSetToTableModel(rs));
			//else System.out.println("error getting searched data");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ctb.closeConnection();
	}
	
	public void showname(String uname,String u_id){
		lblUsernameName.setText(uname);
		useridlabbel.setText(u_id);
		
	}
}
