package ch03_excute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExecuteTest_02 {
	public static void main(String[] args) {

		try {
			//1.드라이버 로딩
	    	Class.forName("oracle.jdbc.OracleDriver");
		    //2.연결 객체 생성
	    	String url ="jdbc:oracle:thin:@db202110231136_high?TNS_ADMIN=/Users/alpha/oracle/Wallet_DB202110231136";
		    String userid="madang";
		    String pwd ="Scott12345678";
		    Connection con = DriverManager.getConnection(url,userid,pwd);
		    
			 //3-1.sql문 전송객체 생성
			 Statement stmt = con.createStatement();
			 //4.sql문 실행
			 String sql = "insert into customer values((select max(custid)+1 from customer),'홍길이',null,null)";
			 
			 //5.결과 처리
			 boolean isResult = stmt.execute(sql);
			 System.out.println("isResult:"+isResult);
			 if(isResult) {
				 ResultSet rs = stmt.getResultSet();
				 while(rs.next()) {
					 System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3));
				 }
			 }else {
				 int resultCount = stmt.getUpdateCount();
				 System.out.println("처리행의 수:"+resultCount);
			 }
			 //6.자원해제
			 stmt.close();   con.close();
		}catch(Exception e) {
		}
	}
}
