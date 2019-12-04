import java.sql.*;
import java.util.ArrayList;



public class OwnerTable {
	
	private ArrayList <String> owner=new ArrayList <String>();
	public ArrayList <String> encOwner=new ArrayList <String>();
	PreparedStatement psmt_owner=null;
	
	ResultSet rs_owner=null;
	

	Connection con=null;

	
	OwnerTable() throws ClassNotFoundException, SQLException
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
		public void queryOwner() throws Exception
		{
			String sql="select id from owner";
			
			
			psmt_owner=con.prepareStatement(sql);
			System.out.println("step3");

		
			rs_owner=psmt_owner.executeQuery();	
			System.out.println("step6 execute");
			//处理结果
			
			
			while(rs_owner.next())
			{
				
				owner.add(rs_owner.getString("id"));
				encOwner.add(PSITest.shaEncode(rs_owner.getString("id")));				
				
		}
		}
		
		public void deleteOwner(int i) throws SQLException
		{
			String sql="delete from owner where id=?";
			
			
			psmt_owner=con.prepareStatement(sql);
			System.out.println("step3");
			psmt_owner.setString(1,owner.get(i) );
		
			psmt_owner.executeUpdate();	
			System.out.println("step6 execute");
			
		}
		
}
