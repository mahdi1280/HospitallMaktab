package ir.maktab.repository;

import ir.maktab.model.Role;
import ir.maktab.model.User;
import org.junit.jupiter.api.Test;

class UserRepositoryTest {

    UserRepository userRepository = new UserRepository() {
    };

    @Test
    void save() {
        User user = User.builder()
                .password("123")
                .username("ali")
                .role(Role.USER)
                .build();
        userRepository.save(user);
    }

    @Test
    void findByUsername() {
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findByUsernameAndPassword() {
    }

    @Test
    void showAll() {
    }
}