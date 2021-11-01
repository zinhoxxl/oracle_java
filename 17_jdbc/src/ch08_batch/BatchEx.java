package ch08_batch;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class BatchEx {
	public static void main(String[] args) {
		Connection con = null;
		try {
			// 입력(transaction)처리
			// 1.드라이버로딩, 2.연결객체 생성하여 연결맺기
			FileInputStream fis = new FileInputStream("/Users/driver/jdbc.properties");
			Properties pro = new Properties();
			//Properties값 읽어 들이기
			pro.load(fis);
			//Properties로 부터 해당키에 값을 추출  getProperty(키)
			String driver = pro.getProperty("driver");
			String url = pro.getProperty("url");
			String user = pro.getProperty("user");
			String pwd = pro.getProperty("password");
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			con.setAutoCommit(false);
			
			//3.sql문 전송객체 생성
			String sql = "insert into table_test values (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			for(int i=0;i<1000;i++) {
				int bookid = 34+i;
				String bookName = "book"+i;
				int price = 5000+(((int)Math.random()*1000)+1);
				
				pstmt.setInt(1, bookid);
				pstmt.setString(2, bookName);
				pstmt.setInt(3, price);
				
				//batch job
				pstmt.addBatch();
				
				//
				pstmt.clearParameters();
				
				if(i%100==0) {
					//100개 업무마다 batch잡 실행
					pstmt.executeBatch();
					//batch잡 초기화
					pstmt.clearBatch();
					//db반영처리
					con.commit();
				}
				//잔여처리
				pstmt.executeBatch();
				con.commit();
			}
		}catch(Exception e) {
			try {
			con.rollback();
			}catch(Exception e1) {
				e.printStackTrace();
			}
			e.printStackTrace();
		}
				
	}
	}
