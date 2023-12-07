package finlandia.finlandia.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "animal")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Animal {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idAnimal;
    @Column
    private String animalName;
    private String farmCode;
    private String FEDEGANCode;

    @ManyToOne
    @JoinColumn(name = "idAnimalColor", nullable = false)
    private AnimalColor animalColor;

    @ManyToOne
    @JoinColumn(name = "idAnimalSex")
    private AnimalSex animalSex;

    @ManyToOne
    @JoinColumn(name = "idAnimalStatus")
    private AnimalStatus animalStatus;

    @ManyToOne
    @JoinColumn(name = "idAnimalBirthType")
    private BirthAnimalType birthAnimalType;

    @ManyToOne
    @JoinColumn(name = "idBirthAnimal")
    private BirthAnimal birthAnimal;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private UserEntity user;

    @OneToMany(mappedBy = "animal")
    private List<AnimalWeightAssociation> animalWeightAssociation;


}
