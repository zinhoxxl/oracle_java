package ch06;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableEx {
	public static void main(String[] args) throws Exception{

		//1.����̹��ε�
		Class.forName("oracle.jdbc.OracleDriver");
		
		//2.���� ��ü ����
    	String url ="jdbc:oracle:thin:@db202110231136_high?TNS_ADMIN=/Users/alpha/oracle/Wallet_DB202110231136";
	    String userid="madang";
	    String pwd ="Scott12345678";
	    Connection con = DriverManager.getConnection(url,userid,pwd);
	    
		 //3.callable��ü ����
		 String sql="{call AVERAGEPRICEBYID(?)}";
		 CallableStatement cstmt = con.prepareCall(sql);
		 //registerOutputParameter()--���ν����� �Ű������� ��¿�(out ���)�� ��� 
		 cstmt.registerOutParameter(1, java.sql.Types.NUMERIC);
		 cstmt.setInt(1, 1);
		 
		 //4.����
		 cstmt.executeUpdate();
		 System.out.println("���:"+cstmt.getInt(1));
		 
       //5.�ڿ�����
		 cstmt.close(); con.close();
	}
}

