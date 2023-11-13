package finlandia.finlandia.Models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "weightAnimal")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WeightAnimal {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idWeightAnimal;
    @Column
    private double weightAnimal;
    private Date dateRegister;

    @OneToMany(mappedBy = "weightAnimal")
    private List<AnimalWeightAssociation> animalWeightAssociation;

    @OneToOne
    @JoinColumn(name = "idWeightProgress")
    private WeightProgress weightProgress;
}
