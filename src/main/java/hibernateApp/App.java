package hibernateApp;

import hibernateDao.StudentDao;
import hibernateModel.Student;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Student student = null;
        List<Student> estudiantes = null;
        StudentDao studentDao = new StudentDao();

        // test saveStudent
/*        student = new Student("Diego","Agudo","pepito@hotmail.com");
        studentDao.saveStudent(student);*/

        // test getStudent
        //System.out.println(studentDao.getStudentById(1).getNombre());

        // test getAllStudents
        for(Student s: studentDao.getAllStudents()){
            System.out.println(s.getNombre()+" "+s.getApellido());
        }

        // test updateStudent
/*        student = new Student("Diego","Agudo","agudod@hotmail.com");
        student.setId(2); //le mando el id al objeto creado para que lo modifique en la tabla
        studentDao.updateStudent(student);
        System.out.println(studentDao.getStudentById(2).getNombre());*/

        // test deleteStudent
        //studentDao.deleteStudent();
    }
}
