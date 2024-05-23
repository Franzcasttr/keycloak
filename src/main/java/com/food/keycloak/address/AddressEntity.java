package com.food.keycloak.address;

import com.food.keycloak.address.utils.AddressType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String user_id;
   private String name;
   @Column(name = "mobile_number")
   private String mobilenumber;
   private String street;
   private String province;
   private String city;
   private String barangay;
   private Integer postalcode;
   @Enumerated(EnumType.STRING)
   @Column(name = "address_type", nullable = false)
   private AddressType addresstype;

    @Column(updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

}
