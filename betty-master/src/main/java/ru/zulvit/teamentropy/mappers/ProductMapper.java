package ru.zulvit.teamentropy.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.zulvit.teamentropy.DTO.ProductDTO;
import ru.zulvit.teamentropy.entity.Product;

@Component
public class ProductMapper {
    private final org.modelmapper.ModelMapper productMap;

    @Autowired
    public ProductMapper(org.modelmapper.ModelMapper productMap) { this.productMap = productMap; }

    public ProductDTO toDTO(Product input) {
        return productMap.map(input, ProductDTO.class);
    }

    public Product toEntity(ProductDTO input) {
        return productMap.map(input, Product.class);
    }
}