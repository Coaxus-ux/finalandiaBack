package finlandia.finlandia.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "birthAnimal")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BirthAnimal {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idBirthAnimal;
    @Column
    private String birthAnimal;

    @OneToMany(mappedBy = "birthAnimal")
    private List<Animal> animal;
}
