package ru.zulvit.teamentropy.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ru.zulvit.teamentropy.DTO.ProductDTO;
import ru.zulvit.teamentropy.entity.Product;
import ru.zulvit.teamentropy.entity.User;
import ru.zulvit.teamentropy.mappers.ProductMapper;
import ru.zulvit.teamentropy.repositories.ProductRepository;
import ru.zulvit.teamentropy.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    private final UserRepository userRepository;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.userRepository = userRepository;
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(String name) {
        if(productRepository.findById(name).isPresent())
            return productMapper.toDTO(productRepository.findById(name).get());
        else
            throw new IllegalArgumentException("Ошибка: нет такого id");
    }

    public ProductDTO updateProduct(ProductDTO updatedProduct, String name) {
        return productRepository.findById(name)
                .map(product -> {
                    product.setReleaseDate(updatedProduct.getReleaseDate());
                    product.setVersion(updatedProduct.getVersion());
                    product.setPrice(updatedProduct.getPrice());
                    product.setPack(updatedProduct.getPack());
                    product.setStudentDiscounts(updatedProduct.isStudentsDiscount());
                    product.setSpecialDiscounts(updatedProduct.isSpecialDiscounts());
                    return  productMapper.toDTO(productRepository.save(product));
                })
                .orElseThrow(() -> new IllegalArgumentException("Ошибка: невозможно обновить продукт"));
    }

    public ProductDTO saveProduct(ProductDTO product) {
        Product temp = productMapper.toEntity(product);
        User user = userRepository.findById(product.getUserId()).
                orElseThrow(EntityNotFoundException::new);
        temp.setUser(user);
        return  productMapper.toDTO(productRepository.save(temp));

    }

    public void deleteProduct(String name) {productRepository.deleteById(name);}
}
