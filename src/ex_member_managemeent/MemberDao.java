package ex_member_managemeent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.DBManager;

public class MemberDao {
    private static final String TABLE_NAME = "members";

    public Member load(int id){
       Connection con = DBManager.createConnection();
        
        String sql = "SELECT id,name,birth_day,gender,color_id FROM " + TABLE_NAME + " WHERE id = ? ";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                Member member = new Member();
                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));                
                member.setBirthDay(rs.getDate("birth_day").toLocalDate());
                member.setGender(rs.getString("gender"));
                member.setColorId(rs.getInt("color_id"));
                return member;
            }
            return null;
        } catch (Exception e) {
            System.out.println("SQL= "+sql);
            throw new RuntimeException("load処理に失敗しました");
        }finally{
            DBManager.closeConnection(con);
        }
    }

        public List <Member> findByName(String name){
        Connection con = DBManager.createConnection();
        String sql = "SELECT name FROM " + TABLE_NAME + " WHERE name LIKE ? ";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "%"+name+"%");
            ResultSet rs = pstmt.executeQuery();

            List<Member>memberList = new ArrayList<>();

            while(rs.next()){
                Member member = new Member();
                member.setName(rs.getString("name"));
                memberList.add(member);
            }
            return memberList;
        } catch (Exception e) {
            System.err.println("SQL = "+sql);
            throw new RuntimeException("検索処理に失敗しました",e);
        }finally{
            DBManager.closeConnection(con);
        }
    }

    public List<Member> findAll() {
    Connection con = DBManager.createConnection();
    String sql = "SELECT * FROM " + TABLE_NAME + " ORDER BY age DESC";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

        List<Member> memberList = new ArrayList<>();
        while(rs.next()){
            Member member = new Member();
            member.setId(rs.getInt("id"));
            member.setName(rs.getString("name"));
            member.setBirthDay(rs.getDate("birth_day").toLocalDate());
            member.setGender(rs.getString("gender"));
            member.setColorId(rs.getInt("color_id"));
            memberList.add(member);
        }
        return memberList;
        } catch (SQLException e) {
            System.err.println("SQL = "+sql);
            throw new RuntimeException("検索処理に失敗しました", e);
        } finally {
            DBManager.closeConnection(con);
        }
    }

    public int insert(Member member) {
        Connection con = DBManager.createConnection();
        String sql = "INSERT INTO " + TABLE_NAME + " (name, birth_day, gender, color_id) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getName());
            pstmt.setDate(2, java.sql.Date.valueOf(member.getBirthDay()));
            pstmt.setString(3, member.getGender());
            pstmt.setInt(4, member.getColorId());
            
            int affected = pstmt.executeUpdate();
            return affected;
        } catch (SQLException e) {
            System.err.println("SQL = "+sql);
            throw new RuntimeException("挿入処理に失敗しました", e);
        } finally {
            DBManager.closeConnection(con);
        }
    }

    public int update(Member member) {
        Connection con = DBManager.createConnection();
        String sql = "UPDATE " + TABLE_NAME + " SET name = ?, birth_day = ?, gender = ?, color_id = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getName());
            pstmt.setDate(2, java.sql.Date.valueOf(member.getBirthDay()));
            pstmt.setString(3, member.getGender());
            pstmt.setInt(4, member.getColorId());
            pstmt.setInt(5, member.getId());
    
            int affected = pstmt.executeUpdate();
            return affected;
        } catch (SQLException e) {
            System.err.println("SQL = "+sql);
            throw new RuntimeException("更新処理に失敗しました", e);
        } finally {
            DBManager.closeConnection(con);
        }
    }

    public int deleteById(int id) {
    Connection con = DBManager.createConnection();
    String sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
    try {
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, id);

        int affected = pstmt.executeUpdate();
        return affected;
    } catch (SQLException e) {
        System.err.println("SQL = "+sql);
        throw new RuntimeException("削除処理に失敗しました", e);
    } finally {
        DBManager.closeConnection(con);
    }
}
}