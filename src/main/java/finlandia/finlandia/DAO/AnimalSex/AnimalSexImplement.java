package finlandia.finlandia.DAO.AnimalSex;


import finlandia.finlandia.Interfaces.CommunicationInterface;
import finlandia.finlandia.Models.AnimalSex;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class AnimalSexImplement implements AnimalSexInterface{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public CommunicationInterface createSex(AnimalSex animalSex){
        try {
            Map<String, Object> animalSexCreated = new HashMap<>();
            animalSexCreated.put("animalSex", animalSex.getAnimalSex());
            entityManager.merge(animalSex);
            return new CommunicationInterface.Builder().setMessage("Created Successful").setData(animalSexCreated).setSuccessful(true).build();
        }catch (Exception e){
            return new CommunicationInterface.Builder().setMessage(e.getMessage()).setSuccessful(false).setData(null).build();
        }
    }

    @Override
    public CommunicationInterface getAnimalSexByUUID(AnimalSex animalSex){
        try {
            String query = "FROM AnimalSex WHERE idAnimalSex=:idAnimalSex";
            List<AnimalSex> response = entityManager.createQuery(query)
                    .setParameter("idAnimalSex", animalSex.getIdAnimalSex())
                    .getResultList();
            if(response.isEmpty()){
                return new CommunicationInterface.Builder().setMessage("This animal sex doesn't exist").setSuccessful(false).build();
            }
            Map<String, Object> animalSexFound = new HashMap<>();
            animalSexFound.put("Animal sex", response.get(0).getAnimalSex());
            return new CommunicationInterface.Builder().setSuccessful(true).setMessage("Animal sex found successfully").setData(animalSexFound).build();
        }catch (Exception e){
            return new CommunicationInterface.Builder().setMessage(e.getMessage()).setSuccessful(false).setData(null).build();
        }
    }

    @Override
    public CommunicationInterface getAllAnimalSex(){
        try {
            String query = "FROM AnimalSex";
            List<AnimalSex> response = entityManager.createQuery(query).getResultList();
            if(response.isEmpty()){
                return new CommunicationInterface.Builder().setMessage("Animal sex doesn't exist").setSuccessful(false).setData(null).build();
            }
            Map<String, Object> AllAnimalSex = new HashMap<>();
            for(AnimalSex a : response){
                Map<String, Object> AnimalSexFound = new HashMap<>();
                AnimalSexFound.put("Id Animal Sex", a.getIdAnimalSex());
                AnimalSexFound.put("Animal sex", a.getAnimalSex());
                AllAnimalSex.put(a.getAnimalSex(), AnimalSexFound);
            }
            return new CommunicationInterface.Builder().setMessage("That's are the animasl sex").setSuccessful(true).setData(AllAnimalSex).build();
        }catch (Exception e){
            return new CommunicationInterface.Builder().setMessage(e.getMessage()).setSuccessful(false).setData(null).build();
        }
    }

}
