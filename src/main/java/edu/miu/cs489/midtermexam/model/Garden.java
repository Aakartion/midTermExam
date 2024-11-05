package edu.miu.cs489.midtermexam.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Garden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gardenId;
    private String gardenName;
    private Double gardenSize;
    @OneToMany(mappedBy = "garden", cascade = CascadeType.ALL)
    private List<Plant> plantList;


    @Override
    public String toString() {
        return "Garden{" +
                "gardenId=" + gardenId +
                ", gardenName='" + gardenName + '\'' +
                ", gardenSize=" + gardenSize +
//                ", plantList=" + plantList +
                '}';
    }
}
