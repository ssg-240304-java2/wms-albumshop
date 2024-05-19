package bangshop.music.view.menu;

import bangshop.music.common.utils.IOUtils;
import bangshop.music.model.dao.EmployeeMapper;
import bangshop.music.model.dto.EmployeeDTO;
import bangshop.music.model.dto.Role;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

import static bangshop.music.common.MyBatisTemplate.getSqlSession;

public class MainMenu {
    private static EmployeeMapper employeeMapper;

    public void mainView() {
//        EmployeeController employeeController = new EmployeeController();

        while (true) {
            displayMenu();
            String inputMenu = IOUtils.input("메뉴를 입력하세요: ");
            MainViewMenu menu = MainViewMenu.from(inputMenu);

            switch (menu) {
                case SIGN_IN -> signIn();
//                case SIGN_IN -> employeeController.saveEmployee(inputEmployee());
                case SIGN_UP -> signUp();
                case EXIT -> exit();
            }
        }
    }

    private Map<String, String> inputEmployee() {
        String id = IOUtils.input("아이디: ");
        String password = IOUtils.input("비밀번호: ");
        Map<String, String> parameter = new HashMap<>();
        parameter.put("id", id);
        parameter.put("password", password);
        return parameter;
    }

    private static void displayMenu() {
        System.out.println("==========메인 메뉴==========");
        for (MainViewMenu menu : MainViewMenu.values()) {
            System.out.println(menu.getCode() + ". " + menu.getTitle());
        }
    }

    public static void signIn() {
        String id = IOUtils.input("아이디: ");
        String password = IOUtils.input("비밀번호: ");

        try (SqlSession sqlSession = getSqlSession()) {
            employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            EmployeeDTO employee = employeeMapper.findEmployeeByIdAndPassword(id, password);

            if (employee != null) {
                System.out.printf("환영합니다. %s님%n", employee.getName());
                if (employee.getRoleNo() == Role.STORE_MANAGER.getRoleNo()) {
                    new StorageAdminView().storageAdminMenu();
                } else {
                    new StoreManagerView().storeManagerMenu();
                }
            } else {
                System.out.println("로그인에 실패했습니다. 아이디나 비밀번호를 다시 확인해주세요.");
            }
        }
    }

    private static void signUp() {
        String name = IOUtils.input("이름: ");
        String id = IOUtils.input("아이디: ");
        String password = IOUtils.input("비밀번호: ");
        EmployeeDTO employee = new EmployeeDTO();
        employee.setName(name);
        employee.setId(id);
        employee.setPassword(password);
        employee.setRoleNo(Role.STORE_MANAGER.getRoleNo());

        if (!isUnique(id)) {
            System.out.println("이미 존재하는 아이디입니다.");
            return;
        }

        try (SqlSession sqlSession = getSqlSession()) {
            employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            employeeMapper.insertEmployee(employee);
            sqlSession.commit();
            System.out.println("회원가입을 완료하였습니다.");
        }
    }

    private static boolean isUnique(String id) {
        try (SqlSession sqlSession = getSqlSession()) {
            employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            EmployeeDTO employee = employeeMapper.findEmployeeById(id);
            sqlSession.commit();
            return employee == null;
        }
    }

    private static void exit() {
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }
}
