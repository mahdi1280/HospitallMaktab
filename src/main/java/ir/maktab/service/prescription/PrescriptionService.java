package ir.maktab.service.prescription;

import ir.maktab.model.Prescription;

import java.util.List;

public interface PrescriptionService {

    void save(Prescription prescription);

    Prescription findById(Long id);

    void update(Prescription prescription);

    void findAll();

    void findByUserId(Long userId);
}
