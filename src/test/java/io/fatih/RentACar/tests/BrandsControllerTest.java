package io.fatih.RentACar.tests;

import io.fatih.RentACar.business.concretes.BrandManager;
import io.fatih.RentACar.business.rules.BrandBusinessRules;
import io.fatih.RentACar.entities.Brand;
import io.fatih.RentACar.service.BrandRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
    void getAllBrands_ReturnsAllBrands() {
        var id = 1L;
        var brand = new Brand();
        brand.setId(id);
        brand.setName("Test Brand");

        Mockito.when(brandRepository.getReferenceById(id)).thenReturn(brand);

        var result = brandManager.getById(id);
        Mockito.verify(brandRepository).getReferenceById(id);

        assertThat(result).isEqualTo(brand);
    }
}
