package org.clss.amaronmw.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class DBConnect {

//	public Connection getConnect(){
//		ResourceBundle bundle = ResourceBundle.getBundle("resources\\db.properties");
//		try{
//			String url=bundle.getString("URL");
//			String username=bundle.getString("USER");
//			String password=bundle.getString("PASSWORD");
//			Class.forName(bundle.getString("Driver")).newInstance();
//			Connection con=DriverManager.getConnection(url,username,password);
//			System.out.println("Connection success!");
//			return con;
//		}catch(Exception e){
//			e.printStackTrace();
//			return null;
//		}
//	}
	public Connection getConnect(){
		try{
			String url="jdbc:mysql://localhost:3306/ediprocess";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con=DriverManager.getConnection(url,"root","root");
			System.out.println("Connection success!");
			return con;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public void disconnect(Connection dbcon){
		try{
		dbcon.clearWarnings();
		dbcon.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnect dbc=new DBConnect();
		Connection con=dbc.getConnect();
		dbc.disconnect(con);

	}

}
