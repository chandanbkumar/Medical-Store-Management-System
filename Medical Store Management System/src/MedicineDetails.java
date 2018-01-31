import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MedicineDetails extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicineDetails frame = new MedicineDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	double price;String medname;
	JLabel mname_label;
	JLabel lblMtype;
	JLabel lblMprice;
	JLabel lblMexpdate;
	JLabel lblMdesc;
	JLabel lblMstock;
	/**
	 * Create the frame.
	 */
	public MedicineDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMedicineName = new JLabel("Medicine Name:");
		lblMedicineName.setBounds(36, 38, 102, 27);
		contentPane.add(lblMedicineName);
		
		JLabel lblNewLabel = new JLabel("Type:");
		lblNewLabel.setBounds(36, 76, 80, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblPriceperTabletml = new JLabel("Price(per tablet/ml):");
		lblPriceperTabletml.setBounds(36, 112, 102, 25);
		contentPane.add(lblPriceperTabletml);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date:");
		lblExpiryDate.setBounds(36, 148, 102, 28);
		contentPane.add(lblExpiryDate);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(36, 187, 102, 28);
		contentPane.add(lblDescription);
		
		JLabel lblStock = new JLabel("Stock Available:");
		lblStock.setBounds(36, 226, 102, 27);
		contentPane.add(lblStock);
		
		JButton btnBuy = new JButton("BUY");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s =JOptionPane.showInputDialog("Quantity");
				BuyMedicine buyMedicine = new BuyMedicine();
				buyMedicine.setVisible(true);
				buyMedicine.setQty(medname,Integer.parseInt(s),price);
			}
		});
		btnBuy.setBounds(156, 272, 89, 23);
		contentPane.add(btnBuy);
		
		mname_label = new JLabel("mname");
		mname_label.setBounds(214, 44, 169, 21);
		contentPane.add(mname_label);
		
		lblMtype = new JLabel("mtype");
		lblMtype.setBounds(214, 81, 169, 20);
		contentPane.add(lblMtype);
		
		lblMprice = new JLabel("mprice");
		lblMprice.setBounds(214, 117, 169, 20);
		contentPane.add(lblMprice);
		
		lblMexpdate = new JLabel("mexpdate");
		lblMexpdate.setBounds(214, 155, 169, 21);
		contentPane.add(lblMexpdate);
		
		lblMdesc = new JLabel("mdesc");
		lblMdesc.setBounds(214, 194, 169, 21);
		contentPane.add(lblMdesc);
		
		lblMstock = new JLabel("mstock");
		lblMstock.setBounds(214, 232, 169, 21);
		contentPane.add(lblMstock);
	}

	public void setLabels(String name, String type, double price, String date, String desc, String stock) {
		mname_label.setText(name);
		lblMtype.setText(type);
		lblMprice.setText(price+"");
		lblMexpdate.setText(date);
		lblMdesc.setText(desc);
		lblMstock.setText(stock);
		this.price=price;
		medname = name;
	}
	
	
	
}
