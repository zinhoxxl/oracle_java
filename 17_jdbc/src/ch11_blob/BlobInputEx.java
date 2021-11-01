package ch11_blob;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BlobInputEx {
	public static void main(String[] args) {

		try {
		//1.드라이버로딩, 2.연결객체 생성하여 연결맺기
		Class.forName("oracle.jdbc.OracleDriver");
		
		//2.연결 객체 생성
    	String url ="jdbc:oracle:thin:@db202110231136_high?TNS_ADMIN=/Users/alpha/oracle/Wallet_DB202110231136";
	    String userid="madang";
	    String pwd ="Scott12345678";
	    Connection con = DriverManager.getConnection(url,userid,pwd);
		
		//3.File입력 스트림 생성
	    File file = new File("/Users/alpha/Downloads/myphoto1.png");
	    int len = (int)file.length(); //파일사이즈
	    InputStream is = new FileInputStream(file);
	    
	    //4.sql문
	    String sql = "insert into photo values (?,?)";
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    pstmt.setString(1, "myphoto1.png");
	    pstmt.setBinaryStream(2, is, len); //setBinaryStream (index,input스트림,파일길이);
	    
	    //5.입력 실행
	    int result = pstmt.executeUpdate();
	    if(result>0) System.out.println("입력 성공");
	    
	    //6.자원 해제
	    pstmt.close(); con.close();
	    
	    
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
