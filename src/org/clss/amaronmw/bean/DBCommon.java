package org.clss.amaronmw.bean;
import java.sql.*;
import java.text.ParseException;

public class DBCommon {

	DBConnect dbcon=new DBConnect();
	public String changePassWord(String plant,String userid,String oldPassword,String newPassword){
		
		String vplant=getLoginDetailsMobile(userid, oldPassword);
	
		oldPassword=Wincode.encode(oldPassword).trim();
		newPassword=Wincode.encode(newPassword).trim();
		System.out.println(vplant+"=="+plant);
		if(vplant.equals(plant)){
//			System.out.println(vplant+"=="+plant+"1");
			try{
				Connection lcon=dbcon.getConnect();
				String sql="update user_master set password=?  where userid=? and plant=?";
				PreparedStatement ps=lcon.prepareStatement(sql);
				ps.setString(1,newPassword);
				ps.setString(2,userid);
				ps.setString(3,plant);
				int ret=ps.executeUpdate();
				if(ret==1){
					dbcon.disconnect(lcon);
					return "Successfully Password Changed!";
				}else{
					dbcon.disconnect(lcon);
					return "E:Change Password failed!";
				}



			}catch(Exception e){
				e.printStackTrace();

				return "E"+e.getMessage();
			}
		}else{
			return "Wrong Userid or password!";
		}

	}
	public String getLoginDetailsMobile(String userid,String password){
//		System.out.println(userid+"=="+password);
		password=Wincode.encode(password).trim();
		myUtil my=new myUtil();
		String plant="N";
		try{
			Connection lcon=dbcon.getConnect();
			
			String sql="select * from user_master where userid=? and user_type=?";
			PreparedStatement ps=lcon.prepareStatement(sql);
			ps.setString(1,userid);
			ps.setString(2, "2");
			ResultSet rs=ps.executeQuery();

				if(rs.next()){
					if(rs.getString("password").equals(password)){
						if(rs.getString("block").equals("A")){
							plant=rs.getString("plant");
						}else{
							plant="B";
						}
					}else{
						plant="PF";
					}
					
				}else{
	
	
					return "NE";
				}

			
			dbcon.disconnect(lcon);

			return plant;
		}catch(Exception e){
			e.printStackTrace();

			return "N";
		}
	}
	public String getLoginDetails(String userid,String password){
//		System.out.println(userid+"=="+password);
//		Wincode win=new Wincode();
		password=Wincode.encode(password).trim();
		System.out.println(password);
		String plant="N";
		try{
			Connection lcon=dbcon.getConnect();
			String sql="select * from user_master where userid=? and password=? and block=? and (user_type='1' or user_type='3') ";
			PreparedStatement ps=lcon.prepareStatement(sql);
			ps.setString(1,userid);
			ps.setString(2,password);
			ps.setString(3, "A");
			ResultSet rs=ps.executeQuery();
//			System.out.println(ps.toString());
			if(rs.next()){
				plant=rs.getString("userid")+"|"+rs.getString("plant")+"|"+rs.getString("user_type");
			}else{


				return plant;
			}
			dbcon.disconnect(lcon);

			return plant;
		}catch(Exception e){
			e.printStackTrace();

			return "N";
		}
	}

	public String[] getSAPLoginDetails(){
		String result[]=null;
		try{
			Connection lcon=dbcon.getConnect();
			String sql="select * from sap_logon where block='A'";
			PreparedStatement ps=lcon.prepareStatement(sql);

			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				result=new String[8];
				result[0]=rs.getString("clientid");
				result[1]=rs.getString("user_id");
				result[2]=rs.getString("password");
				result[3]=rs.getString("langdesc");
				result[4]=rs.getString("hostname");
				result[5]=rs.getString("systemno");
				result[6]=rs.getString("sys_id");
				result[7]=rs.getString("program_id");
			}else{
				result=new String[1];
				result[0]="N";
				return result;

			}
			dbcon.disconnect(lcon);

			return result;
		}catch(Exception e){
			e.printStackTrace();
			result=new String[1];
			result[0]="N";
			return result;
		}
	}
		public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		DBCommon dbc=new DBCommon();
		String data[]=dbc.getSAPLoginDetails();
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
//		dbc.changePassWord("1016","101601","1234","123");
		

	}

}
