package edu.miu.cs489.midtermexam.repository;

import edu.miu.cs489.midtermexam.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlantRepository extends JpaRepository<Plant, Integer> {

    Optional<Plant> findByPlantName(String plantName);
}
