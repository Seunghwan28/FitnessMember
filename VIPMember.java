public class VIPMember extends Member {

    private int pt_number;
    private boolean isVIP;

    public VIPMember(String email, String name, int age, int pt_number) {
        super(email, name, age);
        this.pt_number = pt_number;
        this.isVIP = true;
    }

    public int getPT_number() {
        return pt_number;
    }

    

    public void setPT_number(int pt_number) {
        this.pt_number = pt_number;
    }
    public boolean isVIP() {
        return isVIP;
    }

    // VIP 회원 여부를 설정하는 메서드
    public void setVIP(boolean isVIP) {
        this.isVIP = isVIP;
    }

    @Override
    public String toString() {
        return "%s님은 VIP 회원이고 이메일은 %s이고, 나이는 %d살입니다. 신청하신 PT횟수는 %d회입니다.".formatted(this.getName(), this.getEmail(),
                this.getAge(), this.pt_number);
    }



}