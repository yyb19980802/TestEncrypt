import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ownerTable {

	PreparedStatement psmt_owner=null;
	
	ResultSet rs=null;
	String url="jdbc:mysql://cdb-40zeyzqc.bj.tencentcdb.com:10245/enctest";
	String user="root";
	String password="yangyunbo123";
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("step1");
		//创建连接
		con=DriverManager.getConnection(url, user, password);
		System.out.println("step2");
		//创建执行语句
		
		String sql="select id from Users";
		
	
		psmt_users=con.prepareStatement(sql);
		System.out.println("step3");

	
		rs=psmt_users.executeQuery();	
		System.out.println("step6 execute");
		//处理结果
		
		
		while(rs.next())
		{
			
			
			System.out.println(rs.getString("id"));
			System.out.println(shaEncode(rs.getString("id")));
			System.out.println(" " );				
			
		}
	
	
	
}
