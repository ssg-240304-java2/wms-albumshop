package bangshop.music.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role {
    STORAGE_ADMIN(1, "관리자"),
    STORE_MANAGER(2, "점장");

    private final int roleNo;
    private final String roleName;
}
