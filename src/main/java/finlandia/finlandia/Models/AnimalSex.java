package finlandia.finlandia.Models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "animalSex")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AnimalSex {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idAnimalSex;
    @Column
    private String animalSex;

    @OneToMany(mappedBy = "animalSex")
    private List<Animal> animal;

}
