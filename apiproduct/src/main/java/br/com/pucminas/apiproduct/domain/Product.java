package br.com.pucminas.apiproduct.domain;

import lombok.Builder;
import lombok.Data;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotNull;

@Data
@Builder
@With
@Table("product")
public class Product {

    @Id
    @NotNull
    private Integer id;

    private Integer sku;

    private String name;

    private String category;

    private String image;

    @Column("ecommerceid")
    private Integer ecommerceId;

    @Column("available")
    private boolean isAvailable;

}
