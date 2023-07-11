package com.student.management;

public interface StudentInterface {
    //create student
    public void createStudent(student std);
    //show all student
    public void showAllStudent();
    //show student based on id
    public void showStudentBasedOnID(int id);
    //update employee
    public void updateStudent(int id,String name);
    //delete employee
    public void deleteStudent(int id);
}
