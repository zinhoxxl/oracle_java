package ch02_update;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//DBMS���ᰴü �̱������� �����
public class DaoConnector {
  //1.static�������� �ڽ�Ÿ���� �ʵ� ����
  private static  DaoConnector instance = new DaoConnector();
  
  //2.�⺻�����ڸ� private 
  private DaoConnector(){}
 
  //3.public�޼ҷ� �ڽ�Ÿ���� �ʵ带 ���Ϲ޵��� ����
  public static DaoConnector getInstance() {
	return instance;
  }
  
  //4.���ᰴü ���� �޼ҵ�
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
