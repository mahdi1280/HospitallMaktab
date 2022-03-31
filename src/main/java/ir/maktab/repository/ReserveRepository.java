package ir.maktab.repository;

import ir.maktab.model.Reserve;
import ir.maktab.session.MySession;
import org.hibernate.Session;

import java.util.List;

public interface ReserveRepository {

    default List<Reserve> findAll(){
        Session instance = MySession.getInstance();
        List<Reserve> reserves = instance.createQuery("from Reserve").list();
        instance.close();
        return reserves;
    }

    default Reserve findById(Long id){
        Session instance = MySession.getInstance();
        Reserve reserve = instance.get(Reserve.class, id);
        instance.close();
        return reserve;
    }

    default void save(Reserve reserve){
        Session instance = MySession.getInstance();
        instance.beginTransaction();
        instance.save(reserve);
        instance.getTransaction().commit();
        instance.close();
    }

    default void update(Reserve reserve){
        Session instance = MySession.getInstance();
        instance.beginTransaction();
        instance.update(reserve);
        instance.getTransaction().commit();
        instance.close();
    }

    default void delete(Reserve reserve){
        Session instance = MySession.getInstance();
        instance.beginTransaction();
        instance.delete(reserve);
        instance.getTransaction().commit();
        instance.close();
    }

    default List<Reserve> findByUserId(Long userId){
        Session instance = MySession.getInstance();
        List<Reserve> reserves = instance.createQuery("from Reserve where userId = :userId")
                .setParameter("userId", userId)
                .list();
        instance.close();
        return reserves;
    }


}