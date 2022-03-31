package ir.maktab.service.user;

import ir.maktab.model.User;

public interface UserService {

    void save(User user);

    void update(User user);

    void delete(User user);

    User findById(Long id);

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

}
