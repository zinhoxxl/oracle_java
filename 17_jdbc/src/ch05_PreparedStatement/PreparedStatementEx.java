package ch05_PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PreparedStatementEx {
	public static void main(String[] args) {
        
		try {
			//1.드라이버로딩, 2.연결객체 생성하여 연결맺기
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2.연결 객체 생성
	    	String url ="jdbc:oracle:thin:@db202110231136_high?TNS_ADMIN=/Users/alpha/oracle/Wallet_DB202110231136";
		    String userid="madang";
		    String pwd ="Scott12345678";
		    Connection con = DriverManager.getConnection(url,userid,pwd);
		    
		    //3.sql문 전송객체 생성 - template형식객체
		    String sql = "select * from customer where custid=?";
		    PreparedStatement pstmt	= con.prepareStatement(sql); //생성시 sql문을 매개변수로 받아서 생성
		    //sql문 전달시 10이 바인딩되어서 완전한 쿼리문으로 전달
		    pstmt.setInt(1, 10);
			
			//4.실행
		    ResultSet rs = pstmt.executeQuery(); //실행시는 sql문을 매개변수로 받지 않고 실행
			rs.next();
			System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+rs.getString(4));
			
			//Statement stmt = pstmt;
			//stmt.close();
			
			 try {
				 closeResource(pstmt, rs, con);
			 }catch(Exception e) {}
			 
	  }catch(Exception e) {
		  
	  }
	}
	  static void closeResource(Statement stmt, ResultSet rs, Connection con) throws Exception{
		      stmt.close();
		      rs.close();
		      con.close();
	  }
	 
	}

