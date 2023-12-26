package io.fatih.RentACar.tests.databuilder;

import io.fatih.RentACar.entities.Brand;

public class BrandBuilder {

    public static Brand createBrandWithId(long id) {
        Brand brand = new Brand();
        brand.setId(id);
        brand.setName("BMW");
        return brand;
    }
}
