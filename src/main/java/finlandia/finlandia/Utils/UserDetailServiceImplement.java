package finlandia.finlandia.Utils;

import finlandia.finlandia.DAO.User.UserInterface;
import finlandia.finlandia.Interfaces.CommunicationInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@Service
public class UserDetailServiceImplement implements UserDetailsService {

    @Autowired
    UserInterface userInterface;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        CommunicationInterface userFound = userInterface.getUserByEmail(email);
        if(!userFound.getSuccessful()){
            return (UserDetails) new UsernameNotFoundException(userFound.getMessage());
        }
        String password = userFound.getData().get("password").toString();
        String emailFound = userFound.getData().get("email").toString();
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new User(emailFound, password, true, true, true, true,
                authorities);
    }
}
