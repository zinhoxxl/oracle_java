package ch10_jdbc30;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

//jdbc 3.0�� resultSet ���
public class JDBCRowSetEx {
	public static void main(String[] args) {

		try {
			RowSetFactory rowSetFactory = RowSetProvider.newFactory();
			CachedRowSet jdbcRs = rowSetFactory.createCachedRowSet();
			jdbcRs.setUrl("jdbc:oracle:thin:@db202110231136_high?TNS_ADMIN=/Users/alpha/oracle/Wallet_DB202110231136");
			jdbcRs.setUsername("madang");
			jdbcRs.setPassword("Scott12345678");
			jdbcRs.setCommand("select * from customer order by custid");
			jdbcRs.execute();
			
			while(jdbcRs.next()) {
			System.out.println(jdbcRs.getInt(1)+","+jdbcRs.getString(2)+","+jdbcRs.getString(3)+","+jdbcRs.getString(4));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
