package ch01_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionTest_03 {
	public static void main(String[] args) {
		
		try {
			//1.�������̹� �ε�
			Class.forName("oracle.jdbc.OracleDriver");
			//2.�ε��� ����̹��κ��� ���ᰴü ����
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@db202110231136_high?TNS_ADMIN=/Users/alpha/oracle/Wallet_DB202110231136", 
							                "madang", "Scott12345678");
			if(con!=null) {
				System.out.println("���Ἲ��");
			}else {
				System.out.println("�������");
			}
			//3. ������ ���ް�ü ����
			Statement stmt = con.createStatement();
			//4. ������ �ۼ�
			StringBuffer sb = new StringBuffer();
			sb.append("select bookid, bookname, publisher, price from book order by bookid");
			
			//5. ��ȸ ��ü ���� �� ��� �ޱ�
			ResultSet rs = stmt.executeQuery(sb+"");
			while(rs.next()) {
				int bookid = rs.getInt(1);//getInt(Į������)
				String bookname = rs.getString(2);//getString(Į������)
				String publisher = rs.getString(3);
				int price = rs.getInt(4);
				System.out.println(bookid+"\t|"+bookname+"\t|"+publisher+"\t|"+price);
			}
			//6.�ڿ� ���� 
			rs.close();
			stmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
