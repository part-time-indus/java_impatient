package ch02.sec02;

import java.util.ArrayList;
public class Network {
    public static void main(String[] args){
        Network net = new Network();
         net.enroll("James");
    }
    public class Member{
        private String name;
        private ArrayList<Member> friends;
        public Member(String name){
            this.name = name;
            this.friends = new ArrayList<Member>();
        }
        public void deactivate(){
            Network.this.unenroll(this);
        }
    }
    private ArrayList<Member> members = new ArrayList<>();
    public Member enroll(String name){
        Member newMemb = new Member(name);
        members.add(newMemb);
        return newMemb;
    }
    public void unenroll(Member memb){
        members.remove(memb);
    }


}
