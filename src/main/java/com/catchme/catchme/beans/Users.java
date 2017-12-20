package com.catchme.catchme.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Entity
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue
    @Column(name = "userId")
    private Long userId;

    @Column(name = "deviceId", nullable = false, unique = true)
    private String deviceId;

    @Column(name = "token", nullable = false, unique = true)
    private String token;
}
