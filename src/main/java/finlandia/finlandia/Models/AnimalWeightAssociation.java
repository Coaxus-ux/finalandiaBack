package finlandia.finlandia.Models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "animalWeightAssociation")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AnimalWeightAssociation {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idAnimalWeightAssociation;

    @ManyToOne
    @JoinColumn(name = "idAnimal")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "idWeightAnimal")
    private WeightAnimal weightAnimal;
}
