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
	
		OwnerTable owner=new OwnerTable();
		UserTable user=new UserTable();
		user.queryUser();
		owner.queryOwner();
		
		for(int i=0;i<owner.encOwner.size();++i)
			for(int j=0;j<user.encUser.size();++j)
			{
				if(owner.encOwner.get(i).equals(user.encUser.get(j)))
				{
					owner.deleteOwner(i);
					break;
				}
			}
			

	}
			
		

}
