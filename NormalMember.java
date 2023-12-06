public class NormalMember extends Member {
    public NormalMember(String email, String name, int age) {
        super(email, name, age);
    }

    @Override
    public String toString() {
        return "%s님은 일반 회원이고 이메일은 %s이고, 나이는 %d살입니다.".formatted(this.getName(), this.getEmail(),
                this.getAge());
    }

}