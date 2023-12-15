package finlandia.finlandia.DAO.AnimalMother;

import finlandia.finlandia.Interfaces.CommunicationInterface;
import finlandia.finlandia.Utils.DTOAnimalParent;

public interface AnimalMotherInterface {
    CommunicationInterface createMother(DTOAnimalParent dtoAnimalParent);

    CommunicationInterface getByUUID(DTOAnimalParent dtoAnimalParent);

    CommunicationInterface getByMotherFedeganCode(DTOAnimalParent dtoAnimalParent);

    CommunicationInterface deleteMother(DTOAnimalParent dtoAnimalParent);

    CommunicationInterface editMother(DTOAnimalParent dtoAnimalParent);

    CommunicationInterface getAllMother();
}
