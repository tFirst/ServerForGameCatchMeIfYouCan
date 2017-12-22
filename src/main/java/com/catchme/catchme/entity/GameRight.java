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
@Table(name = "GameRight")
public class GameRight {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "userId", nullable = false, unique = true)
    private Long userId;

    @Column(name = "recordValue", nullable = false)
    private Long recordValue;
}

