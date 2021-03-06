package ch05_PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementEx4_Update {
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
		    //String sql = "insert into book values(?,?,?,?)";
		    String sql = "update book set bookname=?, publisher=? where bookid=?";
		    PreparedStatement pstmt	= con.prepareStatement(sql); //생성시 sql문을 매개변수로 받아서 생
		    //sql문 전달시 10이 바인딩되어서 완전한 쿼리문으로 전달
		    pstmt.setString(1, "축구가 좋을껄?");
		    pstmt.setString(2, "Korea2출판사");
		    pstmt.setInt(3, 30);
		    
			//4.실행
		    int resultCount = pstmt.executeUpdate(); //실행시는 sql문을 매개변수로 받지 않고 실행
		    if(resultCount>0) System.out.println("수정 성공");
		    else System.out.println("수정 실패");
		    
		}catch(Exception e) {
			
		}
		
	}

}
/*
 * 트리거 기능 정지/기동처
 *alter trigger AfterUpdateBook disable;
  alter trigger AfterUpdateBook enable; 
 * */


