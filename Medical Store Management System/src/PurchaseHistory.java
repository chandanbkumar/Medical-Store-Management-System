import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseHistory extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static java.sql.Date date;
	static String mname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseHistory frame = new PurchaseHistory();
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
	public PurchaseHistory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 556, 349);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("PURCHASE HISTORY");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(149, 11, 244, 43);
		contentPane.add(lblNewLabel);
	}
	
	public void showPurchaseHistory(){
		ConnectionToDB ctb= new ConnectionToDB();
		ctb.makeConnection();
		ResultSet rs = ctb.queryExecution("Select m_name,p_quantity,p_price,p_date from purchase");
		try {
			rs.next();
			mname = rs.getString("m_name");System.out.println("mname    "+mname);
			date = rs.getDate("p_date");System.out.println("date                   "+date);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setModel(DbUtils.resultSetToTableModel(rs));
		ctb.closeConnection();
	}
	public static ArrayList showLastPurchaseDetails(){
		ArrayList l = new ArrayList();
		l.add(mname);l.add(date);
		return l;
		
	}
}
