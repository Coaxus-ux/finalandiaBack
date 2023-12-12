package finlandia.finlandia.Controllers;


import finlandia.finlandia.DAO.User.UserInterface;
import finlandia.finlandia.Interfaces.CommunicationInterface;
import finlandia.finlandia.Interfaces.ResponseInterface;
import finlandia.finlandia.Models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/home")
public class HomeController {
    @Autowired
    UserInterface userInterface;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping(value = "register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseInterface> register(@Valid @RequestBody UserEntity user){
        ResponseInterface responseInterface = new ResponseInterface();
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            CommunicationInterface response = userInterface.register(user);
            if(!response.getSuccessful()){
                responseInterface.setMessage(response.getMessage());
                responseInterface.setSuccess(false);
                responseInterface.setData(null);
                return ResponseEntity.status(400).body(responseInterface);
            }
            responseInterface.setSuccess(true);
            responseInterface.setMessage(response.getMessage());
            responseInterface.setData(user);
            return ResponseEntity.status(201).body(responseInterface);
        }catch (Exception e){
            responseInterface.setMessage("Error: " + e.getMessage());
            responseInterface.setSuccess(false);
            responseInterface.setData(null);
            return ResponseEntity.status(500).body(responseInterface);
        }
    }


}
