package com.scasmar.carregistry.controller.mapper;

import com.scasmar.carregistry.controller.dto.CarRequest;
import com.scasmar.carregistry.controller.dto.CarResponse;
import com.scasmar.carregistry.model.Brand;
import com.scasmar.carregistry.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    @Autowired
    private BrandMapper brandMapper;

    public Car toModel(CarRequest model){
        Brand brand = new Brand();
        brand.setName(model.getBrandName());

        Car car = new Car();
        car.setBrand(brand);
        car.setModel(model.getModel());
        car.setMillage(model.getMillage());
        car.setPrice(model.getPrice());
        car.setYear(model.getYear());
        car.setDescription(model.getDescription());
        car.setColour(model.getColour());
        car.setFuelType(model.getFuelType());
        car.setNumDoors(model.getNumDoors());

        return car;
    }

    public CarResponse toResponse(Car entity){
        CarResponse carResponse = new CarResponse();
        carResponse.setId(entity.getId());
        carResponse.setBrand(brandMapper.toResponse(entity.getBrand()));
        carResponse.setModel(entity.getModel());
        carResponse.setMillage(entity.getMillage());
        carResponse.setPrice(entity.getPrice());
        carResponse.setYear(entity.getYear());
        carResponse.setDescription(entity.getDescription());
        carResponse.setColour(entity.getColour());
        carResponse.setFuelType(entity.getFuelType());
        carResponse.setNumDoors(entity.getNumDoors());

        return carResponse;
    }
}
