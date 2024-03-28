package ra.run;

import ra.Support.InputMethods;
import ra.entity.Department;
import ra.entity.Employee;

import java.util.Scanner;

public class employeeManage {

    public static void addEmployee(Scanner sc) {
        System.out.println("mời bạn nhập vào số nhân viên muốn tạo");
        byte count = InputMethods.getByte();
        for (int i = 0; i < count; i++) {
            Employee employee = new Employee();
            employee.inputData(sc);
            Employee.employeeList.add(employee);
            System.out.println("tạo thành công");
        }
    }

    public static void employeeStatus() {
        boolean isExit = true;
        while (isExit) {
            System.out.println("Mời bạn chọn nhân viên muôn sửa trạng thái");
            for (int i = 0; i < Employee.employeeList.size(); i++) {
                System.out.println(" nhân viên số" + (i + 1));
                Employee.employeeList.get(i).displayData();
            }
            System.out.println("mời bạn chọn số nhân viên");
            byte choice = InputMethods.getByte();
            if (choice < Employee.employeeList.size()) {
                System.out.println("trạng thái nhân viên: " + Employee.employeeList.get(choice - 1).getFullName()
                        + "___" + (Employee.employeeList.get(choice - 1).getStatus() ? "làm" : "nghỉ"));
                System.out.println("mời bạn nhập trạng thái mới cho nhân viên (true=làm,false=nghỉ)");
                Employee.employeeList.get(choice - 1).setStatus(InputMethods.getBoolean());
                System.out.println("bạn đã " + (Employee.employeeList.get(choice - 1).getStatus() ? "cho " + Employee.employeeList.get(choice - 1).getFullName() + "đi làm"
                        : "cho nhân viên" + Employee.employeeList.get(choice - 1).getFullName() + "nghỉ làm"));
                isExit = false;
            } else {
                System.err.println("số bạn nhân viên bạn chọn không hợp lệ");
            }
        }

    }

    public static void employeeByDepartment() {
        for (Department department : Department.departmentList) {
            System.out.println("phòng: " + department.getName());
            Employee.employeeList.stream()
                    .filter(employee -> employee.getDepartment().getId() == department.getId())
                    .forEach(Employee::displayData);
            System.out.println("=========================HẾT PHÒNG: " + department.getName() + "==============================");
        }
    }

    public static void sortByName() {
        Employee.employeeList.sort((a, b) -> a.getFullName().compareTo(b.getFullName()));
        System.out.println("sắp xếp thành công");
    }

    public static void employeeUpdate(Scanner sc) {
        boolean isExit = true;
        while (isExit) {
            System.out.println("Mời bạn chọn nhân viên muôn sửa ");
            for (int i = 0; i < Employee.employeeList.size(); i++) {
                System.out.println(" nhân viên số" + (i + 1));
                Employee.employeeList.get(i).displayData();
            }
            System.out.println("mời bạn chọn số nhân viên");
            byte index = InputMethods.getByte();
            if (index < Employee.employeeList.size()) {
                do {

                    System.out.println("mời bạn chọn trường muốn sửa\n" +
                            "1: Tên\n" +
                            "2: địa chỉ\n" +
                            "3: phone\n" +
                            "4: sinh nhật\n" +
                            "5: phòng ban\n" +
                            "6: trạng thái\n" +
                            "0: thoát");
                    byte choice = InputMethods.getByte();
                    switch (choice) {
                        case 1:
                            Employee.employeeList.get(index - 1).setFullName(
                                    Employee.employeeList.get(index - 1).inputFullName(sc));
                            break;
                        case 2:
                            Employee.employeeList.get(index - 1).setAddress(
                                    Employee.employeeList.get(index - 1).inputAddress(sc));
                            break;
                        case 3:
                            Employee.employeeList.get(index - 1).setPhone(
                                    Employee.employeeList.get(index - 1).inputPhone(sc));
                            break;
                        case 4:
                            Employee.employeeList.get(index - 1).setDateOfBirth(
                                    Employee.employeeList.get(index - 1).inputDateOfBirth());
                            break;
                        case 5:
                            Employee.employeeList.get(index - 1).setDepartment(
                                    Employee.employeeList.get(index - 1).inputDepartment(sc));
                            break;
                        case 6:
                            employeeStatus();
                            break;
                        case 0:
                            isExit = false;
                        default:
                            System.err.println(" lựa chọn sai");
                    }
                } while (isExit);
            } else {
                System.err.println("số bạn nhân viên bạn chọn không hợp lệ");
            }
        }

    }

    //0x4   1x4   2x4
//0-3,4-7,8-11
    public static void pagination(int currentPage) {
        int length = Employee.employeeList.size();
        int pageQuantity = (length%4)==0?length/4:(length/4)+1;
        for (int i = currentPage * 4; i < currentPage*4 + 4; i++) {
            if(i==length){break;}
            Employee.employeeList.get(i).displayData();
        }
        System.out.println("========trang(" + (currentPage + 1) + "/" + pageQuantity + ")===========");
    }

    public static void paginationMaint() {
        int length = Employee.employeeList.size();
        int pageQuantity = (length%4)==0?length/4:(length/4)+1;

        pagination(0);
        while (true) {
            System.out.println("mời bạn chọn trang muôn xem");
            System.out.println("chọn 0 để ngừng xem");
            byte choice = InputMethods.getByte();
            if (choice - 1 <=0) {
                return;
            }
            if (choice - 1 <  pageQuantity) {
                pagination(choice-1);
            } else {
                System.err.println("chọn sai mời chọn lại");
            }
        }
    }


    public static void menuEpl(Scanner sc) {
        while (true) {
            System.out.println("================Employee Menu===================");
            System.out.println(
                    "1.Hiển thị tất cả nhân viên (phân trang)\n" +
                            "2.Thêm mới nhân viên\n" +
                            "3.Sửa thông tin nhân viên\n" +
                            "4.Thay đổi trạng thái nhân viên\n" +
                            "5.Danh sách nhân viên theo phòng ban\n" +
                            "6.Sắp xếp nhân viên theo tên tăng dần\n" +
                            "7.Thoat");

            System.out.println("Nhập lựa chọn");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    paginationMaint();
                    break;
                case 2:
                    addEmployee(sc);
                    break;
                case 3:
                    employeeUpdate(sc);
                    break;
                case 4:
                    employeeStatus();
                    break;
                case 5:
                    employeeByDepartment();
                    break;
                case 6:
                    sortByName();
                    break;
                case 7:
                    return;
                default:
                    System.err.println("Nhap sai moi nhap lai");
            }
        }
    }
}
