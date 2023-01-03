package com.CGIEXAM.cgiexam.service;

import com.CGIEXAM.cgiexam.model.CareerModel;
import com.CGIEXAM.cgiexam.repository.CareerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CareerService {

    private final CareerRepository careerRepository;

    public CareerService(CareerRepository careerRepository){
        this.careerRepository = careerRepository;
    }

    public CareerModel addCareer(String name, String description, String targetDate, String completedDate){
        if(name == null && description == null && targetDate == null && completedDate == null) {
            return null;
        }else {

            CareerModel careerModel = new CareerModel();
            careerModel.setName(name);
            careerModel.setDescription(description);
            careerModel.setTargetDate(targetDate);
            careerModel.setCompletedDate(completedDate);
            return careerRepository.save(careerModel);
        }
    }
    public CareerModel editCareer(String name, String description, String targetDate, String completedDate){
        if(name == null && description == null && targetDate == null && completedDate == null) {
            return null;
        }else {

            CareerModel careerModel = new CareerModel();
            careerModel.setName(name);
            careerModel.setDescription(description);
            careerModel.setTargetDate(targetDate);
            careerModel.setCompletedDate(completedDate);
            return careerRepository.save(careerModel);
        }
    }

    public CareerModel editEntry(Integer ID, String name, String description, String targetDate, String completedDate){
        if(name == null && description == null && targetDate == null && completedDate == null) {
            return null;
        }else {

            CareerModel careerModel = careerRepository.findById(ID).orElse(null);
            careerModel.setName(name);
            careerModel.setDescription(description);
            careerModel.setTargetDate(targetDate);
            careerModel.setCompletedDate(completedDate);
            return careerRepository.save(careerModel);

        }
    }


    public List<CareerModel> getAll(){
        return careerRepository.findAll();
    }

    public void delete(Integer id){
        careerRepository.deleteById(id);
    }

    public void save(CareerModel careerModel){
        careerRepository.save(careerModel);
    }

    public CareerModel getById(Integer id) {
        return careerRepository.findById(id).orElse(null);
    }
}
