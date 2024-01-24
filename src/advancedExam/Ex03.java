package advancedExam;

import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex03 {
    public static void main(String[] args) {
            String url = "jdbc:postgresql://localhost:5432/student";
            String user = "postgres";
            String password = "postgres";
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            String sql = null;
    
            try{
                con = DriverManager.getConnection(url, user, password);
                sql = "SELECT m.name as name,m.birth_day as birth_day,m.gender as gender,c.name as color_name from members m inner join colors c on m.color_id = c.id order by m.id asc";
                pstmt = con.prepareStatement(sql);
                rs = pstmt.executeQuery();
                while(rs.next()){
                    String name = rs.getString("name");
                    String birth_day = rs.getString("birth_day");
                    String gender = rs.getString("gender");
                    String color = rs.getString("name");
                    System.out.print(name);
                    System.out.print(birth_day);
                    System.out.print(gender);
                    System.out.print(color);
                    System.out.println();
                }
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
