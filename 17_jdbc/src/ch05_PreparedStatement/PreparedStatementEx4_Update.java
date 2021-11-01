package ch05_PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementEx4_Update {
	public static void main(String[] args) {
        
		try {
			//1.����̹��ε�, 2.���ᰴü �����Ͽ� ����α�
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2.���� ��ü ����
	    	String url ="jdbc:oracle:thin:@db202110231136_high?TNS_ADMIN=/Users/alpha/oracle/Wallet_DB202110231136";
		    String userid="madang";
		    String pwd ="Scott12345678";
		    Connection con = DriverManager.getConnection(url,userid,pwd);
		    
		    //3.sql�� ���۰�ü ���� - template���İ�ü
		    //String sql = "insert into book values(?,?,?,?)";
		    String sql = "update book set bookname=?, publisher=? where bookid=?";
		    PreparedStatement pstmt	= con.prepareStatement(sql); //������ sql���� �Ű������� �޾Ƽ� ��
		    //sql�� ���޽� 10�� ���ε��Ǿ ������ ���������� ����
		    pstmt.setString(1, "�౸�� ������?");
		    pstmt.setString(2, "Korea2���ǻ�");
		    pstmt.setInt(3, 30);
		    
			//4.����
		    int resultCount = pstmt.executeUpdate(); //����ô� sql���� �Ű������� ���� �ʰ� ����
		    if(resultCount>0) System.out.println("���� ����");
		    else System.out.println("���� ����");
		    
		}catch(Exception e) {
			
		}
		
	}

}
/*
 * Ʈ���� ��� ����/�⵿ó
 *alter trigger AfterUpdateBook disable;
  alter trigger AfterUpdateBook enable; 
 * */


