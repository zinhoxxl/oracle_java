package ch02_update;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//DBMS연결객체 싱글톤으로 만들기
public class DaoConnector {
  //1.static접근자의 자신타입의 필드 선언
  private static  DaoConnector instance = new DaoConnector();
  
  //2.기본생성자를 private 
  private DaoConnector(){}
 
  //3.public메소로 자신타입의 필드를 리턴받도록 선언
  public static DaoConnector getInstance() {
	return instance;
  }
  
  //4.연결객체 생성 메소드
  public static Connection getConnection() throws Exception {
		final String driver ="oracle.jdbc.OracleDriver";
		final String url ="jdbc:oracle:thin:@db202110231136_high?TNS_ADMIN=/Users/alpha/oracle/Wallet_DB202110231136";
		final String userid="madang";
		final String pwd ="Scott12345678";
	    Class.forName(driver);
        Connection conn = DriverManager.getConnection(url,userid,pwd);	
     return conn;  
  }
  
  
  
}
