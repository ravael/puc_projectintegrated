package br.com.pucminas.mktvalidator.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@With
@Table("store")
@NoArgsConstructor
@AllArgsConstructor
public class Store {

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
