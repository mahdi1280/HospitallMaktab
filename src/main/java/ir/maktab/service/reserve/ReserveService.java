package ir.maktab.service.reserve;

import ir.maktab.model.Reserve;

import java.util.List;

public interface ReserveService {

    void add(Reserve reserve);

    Reserve findById(Long id);

    List<Reserve> findByUserId(Long id);

    void showAll();

}
