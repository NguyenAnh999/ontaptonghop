package ra.run;

import ra.Support.InputMethods;
import ra.entity.Department;
import ra.entity.Employee;

import java.util.Scanner;

public class departmentManage {


    public static void menuDpm(Scanner sc) {

        while (true) {
            System.out.println("================Department Menu===================");
            System.out.println(
                    "1.Hiển thị tất cả phòng ban\n" +
                            "2.Thêm mới phòng ban\n" +
                            "3.Sửa thông tin phòng ban\n" +
                            "4.Tìm kiếm phòng ban theo tên\n" +
                            "5.Thay đổi trạng thái phòng ban\n" +
                            "6.Thoát\n"
            );
            System.out.println("Nhập lựa chọn");
            byte choice = new Scanner(System.in).nextByte();
            switch (choice) {
                case 1:
                    displayData();
                    break;
                case 2:
                    addDepartment(sc);
                    break;
                case 3:
                    updateNameDepartment(sc);
                    break;
                case 4:
                    searchDepartment();
                    break;
                case 5:
                    statusDepartment();
                    break;
                case 6:
                    return;
                default:
                    System.err.println("Nhap sai moi nhap lai");
            }
        }
    }


    public static void displayData() {
        Department.departmentList.forEach(Department::displayData);
    }

    public static void updateNameDepartment(Scanner sc) {
        boolean isExit = true;
        while (isExit) {
            System.out.println("Mời bạn chọn phòng ban muôn sửa tên");
            for (int i = 0; i < Department.departmentList.size(); i++) {
                System.out.println("phòng ban số" + (i + 1));
                Department.departmentList.get(i).displayData();
            }
            System.out.println("mờ bạn chọn số phòng");
            byte choice = InputMethods.getByte();
            if (choice < Department.departmentList.size()) {
                System.out.println("Tên của phòng: " + Department.departmentList.get(choice - 1).getName());
                Department.departmentList.get(choice - 1).setName(Department.departmentList.get(choice - 1).getInputName(sc));
                System.out.println("cập nhật thành công");
                isExit = false;
            } else {
                System.err.println("số bạn phòng bạn chọn không hợp lệ");
            }
        }
    }

    public static void statusDepartment() {
        boolean isExit = true;
        while (isExit) {
            System.out.println("Mời bạn chọn phòng ban muôn sửa trạng thái");
            for (int i = 0; i < Department.departmentList.size(); i++) {
                System.out.println("phòng ban số" + (i + 1));
                Department.departmentList.get(i).displayData();
            }
            System.out.println("mời bạn chọn số phòng");
            byte choice = InputMethods.getByte();
            if (choice < Department.departmentList.size()) {
                System.out.println("trạng thái của phòng: " + Department.departmentList.get(choice - 1).getName()
                        + "___" + (Department.departmentList.get(choice - 1).isStatus() ? "open" : "close"));
                System.out.println("mời bạn nhập trạng thái mới cho phòng ban (true=open,false=close)");
                Department.departmentList.get(choice - 1).setStatus(InputMethods.getBoolean());
                System.out.println("bạn đã " + (Department.departmentList.get(choice - 1).isStatus() ? "mở " : "đóng "
                        + " phòng: " + Department.departmentList.get(choice - 1).getName() + "thành công"));
                isExit = false;
            } else {
                System.err.println("số bạn phòng bạn chọn không hợp lệ");
            }
        }
    }

    public static void addDepartment(Scanner sc) {
        System.out.println("mời bạn nhập vào số phòng ban muốn tạo");
        byte count = InputMethods.getByte();
        for (int i = 0; i < count; i++) {
            Department department = new Department();
            department.inputData(sc);
            Department.departmentList.add(department);
            System.out.println("tạo thành công");
        }
    }

    public static void searchDepartment() {
        System.out.println("mời bạn nhập tên phòng ban muốn tìm");
        String searchName = InputMethods.getString();
        Department.departmentList.stream().filter(department -> department.getName().contains(searchName)).forEach(Department::displayData);
    }
//public static void autoDepartmentNumber(int DpmId){
//    int  countDpm = (int) Employee.employeeList.stream().map(employee -> employee.getDepartment().getId()==DpmId).count();
//
//    Department.departmentList.stream().map(department -> department.setNumberEmployee(countDpm));
//}

}
