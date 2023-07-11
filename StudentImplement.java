package com.student.management;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentImplement implements StudentInterface{
    Connection con;

    @Override
    public void createStudent(student std) {
        con =DBConnection.createDBConnetion();
        String query="insert into student values(?,?,?,?)";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,std.getId());
            pstm.setString(2,std.getName());
            pstm.setString(3,std.getEmail());
            pstm.setString(4, std.getMobile_no());
            int cnt= pstm.executeUpdate();
            if(cnt!=0) {
                System.out.println("Student Inserted Successfully !!!");
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showAllStudent() {
        con=DBConnection.createDBConnetion();
        String query="select * from student";
        System.out.println("Student Details :");
        System.out.println("---------------------------------------------");

        System.out.format("%s\t%s\t%s\t%s\n","ID","Name","Email","Mobile");
        System.out.println("---------------------------------------------");

        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%s\t%s\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4));
                System.out.println("---------------------------------------------");

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showStudentBasedOnID(int id) {
        con=DBConnection.createDBConnetion();
        String query="select * from student where id="+id;
        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%s\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4));

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void updateStudent(int id, String name) {
        con=DBConnection.createDBConnetion();
        String query="update student set name=? where id=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setInt(2,id);
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Student Details updated successfully !!");

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteStudent(int id) {
        con=DBConnection.createDBConnetion();
        String query="delete from Student where id=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,id);
            int cnt= pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Student Deleted Successfully!!! "+id);

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
}