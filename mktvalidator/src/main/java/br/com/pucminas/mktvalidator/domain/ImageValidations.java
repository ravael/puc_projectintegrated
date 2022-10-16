package br.com.pucminas.mktvalidator.domain;


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
@Table("imagevalidation")
public class ImageValidations {

    @Id
    @NotNull
    private Integer id;

    @NotNull
    private String url;

    private Integer width;

    private String height;

    @Column("ecommerceid")
    private Integer ecommerceId;

}
