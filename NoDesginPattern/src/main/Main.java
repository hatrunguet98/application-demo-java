package main;

import object.Courses;
import object.Students;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Students> listStudents=new ArrayList<Students>();
        ArrayList<Courses> listCourses=new ArrayList<Courses>();
        ArrayList<Students> studentC=new ArrayList<Students>();
        Scanner scanner=new Scanner(System.in);
        for(int i=0;;i++){
            System.out.println("Creat Cutdent:1");
            System.out.println("Creat Course:2");
            System.out.println("Add Student to Course:3");
            System.out.println("Show list Course:4");
            int lock=Integer.valueOf(scanner.nextLine());
            if(lock==1){
                Students students= new Students();
                System.out.println("Set sutdent'name:");
                String name=scanner.nextLine();
                students.setName(name);
                listStudents.add(students);
            }
            if(lock==2){
                Courses courses= new Courses();
                System.out.println("Set course'name:");
                String name=scanner.nextLine();
                courses.setName(name);
                listCourses.add(courses);
            }
            if(lock==3){
                if(listCourses.isEmpty()){
                    System.out.println("listCourses isEmpty");
                }
                if(listStudents.isEmpty()){
                    System.out.println("listStudents isEmpty");
                }
                else{

                    System.out.println("Chose course");
                    for(int j=0;j<listCourses.size();j++)
                    System.out.println(j +": "+listCourses.get(j).getName());
                    int numCourse=Integer.valueOf(scanner.nextLine());
                    System.out.println("Add Student to Course");
                    for(int k=0;k<listStudents.size();k++)
                        System.out.println(k +": "+listStudents.get(k).getName());
                    int numStudent=Integer.valueOf(scanner.nextLine());
                    studentC.add(listStudents.get(numStudent));
                    listCourses.get(numCourse).setListStudents(studentC);
                }
            }
            if(lock==4){
                if(listCourses.isEmpty()){
                    System.out.println("listCourses isEmpty");
                }
                for(int j=0;j<listCourses.size();j++)
                    System.out.println(j +": "+listCourses.get(j).getName());
                System.out.println("Chose course");
                int numCourse=Integer.valueOf(scanner.nextLine());
                System.out.println("Show list Students:");
                for (int j=0;j<listCourses.get(numCourse).getListStudents().size();j++){
                    System.out.println(listCourses.get(numCourse).getListStudents().get(j).getName());
                }
            }
        }

    }

}

