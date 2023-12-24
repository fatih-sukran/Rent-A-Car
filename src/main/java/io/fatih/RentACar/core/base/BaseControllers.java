package io.fatih.RentACar.core.base;

import io.fatih.RentACar.business.abstracts.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
public class BaseControllers<E, S extends BaseService<E>> {
    private final S service;


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        service.delete(id);

        return ResponseEntity.ok("deleted");
    }

    @GetMapping("/{id}")
    public ResponseEntity<E> getById(@PathVariable long id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
