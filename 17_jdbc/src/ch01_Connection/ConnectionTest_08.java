package ch01_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionTest_08 {
	public static void main(String[] args) {
		final String driver ="oracle.jdbc.OracleDriver";
		final String url ="jdbc:oracle:thin:@jdbc:oracle:thin:@db202110231136_high?"
			            	+ " TNS_ADMIN=/Users/alpha/oracle/Wallet_DB202110231136";
		final String userid="madang";
		final String pwd ="Scott12345678";
	 try {
		 //1.드라이버 로딩
		 Class.forName(driver);
		 //2.연결객체 생성
		 Connection con = DriverManager.getConnection(url,userid,pwd);
		 //3.쿼리객체 생성
		 Statement stmt = con.createStatement();
		 //4.쿼리문 작성
		 //조회 조건이 문자열인 경우는 문자열 표시 ''로 묶어서 where 조건 값으로 사용
		 int minValue=10000;
		 int maxValue=20000;
		 //select * from book where price >=10000 and price<=20000;
		 
		 String sql ="select * from book where price >= "+ minValue+" and price<="+maxValue;//<--쿼ㅣ문 작성
		 System.out.println("쿼리문:"+sql);

		 //5.쿼리문 전송 및 결과 받기
		 ResultSet rs = stmt.executeQuery(sql);
		 //6.출력작업
		 System.out.println("bookid| bookname| publisher|price");
		 System.out.println("---------------------------------");
		 //한건 인 경우 한번만 rs.next() 호출
		 while(rs.next()) {
			 int bookid = rs.getInt(1);
			 String bookname = rs.getString(2);
			 String publisher = rs.getString(3);
			 int price =rs.getInt(4);
			 System.out.println(bookid+"\t|"+bookname+"\t|"+publisher+"\t|"+price);
		 }
		 //7.자원해제
		 rs.close();    stmt.close();   con.close();
	 }catch(Exception e) {
		 e.printStackTrace();
	 }

	}
}
