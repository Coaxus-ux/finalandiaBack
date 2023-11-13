package finlandia.finlandia.Models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "animalColor")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AnimalColor {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idAnimalColor;
    @Column
    private String animalColor;

    @OneToMany(mappedBy = "animalColor")
    private List<Animal> animal;
}
