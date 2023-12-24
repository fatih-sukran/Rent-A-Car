package io.fatih.RentACar.business.abstracts;

import java.util.List;

public interface BaseService<T> {
    List<T> getAll();
    T getById(long id);
    void add(T t);

    void delete(long id);
}
