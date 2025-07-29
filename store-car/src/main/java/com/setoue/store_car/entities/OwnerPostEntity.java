package com.setoue.store_car.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "owner_post")
@Data
@NoArgsConstructor
public class OwnerPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(name = "owner_type")
    private String type;

    @Column(name = "owner_contact_number")
    private String contactNumber;
}
