package finlandia.finlandia.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "animal_mother")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AnimalMother {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_animal_mother")
    private UUID IdAnimalMother;

    @Column(name = "fedegan_code", columnDefinition = "VARCHAR(255)")
    private String fedeganCode;

    @OneToMany(mappedBy = "animalMother", cascade = CascadeType.PERSIST)
    private List<Animal> animals;
}
