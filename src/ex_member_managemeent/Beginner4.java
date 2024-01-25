package ex_member_managemeent;

import java.util.List;

public class Beginner4 {
    public static void main(String[] args) {
         MemberDao dao = new MemberDao();
        List<Member>memberList=dao.findAll();

            System.out.println(memberList);
        
    }
}
