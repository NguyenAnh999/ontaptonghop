package ra.run;

import ra.Support.InputMethods;
import ra.entity.Employee;

import java.time.LocalDate;
import java.util.Scanner;

public class run {
    static {

        Employee.employeeList.add(new Employee(0, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        Employee.employeeList.add(new Employee(1, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        Employee.employeeList.add(new Employee(2, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        Employee.employeeList.add(new Employee(3, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        Employee.employeeList.add(new Employee(4, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        Employee.employeeList.add(new Employee(5, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        Employee.employeeList.add(new Employee(6, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        Employee.employeeList.add(new Employee(7, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        Employee.employeeList.add(new Employee(8, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        Employee.employeeList.add(new Employee(9, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        Employee.employeeList.add(new Employee(10, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        Employee.employeeList.add(new Employee(11, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        Employee.employeeList.add(new Employee(12, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        Employee.employeeList.add(new Employee(13, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        Employee.employeeList.add(new Employee(14, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        Employee.employeeList.add(new Employee(15, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
        Employee.employeeList.add(new Employee(16, "anh", "hà nam", "0942341111", LocalDate.of(2000, 5, 6), null, true));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("================MENU===================");
            System.out.println("1- Quản trị Department: \n" +
                    "2- Quản lý Employee\n" +
                    "4.Thoát ");
            System.out.println("Nhập lựa chọn");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    departmentManage.menuDpm(sc);
                    break;
                case 2:
                    employeeManage.menuEpl(sc);
                    break;
                case 4:
                    System.out.println("Thoát");
                    return;
                default:
                    System.err.println("Moi nhap lai");
            }
        }
    }
}
