package com.tobeto.pair6.rentACar.repositories;

import com.tobeto.pair6.rentACar.entities.concretes.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

}
