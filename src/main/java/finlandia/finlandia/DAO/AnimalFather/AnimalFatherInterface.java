package finlandia.finlandia.DAO.AnimalFather;

import finlandia.finlandia.Interfaces.CommunicationInterface;
import finlandia.finlandia.Models.AnimalFather;

public interface AnimalFatherInterface {
    CommunicationInterface createAnimalFather(AnimalFather animalFather);

    CommunicationInterface getAllFather();

    CommunicationInterface getByUUID(AnimalFather animalFather);

    CommunicationInterface getByFedeganCode(AnimalFather animalFather);

    CommunicationInterface editFather(AnimalFather animalFather);

    CommunicationInterface deleteFather(AnimalFather animalFather);
}
