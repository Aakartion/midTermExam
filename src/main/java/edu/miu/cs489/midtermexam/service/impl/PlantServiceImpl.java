package edu.miu.cs489.midtermexam.service.impl;

import edu.miu.cs489.midtermexam.model.Plant;
import edu.miu.cs489.midtermexam.repository.PlantRepository;
import edu.miu.cs489.midtermexam.service.PlantService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PlantServiceImpl implements PlantService {

    private final PlantRepository plantRepository;

    public PlantServiceImpl(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @Override
    public Plant addPlant(Plant plant) {
        return plantRepository.save(plant);
    }

    @Override
    public void removePlant(String plantName) {
        Optional<Plant> searchPlant = plantRepository.findByPlantName(plantName);
        if(searchPlant.isPresent()){
            plantRepository.delete(searchPlant.get());
        }
    }

    @Override
    public Plant updatePlant(Plant plant, String plantName) {
        Optional<Plant> searchPlant = plantRepository.findByPlantName(plantName);
        Plant foundPlant = new Plant();
        if(searchPlant.isPresent()){
            foundPlant.setPlantType(plant.getPlantType());
            foundPlant.setPlantDate(plant.getPlantDate());
            foundPlant.setPlantName(plant.getPlantName());
            foundPlant.setGarden(plant.getGarden());
            plantRepository.save(foundPlant);
        }
        return  foundPlant;
    }

    @Override
    public Plant getPlantByPlantId(int plantId) {
        return plantRepository.findById(plantId).orElse(null);
    }

    @Override
    public List<Plant> getAllPlant() {
        return plantRepository.findAll();
    }

    public List<Plant> findAllPlantSortByName(){
        List<Plant> plantList = plantRepository.findAll();
        plantList.stream()
                .sorted(Comparator.comparing(plant -> plant.getPlantName()))
                        .forEach(System.out::println);
        return plantList;
    }

     public List<Plant> findAllPlantSortByPlantDate(){
        List<Plant> plantList = plantRepository.findAll();
        plantList.stream()
                .sorted(Comparator.comparing(plant -> plant.getPlantDate()))
                        .forEach(System.out::println);
        return plantList;
    }


}
