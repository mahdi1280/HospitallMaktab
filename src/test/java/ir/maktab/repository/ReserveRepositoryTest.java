package ir.maktab.repository;

import ir.maktab.model.Reserve;
import ir.maktab.model.Time;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

class ReserveRepositoryTest {

    final ReserveRepository reserveRepository = new ReserveRepository() {
    };

    @Test
    void findAll() {
        reserveRepository.findAll();
    }

    @Test
    void findById() {
        Reserve byId = reserveRepository.findById(200L);
        assertNull(byId);
    }

    @Test
    void save() {
        Reserve build = Reserve.builder()
                .doctor(null)
                .time(Time.NOON)
                .user(null)
                .build();
        reserveRepository.save(build);
    }

    @Test
    void update() {
        Reserve build = Reserve.builder()
                .doctor(null)
                .time(Time.NOON)
                .user(null)
                .build();
        reserveRepository.save(build);
        reserveRepository.update(build);
    }

    @Test
    void delete() {
        reserveRepository.delete(new Reserve());
    }

    @Test
    void findByUserId() {
        reserveRepository.findByUserId(1L);
    }

    @Test
    void findByDoctorIdAndTime() {
        reserveRepository.findByDoctorIdAndTime(1L, Time.NOON);
    }
}