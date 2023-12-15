package finlandia.finlandia.DAO.AnimalFather;

import finlandia.finlandia.Interfaces.CommunicationInterface;
import finlandia.finlandia.Models.AnimalFather;
import finlandia.finlandia.Utils.DTOAnimalParent;

public interface AnimalFatherInterface {
    CommunicationInterface createAnimalFather(DTOAnimalParent dtoAnimalParent);

    CommunicationInterface getAllFather();

    CommunicationInterface getByUUID(DTOAnimalParent dtoAnimalParent);

    CommunicationInterface getByFedeganCode(DTOAnimalParent dtoAnimalParent);

    CommunicationInterface editFather(DTOAnimalParent dtoAnimalParent);

    CommunicationInterface deleteFather(DTOAnimalParent dtoAnimalParent);
}
