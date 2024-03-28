package ra.entity;

import ra.Support.InputMethods;
import ra.run.departmentManage;

import javax.swing.plaf.basic.BasicToolTipUI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Employee {
    public static List<Employee> employeeList = new ArrayList<>();
    private int id;
    private String fullName;
    private String address;
    private String phone;
    private LocalDate dateOfBirth;
    private Department department;
    private Boolean status;

    public Employee() {
    }

    public Employee(int id, String fullName, String address, String phone, LocalDate dateOfBirth, Department department, Boolean status) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void inputData(Scanner sc) {
        this.id = inputID();
        this.fullName = inputFullName(sc);
        this.address = inputAddress(sc);
        this.phone = inputPhone(sc);
        this.dateOfBirth = inputDateOfBirth();
        this.department = inputDepartment(sc);
        this.status = true;
    }

    public String inputPhone(Scanner sc) {
        final String regex = "^(032|033|034|035|036|037|038|039|096|097|098|086|083|084|085|081|082|088|091|094|070|079|077|076|078|090|093|089|056|058|092|059|099)[0-9]{7}$";
        while (true) {
            System.out.println("mời bạn nhập số điện thoại");
            String phone = sc.nextLine();
            if (phone.matches(regex)) {
                return phone;
            } else {
                System.err.println("số điện thoại của bạn không đúng");
            }
        }


    }

    public int inputID() {
        if (employeeList.isEmpty()) {
            return 0;
        } else {
            return employeeList.get(employeeList.size() - 1).getId() + 1;
        }
    }

    public String inputFullName(Scanner sc) {
        while (true) {
            System.out.println("Moi bạn nhập vào tên nhân viên");
            String name = sc.nextLine();
            if (name.isBlank()) {
                System.err.println("ban không dc để trống tên");
            } else {
                return name;
            }
        }
    }

    public String inputAddress(Scanner sc) {
        while (true) {
            System.out.println("Moi bạn nhập vào địa chỉ");
            String address = sc.nextLine();
            if (address.isBlank()) {
                System.err.println("ban không dc để trống địa chỉ");
            } else {
                return address;
            }
        }
    }

    public LocalDate inputDateOfBirth() {
        System.out.println("mời bạn nhập ngày sinh");
        return InputMethods.getLocalDate();
    }

    public Department inputDepartment(Scanner sc) {
        while (true) {
            if (!Department.departmentList.isEmpty()) {
                System.out.println("bạn có muốn chọn phòng làm việc không");
                System.out.println("1: có");
                System.out.println("2: không");
                byte choice = InputMethods.getByte();
                switch (choice) {
                    case 1:
                        return null;
                    case 2:
                        while (true) {
                            for (int i = 0; i < Department.departmentList.size(); i++) {
                                System.out.println("phòng ban số" + (i + 1));
                                Department.departmentList.get(i).displayData();
                            }
                            System.out.println("mờ bạn chọn số phòng");
                            choice = InputMethods.getByte();
                            if (choice < Department.departmentList.size()) {
                                return Department.departmentList.get(choice - 1);
                            } else {
                                System.err.println("số bạn phòng bạn chọn không hợp lệ");
                            }
                        }
                    default:
                        System.err.println(" lựa chọn không hợp lệ mời chọn lại");

                }
            } else {
                System.out.println(" bạn chưa có phòng ban nào bạn có muốn nạo mới không");
                System.out.println("1: chúng tôi không cần phòng ban");
                System.out.println("2: tạo phòng ban mới");
                byte choice = InputMethods.getByte();
                switch (choice) {
                    case 1:
                        return null;
                    case 2:
                        departmentManage.addDepartment(sc);
                       break;
                    default:
                        System.err.println(" lựa chọn không hợp lệ mời chọn lại");

                }
            }
        }

    }
    public void displayData(){
        System.out.printf("%-10s\n",this);
    }
    @Override
    public String toString() {
        return "nhân viên{" +
                "id=" + id +
                ", họ và tên='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", department=" + department +
                ", status=" + status +
                '}';
    }
}
