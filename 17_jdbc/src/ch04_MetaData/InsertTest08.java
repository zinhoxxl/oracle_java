package ch04_MetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class InsertTest08 {
	public static void main(String[] args) throws Exception{
		//�Է�(transaction)ó��
		//1.����̹��ε�, 2.���ᰴü �����Ͽ� ����α�
		Class.forName("oracle.jdbc.OracleDriver");
		//2.���� ��ü ����
    	String url ="jdbc:oracle:thin:@db202110231136_high?TNS_ADMIN=/Users/alpha/oracle/Wallet_DB202110231136";
	    String userid="madang";
	    String pwd ="Scott12345678";
	    Connection con = DriverManager.getConnection(url,userid,pwd);
		//3.sql�� ���۰�ü ����
		  Statement stmt = con.createStatement();
		//4.���� ���� �� ��� ó��
		  String sql="select * from customer order by custid"; 
		  System.out.println("sql:"+sql);
		  ResultSet rs = stmt.executeQuery(sql);
		  //���set�� ��Ÿ ���� ���
		  ResultSetMetaData rsmd = rs.getMetaData();
		  System.out.println("������� Į����:"+rsmd.getColumnCount());//
		  System.out.println("������� ù��° �ε����� �ش��ϴ� Į����:"+rsmd.getColumnClassName(1));//
		  System.out.println("������� ù��° �ε����� �ش��ϴ� Į���� ������ Ÿ��:"+rsmd.getColumnTypeName(1));//
		  
		  while(rs.next()) {
			  System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4));
		  }
		  
		//5.�ڿ�����-������ ��ü �� �������� ����
		  rs.close(); stmt.close(); con.close();
	}
}