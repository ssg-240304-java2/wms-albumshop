package bangshop.music.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    int employeeNo;
    String name;
    String id;
    String password;
    int roleNo;
    String roleName;

    @Override
    public String toString() {
        return "이름: " + name + ", " +
                "아이디: " + id + ", " +
                "비밀번호: " + password + ", " +
                "직책: " + roleName;
    }
}
