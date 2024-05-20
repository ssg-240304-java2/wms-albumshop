package bangshop.music.controller;

import bangshop.music.common.utils.IOUtils;
import bangshop.music.model.dto.EmployeeDTO;
import bangshop.music.model.dto.Role;
import bangshop.music.model.dto.StoreDTO;
import bangshop.music.model.service.EmployeeService;
import bangshop.music.view.menu.StorageAdminView;
import bangshop.music.view.menu.StoreManagerView;

import java.util.List;
import java.util.Map;

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController() {
        employeeService = new EmployeeService();
    }

    public void createAccount(Map<String, String> parameter) {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setName(parameter.get("name"));
        employee.setId(parameter.get("id"));
        employee.setPassword(parameter.get("password"));
        employee.setRoleNo(Role.STORE_MANAGER.getRoleNo());

        if (!isUnique(parameter.get("id"))) {
            System.out.println("이미 존재하는 아이디입니다.\n");
            return;
        }

        if (employeeService.registerEmployee(employee)) {
            System.out.println("회원가입을 완료하였습니다.\n");
        } else {
            System.out.println("회원가입에 실패하였습니다.\n");
        }
    }

    private boolean isUnique(String id) {
        return employeeService.findEmployeeById(id) == null;
    }


    public void signIn(Map<String, String> parameter) {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setId(parameter.get("id"));
        employee.setPassword(parameter.get("password"));

        EmployeeDTO foundEmployee = employeeService.findEmployeeById(employee.getId());
        if (foundEmployee == null) {
            System.out.println("존재하지 않는 아이디입니다.\n");
        } else if (!foundEmployee.getPassword().equals(employee.getPassword())) {
            System.out.println("잘못된 비밀번호입니다.\n");
        } else if (foundEmployee.getRoleNo() == Role.STORAGE_ADMIN.getRoleNo()) {
            System.out.printf("환영합니다, %s %s님\n\n", foundEmployee.getName(), Role.STORAGE_ADMIN.getRoleName());
            new StorageAdminView().storageAdminMenu();
        } else {
            System.out.printf("환영합니다, %s %s님\n\n", foundEmployee.getName(), Role.STORE_MANAGER.getRoleName());
            new StoreManagerView().storeManagerMenu(foundEmployee);
        }
    }

    public void findStoreByKeyword(String keyword) {
        List<StoreDTO> storeList = employeeService.findStoreByKeyword(keyword);
        if (storeList != null && !storeList.isEmpty()) {
            System.out.printf("\n==========\"%s\"로 검색한 매장 결과입니다.==========\n", keyword);
            storeList.forEach(s ->  System.out.printf("%d. %s\n", storeList.indexOf(s) + 1, s));
        } else {
            System.out.println("\n해당 키워드로 검색된 가게가 없습니다.");
        }
        pause();
    }

    public void findEmployeeByName(String name) {
        List<EmployeeDTO> employeeList = employeeService.findEmployeeByName(name);
        if (employeeList != null && !employeeList.isEmpty()) {
            System.out.printf("\n==========\"%s\"로 검색한 직원 목록입니다.==========\n", name);
            employeeList.forEach(e -> System.out.printf("%d. %s\n", employeeList.indexOf(e) + 1, e));
        } else {
            System.out.println("\n입력하신 이름과 일치하는 직원이 없습니다.");
        }
        pause();
    }

    private void pause() {
        while (true) {
            String input = IOUtils.input("이전으로 돌아가려면 p를 입력하세요: ");
            if (input.equals("p")) {
                System.out.println();
                return;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
