package bangshop.music.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO {
    int employeeNo;
    String name;
    String id;
    String password;
    int roleNo;
}
