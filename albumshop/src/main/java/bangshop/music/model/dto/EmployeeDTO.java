package bangshop.music.model.dto;

import lombok.*;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO that = (EmployeeDTO) o;
        return roleNo == that.roleNo && Objects.equals(name, that.name) && Objects.equals(id, that.id) && Objects.equals(password, that.password) && Objects.equals(roleName, that.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, password, roleNo, roleName);
    }
}
