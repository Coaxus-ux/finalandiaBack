package finlandia.finlandia.DAO.AnimalSex;

import finlandia.finlandia.Interfaces.CommunicationInterface;
import finlandia.finlandia.Models.AnimalSex;

public interface AnimalSexInterface {
    CommunicationInterface createSex(AnimalSex animalSex);

    CommunicationInterface getAnimalSexByUUID(AnimalSex animalSex);

    CommunicationInterface getAllAnimalSex();
}
