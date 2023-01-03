package com.CGIEXAM.cgiexam.repository;

import com.CGIEXAM.cgiexam.model.CareerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CareerRepository extends JpaRepository<CareerModel, Integer> {
}
