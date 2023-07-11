package com.student.management;

public class student {
    private int Id;
    private String Name;
    private String Email;
    private String Mobile_no;

    public student() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public String getMobile_no() {
        return Mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        Mobile_no = mobile_no;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "student{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Mobile_no=" + Mobile_no +
                '}';
    }
}
