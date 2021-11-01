package ch03_excute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExecuteTest_01 {
	public static void main(String[] args) {

		try {
			//1.드라이버 로딩
	    	Class.forName("oracle.jdbc.OracleDriver");
		    //2.연결 객체 생성
	    	String url ="jdbc:oracle:thin:@db202110231136_high?TNS_ADMIN=/Users/alpha/oracle/Wallet_DB202110231136";
		    String userid="madang";
		    String pwd ="Scott12345678";
		    Connection con = DriverManager.getConnection(url,userid,pwd);
		    
		    //3-1.sql문 전송 객체 생성
		    Statement stmt = con.createStatement();
		    //3-2. db반영 수동 처리
		    con.setAutoCommit(false); //default는 true, -> false로 처리 하면 수동 commit 됨.
		    
		    //4.sql문 실행
		    String sql = "select * from customer";
		   
		    
		    //5.db반영 처리
		    boolean isResult = stmt.execute(sql);
		    System.out.println("isResult:"+isResult);
		    if(isResult) {
		    	ResultSet rs = stmt.getResultSet();
		        while(rs.next()) {
		        	System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3));
		        }
		        
		    }else {
		    	int resultCount = stmt.getUpdateCount();
		    	System.out.println("처리 행의 수:"+resultCount);
		    }
		    
		    //6.자원 해제
		    stmt.close(); con.close();
			
		}catch (Exception e) {
			
		}
		
		
	}

}
