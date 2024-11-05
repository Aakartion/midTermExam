package edu.miu.cs489.midtermexam.service.impl;

import edu.miu.cs489.midtermexam.model.Garden;
import edu.miu.cs489.midtermexam.repository.GardenRepository;
import edu.miu.cs489.midtermexam.service.GardenService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GardenServiceImpl implements GardenService {

    private final GardenRepository gardenRepository;

    public GardenServiceImpl(GardenRepository gardenRepository) {
        this.gardenRepository = gardenRepository;
    }

    @Override
    public Garden createGarden(Garden garden) {
        return gardenRepository.save(garden);
    }

    @Override
    public void deleteGarden(int gardenId) {
        Optional <Garden> searchGarden = gardenRepository.findById(gardenId);
        if(searchGarden.isPresent()){
            Garden foundGarden = searchGarden.get();
            gardenRepository.delete(foundGarden);
        }
    }

    @Override
    public Garden updateGarden(Garden garden, int gardenId) {
        Optional<Garden> searchGarden = gardenRepository.findById(gardenId);
        Garden foundGarden = new Garden();
        if(searchGarden.isPresent()){
            foundGarden = searchGarden.get();
            foundGarden.setGardenSize(garden.getGardenSize());
            foundGarden.setGardenName(garden.getGardenName());
            foundGarden.setPlantList(garden.getPlantList());
        }
        return foundGarden;
    }

    @Override
    public Garden getGardenByGardenId(int gardenId) {
        Optional<Garden> searchGarden = gardenRepository.findById(gardenId);
        return searchGarden.get();
    }

    @Override
    public List<Garden> getAllGarden() {
        List<Garden> gardenList = gardenRepository.findAll();
        gardenList.stream().forEach(System.out::println);
        return gardenList;
    }
}
