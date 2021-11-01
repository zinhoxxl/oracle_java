package ch03_excute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExecuteTest_01 {
	public static void main(String[] args) {

		try {
			//1.����̹� �ε�
	    	Class.forName("oracle.jdbc.OracleDriver");
		    //2.���� ��ü ����
	    	String url ="jdbc:oracle:thin:@db202110231136_high?TNS_ADMIN=/Users/alpha/oracle/Wallet_DB202110231136";
		    String userid="madang";
		    String pwd ="Scott12345678";
		    Connection con = DriverManager.getConnection(url,userid,pwd);
		    
		    //3-1.sql�� ���� ��ü ����
		    Statement stmt = con.createStatement();
		    //3-2. db�ݿ� ���� ó��
		    con.setAutoCommit(false); //default�� true, -> false�� ó�� �ϸ� ���� commit ��.
		    
		    //4.sql�� ����
		    String sql = "select * from customer";
		   
		    
		    //5.db�ݿ� ó��
		    boolean isResult = stmt.execute(sql);
		    System.out.println("isResult:"+isResult);
		    if(isResult) {
		    	ResultSet rs = stmt.getResultSet();
		        while(rs.next()) {
		        	System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3));
		        }
		        
		    }else {
		    	int resultCount = stmt.getUpdateCount();
		    	System.out.println("ó�� ���� ��:"+resultCount);
		    }
		    
		    //6.�ڿ� ����
		    stmt.close(); con.close();
			
		}catch (Exception e) {
			
		}
		
		
	}

}
