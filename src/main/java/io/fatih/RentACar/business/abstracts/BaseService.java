package io.fatih.RentACar.business.abstracts;

import java.util.List;

public interface BaseService<T> {
    List<T> getAll();
    void add(T t);

}
