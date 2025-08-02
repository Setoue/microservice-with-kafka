package com.setoue.store_car.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="car_post")
public class CarPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="car_model")
    private String model;

    @Column(name="car_brand")
    private String brand;

    @Column(name="car_price")
    private Double price;

    @Column(name="car_description")
    private String description;

    @Column(name="car_engine_version")
    private String engineVersion;

    @Column(name="car_city")
    private String city;

    @Column(name="car_created_date")
    private String createdDate;

    @Column(name="car_owner_id")
    private Long ownerId;

    @Column(name="car_owner_name")
    private String ownerName;

    @Column(name="car_owner_type")
    private String ownerType;

    @Column(name="car_post_contact")
    private String contact;

    @ManyToOne
    @JoinColumn(name = "owner_post_id", nullable = false, referencedColumnName = "id")
    private OwnerPostEntity ownerPost;
}
