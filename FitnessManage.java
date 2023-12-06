import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FitnessManage {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MemberRepository memberRepository = new MemberRepository();

    public void run() throws NumberFormatException, IOException {

        while (true) {

            // 회원 등록
            int menu = InputMenu();
            if (menu == 1) {
                try {
                    memberRepository.createMember(residentMember());
                    System.out.println("회원 등록이 성공적으로 완료되었습니다. ");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            } else if (menu == 2) {
                SearchMember();
            }
            else if (menu == 3) {
                DeleteMember();
            }
            else if (menu == 4) {
                UpdateMember();
            }

        }
    }

    // 메뉴 입력
    private int InputMenu() throws NumberFormatException, IOException {
        System.out.println("원하시는 번호를 입력해주세요.");
        System.out.println("1. 회원 등록");
        System.out.println("2. 회원 조회");
        System.out.println("3. 회원 삭제");
        System.out.println("4. 회원 수정");


        return Integer.parseInt(br.readLine());
    }

    // 회원 등록
    private Member residentMember() throws IOException {
        Member member;
        System.out.println("원하시는 번호를 입력해주세요.");
        System.out.println("1. 일반 회원");
        System.out.println("2. VIP 회원");
        int rating = Integer.parseInt(br.readLine());

        System.out.println("이메일을 입력해주세요.");
        String email = br.readLine();
        System.out.println("이름을 입력해주세요.");
        String name = br.readLine();
        System.out.println("나이를 입력해주세요.");
        int age = Integer.parseInt(br.readLine());



        if (rating == 2) {
            System.out.println("신청한 PT 횟수를 입력해주세요.");
            int pt_number = Integer.parseInt(br.readLine());
            member = new VIPMember(email, name, age, pt_number);
        } else {
            member = new NormalMember(email, name, age);
        }

        return member;
    }

    // 회원 조회
    private void SearchMember() throws IOException {
        System.out.println("조회하려는 회원의 이름을 입력해주세요.");
        memberRepository.readMember(br.readLine());
    }

    private void DeleteMember() throws IOException {
        System.out.println("삭제하고싶은 회원의 이름을 입력해주세요.");
        memberRepository.delMember(br.readLine());
    }
    private void UpdateMember() throws IOException {
        System.out.println("수정하고 싶은 회원의 이름을 입력해주세요.");
        String name = br.readLine();

        // 해당 이름을 가진 회원을 찾아서 수정
        Member foundMember = findMemberByName(name);

        if (foundMember != null) {
            System.out.println("수정할 항목을 선택해주세요.");
            System.out.println("0. 수정할게 없습니다.");
            System.out.println("1. 이메일 수정");
            System.out.println("2. 나이 수정");
            System.out.println("3. 이름 수정");
            int option = Integer.parseInt(br.readLine());

            while(option!=0) {
                switch (option) {
                    case 0:
                        break;
                    case 1:
                        System.out.println("새 이메일을 입력해주세요.");
                        String newEmail = br.readLine();
                        foundMember.setEmail(newEmail);
                        System.out.println("이메일이 수정되었습니다.");
                        break;
                    case 2:
                        System.out.println("새 나이를 입력해주세요.");
                        int newAge = Integer.parseInt(br.readLine());
                        foundMember.setAge(newAge);
                        System.out.println("나이가 수정되었습니다.");
                        break;
                    case 3:
                        System.out.println("새 이름을 입력해주세요.");
                        String newName = br.readLine();
                        foundMember.setName(newName);
                        System.out.println("이름이 수정되었습니다.");
                        break;
                    default:
                        System.out.println("올바른 옵션을 선택해주세요.");
                }
                System.out.println("수정할 항목을 선택해주세요.");
                System.out.println("0. 수정할게 없습니다.");
                System.out.println("1. 이메일 수정");
                System.out.println("2. 나이 수정");
                System.out.println("3. 이름 수정");
                option = Integer.parseInt(br.readLine());
            }
            }
        else {
            System.out.println("해당하는 회원을 찾을 수 없습니다.");
        }

    }

    // 이름으로 회원 찾기
    private Member findMemberByName(String name) {
        // MemberRepository의 메서드를 사용하여 이름으로 회원을 찾음
        return memberRepository.findByName(name);
    }


}