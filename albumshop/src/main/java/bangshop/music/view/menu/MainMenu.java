package bangshop.music.view.menu;

import bangshop.music.common.utils.IOUtils;
import bangshop.music.controller.EmployeeController;
import bangshop.music.model.dao.EmployeeMapper;
import bangshop.music.model.dto.EmployeeDTO;
import bangshop.music.model.dto.Role;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

import static bangshop.music.common.MyBatisTemplate.getSqlSession;

public class MainMenu {
    public void mainView() {
        EmployeeController employeeController = new EmployeeController();

        while (true) {
            displayMenu();
            String inputMenu = IOUtils.input("메뉴를 입력하세요: ");
            MainViewMenu menu = MainViewMenu.from(inputMenu);
            switch (menu) {
                case SIGN_IN -> employeeController.signIn(inputAccountInfo());
                case EXIT -> exit();
            }
        }
    }

    private static void displayMenu() {
        System.out.println("==========메인 메뉴==========");
        for (MainViewMenu menu : MainViewMenu.values()) {
            System.out.println(menu.getCode() + ". " + menu.getTitle());
        }
    }

    public static Map<String, String> inputAccountInfo() {
        String id = IOUtils.input("아이디: ");
        String password = IOUtils.input("비밀번호: ");
        Map<String, String> parameter = new HashMap<>();
        parameter.put("id", id);
        parameter.put("password", password);
        return parameter;
    }

    private static void exit() {
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }
}
