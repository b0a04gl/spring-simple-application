package com.foobar;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.foobar.StudentJDBCTemplate;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

      StudentJDBCTemplate studentJDBCTemplate = 
         (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
     //insert 
      System.out.println("------Records Creation--------" );
      studentJDBCTemplate.create("Balaji", 20);
      studentJDBCTemplate.create("Mukesh", 19);
      studentJDBCTemplate.create("Venkii", 20);

      //retreive
      System.out.println("------Listing Multiple Records--------" );
      List<Student> students = studentJDBCTemplate.listStudents();
      
      for (Student record : students) {
         System.out.print("ID : " + record.getId() );
         System.out.print(", Name : " + record.getName() );
         System.out.println(", Age : " + record.getAge());
      }

      //update
      System.out.println("----Updating Record with ID = 2 -----" );
      studentJDBCTemplate.update(8, 20);

      System.out.println("----Listing Record with ID = 2 -----" );
      Student student = studentJDBCTemplate.getStudent(8);
      System.out.print("ID : " + student.getId() );
      System.out.print(", Name : " + student.getName() );
      System.out.println(", Age : " + student.getAge());
      
      //delete
      studentJDBCTemplate.delete(9);
      
      
   }
   
   
   
}

