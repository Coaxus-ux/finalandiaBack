package finlandia.finlandia.Controllers;


import finlandia.finlandia.DAO.AnimalSex.AnimalSexInterface;
import finlandia.finlandia.Interfaces.CommunicationInterface;
import finlandia.finlandia.Interfaces.ResponseInterface;
import finlandia.finlandia.Models.AnimalSex;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/animalsex")
public class AnimalSexController {
    @Autowired
    AnimalSexInterface animalSexInterface;

    @PostMapping(value = "create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseInterface> CreateAnimalSex(@Valid @RequestBody AnimalSex animalSex){
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            CommunicationInterface response = animalSexInterface.createSex(animalSex);
            if(!response.getSuccessful()){
                responseInterface.setMessage(response.getMessage());
                responseInterface.setSuccess(false);
                responseInterface.setData(null);
                return ResponseEntity.status(400).body(responseInterface);
            }
            Map<String, Object> data = new HashMap<>();
            data.put("Animal Sex", animalSex.getAnimalSex());
            responseInterface.setSuccess(true);
            responseInterface.setData(data);
            responseInterface.setMessage(response.getMessage());
            return ResponseEntity.status(201).body(responseInterface);
        }catch (Exception e){
            responseInterface.setMessage(e.getMessage());
            responseInterface.setSuccess(false);
            responseInterface.setData(null);
            return ResponseEntity.status(500).body(responseInterface);
        }
    }

    @GetMapping(value = "getAnimalSexByUUID", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseInterface> GetAnimalSexByUUID(@Valid @RequestBody AnimalSex animalSex){
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            CommunicationInterface response = animalSexInterface.getAnimalSexByUUID(animalSex);
            if(!response.getSuccessful()){
                responseInterface.setMessage(response.getMessage());
                responseInterface.setSuccess(false);
                responseInterface.setData(null);
                return ResponseEntity.status(400).body(responseInterface);
            }
            responseInterface.setSuccess(true);
            responseInterface.setMessage("All animal sex");
            responseInterface.setData(response.getData());
            return ResponseEntity.status(200).body(responseInterface);
        }catch (Exception e){
            responseInterface.setMessage(e.getMessage());
            responseInterface.setSuccess(false);
            responseInterface.setData(null);
            return ResponseEntity.status(500).body(responseInterface);
        }
    }

    @GetMapping(value = "getall",  produces = "application/json")
    public ResponseEntity<ResponseInterface> GetAllAnimalSex(){
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            CommunicationInterface response = animalSexInterface.getAllAnimalSex();
            if(!response.getSuccessful()){
                responseInterface.setMessage(response.getMessage());
                responseInterface.setSuccess(false);
                responseInterface.setData(null);
                return ResponseEntity.status(400).body(responseInterface);
            }
            responseInterface.setSuccess(response.getSuccessful());
            responseInterface.setMessage(response.getMessage());
            responseInterface.setData(response.getData());
            return ResponseEntity.status(200).body(responseInterface);
        }catch (Exception e){
            responseInterface.setMessage(e.getMessage());
            responseInterface.setSuccess(false);
            responseInterface.setData(null);
            return ResponseEntity.status(500).body(responseInterface);
        }
    }

}
