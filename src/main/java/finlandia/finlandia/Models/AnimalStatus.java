package finlandia.finlandia.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "animalStatus")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AnimalStatus {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idAnimalStatus;
    @Column
    private String animalStatus;

    @OneToMany(mappedBy = "animalStatus")
    private List<Animal> animal;


}
