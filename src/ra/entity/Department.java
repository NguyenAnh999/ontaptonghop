package ra.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Department {
    public static List<Department> departmentList = new ArrayList<>();
    private int id;
    private String name;
    private int numberEmployee;
    private boolean status;

    public Department() {
    }

    public Department(int id, String name, int numberEmployee, boolean status) {
        this.id = id;
        this.name = name;
        this.numberEmployee = numberEmployee;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberEmployee() {
        return numberEmployee;
    }

    public void setNumberEmployee(int numberEmployee) {
        this.numberEmployee = numberEmployee;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public  void inputData(Scanner sc){
        this.id=getInputID(sc);
        this.name=getInputName(sc);
        this.status=true;
        this.numberEmployee=0;
    }
    public int getInputID (Scanner sc){
        if (departmentList.isEmpty()){
            return 0;
        }else {
           return   departmentList.get(departmentList.size()-1).getId()+1;
        }
    }
    public String getInputName (Scanner sc){
       while (true){
           System.out.println("Moi bạn nhập vào tên phòng ban");
           String nameCheck = sc.nextLine();
           if (nameCheck.isBlank()){
               System.err.println("ban không dc để trống tên");
           }else {
               if(
                       departmentList.stream().anyMatch(department -> department.name.equals(nameCheck))
               ){
                   return name;
               }else {
                   System.err.println("tên đã được sử dụng");
               }
           }
       }
    }
public void displayData(){
    System.out.printf("%-10s\n",this);
}
    @Override
    public String toString() {
        return "thông tin phòng ban{" +
                "id=" + id +
                ", tên ='" + name + '\'' +
                ", số nhân viên=" + numberEmployee +
                ", trạng thái =" + (status?"làm":"nghỉ") +
                '}';
    }
}
