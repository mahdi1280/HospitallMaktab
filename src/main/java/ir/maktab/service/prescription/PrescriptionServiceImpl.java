package ir.maktab.service.prescription;

import ir.maktab.model.Prescription;
import ir.maktab.repository.PrescriptionRepository;

import java.util.List;

public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionServiceImpl() {
        this.prescriptionRepository = new PrescriptionRepository() {};
    }

    @Override
    public void save(Prescription prescription) {
        prescriptionRepository.save(prescription);
    }

    @Override
    public Prescription findById(Long id) {
        return prescriptionRepository.findById(id);
    }

    @Override
    public void update(Prescription prescription) {
        prescriptionRepository.update(prescription);
    }

    @Override
    public void findAll() {
        List<Prescription> all = prescriptionRepository.findAll();
        for (Prescription prescription : all) {
            System.out.println(prescription);
        }
    }

    @Override
    public void findByUserId(Long userId) {
        List<Prescription> all = prescriptionRepository.findByUserId(userId);
        for (Prescription prescription : all) {
            System.out.println(prescription);
        }
    }
}
