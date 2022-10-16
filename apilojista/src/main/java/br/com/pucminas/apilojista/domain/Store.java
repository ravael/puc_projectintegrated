package br.com.pucminas.apilojista.domain;


import lombok.Builder;
import lombok.Data;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@With
@Table("store")
public class Store {

    @Id
    private Integer id;

    @NotNull
    @NotEmpty(message = "The name cannot be empty")
    private String name;

    @Column("zipcode")
    private Integer zipCode;

    private String address;

    private String city;

    private String state;

    @Column("ecommerceid")
    private Integer ecommerceId;

}
