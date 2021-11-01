package ch01_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionTest_03 {
	public static void main(String[] args) {
		
		try {
			//1.연결드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			//2.로딩된 드라이버로부터 연결객체 생성
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@db202110231136_high?TNS_ADMIN=/Users/alpha/oracle/Wallet_DB202110231136", 
							                "madang", "Scott12345678");
			if(con!=null) {
				System.out.println("연결성공");
			}else {
				System.out.println("연결실패");
			}
			//3. 쿼리문 전달객체 생성
			Statement stmt = con.createStatement();
			//4. 쿼리문 작성
			StringBuffer sb = new StringBuffer();
			sb.append("select bookid, bookname, publisher, price from book order by bookid");
			
			//5. 조회 객체 전달 및 결과 받기
			ResultSet rs = stmt.executeQuery(sb+"");
			while(rs.next()) {
				int bookid = rs.getInt(1);//getInt(칼럼순서)
				String bookname = rs.getString(2);//getString(칼럼순서)
				String publisher = rs.getString(3);
				int price = rs.getInt(4);
				System.out.println(bookid+"\t|"+bookname+"\t|"+publisher+"\t|"+price);
			}
			//6.자원 해제 
			rs.close();
			stmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
