package ir.maktab.repository;

import ir.maktab.model.Doctor;
import ir.maktab.session.MySession;
import org.hibernate.Session;

import java.util.List;

public interface DoctorRepository {

    default List<Doctor> findAll() {
        Session instance = MySession.getInstance();
        return instance.createQuery("select d from Doctor d",Doctor.class).list();
    }

    default Doctor findById(long id) {
        Session instance = MySession.getInstance();
        Doctor doctor = instance.get(Doctor.class, id);
        instance.close();
        return doctor;
    }

    default void save(Doctor doctor) {
        Session instance = MySession.getInstance();
        instance.save(doctor);
        instance.close();
    }

    default void update(Doctor doctor) {
        Session instance = MySession.getInstance();
        instance.update(doctor);
        instance.close();
    }

    default void delete(Doctor doctor) {
        Session instance = MySession.getInstance();
        instance.delete(doctor);
        instance.close();
    }

    default List<Doctor> findByName(String name) {
        Session instance = MySession.getInstance();
        List<Doctor> doctors = instance.createQuery("from Doctor where name = '" + name + "'").list();
        instance.close();
        return doctors;
    }


}
