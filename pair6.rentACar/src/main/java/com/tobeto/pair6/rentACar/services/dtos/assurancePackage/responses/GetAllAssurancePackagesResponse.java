package com.tobeto.pair6.rentACar.services.dtos.assurancePackage.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAssurancePackagesResponse {

    private String name;

    private String detail;

    private Double dailyPrice;

}
