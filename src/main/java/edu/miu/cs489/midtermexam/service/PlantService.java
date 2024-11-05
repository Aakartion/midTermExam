package edu.miu.cs489.midtermexam.service;

import edu.miu.cs489.midtermexam.model.Plant;

import java.util.List;

public interface PlantService {

    Plant addPlant(Plant plant);

    void removePlant(String plantName);

    Plant updatePlant(Plant plant, String plantName);

    Plant getPlantByPlantId(int plantId);

    List<Plant> getAllPlant();

    List<Plant> findAllPlantSortByName();

     List<Plant> findAllPlantSortByPlantDate();

}
