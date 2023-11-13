package finlandia.finlandia.Models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "weightProgress")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WeightProgress {
     @Id @GeneratedValue(strategy = GenerationType.AUTO)
     private UUID idAnimalWeightAssociation;

     @Column
     private double weightProgress;

     @OneToOne(mappedBy = "weightProgress")
     private WeightAnimal weightAnimal;
}
