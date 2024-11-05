package edu.miu.cs489.midtermexam;

import edu.miu.cs489.midtermexam.model.Garden;
import edu.miu.cs489.midtermexam.model.Plant;
import edu.miu.cs489.midtermexam.service.GardenService;
import edu.miu.cs489.midtermexam.service.PlantService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class MidTermExamApplication implements CommandLineRunner {

    private GardenService gardenService;
    private PlantService plantService;

    public MidTermExamApplication(GardenService gardenService, PlantService plantService) {
        this.gardenService = gardenService;
        this.plantService = plantService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MidTermExamApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Garden vegetablePatch = new Garden();
        vegetablePatch.setGardenName("Vegetable Patch");
        vegetablePatch.setGardenSize(50.0);
        gardenService.createGarden(vegetablePatch);

        Garden herbGarden = new Garden();
        herbGarden.setGardenName("Herb Garden");
        herbGarden.setGardenSize(20.0);
        gardenService.createGarden(herbGarden);


        Plant tomato = new Plant();
        tomato.setGarden(vegetablePatch);
        tomato.setPlantDate(LocalDate.of(2024,03,10));
        tomato.setPlantType("Vegetable");
        tomato.setPlantName("Tomato");
        plantService.addPlant(tomato);

        Plant carrot = new Plant();
        carrot.setGarden(vegetablePatch);
        carrot.setPlantDate(LocalDate.of(2024,02,20));
        carrot.setPlantName("Carrot");
        carrot.setPlantType("Vegetable");
        plantService.addPlant(carrot);

        Plant basil = new Plant();
        basil.setGarden(herbGarden);
        basil.setPlantDate(LocalDate.of(2024,04,05));
        basil.setPlantName("Basil");
        basil.setPlantType("Herb");
        plantService.addPlant(basil);


        System.out.println();

        System.out.println("********** All Garden ***************");
        gardenService.getAllGarden();

        System.out.println();

        System.out.println("********** All Plant sort by Plant Name ***************");
        plantService.findAllPlantSortByName();

        System.out.println();


        System.out.println("********** All Plant sort by Plant Date ***************");
        plantService.findAllPlantSortByPlantDate();

        System.out.println();


        System.out.println("**** Add new plant *********");

        Plant rosemary = new Plant();
        rosemary.setGarden(herbGarden);
        rosemary.setPlantDate(LocalDate.of(2024,11,05));
        rosemary.setPlantName("Rosemary");
        rosemary.setPlantType("Herb");
        plantService.addPlant(rosemary);

        plantService.findAllPlantSortByName();

        System.out.println();


        System.out.println("************ Delete plant **************");
        plantService.removePlant("Carrot");
        plantService.findAllPlantSortByName();
        System.out.println();


        System.out.println("********** Update ************");
        tomato.setPlantType("Fruit");
        plantService.updatePlant(tomato, "Tomato" );
        plantService.findAllPlantSortByName();
        System.out.println();
    }
}
