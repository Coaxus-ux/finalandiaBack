package finlandia.finlandia.DAO.AnimalFather;

import finlandia.finlandia.DAO.AnimalMother.AnimalMotherInterface;
import finlandia.finlandia.Interfaces.CommunicationInterface;
import finlandia.finlandia.Models.AnimalFather;
import finlandia.finlandia.Models.AnimalMother;
import finlandia.finlandia.Utils.DTOAnimalParent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class AnimalFatherImplement implements AnimalFatherInterface {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public CommunicationInterface createAnimalFather(DTOAnimalParent dtoAnimalParent){
        try {
            String query = "FROM AnimalFather WHERE fedeganCode=:fedegan_code";
            List<AnimalFather> animal = entityManager.createQuery(query)
                    .setParameter("fedegan_code", dtoAnimalParent.getFedeganCode())
                    .getResultList();
            Map<String, Object> animalMap = new HashMap<>();
            if(!animal.isEmpty()){
                String queryMother = "FROM AnimalMother WHERE fedeganCode=:fedegan_code";
                List<AnimalMother> animalMother = entityManager.createQuery(queryMother)
                        .setParameter("fedegan_code", dtoAnimalParent.getFedeganCode())
                        .getResultList();
                if(dtoAnimalParent.getFedeganCode().equals("")){
                    if(animalMother.get(0).getFedeganCode().equals("")){
                        AnimalFather animalFather = new AnimalFather();
                        animalFather.setFedeganCode(dtoAnimalParent.getFedeganCode());
                        entityManager.merge(animalFather);
                        animalMap.put("Animal", animalFather);
                        return new CommunicationInterface.Builder().setSuccessful(true).setMessage("Created successfully").setData(animalMap).build();
                    }else{
                        animalMap.put("Mother", animalMother.get(0));
                        return new CommunicationInterface.Builder().setSuccessful(false).setMessage("This animal already exist in mother").setData(animalMap).build();
                    }
                }
                animalMap.put("Animal", animal.get(0));
                return new CommunicationInterface.Builder().setMessage("Animal already exist").setSuccessful(false).setData(animalMap).build();
            }
            AnimalFather animalFather = new AnimalFather();
            animalFather.setFedeganCode(dtoAnimalParent.getFedeganCode());
            entityManager.merge(animalFather);
            animalMap.put("Animal", animalFather);
            return new CommunicationInterface.Builder().setSuccessful(true).setMessage("Created successfully").setData(animalMap).build();
        }catch (Exception e){
            return new CommunicationInterface.Builder().setSuccessful(false).setData(null).setMessage(e.getMessage()).build();
        }
    }

    @Override
    public CommunicationInterface getAllFather(){
        try {
            String query = "FROM AnimalFather";
            List<AnimalFather> animalFathers = entityManager.createQuery(query).getResultList();
            Map<String, Object> animalsFathersMap = new HashMap<>();
            if(animalFathers.isEmpty()){
                return new CommunicationInterface.Builder().setSuccessful(false).setMessage("There's no animals fathers in the database").build();
            }
            animalsFathersMap.put("Animals", animalFathers);
            return new CommunicationInterface.Builder().setSuccessful(true).setMessage("Fathers find successfully").setData(animalsFathersMap).build();
        }catch (Exception e){
            return new CommunicationInterface.Builder().setSuccessful(false).setData(null).setMessage(e.getMessage()).build();
        }
    }

    @Override
    public CommunicationInterface getByUUID(DTOAnimalParent dtoAnimalParent){
        try {
            String query = "FROM AnimalFather WHERE idAnimalFather = :id_animal_father";
            List<AnimalFather> animalFind = entityManager.createQuery(query)
                    .setParameter("id_animal_father", dtoAnimalParent.getIdAnimalParent())
                    .getResultList();
            if(animalFind.isEmpty()){
                return new CommunicationInterface.Builder().setSuccessful(false).setMessage("The animal with this id doesn't exist").build();
            }
            Map<String, Object> animalMap = new HashMap<>();
            animalMap.put("Father", animalFind.get(0));
            return new CommunicationInterface.Builder().setSuccessful(true).setData(animalMap).setMessage("Father found successfully").build();
        }catch (Exception e){
            return new CommunicationInterface.Builder().setSuccessful(false).setData(null).setMessage(e.getMessage()).build();
        }
    }

    @Override
    public CommunicationInterface getByFedeganCode(DTOAnimalParent dtoAnimalParent){
        try {
            String query = "FROM AnimalFather WHERE fedeganCode = :fedegan_code";
            List<AnimalFather> animalFind = entityManager.createQuery(query)
                    .setParameter("fedegan_code", dtoAnimalParent.getFedeganCode())
                    .getResultList();
            if(animalFind.isEmpty()){
                return new CommunicationInterface.Builder().setSuccessful(false).setMessage("The animal with this fedegan code doesn't exist").build();
            }
            Map<String, Object> animalMap = new HashMap<>();
            animalMap.put("Father", animalFind.get(0));
            return new CommunicationInterface.Builder().setSuccessful(true).setData(animalMap).setMessage("Father found successfully").build();
        }catch (Exception e){
            return new CommunicationInterface.Builder().setSuccessful(false).setData(null).setMessage(e.getMessage()).build();
        }
    }

    @Override
    public CommunicationInterface editFather(DTOAnimalParent dtoAnimalParent){
        try {
            CommunicationInterface response = getByUUID(dtoAnimalParent);
            CommunicationInterface duplicate = getByFedeganCode(dtoAnimalParent);
            if(!response.getSuccessful()){
                return new CommunicationInterface.Builder().setSuccessful(response.getSuccessful()).setMessage(response.getMessage()).build();
            }
            AnimalFather animalFatherFound = (AnimalFather) response.getData().get("Father");
            if(duplicate.getSuccessful()){
                AnimalFather duplicated = (AnimalFather) duplicate.getData().get("Father");
                if(!animalFatherFound.getIdAnimalFather().equals(duplicated.getIdAnimalFather())){
                    Map<String, Object> animalMap = new HashMap<>();
                    animalMap.put("Animal with this fedegan code", duplicated);
                    return new CommunicationInterface.Builder().setSuccessful(false).setMessage("Already exist a father with this fedegan code").setData(animalMap).build();
                }
            }
            animalFatherFound.setIdAnimalFather(animalFatherFound.getIdAnimalFather());
            animalFatherFound.setFedeganCode(dtoAnimalParent.getFedeganCode());
            Map<String, Object> animalMap = new HashMap<>();
            animalMap.put("Father", animalFatherFound);
            entityManager.merge(animalFatherFound);
            return new CommunicationInterface.Builder().setSuccessful(true).setMessage("Edited successfully").setData(animalMap).build();
        }catch (Exception e){
            return new CommunicationInterface.Builder().setSuccessful(false).setData(null).setMessage(e.getMessage()).build();
        }
    }

    @Override
    public CommunicationInterface deleteFather(DTOAnimalParent dtoAnimalParent){
        try {
            CommunicationInterface response = getByUUID(dtoAnimalParent);
            if(!response.getSuccessful()){
                return new CommunicationInterface.Builder().setSuccessful(response.getSuccessful()).setMessage(response.getMessage()).build();
            }
            AnimalFather animalFatherFound = (AnimalFather) response.getData().get("Father");
            entityManager.remove(animalFatherFound);
            return new CommunicationInterface.Builder().setSuccessful(true).setMessage("Deleted successfully").build();
        }catch (Exception e){
            return new CommunicationInterface.Builder().setSuccessful(false).setData(null).setMessage(e.getMessage()).build();
        }
    }
}
