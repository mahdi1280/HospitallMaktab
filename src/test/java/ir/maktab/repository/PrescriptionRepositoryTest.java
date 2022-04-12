package ir.maktab.repository;

import ir.maktab.model.Prescription;
import ir.maktab.model.Reserve;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrescriptionRepositoryTest {

    final PrescriptionRepository repository = new PrescriptionRepository(){};

    @Test
    void save() {
        Prescription build = Prescription.builder()
                .reserve(null)
                .description("alie e ")
                .build();
        repository.save(build);
    }

    @Test
    void update() {
        Prescription build = Prescription.builder()
                .reserve(null)
                .description("alie e ")
                .build();
        repository.save(build);
        repository.update(build);
    }

    @Test
    void findById() {
        Prescription byId = repository.findById(100L);
        assertNull(byId);
    }

    @Test
    void findAll() {
        repository.findAll();
    }

    @Test
    void findByUserId() {
        List<Prescription> byUserId = repository.findByUserId(100L);
        Assertions.assertEquals(Collections.emptyList(),byUserId);
    }
}