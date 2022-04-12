package ir.maktab.repository;

import ir.maktab.model.Role;
import ir.maktab.model.User;
import org.junit.jupiter.api.Assertions;
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
        User ali = userRepository.findByUsername("daqewdsfdsfertertali");
        Assertions.assertNull(ali);
    }

    @Test
    void findById() {
        User byId = userRepository.findById(1000L);
        Assertions.assertNull(byId);
    }

    @Test
    void update() {
        User user = User.builder()
                .password("123")
                .username("ali")
                .role(Role.USER)
                .build();
        userRepository.save(user);
        userRepository.update(user);
    }

    @Test
    void delete() {
        userRepository.delete(new User());
    }

    @Test
    void findByUsernameAndPassword() {
        User ali = userRepository.findByUsernameAndPassword("erwerw", "wer234234234");
        Assertions.assertNull(ali);
    }
}