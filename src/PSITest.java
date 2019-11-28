import java.security.MessageDigest;
import java.sql.*;


public class PSITest {
    public static String shaEncode(String inStr) throws Exception {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
 
        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = sha.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
    
    
    
    
	public static void main(String []args) throws Exception
	{
	
		Connection con=null;
		PreparedStatement psmt_users=null;
		PreparedStatement psmt_owner=null;
		
		ResultSet rs_user=null;
		ResultSet rs_owner=null;
		
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
			String sql0="select id from ownerTable";
			
			System.out.println("step3");
			psmt_users=con.prepareStatement(sql);
			psmt_owner=con.prepareStatement(sql0);
		
			rs_user=psmt_users.executeQuery();	
			rs_owner=psmt_owner.executeQuery();
			System.out.println("step6 execute");
			//处理结果
			while(rs_owner.next())
			{
				System.out.println(rs_owner.getString("id"));
				System.out.println(shaEncode(rs_owner.getString("id")));
				System.out.println(" " );						
			}
			
			while(rs_user.next())
			{
				System.out.println(rs_user.getString("id"));
				System.out.println(shaEncode(rs_user.getString("id")));
				System.out.println(" " );						
			}
			

	}
			
		

}
