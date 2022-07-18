package com.example.product.controller.dto;

import com.example.product.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;

    @NotNull @NotEmpty
    private String code;

    @NotNull @NotEmpty @Length(min = 5)
    private String name;

    @NotNull @NotEmpty @Length(min = 10)
    private String description;

    @NotNull
    private BigDecimal price;

    private Boolean status;

    public Product convert(Long id) {
        return new Product(id, this.code, this.name,
                this.description, this.price, LocalDateTime.now(), false);
    }

    public Product convertWithNoId() {
        return new Product(this.id, this.code, this.name,
                this.description, this.price, LocalDateTime.now(), this.status);
    }
}
