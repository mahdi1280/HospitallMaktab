package ir.maktab.repository;

import ir.maktab.model.Prescription;
import ir.maktab.session.MySession;
import org.hibernate.Session;

import java.util.List;

public interface PrescriptionRepository {

    default void save(Prescription prescription) {
        Session instance = MySession.getInstance();
        instance.beginTransaction();
        instance.save(prescription);
        instance.getTransaction().commit();
        instance.close();
    }


    default void update(Prescription prescription) {
        Session instance = MySession.getInstance();
        instance.beginTransaction();
        instance.update(prescription);
        instance.getTransaction().commit();
        instance.close();
    }

    default Prescription findById(Long id) {
        Session instance = MySession.getInstance();
        instance.beginTransaction();
        Prescription prescription = (Prescription) instance.get(Prescription.class, id);
        instance.getTransaction().commit();
        instance.close();
        return prescription;
    }

    default List<Prescription> findAll() {
        Session instance = MySession.getInstance();
        instance.beginTransaction();
        List<Prescription> prescriptions = instance.createQuery("from Prescription").list();
        instance.getTransaction().commit();
        instance.close();
        return prescriptions;
    }

    default List<Prescription> findByUserId(Long id) {
        Session instance = MySession.getInstance();
        instance.beginTransaction();
        List<Prescription> prescriptions = instance.createQuery("from Prescription where userId=" + id).list();
        instance.getTransaction().commit();
        instance.close();
        return prescriptions;
    }

}
