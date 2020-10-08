package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static Connection getConnection() { // get 호출하면 Connection
        Connection conn = null;
        try {
            String user = "hr"; //db 사용자계정 
            String pw = "hr";
            String url = "jdbc:oracle:thin:@localhost:1521:xe"; //웹접속 주소명 
            
            Class.forName("oracle.jdbc.driver.OracleDriver");   //oracledriver 오라클에서 제공해줌 데이터베이스와 자바 연결해서 사용가능한 driver     
            conn = DriverManager.getConnection(url, user, pw);	
            
            System.out.println("Database에 연결되었습니다.\n"); 
            
        } catch (ClassNotFoundException cnfe) { //예외처리. oracle.jdbc.driver.OracleDriver 해당되는 위치에 가서 접근할때 파일이없으면 예외발생으로 error 출력  
            System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
        } catch (SQLException sqle) {
            System.out.println("DB 접속실패 : "+sqle.toString());
        } catch (Exception e) {
            System.out.println("Unkonwn error");
            e.printStackTrace();
        }
        return conn;     
    }
}
