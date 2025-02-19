package com.tobeto.pair6.rentACar.services.dtos.car.requests;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCarRequest {

    @Positive(message = "Doğru Id girişi yapınız!")
    private Integer id;

}
