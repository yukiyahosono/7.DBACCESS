package ex_member_managemeent;

public class Beginner2 {
    public static void main(String[] args) {
        MemberDao dao = new MemberDao();
        Member member = dao.load(1);
        System.out.println("id= " + member.getId());
        System.out.println("name= " + member.getName());
        System.out.println("birth_day " + member.getBirthDay());
        System.out.println("gender= " + member.getGender());
        System.out.println("color_id= " + member.getColorId());
    }
}