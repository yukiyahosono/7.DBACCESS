package ex_member_managemeent;

import java.time.LocalDate;

public class Beginner1 {
    public static void main(String[] args) {
        MemberDao dao = new MemberDao();
        Member member = new Member();
        member.setName("大野智");
        member.setBirthDay(LocalDate.of(1980, 11, 26));       
        member.setGender("男");
        member.setColorId(1);
        dao.insert(member);

        member = new Member();
        member.setName("桜井翔");
        member.setBirthDay(LocalDate.of(1982, 1, 25));       
        member.setGender("男");
        member.setColorId(2);
        dao.insert(member);
        
        member = new Member();
        member.setName("相葉雅紀");
        member.setBirthDay(LocalDate.of(1982, 12, 24));       
        member.setGender("男");
        member.setColorId(3);
        dao.insert(member);

        member = new Member();
        member.setName("二宮和也");
        member.setBirthDay(LocalDate.of(1983, 6, 17));       
        member.setGender("男");
        member.setColorId(4);
        dao.insert(member);
       
        member = new Member();
        member.setName("松本潤");
        member.setBirthDay(LocalDate.of(1983, 8, 30));       
        member.setGender("男");
        member.setColorId(5);
        dao.insert(member);
    }
}
