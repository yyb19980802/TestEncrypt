import java.sql.*;
import java.util.ArrayList;



public class UserTable {
	
	private ArrayList <String> user=new ArrayList <String>();
	public ArrayList <String> encUser=new ArrayList <String>();
	PreparedStatement psmt_user=null;
	
	ResultSet rs_user=null;
	

	Connection con=null;

	
	UserTable() throws ClassNotFoundException, SQLException
	{

		String url="jdbc:mysql://cdb-40zeyzqc.bj.tencentcdb.com:10245/enctest";
		String user="root";
		String password="yangyunbo123";
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("step1");
			//创建连接
			con=DriverManager.getConnection(url, user, password);
			System.out.println("step2");
		
	}

		//创建执行语句
		public void queryUser() throws Exception
		{
			String sql="select id from users";
			
			
			psmt_user=con.prepareStatement(sql);
			System.out.println("step3");

		
			rs_user=psmt_user.executeQuery();	
			System.out.println("step6 execute");
			//处理结果
			
			
			while(rs_user.next())
			{
				
				user.add(rs_user.getString("id"));
				encUser.add(PSITest.shaEncode(rs_user.getString("id")));				
				
		}
		}
		
		
	
	
	
}
