package ir.maktab.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySession {

    private static class MySessionHolder {
        private static final SessionFactory INSTANCE = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static Session getInstance() {
        return MySessionHolder.INSTANCE.openSession();
    }

}
