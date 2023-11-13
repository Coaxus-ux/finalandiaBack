package finlandia.finlandia.Models;

import java.util.List;
import java.util.UUID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "birthAnimalType")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BirthAnimalType {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idAnimalBirthType;
    @Column
    private String animalBirthType;

    @OneToMany(mappedBy = "birthAnimalType")
    private List<Animal> animal;
}
