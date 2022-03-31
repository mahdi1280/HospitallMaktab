package ir.maktab.service.reserve;

import ir.maktab.model.Reserve;
import ir.maktab.repository.ReserveRepository;

import java.util.List;

public class ReserveServiceImpl implements ReserveService {

    private final ReserveRepository reserveRepository;

    public ReserveServiceImpl() {
        this.reserveRepository = new ReserveRepository() {};
    }


    @Override
    public void add(Reserve reserve) {
        reserveRepository.save(reserve);
    }

    @Override
    public Reserve findById(Long id) {
        return reserveRepository.findById(id);
    }

    @Override
    public List<Reserve> findByUserId(Long id) {
        return reserveRepository.findByUserId(id);
    }

    @Override
    public void showAll() {
        List<Reserve> all = reserveRepository.findAll();
        for (Reserve reserve : all) {
            System.out.println(reserve);
        }
    }
}
