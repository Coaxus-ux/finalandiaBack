package finlandia.finlandia.DAO.User;


import finlandia.finlandia.Interfaces.CommunicationInterface;
import finlandia.finlandia.Models.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
@Transactional
public class UserImplement implements UserInterface{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public CommunicationInterface getUserByEmail(String email){
        try {
            String query = "FROM UserEntity WHERE email=:email";
            List<UserEntity> user = entityManager.createQuery(query).setParameter("email", email).getResultList();
            if(user.isEmpty()){
                return new CommunicationInterface.Builder().setSuccessful(false).setMessage("User not found").build();
            }
            Map<String, Object> userFound = new HashMap<>();
            userFound.put("email", user.get(0).getEmail());
            userFound.put("password", user.get(0).getPassword());
            return new CommunicationInterface.Builder().setSuccessful(true).setMessage("User found successfully").setData(userFound).build();
        }catch (Exception e){
            return new CommunicationInterface.Builder().setMessage(e.getMessage()).setSuccessful(false).build();
        }

    }

    @Override
    public CommunicationInterface register(UserEntity user){
        try {
            String query = "FROM UserEntity WHERE email=:email";
            List<UserEntity> userFound = entityManager.createQuery(query).setParameter("email", user.getEmail()).getResultList();
            if(!userFound.isEmpty()){
                return new CommunicationInterface.Builder().setSuccessful(false).setMessage("User already exist with this email").build();
            }
            entityManager.merge(user);
            return new CommunicationInterface.Builder().setSuccessful(true).setMessage("User created successfully").build();
        }catch (Exception e){
            return new CommunicationInterface.Builder().setMessage(e.getMessage()).setSuccessful(false).build();
        }
    }
}
