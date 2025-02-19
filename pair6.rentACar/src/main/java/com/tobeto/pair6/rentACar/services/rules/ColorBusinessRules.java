package com.tobeto.pair6.rentACar.services.rules;

import com.tobeto.pair6.rentACar.repositories.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ColorBusinessRules {

    private final ColorRepository colorRepository;

    public void checkIfColorByNameExists(String name) {
        if (this.colorRepository.existsByName(name)) {
            throw new RuntimeException("Aynı renk 2. kez eklenemez!");
        }
    }

    public void checkIfColorByIdExists(Integer id) {
        if (!this.colorRepository.existsById(id)) {
            throw new RuntimeException("Verilen Color Id ile sistemde bir Color olmalıdır!");
        }
    }

}
