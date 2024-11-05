package edu.miu.cs489.midtermexam.repository;

import edu.miu.cs489.midtermexam.model.Garden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GardenRepository extends JpaRepository<Garden, Integer> {
}
