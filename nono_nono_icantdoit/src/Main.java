
import DAO.UserDAO;
import Model.User;
import Service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        //생성자 덩ari들
        Map<Integer, User> db = new HashMap<>();
        UserDAO userDAO = new UserDAO(db);
        UserService userService = new UserService(userDAO);
        int id = 1;
        boolean setlogin = false;
        String isLoginusername = null;

        //입력
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1:회원가입/2:로그인/3:회원정보 수정/4:탈퇴/0:종료");
            System.out.println("입력:");

            int select = Integer.parseInt(sc.nextLine());

            //0번 종료 메소드
            if (select == 0) {
                System.out.println("흑흑 잘가~");
                break;
            }

            //1번 회원가입
            if (select == 1) {
                System.out.println("id,password,이름을 입력하세요");
                String input = sc.nextLine();
                String[] sign = input.split(" ");
                String username = sign[0];
                String password = sign[1];
                String name = sign[2];

                //메인 저장 메소드 저장 메소드는
                User user = new User(id, username, password, name);
                boolean signup = userService.Join(id, user);

                if (signup) {
                    System.out.println(name + "님 가입을 환영합니다. ");
                    //자동 id증가
                    id += 1;
                }

            }

            //2번 로그인 부분 Controller
            if (select == 2) {

                //로그인 부분(리팩토링)
                System.out.println("id와 비번를 입력하세요");
                String data = sc.nextLine();
                String[] Logindata=data.split(" ");

                //service 로직(
                boolean successlogin = userService.Login(Logindata[0], Logindata[1]);

                //then

                if (successlogin) {
                    System.out.println("로그인 되었습니다. ");
                    isLoginusername = Logindata[0];
                    setlogin = true;
                } else {
                    System.out.println("로그인 실패! ");
                }


            }

            //3번 회원정보 수정 로직
            if (select == 3) {
                if (setlogin) {

                    System.out.println("회원정보 수정 입니다.");
                    System.out.println("이름과 바꾸실 이름을 입력하세요");
                    String namedata =sc.nextLine();
                    String[] finalname=namedata.split(" ");

                    boolean changenameresult = userService.Change(finalname[0], finalname[1]);

                    if (changenameresult) {
                        System.out.println("수정되었습니다.");
                    } else {
                        System.out.println("수정오류!");
                    }

                } else {
                    System.out.println("로그인 상태가 아닙니다.");
                }

            }

            //4번 로직
            if (select == 4) {
                if (setlogin){
                    boolean successDelete=userService.Delete(isLoginusername);
                    if(successDelete){
                        System.out.println("탈퇴 했습니다. 잘가요~ 흑흑");
                    }
                }else{
                    System.out.println("탈퇴는 로그인 하고 가능합니다!");
                }
            }
        }
    }
}




