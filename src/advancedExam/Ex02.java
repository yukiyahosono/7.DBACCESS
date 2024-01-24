package advancedExam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex02 {
    // public static void main(String[] args) {
    //      String url = "jdbc:postgresql://localhost:5432/student";
    //     String user = "postgres";
    //     String password = "postgres";

    //     Connection con = null;
    //     PreparedStatement pstmt = null;
    //     String sql = null;

    //     try{
    //         con = DriverManager.getConnection(url, user, password);
    //         sql = "INSERT INTO colors (id,name) VALUES (1,'blue'),(2,'red'),(3,'green'),(4,'yellow'),(5,'purple'),(6,'orange');";
    //         pstmt = con.prepareStatement(sql);
    //         int numOfUpdate = pstmt.executeUpdate();
    //         System.out.println(numOfUpdate + "件のデータを操作しました。");
    //     }catch(SQLException ex){
    //         System.err.println("SQL = " + sql);
    //         ex.printStackTrace();
    //     }finally{
    //         try{
    //             if(con != null){
    //                 con.close();
    //             }
    //             if(pstmt != null){
    //                 pstmt.close();
    //             }
    //         }catch(SQLException e){
    //             e.printStackTrace();
    //         }
    //     }
    // }

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String password = "postgres";
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = null;

        try{
            con = DriverManager.getConnection(url, user, password);
            BEGIN;
            sql = "INSERT INTO members(name,birth_day,gender,color_id) values('大野智','1980-11-26','男',1),('櫻井翔','1982-1-25','男',2),('相葉雅紀','1982-12-24','男',3),('二宮和也','1983-6-17','男',4),('松本潤','1983-8-30','男',5)";
            pstmt = con.prepareStatement(sql);
            int numOfUpdate = pstmt.executeUpdate();
            System.out.println(numOfUpdate+"件のデータを操作しました");
            COMMIT;
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
