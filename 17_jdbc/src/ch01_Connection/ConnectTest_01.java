package ch01_Connection;

import java.sql.Connection;

import java.sql.DriverManager;

/*
 * ����Ŭ ���� �׽�Ʈ
 * */
public class ConnectTest_01 {
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
       }catch(Exception e) {
    	   e.printStackTrace();
       }
	}
}
