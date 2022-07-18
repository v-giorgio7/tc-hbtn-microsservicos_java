package com.example.product.controller;

import com.example.product.controller.dto.ProductDto;
import com.example.product.exception.InvalidProductInformation;
import com.example.product.exception.ProductNotFoundException;
import com.example.product.model.Product;
import com.example.product.model.ProductRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    ProductRepository productRepository = new ProductRepository();

    @GetMapping("/welcome")
    @ApiOperation(value = "Responsável por retornar uma mensagem de boas vindas.")
    public String mensagemBoasVindas() {
        return "BEM VINDO À PRODUCT REST API.";
    }

    @GetMapping("/allProducts")
    @ApiOperation(value = "Responsável por retornar uma lista de produtos.")
    @ApiResponses(value = {
            @ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products.")
    })
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @GetMapping("/findProductById/{id}")
    @ApiOperation(value = "Responsável por retornar um produto pelo id.")
    @ApiResponses(value = {
            @ApiResponse(code = 12, message = "The field id not informed. This information is required.")
    })
    public Product findProductById(@PathVariable Long id) {
        try {
            return productRepository.getProductById(id);
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/addProduct")
    @ApiOperation(value = "Responsável por adicionar um produto.")
    @ApiResponses(value = {
            @ApiResponse(code = 10, message = "Required fields not informed.")
    })
    public void addProduct(@RequestBody @Valid ProductDto productDto) {
        try {
            productRepository.addProduct(productDto);
        } catch (InvalidProductInformation e) {
            System.out.println(e.getMessage());
        }
    }

    @PutMapping("/updateProduct")
    @ApiOperation(value = "Responsável por atualizar um produto.")
    @ApiResponses(value = {
            @ApiResponse(code = 14,
                    message = "No information has been updated. The new information is the same as recorded in the database.")
    })
    public void updateProduct(@RequestBody @Valid ProductDto productDto) {
        try {
            productRepository.updateProduct(productDto);
        } catch (ProductNotFoundException | InvalidProductInformation e) {
            System.out.println(e.getMessage());
        }
    }

    @DeleteMapping("/removeProduct")
    @ApiOperation(value = "Responsável por remover um produto.")
    @ApiResponses(value = {
            @ApiResponse(code = 13, message = "User not allowed to remove a product from this category.")
    })
    public void deleteProductById(@RequestParam Long id) {
        try {
            productRepository.removeProduct(id);
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
