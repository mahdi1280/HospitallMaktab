package ir.maktab.service.doctor;

import ir.maktab.model.Doctor;
import ir.maktab.repository.DoctorRepository;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl() {
        this.doctorRepository = new DoctorRepository() {};
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        doctorRepository.update(doctor);
    }

    @Override
    public void deleteDoctor(Doctor doctor) {
        doctorRepository.delete(doctor);
    }

    @Override
    public Doctor findDoctorById(long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public List<Doctor> findDoctorByName(String name) {
        return doctorRepository.findByName(name);
    }

    @Override
    public void showAllDoctors() {
        List<Doctor> all = doctorRepository.findAll();
        for (Doctor doctor : all) {
            System.out.println(doctor);
        }
    }
}
