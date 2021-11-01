package ch05_PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementEx2 {
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
		    String sql = "select * from customer where name like ? and address like ?";
		    PreparedStatement pstmt	= con.prepareStatement(sql); //������ sql���� �Ű������� �޾Ƽ� ��
		    //sql�� ���޽� 10�� ���ε��Ǿ ������ ���������� ����
		    pstmt.setString(1, "������");
		    pstmt.setString(2, "�����");
		    
			//4.����
		    ResultSet rs = pstmt.executeQuery(); //����ô� sql���� �Ű������� ���� �ʰ� ����
			rs.next();
			System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+rs.getString(4));
			
		}catch(Exception e) {
			
		}
		
	}

}