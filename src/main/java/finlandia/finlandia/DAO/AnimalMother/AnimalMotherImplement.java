package finlandia.finlandia.DAO.AnimalMother;

import finlandia.finlandia.Interfaces.CommunicationInterface;
import finlandia.finlandia.Models.AnimalFather;
import finlandia.finlandia.Models.AnimalMother;
import finlandia.finlandia.Utils.DTOAnimalParent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class AnimalMotherImplement implements AnimalMotherInterface {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public CommunicationInterface createMother(DTOAnimalParent dtoAnimalParent) {
        try {
            String query = "FROM AnimalMother WHERE fedeganCode=:fedegan_code";
            List<AnimalMother> animal = entityManager.createQuery(query)
                    .setParameter("fedegan_code", dtoAnimalParent.getFedeganCode())
                    .getResultList();
            Map<String, Object> animalMap = new HashMap<>();
            if (!animal.isEmpty()) {
                String queryFather = "FROM AnimalFather WHERE fedeganCode=:fedegan_code";
                List<AnimalFather> animalFather = entityManager.createQuery(queryFather)
                        .setParameter("fedegan_code", dtoAnimalParent.getFedeganCode())
                        .getResultList();
                if (dtoAnimalParent.getFedeganCode().equals("")) {
                    if (animalFather.get(0).getFedeganCode().equals("")) {
                        AnimalMother animalMother = new AnimalMother();
                        animalMother.setFedeganCode(dtoAnimalParent.getFedeganCode());
                        entityManager.merge(animalMother);
                        animalMap.put("Animal", animalMother);
                        return new CommunicationInterface.Builder().setSuccessful(true).setMessage("Created successfully").setData(animalMap).build();
                    } else {
                        animalMap.put("Father", animalFather.get(0));
                        return new CommunicationInterface.Builder().setSuccessful(false).setMessage("This animal already exist in father").setData(animalMap).build();
                    }
                }
                animalMap.put("Mother", animal.get(0));
                return new CommunicationInterface.Builder().setMessage("Animal already exist").setSuccessful(false).setData(animalMap).build();
            }
            AnimalMother animalMother = new AnimalMother();
            animalMother.setFedeganCode(dtoAnimalParent.getFedeganCode());
            entityManager.merge(animalMother);
            animalMap.put("Mother", animalMother);
            return new CommunicationInterface.Builder().setSuccessful(true).setMessage("Created successfully").setData(animalMap).build();
        } catch (Exception e) {
            return new CommunicationInterface.Builder().setSuccessful(false).setData(null).setMessage(e.getMessage()).build();
        }
    }

    @Override
    public CommunicationInterface getByUUID(DTOAnimalParent dtoAnimalParent) {
        try {
            String query = "FROM AnimalMother WHERE idAnimalMother=:id_animal_mother";
            List<AnimalMother> animal = entityManager.createQuery(query)
                    .setParameter("id_animal_mother", dtoAnimalParent.getIdAnimalParent())
                    .getResultList();
            Map<String, Object> animalMap = new HashMap<>();
            if (animal.isEmpty()) {
                return new CommunicationInterface.Builder().setData(null).setMessage("The mother doesn't exist").setSuccessful(false).build();
            }
            animalMap.put("Mother", animal);
            return new CommunicationInterface.Builder().setSuccessful(true).setMessage("Mother found successfully").setData(animalMap).build();
        } catch (Exception e) {
            return new CommunicationInterface.Builder().setSuccessful(false).setData(null).setMessage(e.getMessage()).build();
        }
    }

    @Override
    public CommunicationInterface getByMotherFedeganCode(DTOAnimalParent dtoAnimalParent) {
        try {
            String query = "FROM AnimalMother WHERE fedeganCode=:fedegan_code";
            List<AnimalMother> animal = entityManager.createQuery(query)
                    .setParameter("fedegan_code", dtoAnimalParent.getFedeganCode())
                    .getResultList();
            Map<String, Object> animalMap = new HashMap<>();
            if (animal.isEmpty()) {
                return new CommunicationInterface.Builder().setMessage("The animal with this fedegan code doesn't exist").setSuccessful(false).setData(null).build();
            }
            animalMap.put("Mother", animal);
            return new CommunicationInterface.Builder().setSuccessful(true).setMessage("Mother found successfully").setData(animalMap).build();
        } catch (Exception e) {
            return new CommunicationInterface.Builder().setSuccessful(false).setData(null).setMessage(e.getMessage()).build();
        }
    }

    @Override
    public CommunicationInterface deleteMother(DTOAnimalParent dtoAnimalParent) {
        try {
            String query = "FROM AnimalMother WHERE idAnimalMother= :id_animal_mother";
            List<AnimalMother> animal = entityManager.createQuery(query)
                    .setParameter("id_animal_mother", dtoAnimalParent.getIdAnimalParent())
                    .getResultList();
            System.out.println(animal);
            if (animal.isEmpty()) {
                return new CommunicationInterface.Builder().setSuccessful(false).setMessage("cow doesn't exist").build();
            }
            entityManager.remove(animal.get(0));
            return new CommunicationInterface.Builder().setSuccessful(true).setMessage("Deleted successfully").build();
        } catch (Exception e) {
            return new CommunicationInterface.Builder().setSuccessful(false).setData(null).setMessage(e.getMessage()).build();
        }
    }

    @Override
    public  CommunicationInterface editMother(DTOAnimalParent dtoAnimalParent){
        try {
            String query = "FROM AnimalMother WHERE idAnimalMother=:id_animal_mother";
            List<AnimalMother> animal = entityManager.createQuery(query)
                    .setParameter("id_animal_mother", dtoAnimalParent.getIdAnimalParent())
                    .getResultList();
            CommunicationInterface duplicate = getByMotherFedeganCode(dtoAnimalParent);
            if(duplicate.getSuccessful()){
                return new CommunicationInterface.Builder().setSuccessful(false).setMessage("A cow with this fedegan code already exist").setData(duplicate.getData()).build();
            }
            if(animal.isEmpty()){
                return new CommunicationInterface.Builder().setSuccessful(false).setData(null).setMessage("This mother doesn't exist").build();
            }
            animal.get(0).setIdAnimalMother(animal.get(0).getIdAnimalMother());
            animal.get(0).setFedeganCode(dtoAnimalParent.getFedeganCode());
            entityManager.merge(animal.get(0));
            Map<String, Object> animalMap = new HashMap<>();
            animalMap.put("Mother", animal.get(0));
            return new CommunicationInterface.Builder().setMessage("Edited successfully").setData(animalMap).setSuccessful(true).build();
        }catch (Exception e) {
            return new CommunicationInterface.Builder().setSuccessful(false).setData(null).setMessage(e.getMessage()).build();
        }
    }

    @Override
    public CommunicationInterface getAllMother(){
        try {
            String query = "FROM AnimalMother";
            List<AnimalMother> animalMothers = entityManager.createQuery(query).getResultList();
            if(animalMothers.isEmpty()){
                return new CommunicationInterface.Builder().setSuccessful(false).setMessage("Cows doesn't exist").build();
            }
            Map<String, Object> animalMap = new HashMap<>();
            animalMap.put("Mothers", animalMothers);
            return new CommunicationInterface.Builder().setSuccessful(true).setMessage("Mothers found successfully").setData(animalMap).build();
        }catch (Exception e) {
            return new CommunicationInterface.Builder().setSuccessful(false).setData(null).setMessage(e.getMessage()).build();
        }
    }

}
