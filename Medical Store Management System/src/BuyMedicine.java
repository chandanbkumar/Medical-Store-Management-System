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

public class BuyMedicine extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyMedicine frame = new BuyMedicine();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	JLabel lblMname;
	JLabel lblQty;
	JLabel lblPrice;

	/**
	 * Create the frame.
	 */
	public BuyMedicine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel buyMname = new JLabel("Medicine Name:");
		buyMname.setBounds(61, 45, 91, 26);
		contentPane.add(buyMname);
		
		JLabel quantity = new JLabel("Quantity:");
		quantity.setBounds(61, 102, 91, 26);
		contentPane.add(quantity);
		
		JLabel price = new JLabel("Price:");
		price.setBounds(61, 153, 91, 26);
		contentPane.add(price);
		
		JButton btnConfirmToBuy = new JButton("CONFIRM TO BUY");
		btnConfirmToBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertPurchase(lblMname,lblQty,lblPrice);
			}
		});
		btnConfirmToBuy.setBounds(163, 232, 136, 34);
		contentPane.add(btnConfirmToBuy);
		
		lblMname = new JLabel("mname");
		lblMname.setBounds(201, 51, 98, 20);
		contentPane.add(lblMname);
		
		lblQty = new JLabel("qty");
		lblQty.setBounds(201, 108, 98, 20);
		contentPane.add(lblQty);
		
		lblPrice = new JLabel("price");
		lblPrice.setBounds(201, 159, 121, 20);
		contentPane.add(lblPrice);
	}

	protected void insertPurchase(JLabel name, JLabel qty, JLabel price) {
		ConnectionToDB c = new ConnectionToDB();
		c.makeConnection();
		java.util.Date d = new java.util.Date();
		java.sql.Date date = new java.sql.Date(d.getTime());
		c.insertPurchaseData(date, name.getText(), price.getText(), qty.getText());
		c.closeConnection();
		JOptionPane.showMessageDialog(null, "You bought this product");
		
	}

	public void setQty(String name,int qty,double price) {
		lblMname.setText(name);
		lblQty.setText(qty+"");
		lblPrice.setText((price*qty)+"");
		
	}

}
