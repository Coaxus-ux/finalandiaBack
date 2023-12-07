package finlandia.finlandia.DAO.User;

import finlandia.finlandia.Interfaces.CommunicationInterface;
import finlandia.finlandia.Models.UserEntity;

public interface UserInterface{
    CommunicationInterface getUserByEmail(String email);

    CommunicationInterface register(UserEntity user);
}
