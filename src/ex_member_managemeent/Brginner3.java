package ex_member_managemeent;

import java.util.List;

public class Brginner3 {
    public static void main(String[] args) {
        MemberDao dao = new MemberDao();
        List<Member>memberList=dao.findByName("和");

        for(Member member : memberList){
            System.out.println("name= "+ member.getName());
        }
    }
}
