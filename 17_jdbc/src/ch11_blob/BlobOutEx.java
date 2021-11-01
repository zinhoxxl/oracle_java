package ch11_blob;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BlobOutEx {
	public static void main(String[] args) {

		try {
			//1.����̹��ε�, 2.���ᰴü �����Ͽ� ����α�
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2.���� ��ü ����
	    	String url ="jdbc:oracle:thin:@db202110231136_high?TNS_ADMIN=/Users/alpha/oracle/Wallet_DB202110231136";
		    String userid="madang";
		    String pwd ="Scott12345678";
		    Connection con = DriverManager.getConnection(url,userid,pwd);
			
		
		    File file = new File("/Users/alpha/Downloads/myphoto.png");
		    FileOutputStream fos = null;
		    
		    //3.sql�� ���۰�ü ���� = template ���İ�ü
		    String sql =  "select image from photo where id=?";
		    PreparedStatement pstmt = con.prepareStatement(sql); //����� sql���� �Ű������� �޾Ƽ� ����
		    pstmt.setString(1, "myphoto1.png");
		    
		    
		    //5.�Է� ����
		    ResultSet rs = pstmt.executeQuery();
		    if(rs.next()) {
		    	Blob blob = rs.getBlob(1);
		    	InputStream is = blob.getBinaryStream(); //���̳ʸ������� �Է� ��Ʈ�� ����
		    	byte[] bt = new byte[8*1024]; //buffer
		    	int len = 0;
		    	fos = new FileOutputStream(file); //������ ��� ���ϸ����� �ƿ���Ʈ�� ����
		    	
		    	while((len=is.read(bt))!=-1) {
		    		fos.write(bt,0,len);
		    	}
		    	is.close(); fos.close();
		    	System.out.println("��ȸ ����");
		    }else {
		    	System.out.println("������ ����");
		    }
		    rs.close();
		    pstmt.close();
		    con.close();
		    
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		
		
	}

}
