package edu.miu.cs489.midtermexam.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer plantId;
    private String plantName;
    private String plantType;
    private LocalDate plantDate;
    @ManyToOne
    @JoinColumn(name = "garden_id")
    private Garden garden;


    @Override
    public String toString() {
        return "Plant{" +
                "plantId=" + plantId +
                ", plantName='" + plantName + '\'' +
                ", plantType='" + plantType + '\'' +
                ", plantDate=" + plantDate +
                ", garden=" + garden +
                '}';
    }
}
