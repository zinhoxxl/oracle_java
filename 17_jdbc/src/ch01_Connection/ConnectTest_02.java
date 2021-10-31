package ch01_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * ����Ŭ ���� �׽�Ʈ
 * */
public class ConnectTest_02 {
	public static void main(String[] args) {
       String url ="jdbc:oracle:thin:@db202110231136_high?TNS_ADMIN=/Users/alpha/oracle/Wallet_DB202110231136";
       String userid="madang";
       String pwd ="Scott12345678";
     
       //����̹� �ε�
       try {
    	    //oracle DB���� ����̹� �ε�
    	    Class.forName("oracle.jdbc.OracleDriver");//
    	    System.out.println("����̹� �ε� ����");
       }catch(Exception e) {
    	    e.printStackTrace();
       }
       
       //DBMS�� ����
       try {
    	       System.out.println("�����ͺ��̽� ���� �غ�......");
    	       Connection con =DriverManager.getConnection(url, userid, pwd);
    	       if(con!=null) {
    	    	   System.out.println("�����ͺ��̽� ���� ����...");
    	       }
    	  //������ü ����
    	   Statement stmt = null;
    	   ResultSet rs=null;
    	   //db���������� ������ü ����
    	   stmt = con.createStatement();
    	   //������ ������
    	   String sql ="select bookid, bookname, publisher, price from book order by bookid";
    	   //DBMS�� ������ ���� �� ��� �ޱ�
    	   rs = stmt.executeQuery(sql);
    	   //����� �Ѿ�� ResultSet�� �� �྿ �����Ͽ� ó���ϱ�
    	   while(rs.next()) {
    		    int bookid =rs.getInt("bookid"); // getInt(Į����)
    		    String bookname=rs.getString("bookname");//getString(Į����)
    		    String publisher=rs.getString("publisher");
    		    int price =rs.getInt("price");
    		    System.out.println(bookid+"|"+bookname+"|"+publisher+"|"+price); 
    	   }
    	   //�ڿ�����
    	   con.close();
       }catch(Exception e) {
    	   e.printStackTrace();
       }
	}
}
