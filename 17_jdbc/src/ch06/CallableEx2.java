package ch06;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableEx2 {
	public static void main(String[] args) throws Exception{

		//1.드라이버로딩, 2.연결객체 생성하여 연결맺기
		Class.forName("oracle.jdbc.OracleDriver");
		
		//2.연결 객체 생성
    	String url ="jdbc:oracle:thin:@db202110231136_high?TNS_ADMIN=/Users/alpha/oracle/Wallet_DB202110231136";
	    String userid="madang";
	    String pwd ="Scott12345678";
	    Connection con = DriverManager.getConnection(url,userid,pwd);
	    
	    //3.Callable객체 생성
	    String sql = "{call bookInsertOrUpdate(?,?,?,?)}";
	    CallableStatement cstmt = con.prepareCall(sql);
	    //입력파라미터 설정
	    cstmt.setInt(1, 31);
	    cstmt.setString(2, "야구가 좋냐?");
	    cstmt.setString(3, "야구좋아출판사");
	    cstmt.setInt(4, 30000);
	    
	    //4.실행
	    cstmt.executeUpdate();
	    
	    //5.자원해제
	    cstmt.close(); con.close();
	    
	    
	    
	    
	}

}
