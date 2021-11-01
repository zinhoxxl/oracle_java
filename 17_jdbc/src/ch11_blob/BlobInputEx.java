package ch11_blob;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BlobInputEx {
	public static void main(String[] args) {

		try {
		//1.����̹��ε�, 2.���ᰴü �����Ͽ� ����α�
		Class.forName("oracle.jdbc.OracleDriver");
		
		//2.���� ��ü ����
    	String url ="jdbc:oracle:thin:@db202110231136_high?TNS_ADMIN=/Users/alpha/oracle/Wallet_DB202110231136";
	    String userid="madang";
	    String pwd ="Scott12345678";
	    Connection con = DriverManager.getConnection(url,userid,pwd);
		
		//3.File�Է� ��Ʈ�� ����
	    File file = new File("/Users/alpha/Downloads/myphoto1.png");
	    int len = (int)file.length(); //���ϻ�����
	    InputStream is = new FileInputStream(file);
	    
	    //4.sql��
	    String sql = "insert into photo values (?,?)";
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    pstmt.setString(1, "myphoto1.png");
	    pstmt.setBinaryStream(2, is, len); //setBinaryStream (index,input��Ʈ��,���ϱ���);
	    
	    //5.�Է� ����
	    int result = pstmt.executeUpdate();
	    if(result>0) System.out.println("�Է� ����");
	    
	    //6.�ڿ� ����
	    pstmt.close(); con.close();
	    
	    
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
