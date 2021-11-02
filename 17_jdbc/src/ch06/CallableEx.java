package ch06;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableEx {
	public static void main(String[] args) throws Exception{

		//1.드라이버로딩
		Class.forName("oracle.jdbc.OracleDriver");
		
		//2.연결 객체 생성
    	String url ="jdbc:oracle:thin:@db202110231136_high?TNS_ADMIN=/Users/alpha/oracle/Wallet_DB202110231136";
	    String userid="madang";
	    String pwd ="Scott12345678";
	    Connection con = DriverManager.getConnection(url,userid,pwd);
	    
		 //3.callable객체 생성
		 String sql="{call AVERAGEPRICEBYID(?)}";
		 CallableStatement cstmt = con.prepareCall(sql);
		 //registerOutputParameter()--프로시져의 매개변수가 출력용(out 모드)인 경우 
		 cstmt.registerOutParameter(1, java.sql.Types.NUMERIC);
		 cstmt.setInt(1, 1);
		 
		 //4.실행
		 cstmt.executeUpdate();
		 System.out.println("평균:"+cstmt.getInt(1));
		 
       //5.자원해제
		 cstmt.close(); con.close();
	}
}

