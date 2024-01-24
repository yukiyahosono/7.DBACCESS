package advancedExam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex04 {
    public static void main(String[] args) {
            String url = "jdbc:postgresql://localhost:5432/student";
            String user = "postgres";
            String password = "postgres";
            Connection con = null;
            PreparedStatement pstmt = null;
            String sql = null;
    
            try{
                con = DriverManager.getConnection(url, user, password);
                sql = "UPDATE members SET name = '細野征哉',birth_day = '1997-08-03',color_id=6 WHERE id = 1";
                pstmt = con.prepareStatement(sql);
                int numOfUpdate = pstmt.executeUpdate();
                System.out.println(numOfUpdate+"件のデータを操作しました");
            }catch(SQLException ex){
                System.err.println("SQL関連の例外が発生しました");
                System.err.println("発生したSQLは「"+sql+"」です");
                ex.printStackTrace();
            }finally{
                try{
                    if(con != null){
                        con.close();
                    }if (pstmt != null) {
                        pstmt.close();
                    }
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        
    }
}
