package com.catchme.catchme.common;

import lombok.*;
import lombok.experimental.Builder;
import org.springframework.http.HttpStatus;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class StateMain {
    private Long userId;
    private Long gameLeftRecord;
    private Long gameRightRecord;
    private HttpStatus status;
}
