package finlandia.finlandia.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "animal_father")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AnimalFather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_animal_father")
    private UUID idAnimalFather;

    @Column(name = "fedegan_code", columnDefinition = "VARCHAR(255)")
    private String fedeganCode;

    @OneToMany(mappedBy = "animalFather", cascade = CascadeType.PERSIST)
    private List<Animal> animals;
}
