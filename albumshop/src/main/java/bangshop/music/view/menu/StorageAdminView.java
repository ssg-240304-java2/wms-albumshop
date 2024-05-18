package bangshop.music.view.menu;

import bangshop.music.common.utils.IOUtils;

public class StorageAdminView {

    public void storageAdminMenu() {
        displayMenu();
        String inputMenu = IOUtils.input("메뉴를 입력하세요: ");
    }

    private static void displayMenu() {
        System.out.println("==========창고관리자 메뉴==========");
        for (StorageAdminMenu menu : StorageAdminMenu.values()) {
            System.out.println(menu.getCode() + ". " + menu.getTitle());
        }
    }
}
