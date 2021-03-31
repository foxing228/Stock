package com.example.stock.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Builder
@EqualsAndHashCode
@Setter
@Getter
@Entity
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private BigDecimal price;

    private Double weight;


}
