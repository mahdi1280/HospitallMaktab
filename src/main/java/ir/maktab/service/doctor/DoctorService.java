package ir.maktab.service.doctor;

import ir.maktab.model.Doctor;

import java.util.List;

public interface DoctorService {

    void addDoctor(Doctor doctor);

    void updateDoctor(Doctor doctor);

    void deleteDoctor(Doctor doctor);

    Doctor findDoctorById(long id);

    List<Doctor> findDoctorByName(String name);

    void showAllDoctors();
}
