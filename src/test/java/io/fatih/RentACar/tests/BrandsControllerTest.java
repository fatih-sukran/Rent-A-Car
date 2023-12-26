package io.fatih.RentACar.tests;

import io.fatih.RentACar.business.concretes.BrandManager;
import io.fatih.RentACar.business.rules.BrandBusinessRules;
import io.fatih.RentACar.core.utilities.exceptions.BusinessRulesException;
import io.fatih.RentACar.service.BrandRepository;
import io.fatih.RentACar.tests.databuilder.BrandBuilder;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class BrandsControllerTest {
    @Mock
    private BrandRepository brandRepository;
    @Mock
    private BrandBusinessRules brandBusinessRules;
    @InjectMocks
    private BrandManager brandManager;

    @Test
    void getAll() {
        var brand = BrandBuilder.createBrandWithId(1L);
        Mockito.when(brandRepository.findAll()).thenReturn(List.of(brand));

        var result = brandManager.getAll();

        Mockito.verify(brandRepository).findAll();
        assertThat(result).isEqualTo(List.of(brand));
    }

    @Test
    void getById_validId() {
        var id = 1L;
        var brand = BrandBuilder.createBrandWithId(id);

        Mockito.when(brandRepository.getReferenceById(id)).thenReturn(brand);

        var result = brandManager.getById(id);
        Mockito.verify(brandRepository).getReferenceById(id);

        assertThat(result).isEqualTo(brand);
    }

    @Test
    void getById_invalidId() {
        var id = -1L;

        Mockito.when(brandRepository.getReferenceById(id)).thenThrow(EntityNotFoundException.class);

        assertThrows(EntityNotFoundException.class, () -> brandManager.getById(id));
        Mockito.verify(brandRepository).getReferenceById(id);
    }

    @Test
    void add_validBrand() {
        var brand = BrandBuilder.createBrandWithId(1L);

        Mockito.when(brandRepository.save(brand)).thenReturn(brand);

        brandManager.add(brand);

        Mockito.verify(brandRepository).save(brand);
        Mockito.verify(brandBusinessRules).checkIfBrandNameExists(brand.getName());
    }

    @Test
    void add_invalidBrand() {
        var brand = BrandBuilder.createBrandWithId(1L);
        Mockito.doThrow(BusinessRulesException.class).when(brandBusinessRules).checkIfBrandNameExists(brand.getName());

        assertThrows(BusinessRulesException.class, () -> brandManager.add(brand));

        Mockito.verify(brandBusinessRules).checkIfBrandNameExists(brand.getName());
        Mockito.verify(brandRepository, Mockito.never()).save(brand);
    }

    @Test
    void delete_validId() {
        var id = 1L;
        Mockito.doNothing().when(brandRepository).deleteById(id);

        brandManager.delete(id);

        Mockito.verify(brandRepository).deleteById(id);
    }

    @Test
    void delete_invalidId() {
        var id = -1L;
        Mockito.doThrow(IllegalArgumentException.class).when(brandRepository).deleteById(id);

        assertThrows(IllegalArgumentException.class, () -> brandManager.delete(id));

        Mockito.verify(brandRepository).deleteById(id);
    }

}
