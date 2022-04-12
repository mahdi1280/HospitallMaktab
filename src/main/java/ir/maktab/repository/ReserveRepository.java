package ir.maktab.repository;

import ir.maktab.model.Reserve;
import ir.maktab.model.Time;
import ir.maktab.session.MySession;
import org.hibernate.Session;

import java.util.List;

public interface ReserveRepository {

    default List<Reserve> findAll() {
        Session instance = MySession.getInstance();
        return instance.createQuery("select r from Reserve r",Reserve.class)
                .getResultList();
    }

    default Reserve findById(Long id) {
        Session instance = MySession.getInstance();
        Reserve reserve = instance.get(Reserve.class, id);
        instance.close();
        return reserve;
    }

    default void save(Reserve reserve) {
        Session instance = MySession.getInstance();
        instance.beginTransaction();
        instance.save(reserve);
        instance.getTransaction().commit();
        instance.close();
    }

    default void update(Reserve reserve) {
        Session instance = MySession.getInstance();
        instance.beginTransaction();
        instance.update(reserve);
        instance.getTransaction().commit();
        instance.close();
    }

    default void delete(Reserve reserve) {
        Session instance = MySession.getInstance();
        instance.beginTransaction();
        instance.delete(reserve);
        instance.getTransaction().commit();
        instance.close();
    }

    default List<Reserve> findByUserId(Long userId) {
        Session instance = MySession.getInstance();
        return instance.createQuery("select r from Reserve r where r.user.id = :userId", Reserve.class)
                .setParameter("userId", userId)
                .list();
    }


    default Reserve findByDoctorIdAndTime(long id2, Time time) {
        Session instance = MySession.getInstance();
        Reserve reserve = instance.createQuery("select r From Reserve r where r.doctor.id = :doctorId and r.time = :time", Reserve.class)
                .setParameter("doctorId", id2)
                .setParameter("time", time)
                .uniqueResult();
        instance.close();
        return reserve;
    }
}
