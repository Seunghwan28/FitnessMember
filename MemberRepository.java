import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MemberRepository {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    private List<Member> members;

    public MemberRepository() {

        members = new ArrayList<Member>();
    }

    // 회원 저장
    public void createMember(Member member) {

        members.forEach((person) -> {
            if (person.getEmail().equals(member.getEmail())) {
                throw new IllegalArgumentException("이미 등록된 이메일이어서 회원 등록에 실패했습니다.");
            }
        });

        members.add(member);
    }

    public void readMember(String name) {
        members.forEach((member) -> {
            if (member.isEqualeWithName(name)) {
                System.out.println(member.toString());
            }
        });
        members.forEach((member) -> {
            if (!(member.isEqualeWithName(name))) {
                System.out.println(name+" 님은 저장되지 않은 사람입니다.");
            }
        });
    }

    public void delMember(String name) {
            if(members.isEmpty()) {
                System.out.println("저장된 회원이 없습니다.");
            }
        boolean found = false;
        Iterator<Member> iterator = members.iterator();
        while (iterator.hasNext()) {
            Member member = iterator.next();
            if (member.isEqualeWithName(name)) {
                iterator.remove();
                System.out.println(name + " 회원님 삭제 완료");
                found = true;
                break; // 삭제 후 바로 종료
            }
        }

        if (!found) {
            System.out.println(name + " 님은 저장되지 않은 회원입니다.");
        }

        }
    public Member findByName(String name) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                return member; // 이름으로 회원을 찾으면 해당 회원 반환
            }
        }
        return null; // 해당 이름을 가진 회원이 없을 경우 null 반환
    }



    }

