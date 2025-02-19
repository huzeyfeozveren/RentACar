package com.tobeto.pair6.rentACar.services.concretes;

import com.tobeto.pair6.rentACar.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair6.rentACar.core.utilities.results.DataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.Result;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessDataResult;
import com.tobeto.pair6.rentACar.core.utilities.results.SuccessResult;
import com.tobeto.pair6.rentACar.entities.concretes.AdditionalFeature;
import com.tobeto.pair6.rentACar.repositories.AdditionalFeatureRepository;
import com.tobeto.pair6.rentACar.services.abstracts.AdditionalFeatureService;
import com.tobeto.pair6.rentACar.services.dtos.additionalFeature.requests.AddAdditionalFeatureRequest;
import com.tobeto.pair6.rentACar.services.dtos.additionalFeature.requests.DeleteAdditionalFeatureRequest;
import com.tobeto.pair6.rentACar.services.dtos.additionalFeature.requests.UpdateAdditionalFeatureRequest;
import com.tobeto.pair6.rentACar.services.dtos.additionalFeature.responses.GetAllAdditionalFeaturesResponse;
import com.tobeto.pair6.rentACar.services.dtos.additionalFeature.responses.GetByIdAdditionalFeatureResponse;
import com.tobeto.pair6.rentACar.services.rules.AdditionalFeatureBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdditionalFeatureManager implements AdditionalFeatureService {

    private final AdditionalFeatureRepository additionalFeatureRepository;

    private final ModelMapperService modelMapperService;

    private final AdditionalFeatureBusinessRules additionalFeatureBusinessRules;

    @Override
    public Result add(AddAdditionalFeatureRequest addAdditionalFeatureRequest) {

        AdditionalFeature additionalFeature = this.modelMapperService.forRequest()
                .map(addAdditionalFeatureRequest, AdditionalFeature.class);
        additionalFeature.setId(null);

        this.additionalFeatureRepository.save(additionalFeature);

        return new SuccessResult("Ek özellik eklendi!");

    }

    @Override
    public Result delete(DeleteAdditionalFeatureRequest deleteAdditionalFeatureRequest) {

        this.additionalFeatureBusinessRules.checkIfAdditionalFeatureByIdExists(deleteAdditionalFeatureRequest.getId());

        AdditionalFeature additionalFeature = this.modelMapperService.forRequest()
                .map(deleteAdditionalFeatureRequest, AdditionalFeature.class);

        this.additionalFeatureRepository.delete(additionalFeature);

        return new SuccessResult("Ek özellik silindi!");

    }

    @Override
    public Result update(UpdateAdditionalFeatureRequest updateAdditionalFeatureRequest) {

        this.additionalFeatureBusinessRules.checkIfAdditionalFeatureByIdExists(updateAdditionalFeatureRequest.getId());

        AdditionalFeature additionalFeature = this.modelMapperService.forRequest()
                .map(updateAdditionalFeatureRequest, AdditionalFeature.class);

        this.additionalFeatureRepository.save(additionalFeature);

        return new SuccessResult("Ek özellik güncellendi!");

    }

    @Override
    public DataResult<List<GetAllAdditionalFeaturesResponse>> getAll() {

        List<AdditionalFeature> additionalFeatures = this.additionalFeatureRepository.findAll();

        List<GetAllAdditionalFeaturesResponse> additionalFeaturesResponse = additionalFeatures.stream()
                .map(additionalFeature -> this.modelMapperService.forResponse().map(additionalFeature, GetAllAdditionalFeaturesResponse.class)).toList();

        return new SuccessDataResult<>(additionalFeaturesResponse, "Tüm ek özellikler listelendi!");

    }

    @Override
    public DataResult<GetByIdAdditionalFeatureResponse> getById(Integer id) {

        this.additionalFeatureBusinessRules.checkIfAdditionalFeatureByIdExists(id);

        GetByIdAdditionalFeatureResponse response = this.modelMapperService.forResponse()
                .map(additionalFeatureRepository.findById(id), GetByIdAdditionalFeatureResponse.class);

        return new SuccessDataResult<>(response, "Ek özellik listelendi!");

    }

}
