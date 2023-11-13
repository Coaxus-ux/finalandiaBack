package finlandia.finlandia.DAO.AnimalColor;
import finlandia.finlandia.Models.AnimalColor;
public interface AnimalColorInterface {
    Boolean addAnimalColor(AnimalColor animalColor);
    AnimalColor getAnimalColorByUUID(AnimalColor animalColor);
    AnimalColor getAnimalColorByAnimalColor(AnimalColor animalColor);

    Boolean updateAnimalColor(AnimalColor animalColor);
}
