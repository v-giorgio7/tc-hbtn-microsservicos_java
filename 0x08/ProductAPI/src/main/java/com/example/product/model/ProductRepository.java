package com.example.product.model;

import com.example.product.controller.dto.ProductDto;
import com.example.product.exception.InvalidProductInformation;
import com.example.product.exception.ProductNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ProductRepository {

    private List<Product> list = new ArrayList<Product>();
    private Long defaultId = 1L;

    public List<Product> getAllProducts() {
        return this.list;
    }

    public Product getProductById(Long id) throws ProductNotFoundException {
        Optional<Product> product = this.list
                .stream()
                .filter(p -> Objects.equals(id, p.getId()))
                .findFirst();

        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ProductNotFoundException("Produto não encontrado");
        }
    }

    public void addProduct(ProductDto s) throws InvalidProductInformation {
        if (s != null) {
            Product product  = s.convert(this.defaultId++);
            this.list.add(product);
        } else {
            throw new InvalidProductInformation("Insira os dados do produto corretamente");
        }
    }

    public void updateProduct(ProductDto s) throws ProductNotFoundException, InvalidProductInformation {
        if (s == null) {
            throw new InvalidProductInformation("Insira os dados do produto corretamente");
        }

        Product prodEntity  = s.convertWithNoId();
        Optional<Product> product = this.list
                .stream()
                .filter(p -> p.getId().equals(prodEntity.getId()))
                .findFirst();

        if (product.isPresent()) {
            int productIndex = this.list.indexOf(product.get());
            this.list.remove(productIndex);
            this.list.add(productIndex, prodEntity);
        } else {
            throw new ProductNotFoundException("Produto com id " + prodEntity.getId() + " não encontrado");
        }
    }

    public void removeProduct(Long id) throws ProductNotFoundException {
        Optional<Product> product = this.list
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();

        if (product.isPresent()) {
            this.list.remove(product.get());
        } else {
            throw new ProductNotFoundException("Produto com id " + id + " não encontrado");
        }
    }

    public void addList(List<Product> listOfProducts) {
        this.list.addAll(listOfProducts);
    }
}
