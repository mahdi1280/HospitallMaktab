package ir.maktab.repository;

import ir.maktab.model.Clinic;
import ir.maktab.model.Doctor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

class DoctorRepositoryTest {

    final DoctorRepository doctorRepository = new DoctorRepository() {
    };

    @Test
    void findAll() {
        doctorRepository.findAll();
    }

    @Test
    void findById() {
        Doctor byId = doctorRepository.findById(100);
        Assertions.assertNull(byId);
    }

    @Test
    void findByName() {
        doctorRepository.findByName("Ali");
    }

    @Test
    void save() {
        Doctor doctor = Doctor.builder()
                .clinics(Collections.singletonList(new Clinic("das")))
                .name("asdasd")
                .build();
        doctorRepository.save(doctor);
    }

    @Test
    void delete() {
        doctorRepository.delete(new Doctor());
    }

    @Test
    void update(){
        Doctor doctor = Doctor.builder()
                .clinics(Collections.singletonList(new Clinic("das")))
                .name("asdasd")
                .build();
        doctorRepository.save(doctor);
        doctor.setName("asdasd");
        doctorRepository.update(doctor);
        Doctor byId = doctorRepository.findById(doctor.getId());
        Assertions.assertEquals(doctor.getName(),byId.getName());
    }
}