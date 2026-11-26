package kh.edu.istad.restapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "m2_customers")

public class Customer {
    @Id
    private UUID id;
    @Column(nullable = false, unique = true, length = 12)
    private String phoneNumber;
    @Column(nullable = false, unique = true, length = 60)
    private String email;
    private String address;
    @Column(nullable = false)
    private Boolean isDeleted;

    @OneToOne
    private User user;

}

