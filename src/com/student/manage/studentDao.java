package com.student.manage;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class studentDao {
    public static  boolean insertStudentToDb(student st) {
        boolean f = false;
        // jdbc code ...
         try {
             // jdbc conde..
             Connection conn  = ConnectionDatabase.createC();
             String q = "insert into students(sname,sphone,scity) values(?,?,?)";
             PreparedStatement pstmt = conn.prepareStatement(q);

             // set the values of parameters
             pstmt.setString(1,st.getStudentName());
             pstmt.setString(2,st.getStudentPhone());
             pstmt.setString(3,st.getStudentCity());

             //execute
             pstmt.executeUpdate();
             f = true;


         } catch (Exception e) {
             e.printStackTrace();
         }
         return f;
    }

    public static boolean deleteStudent(int userId) {

        boolean f = false;
        // jdbc code ...
        try {
            // jdbc conde..
            Connection conn  = ConnectionDatabase.createC();
            String q = "delete from students where sid= ?";
            PreparedStatement pstmt = conn.prepareStatement(q);

            // set the values of parameters
            pstmt.setInt(1,userId);


            //execute
            pstmt.executeUpdate();
            f = true;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;

    }

    public static void showAllStudentData() {
        {
            boolean f = false;
            // jdbc code ...
            try {
                // jdbc conde..
                Connection conn = ConnectionDatabase.createC();
                String q = "select * from students;";
                Statement stmt = conn.createStatement();
                ResultSet set = stmt.executeQuery(q);

                while (set.next()) {
                    int id = set.getInt(1);
                    String name = set.getString(2);
                    String phone = set.getString(3);
                    String city = set.getString(4);
                    System.out.println("ID : " + id);
                    System.out.println("name : " + name);
                    System.out.println("phone : " + phone);
                    System.out.println("city : " + city);
                    System.out.println("++++++++++++++++++++++++++++++++++++");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }}
