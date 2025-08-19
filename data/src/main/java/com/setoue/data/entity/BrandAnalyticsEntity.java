package com.setoue.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "brand_analytics")
@Data
@NoArgsConstructor
public class BrandAnalyticsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand;

    private Long posts;

}
