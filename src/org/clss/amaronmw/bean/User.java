
package org.clss.amaronmw.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author admin
 */
public class User {

	public String getSingleUser(String userid) {
		String user="E";
        DBConnect dbcon = new DBConnect();


	Connection con1 = dbcon.getConnect();
	try {
		PreparedStatement ps;
		ResultSet rs1 = null;
		ps = con1.prepareStatement("select userid,username,plant,plantdesc  from user_master where userid<>'admin' and userid='"+userid+"'");
		rs1 = ps.executeQuery();

		if (rs1.next()) {
			user=rs1.getString(1)+"|"+rs1.getString(2)+"|"+rs1.getString(3)+"|"+rs1.getString(4);
        }else{
        	user="E";
        }
		rs1.close();
		ps.close();
		con1.close();

	} catch (Exception ex) {
	}
return user;

}

	public String[][] getResetuser() {
        DBConnect dbcon = new DBConnect();

        String user[][]=null;
	Connection con1 = dbcon.getConnect();
	try {
		PreparedStatement ps;
		ResultSet rs1 = null;
		ps = con1.prepareStatement("select plant, userid ,block  from user_master where userid<>'admin' and block='A' ");
		rs1 = ps.executeQuery();

//		while (rs1.next()) {
//			System.out.print(rs1.getString("plant")+"\t");
//                            System.out.print(rs1.getString("userid")+"\t");
//                            System.out.println(rs1.getString("password"));
//		}
                    rs1.last();
		int w = rs1.getRow();
		user = new String[w][3];
		rs1.beforeFirst();
		if (rs1.next()) {
			for (int i = 0; i < w; i++) {
				user[i][0] = rs1.getString("plant");
				user[i][1] = rs1.getString("userid");
				user[i][2] = rs1.getString("block");

				rs1.next();
                            }}
		rs1.close();
		ps.close();
		con1.close();

	} catch (Exception ex) {
	}
return user;

}
	public String getErrorMessage(String errno){
		String result="";
		try{
			DBConnect dbcon = new DBConnect();
			Connection con=dbcon.getConnect();
			PreparedStatement ps;
			ResultSet rs1 = null;
			ps = con.prepareStatement("select message_txt,message1 from  message_master where message_no='"+errno+"'");
			rs1 = ps.executeQuery();
			if(rs1.next()){
				if(rs1.getString("message1")==null || rs1.getString("message1")==""){
					result=rs1.getString("message_txt");
				}else{
					result=rs1.getString("message1");
				}

			}
			ps.close();
			con.close();
		}catch(Exception ex){

		}
		return result;
	}

	public String getErrorMessage(Connection con,String errno){
		String result="";
		try{
			PreparedStatement ps;
			ResultSet rs1 = null;
			ps = con.prepareStatement("select message_txt,message1 from  message_master where message_no='"+errno+"'");
			rs1 = ps.executeQuery();
			if(rs1.next()){
				if(rs1.getString("message1")==null || rs1.getString("message1")==""){
					result=rs1.getString("message_txt");
				}else{
					result=rs1.getString("message1");
				}

			}

		}catch(Exception ex){

		}
		return result;
	}

	public String[][] viewErrorLog(String vbeln) {
        DBConnect dbcon = new DBConnect();
        String user[][]=null;
	Connection con1 = dbcon.getConnect();
	try {
		PreparedStatement ps;
		ResultSet rs1 = null;
		ps = con1.prepareStatement("select * from  sap_error_log where vbeln='"+vbeln+"'");
		rs1 = ps.executeQuery();
        rs1.last();
		int w = rs1.getRow();
		user = new String[w][12];
		rs1.beforeFirst();

		if (rs1.next()) {
			for (int i = 0; i < w; i++) {
				user[i][0] = rs1.getString(1);
				user[i][1] = rs1.getString(2);
				user[i][2] = rs1.getString(3);
				user[i][3] = rs1.getString(4);
				user[i][4] = rs1.getString(5);
				user[i][5] = rs1.getString(6);
				user[i][6] = rs1.getString(7);

				user[i][7] = rs1.getString(8);
				user[i][8] = rs1.getString(9);
				user[i][9] = rs1.getString(10);
				user[i][10] =rs1.getString(11);
				user[i][11] =getErrorMessage(con1,rs1.getString(7));

				rs1.next();
                            }}
		rs1.close();
		ps.close();
		con1.close();

	} catch (Exception ex) {
	}
	//user=viewErrorLog_msg(user);
return user;

}

	public String[][] viewErrorLog_msg(String err_arr[][]) {
        DBConnect dbcon = new DBConnect();
        String user[][]=null;
	Connection con1 = dbcon.getConnect();
	try {

		for(int j=0;j<err_arr.length;j++){
		PreparedStatement ps;
		ResultSet rs1 = null;
		ps = con1.prepareStatement("select message_txt from message_master where message_no='"+err_arr[j][6]+"'");
		rs1 = ps.executeQuery();

		if (rs1.next()) {
			System.out.println(rs1.getString("message_txt"));
			err_arr[j][11]=rs1.getString("message_txt");
			}
		rs1.close();
		ps.close();
		}
		con1.close();

	} catch (Exception ex) {
	}
return user;

}

	public String[][] getErrorDelivery() {
        DBConnect dbcon = new DBConnect();
        String user[][]=null;
	Connection con1 = dbcon.getConnect();
	try {
		PreparedStatement ps;
		ResultSet rs1 = null;
		ps = con1.prepareStatement("select distinct vbeln,err_dat,werks  from  sap_error_log");
		rs1 = ps.executeQuery();
        rs1.last();
		int w = rs1.getRow();
		user = new String[w][3];
		rs1.beforeFirst();
		 myUtil my=new myUtil();
		if (rs1.next()) {
			for (int i = 0; i < w; i++) {
				user[i][0] = rs1.getString("vbeln");
				user[i][1] = my.ChangeDateFormat(rs1.getString("err_dat"));
				user[i][2] = rs1.getString("werks");
				rs1.next();
                            }}
		rs1.close();
		ps.close();
		con1.close();

	} catch (Exception ex) {
	}
return user;

}
	public String[][] getErrorDelivery(String plant) {
        DBConnect dbcon = new DBConnect();
        String user[][]=null;
	Connection con1 = dbcon.getConnect();
	try {
		PreparedStatement ps;
		ResultSet rs1 = null;
		ps = con1.prepareStatement("select distinct vbeln,err_dat,werks  from  sap_error_log where werks='"+plant+"'");
		rs1 = ps.executeQuery();
        rs1.last();
		int w = rs1.getRow();
		user = new String[w][3];
		rs1.beforeFirst();
		 myUtil my=new myUtil();
		if (rs1.next()) {
			for (int i = 0; i < w; i++) {
				user[i][0] = rs1.getString("vbeln");
				user[i][1] = my.ChangeDateFormat(rs1.getString("err_dat"));
				user[i][2] = rs1.getString("werks");
				rs1.next();
                            }}
		rs1.close();
		ps.close();
		con1.close();

	} catch (Exception ex) {
	}
return user;

}

	public String[][] getResetUserDetails(String userid) {
        DBConnect dbcon = new DBConnect();
        String user[][]=null;
	Connection con1 = dbcon.getConnect();
	try {
		PreparedStatement ps;
		ResultSet rs1 = null;
		//select plant, userid ,block  from user_master where userid<>'admin'
		ps = con1.prepareStatement("select t1.plant,t2.plantdesc,t1.userid,t1.username,t1.block,t1.user_type from user_master as t1,plant as t2 where t1.plant=t2.plant and t1.userid<>'admin' and t1.block='A' and t1.userid='"+userid+"'");
		rs1 = ps.executeQuery();

//		while (rs1.next()) {
//			System.out.print(rs1.getString("plant")+"\t");
//                            System.out.print(rs1.getString("userid")+"\t");
//                            System.out.println(rs1.getString("password"));
//		}
                    rs1.last();
		int w = rs1.getRow();
		user = new String[w][6];
		rs1.beforeFirst();
		if (rs1.next()) {
			for (int i = 0; i < w; i++) {
				user[i][0] = rs1.getString("plant");
				user[i][1] = rs1.getString("plantdesc");
				user[i][2] = rs1.getString("userid");
				user[i][3] = rs1.getString("username");
				user[i][4] = rs1.getString("block");
				String usertype=rs1.getString("user_type");
				if(usertype.equals("1")){
					user[i][5] = "Power User";
				}
				else if(usertype.equals("2")){
					user[i][5] = "End User";
				}else if(usertype.equals("3")){
					user[i][5] = "Super User";
				}

				rs1.next();
                            }
	}
		rs1.close();
		ps.close();
		con1.close();

	} catch (Exception ex) {
	}
return user;

}

	public String[][] getResetUser(String plant) {
        DBConnect dbcon = new DBConnect();
        String user[][]=null;
	Connection con1 = dbcon.getConnect();
	try {
		PreparedStatement ps;
		ResultSet rs1 = null;
		//select plant, userid ,block  from user_master where userid<>'admin'
		ps = con1.prepareStatement("select t1.plant,t2.plantdesc,t1.userid,t1.username,t1.block from user_master as t1,plant as t2 where t1.plant=t2.plant and t1.userid<>'admin' and t1.block='A' and t1.plant='"+plant+"'");
		rs1 = ps.executeQuery();

//		while (rs1.next()) {
//			System.out.print(rs1.getString("plant")+"\t");
//                            System.out.print(rs1.getString("userid")+"\t");
//                            System.out.println(rs1.getString("password"));
//		}
                    rs1.last();
		int w = rs1.getRow();
		user = new String[w][5];
		rs1.beforeFirst();
		if (rs1.next()) {
			for (int i = 0; i < w; i++) {
				user[i][0] = rs1.getString("plant");
				user[i][1] = rs1.getString("plantdesc");
				user[i][2] = rs1.getString("userid");
				user[i][3] = rs1.getString("username");
				user[i][4] = rs1.getString("block");

				rs1.next();
                            }}
		rs1.close();
		ps.close();
		con1.close();

	} catch (Exception ex) {
	}
return user;

}

	public String[][] getResetUser() {
        DBConnect dbcon = new DBConnect();
        String user[][]=null;
	Connection con1 = dbcon.getConnect();
	try {
		PreparedStatement ps;
		ResultSet rs1 = null;
		//select plant, userid ,block  from user_master where userid<>'admin'
		ps = con1.prepareStatement("select t1.plant,t2.plantdesc,t1.userid,t1.username,t1.block from user_master as t1,plant as t2 where t1.plant=t2.plant and t1.userid<>'admin' and t1.block='A'");
		rs1 = ps.executeQuery();
		System.out.println(ps.toString());
//		while (rs1.next()) {
//			System.out.print(rs1.getString("plant")+"\t");
//                            System.out.print(rs1.getString("userid")+"\t");
//                            System.out.println(rs1.getString("password"));
//		}
                    rs1.last();
		int w = rs1.getRow();
		user = new String[w][5];
		rs1.beforeFirst();
		if (rs1.next()) {
			for (int i = 0; i < w; i++) {
				user[i][0] = rs1.getString("plant");
				user[i][1] = rs1.getString("plantdesc");
				user[i][2] = rs1.getString("userid");
				user[i][3] = rs1.getString("username");
				user[i][4] = rs1.getString("block");

				rs1.next();
                            }}
		rs1.close();
		ps.close();
		con1.close();

	} catch (Exception ex) {
	}
return user;

}


	public String[][] getBlockuser(String plant) {
        DBConnect dbcon = new DBConnect();
        String user[][]=null;
	Connection con1 = dbcon.getConnect();
	try {
		PreparedStatement ps;
		ResultSet rs1 = null;
		//select plant, userid ,block  from user_master where userid<>'admin'
		ps = con1.prepareStatement("select t1.plant,t2.plantdesc,t1.userid,t1.username,t1.block,t1.user_type from user_master as t1,plant as t2 where t1.plant=t2.plant and t1.userid<>'admin' and t1.plant='"+plant+"'");
		rs1 = ps.executeQuery();

//		while (rs1.next()) {
//			System.out.print(rs1.getString("plant")+"\t");
//                            System.out.print(rs1.getString("userid")+"\t");
//                            System.out.println(rs1.getString("password"));
//		}
                    rs1.last();
		int w = rs1.getRow();
		user = new String[w][6];
		rs1.beforeFirst();
		if (rs1.next()) {
			for (int i = 0; i < w; i++) {
				user[i][0] = rs1.getString("plant");
				user[i][1] = rs1.getString("plantdesc");
				user[i][2] = rs1.getString("userid");
				user[i][3] = rs1.getString("username");
				user[i][4] = rs1.getString("block");
				String usertype=rs1.getString("user_type");
				if(usertype.equals("1")){
					user[i][5] = "Power User";
				}
				else if(usertype.equals("2")){
					user[i][5] = "End User";
				}else if(usertype.equals("3")){
					user[i][5] = "Super User";
				}
				rs1.next();
                            }}
		rs1.close();
		ps.close();
		con1.close();

	} catch (Exception ex) {
	}
return user;

}

    	public String[][] getBlockuser() {
            DBConnect dbcon = new DBConnect();
            String user[][]=null;
		Connection con1 = dbcon.getConnect();
		try {
			PreparedStatement ps;
			ResultSet rs1 = null;
			//select plant, userid ,block  from user_master where userid<>'admin'
			ps = con1.prepareStatement("select t1.plant,t2.plantdesc,t1.userid,t1.username,t1.block from user_master as t1,plant as t2 where t1.plant=t2.plant and t1.userid<>'admin'");
			rs1 = ps.executeQuery();

//			while (rs1.next()) {
//				System.out.print(rs1.getString("plant")+"\t");
//                                System.out.print(rs1.getString("userid")+"\t");
//                                System.out.println(rs1.getString("password"));
//			}
                        rs1.last();
			int w = rs1.getRow();
			user = new String[w][5];
			rs1.beforeFirst();
			if (rs1.next()) {
				for (int i = 0; i < w; i++) {
					user[i][0] = rs1.getString("plant");
					user[i][1] = rs1.getString("plantdesc");
					user[i][2] = rs1.getString("userid");
					user[i][3] = rs1.getString("username");
					user[i][4] = rs1.getString("block");

					rs1.next();
                                }}
			rs1.close();
			ps.close();
			con1.close();

		} catch (Exception ex) {
		}
return user;

	}
        public boolean updateuser(String[][] user)
        {

        	 for (int i = 0; i < user.length; i++) {
        		 System.out.println(user[i][2]);
        	 }
              DBConnect dbcon = new DBConnect();

		Connection con1 = dbcon.getConnect();
		try {
			PreparedStatement ps;

			ps = con1.prepareStatement("update user_master set block=? where plant=? and userid=?");
                       for (int i = 0; i < user.length; i++) {
                           ps.setString(1, user[i][4]);
                          ps.setString(2, user[i][0]);
                          ps.setString(3, user[i][2]);
                        ps.addBatch();
                    }
                        int id[]= ps.executeBatch();
                        System.out.println(ps.toString());
//
			ps.close();
			con1.close();
                        return true;

		} catch (Exception ex) {
                    return false;
		}
        }


    public boolean updateuserpwd(String[][] user){



    	DBConnect dbcon = new DBConnect();
    	String pwd=Wincode.encode("1234").trim();
	Connection con2 = dbcon.getConnect();
	try {
		PreparedStatement ps1;
		ps1 = con2.prepareStatement("update user_master set password=? where plant=? and userid=?");
		System.out.println(user.length);
		for (int i = 0; i < user.length; i++) {
			if(user[i][4].equals("X")){


			ps1.setString(1,pwd );
              ps1.setString(2, user[i][0]);
              ps1.setString(3, user[i][2]);
              ps1.executeUpdate();
              System.out.println(ps1.toString());
              //ps1.addBatch();
			}
		}

              // ps1.executeBatch();
                 //  System.out.println(ps1.toString());
		ps1.close();
		con2.close();
                    return true;

	} catch (Exception ex) {
                return false;
	}
    }







    public static void main(String[] args)
        {
            User u =new User();
            //DBConnect dbcon=new DBConnect();
           String result[][]= u.getErrorDelivery("1016");

           for(int i=0;i<result.length;i++){
       		for(int j=0;j<result[i].length;j++){
       			if(j==(result[i].length-1)){
       				System.out.print(result[i][j]);
       			}else{
       				System.out.print(result[i][j]+"|");
       			}
       		}
       		System.out.print("^");
       	}

        }
}