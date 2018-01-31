
import java.sql.*;

import javax.sound.midi.Soundbank;
import javax.swing.JOptionPane;

import java.io.*;

public class ConnectionToDB {
	
	private Connection connection;
	private Statement statement;
	private String url,username,password;
	private String u_id,p_id;
	private PreparedStatement preparedStatement;
	private String prepared_query;
	public ConnectionToDB() {
		
	}
	
	/*ESTABLISH CONNECTION*/
	public boolean makeConnection(){
		boolean flag = true;
		if(flag){
		url = "jdbc:oracle:thin:@localhost:1521:orcl";
		username = "hr";
		password = "hr";
		try{
		connection = DriverManager.getConnection(url,username,password);
		
		statement = connection.createStatement();
		}
		catch(SQLException sqlException){
			flag=false;
			JOptionPane.showMessageDialog(null, "error due to url un up"+sqlException.getMessage());
		}
		}
		return flag;
	}
	
	public String createNewUserId(int flag){
		BufferedReader bufferedReader=null;
		PrintWriter printWriter = null;
		String line=null;
		try{
			bufferedReader = new BufferedReader(new FileReader("userid.txt"));
		}
		catch(Exception fileNotFoundException){
			JOptionPane.showMessageDialog(null, "file na mila");
			File f = new File("userid.txt");
			try{
				f.createNewFile();
				return null;
			}
			catch(IOException ioException){
				JOptionPane.showMessageDialog(null, "file v ni bn rahi"+ioException.getMessage());
				return null;
			}
		}
		try{
			line=bufferedReader.readLine();
		}
		catch(IOException ioException){JOptionPane.showMessageDialog(null, "line ni hua read"+ioException.getMessage());}
		if(line==null){
			System.out.println(line+"ghus gayee bhyii null me");
			try {
				printWriter = new PrintWriter("userid.txt");
				printWriter.println(1);
				System.out.println("writtentofile");
				bufferedReader.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			//printWriter.close();*/
			if(flag==1)
				return "u1001";
			else if(flag==2)
				return "p1001";
			else
				return null;
		}
		else{
			int id;
			id=Integer.parseInt(line);System.out.println(id);
			try {
			printWriter = new PrintWriter("userid.txt");
			u_id="u100"+id;p_id="p100"+id;
			printWriter.println(id+1);
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			printWriter.close();
			if(flag==1)
			return u_id;
			else if(flag==2) return p_id;
			else return null;
		}
		
	}
	
	
	/*public String createNewId(int flag) throws IOException{
		BufferedReader bufferedReader=null;
		PrintWriter printWriter = null;
		String line=null;
		try{
			bufferedReader = new BufferedReader(new FileReader("userid.txt"));
			printWriter = new PrintWriter("userid.txt");

		}
		catch(FileNotFoundException fileNotFoundException){
			File f = new File("userid.txt");
			try{
				f.createNewFile();
				return null;
			}
			catch(IOException ioException){
				return null;
			}
		}
		try{
		line = bufferedReader.readLine();
		}catch(IOException ioException){}
		if(line==null){
			printWriter.print(1);
			bufferedReader.close();
			printWriter.close();
			return "u1";
		}
		else{
			int id=0 ;
			while(line!=null){
				id = Integer.parseInt(line);
				line=bufferedReader.readLine();	
			}
			if(flag==1){
			String ret="u"+id;
			printWriter.print(id++);
			bufferedReader.close();
			printWriter.close();
			return ret;}
			if(flag==2){
				return "p
			}
		}
		
	}*/

	public int insertToUsers(String query,String u_id,String uname,int uage,String usex,String uemail,String uphone,String uaddress,String ucity,String ustate,
								String ucountry,String upassword)
	{
		int res= -999;
		prepared_query=query;
		
		try{
			preparedStatement = connection.prepareStatement(prepared_query);System.out.println(preparedStatement);
		System.out.println(preparedStatement);
		preparedStatement.setString(1, u_id);
		System.out.println("setuid");
		preparedStatement.setString(2, uname);
		preparedStatement.setInt(3, uage);
		preparedStatement.setString(4, usex);
		preparedStatement.setString(5, uemail);
		preparedStatement.setString(6, uphone);
		preparedStatement.setString(7, uaddress);
		preparedStatement.setString(8, ucity);
		preparedStatement.setString(9, ustate);
		preparedStatement.setString(10, ucountry);
		preparedStatement.setString(11, upassword);
		res=preparedStatement.executeUpdate();
		System.out.println("inserted");
		
		}
		catch(SQLException s){
			JOptionPane.showMessageDialog(null, "Insert Proper Values for fields");
			System.out.println(s.getMessage());s.printStackTrace();

			
		}
		return res;
	}

	
	public void closeConnection(){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet queryExecution(String query){
		try {
				return statement.executeQuery(query);

		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public int queryUpdation(String query){
		try {
			System.out.println(query);
			return statement.executeUpdate(query);
		}
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
	}
	
	public void insertPurchaseData(java.sql.Date date,String name,String price,String qty){
		prepared_query = "insert into purchase values(?,?,?,?,?)";
		int check=0;
		float price1 = Float.parseFloat(price);
		int qty1 = Integer.parseInt(qty);
		String id = createNewUserId(2);
		try {
			preparedStatement=connection.prepareStatement(prepared_query);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, qty1);
			preparedStatement.setFloat(4, price1);
			preparedStatement.setDate(5, date);
			check = preparedStatement.executeUpdate();
			new UserPage(1).queriesExecute(4, qty1, name);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
