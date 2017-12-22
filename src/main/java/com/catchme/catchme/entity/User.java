package com.catchme.catchme.entity;


import lombok.*;
import lombok.experimental.Builder;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "userId")
    private Long userId;

    @Column(name = "deviceId", nullable = false, unique = true)
    private String deviceId;

    @Column(name = "token", nullable = false, unique = true)
    private String token;
}
