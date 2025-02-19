package com.tobeto.pair6.rentACar.controllers;

import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.services.abstracts.AssurancePackageService;
import com.tobeto.pair6.rentACar.services.dtos.assurancePackage.requests.AddAssurancePackageRequest;
import com.tobeto.pair6.rentACar.services.dtos.assurancePackage.requests.DeleteAssurancePackageRequest;
import com.tobeto.pair6.rentACar.services.dtos.assurancePackage.requests.UpdateAssurancePackageRequest;
import com.tobeto.pair6.rentACar.services.dtos.assurancePackage.responses.GetAllAssurancePackagesResponse;
import com.tobeto.pair6.rentACar.services.dtos.assurancePackage.responses.GetByIdAssurancePackageResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assurancePackages")
@AllArgsConstructor
@CrossOrigin
public class AssurancePackagesController {

    private final AssurancePackageService assurancePackageService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddAssurancePackageRequest addAssurancePackageRequest) {

        return this.assurancePackageService.add(addAssurancePackageRequest);

    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody @Valid DeleteAssurancePackageRequest deleteAssurancePackageRequest) {

        return this.assurancePackageService.delete(deleteAssurancePackageRequest);

    }

    @PutMapping("/update")
    public Result update(@RequestBody @Valid UpdateAssurancePackageRequest updateAssurancePackageRequest) {

        return this.assurancePackageService.update(updateAssurancePackageRequest);

    }

    @GetMapping("/getAll")
    public DataResult<List<GetAllAssurancePackagesResponse>> getAll() {

        return this.assurancePackageService.getAll();

    }

    @GetMapping("/getById/{id}")
    public DataResult<GetByIdAssurancePackageResponse> getById(@PathVariable Integer id) {

        return this.assurancePackageService.getById(id);

    }

}
