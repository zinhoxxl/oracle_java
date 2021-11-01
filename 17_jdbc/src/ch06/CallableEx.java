package ch06;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableEx {
	public static void main(String[] args) throws Exception{

		//1.����̹��ε�, 2.���ᰴü �����Ͽ� ����α�
		Class.forName("oracle.jdbc.OracleDriver");
		
		//2.���� ��ü ����
    	String url ="jdbc:oracle:thin:@db202110231136_high?TNS_ADMIN=/Users/alpha/oracle/Wallet_DB202110231136";
	    String userid="madang";
	    String pwd ="Scott12345678";
	    Connection con = DriverManager.getConnection(url,userid,pwd);
	    
	    //3.Callable��ü ����
	    String sql = "{call AveragePrice(?)}";
	    CallableStatement cstmt = con.prepareCall(sql);
	    //registerOutPutParameter()
	    cstmt.registerOutParameter(1, java.sql.Types.VARCHAR);
		
	    //4.����
	    cstmt.executeUpdate();
	    System.out.println("���:"+cstmt.getInt(1));
	    
	    //5.�ڿ�����
	    cstmt.close(); con.close();
	}

}
