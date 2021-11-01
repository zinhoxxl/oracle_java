package ch01_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectionTest_09 {
	public static void main(String[] args) {
		final String driver ="oracle.jdbc.OracleDriver";
		final String url ="jdbc:oracle:thin:@db202110231136_high?TNS_ADMIN=/Users/alpha/oracle/Wallet_DB202110231136";
		final String userid="madang";
		final String pwd ="Scott12345678";
	 try {
		 //1.����̹� �ε�
		 Class.forName(driver);
		 //2.���ᰴü ����
		 Connection con = DriverManager.getConnection(url,userid,pwd);
		 //3.������ü ����
		 Statement stmt = con.createStatement();
		 //4.������ �ۼ�
		 //��ȸ ������ ���ڿ��� ���� ���ڿ� ǥ�� ''�� ��� where ���� ������ ���
		 //��ĳ�ʷ� ���� �Է¹޾ ��ȸ
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("��ȸ�� å ������ �Է��ϼ���>");
		 String title = scanner.next();
		 //title�� sql�� �����ؼ� �Ʒ��� ���� ����� ��� 
		String sql ="select bookname,publisher from book where bookname like '%'||'"+title+"'||'%'";//<--���ӹ� �ۼ�
		
		 System.out.println("������:"+sql);

		 //5.������ ���� �� ��� �ޱ�
		 ResultSet rs = stmt.executeQuery(sql);
		 //6.����۾�
		 System.out.println("bookid| bookname| publisher|price");
		 System.out.println("---------------------------------");
		 //�Ѱ� �� ��� �ѹ��� rs.next() ȣ��
		 while(rs.next()) {
			 String bookname = rs.getString(1);
			 String publisher = rs.getString(2);
			
			 System.out.println(bookname+"\t|"+publisher);
		 }
		 //7.�ڿ�����
		 rs.close();    stmt.close();   con.close();
	 }catch(Exception e) {
		 e.printStackTrace();
	 }

	}
}
