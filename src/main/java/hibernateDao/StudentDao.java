package hibernateDao;

import hibernateModel.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hibernateUtil.HibernateUtil;

import java.util.List;

public class StudentDao {

    //save student
    //get All student
    //get student por id
    //update student
    //delete student

    public void saveStudent(Student student){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            // start the transaction
            transaction = session.beginTransaction();

            // save student object
            session.save(student);

            // commit the transaction
            transaction.commit();

            // cierro la session
            session.close();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public void updateStudent(Student student){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            // start the transaction
            transaction = session.beginTransaction();

            // save student object
            session.saveOrUpdate(student);

            // commit the transaction
            transaction.commit();

            // cierro la session
            session.close();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public Student getStudentById(long id){
        Transaction transaction = null;
        Student student = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            // start the transaction
            transaction = session.beginTransaction();

            // get student object
            student = session.get(Student.class, id);

            // commit the transaction
            transaction.commit();

            // cierro la session
            session.close();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return student;
    }

    public List<Student> getAllStudents(){
        Transaction transaction = null;
        List<Student> students = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            // start the transaction
            transaction = session.beginTransaction();

            // get students
            students = session.createQuery("from Student").list();

            // commit the transaction
            transaction.commit();

            // cierro la session
            session.close();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        return students;
    }

    public void deleteStudent(long id){
        Transaction transaction = null;
        Student student = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            // start the transaction
            transaction = session.beginTransaction();

            student = session.get(Student.class, id);
            // get student object
            session.delete(student);
            
            // commit the transaction
            transaction.commit();

            // cierro la session
            session.close();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
}
