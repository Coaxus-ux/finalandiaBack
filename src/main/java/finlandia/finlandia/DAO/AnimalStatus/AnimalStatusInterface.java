package finlandia.finlandia.DAO.AnimalStatus;

import finlandia.finlandia.Models.AnimalStatus;

public interface AnimalStatusInterface {
    Boolean addAnimalStatus(AnimalStatus animalStatus);
    AnimalStatus getAnimalStatusByUUID(AnimalStatus animalStatus);
    AnimalStatus getAnimalStatusByAnimalStatus(AnimalStatus animalStatus);
    Boolean updateAnimalStatus(AnimalStatus animalStatus);
}
