package ir.maktab.repository;

import ir.maktab.model.User;
import ir.maktab.session.MySession;
import org.hibernate.Session;

import java.util.List;

public interface UserRepository {

    default void save(User user) {
        Session instance = MySession.getInstance();
        instance.beginTransaction();
        instance.save(user);
        instance.getTransaction().commit();
    }

    default User findByUsername(String username) {
        Session instance = MySession.getInstance();
        List<User> username1 = instance.createQuery("select u from User u where u.username = :username", User.class)
                .setParameter("username", username)
                .getResultList();
        if(username1.isEmpty())
            return null;
        return username1.get(0);
    }

    default User findById(Long id) {
        Session instance = MySession.getInstance();
        List<User> id1 = instance.createQuery("select u from User u where u.id = :id", User.class)
                .setParameter("id", id).getResultList();
        if (id1.isEmpty())
            return null;
        return id1.get(0);
    }

    default void update(User user) {
        Session instance = MySession.getInstance();
        instance.beginTransaction();
        instance.update(user);
        instance.getTransaction().commit();
    }

    default void delete(User user) {
        Session instance = MySession.getInstance();
        instance.beginTransaction();
        instance.delete(user);
        instance.getTransaction().commit();
    }

    default User findByUsernameAndPassword(String username, String password) {
        Session instance = MySession.getInstance();
        List<User> resultList = instance.createQuery("select u from User u where u.username=:username and u.password=:password", User.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultList();
        if (resultList.size() == 0)
            return null;
        return resultList.get(0);
    }

    default List<User> showAll() {
        Session instance = MySession.getInstance();
        instance.beginTransaction();
        List<User> users = instance.createQuery("from User").getResultList();
        instance.getTransaction().commit();
        return users;
    }
}
