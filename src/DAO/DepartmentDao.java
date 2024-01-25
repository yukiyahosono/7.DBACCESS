package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DepartmentDao {
    private static final String TABLE_NAME = "departments";

    public Department load(int id){
        Connection con = DBManager.createConnection();
        
        String sql = "SELECT id,name FROM " + TABLE_NAME + " WHERE id = ? ";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                Department department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                return department;
            }
            return null;
        } catch (Exception e) {
            System.out.println("SQL= "+sql);
            throw new RuntimeException("load処理に失敗しました");
        }finally{
            DBManager.closeConnection(con);
        }
    }

    
    public int insert (Department department){
        Connection con = DBManager.createConnection();
        String sql = "INSERT INTO " + TABLE_NAME + "(id,name)" + "VALUES(?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, department.getId());
            pstmt.setString(2, department.getName());
            int affected = pstmt.executeUpdate();
            return affected;

        } catch (Exception e) {
            System.err.println("SQL= "+ sql);
            throw new RuntimeException("inseert処理に失敗しました"+ e);
        }finally{
            DBManager.closeConnection(con);
        }
    }

    public int update(Department department){
        Connection con = DBManager.createConnection();
        String sql = " UPDATE " + TABLE_NAME + " SET name = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, department.getName());
            pstmt.setInt(2, department.getId());

            int affected = pstmt.executeUpdate();
            return affected;

        } catch (Exception e) {
            System.err.println("SQL= "+ sql);
            throw new RuntimeException("update処理に失敗しました"+ e);
        }finally{
            DBManager.closeConnection(con);
        }
    }

    public int deleteById(int id){
        Connection con = DBManager.createConnection();
        String sql = " DELETE FROM " + TABLE_NAME + " WHERE id = ? ";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            int affected = pstmt.executeUpdate();

            return affected;
        } catch (Exception e) {
            System.err.println("SQL= "+sql);
            throw new RuntimeException("delete処理に失敗しました",e);
        }finally{
            DBManager.closeConnection(con);
        }
    }

   
}


