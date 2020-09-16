package com.mylesson.stage2.oop.javaio;

import com.javalesson.collections.map.treemap.AverageStudentGrade;
import com.javalesson.collections.map.treemap.SubjectGrade;
import com.javalesson.collections.map.treemap.TreeMapRunner;

import java.io.*;
import java.util.*;

public class IOMain {
    private static final String FILE_NAME = "GradeBook.txt";
    private static final String BINARY_FILE = "Students.bin";

    public static void main(String[] args) throws IOException {


        SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades = TreeMapRunner.createGrades();
        Writer writer = new Writer();
        writer.writeFile(FILE_NAME, grades);
        Reader reader = new Reader();
        reader.readFile(FILE_NAME);

//        try (FileInputStream reader = new FileInputStream((FILE_NAME));
//             FileOutputStream writer = new FileOutputStream("GradeBookByte.txt");){
//
//            int c;
//            while ((c = reader.read()) != -1){
//                System.out.print(c);
//                writer.write(c);
//            }
//
//        }

//        writter.writeWithFormatter();
        processGrades(grades, BINARY_FILE, writer);
        outputObjects(BINARY_FILE, reader);

    }

    private static void processGrades( SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades, String fileName, Writer writer){

        List<Student> studentList = new ArrayList<>();

        for ( AverageStudentGrade gradeKey : grades.keySet()){
            studentList.add(new Student(gradeKey.getName(), gradeKey.getAverageGrade(), grades.get(gradeKey)));
        }
        writer.writeObject(studentList, fileName);

    }

    private static void outputObjects(String fileName, Reader reader){

        List<Student> students = reader.readObject(fileName);

        for (Student student : students){

            System.out.printf("%s, %.2f %n", student.getName(), student.getAverageGrade());
            System.out.println(student.getGrades());

        }

    }

}
