package edu.miu.cs489.midtermexam.service;

import edu.miu.cs489.midtermexam.model.Garden;

import java.util.List;

public interface GardenService {

    Garden createGarden(Garden garden);

    void deleteGarden(int gardenId);

    Garden updateGarden(Garden garden, int gardenId);

    Garden getGardenByGardenId(int gardenId);

    List<Garden> getAllGarden();
}
