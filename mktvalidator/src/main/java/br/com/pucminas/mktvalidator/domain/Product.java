package br.com.pucminas.mktvalidator.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotNull;

@Data
@Builder
@With
@Table("product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
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
