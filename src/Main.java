import com.student.manage.student;
import com.student.manage.studentDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) throws IOException {
//       try {
//           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
//                   "root",
//                   "adeshpokhrel.com.9847822556"
//           );
//           System.out.println(conn);
//       } catch(Exception e) {
//           System.out.println(e);
//       }
//
//    }
        System.out.println("Welcome to Management System");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.println("Press 1 to Add student");
            System.out.println("Press 2 to Delete student");
            System.out.println("Press 3 to Display student");
            System.out.println("Press 4 to Exit App");
            int c = Integer.parseInt(br.readLine());

            if (c == 1) {
                //add student
                System.out.println("Enter user name");
                String name = br.readLine();

                System.out.println("Enter user phone");
                String phone = br.readLine();

                System.out.println("Enter user city");
                String city = br.readLine();

                // create student object to store student

                student st = new student(name, phone, city);
               boolean ans= studentDao.insertStudentToDb( st );
               if (ans) {
                   System.out.println("Successfully added");
               } else {
                   System.out.println("Something went wrong");
               }
                System.out.println(st);

            } else if (c == 2) {
                System.out.println("Enter student id to delete:");
                int userId = Integer.parseInt(br.readLine());
                 boolean f = studentDao.deleteStudent(userId);
                 if(f){
                     System.out.println("Good xa delete vako xa");
                 } else {
                     System.out.println("key vako xaina la");
                 }


            } else if (c == 3) {
                //show all the data
                studentDao.showAllStudentData();

            } else if (c == 4) {
                //exit
                break;


            } else {


            }
        }

        System.out.println("Thank You");


    }
}
