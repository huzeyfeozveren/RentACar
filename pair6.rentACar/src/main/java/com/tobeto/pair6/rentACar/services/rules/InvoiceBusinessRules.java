package com.tobeto.pair6.rentACar.services.rules;

import com.tobeto.pair6.rentACar.repositories.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InvoiceBusinessRules {

    private final InvoiceRepository invoiceRepository;

    public void checkIfInvoiceByIdExists(Integer id) {
        if (!this.invoiceRepository.existsById(id)) {
            throw new RuntimeException("Verilen Invoice Id ile sistemde bir Invoice olmalıdır!");
        }
    }

}
