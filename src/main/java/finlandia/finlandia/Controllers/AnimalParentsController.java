package finlandia.finlandia.Controllers;


import finlandia.finlandia.DAO.AnimalFather.AnimalFatherInterface;
import finlandia.finlandia.Interfaces.CommunicationInterface;
import finlandia.finlandia.Interfaces.ResponseInterface;
import finlandia.finlandia.Models.AnimalFather;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "animal_parents")
public class AnimalParentsController {
    @Autowired
    AnimalFatherInterface animalFatherInterface;

    @PostMapping(value = "father/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseInterface> createFather(@Valid @RequestBody AnimalFather animalFather){
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            CommunicationInterface response = animalFatherInterface.createAnimalFather(animalFather);
            if (!response.getSuccessful()){
                responseInterface.setData(response.getData());
                responseInterface.setMessage(response.getMessage());
                responseInterface.setSuccess(response.getSuccessful());
                return ResponseEntity.status(400).body(responseInterface);
            }
            responseInterface.setData(response.getData());
            responseInterface.setMessage(response.getMessage());
            responseInterface.setSuccess(response.getSuccessful());
            return ResponseEntity.status(201).body(responseInterface);
        }catch (Exception e){
            responseInterface.setSuccess(false);
            responseInterface.setMessage(e.getMessage());
            return ResponseEntity.status(500).body(responseInterface);
        }
    }

    @GetMapping(value = "father/getAll", produces = "application/json")
    public ResponseEntity<ResponseInterface> getAllFathers(){
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            CommunicationInterface response = animalFatherInterface.getAllFather();
            if (!response.getSuccessful()){
                responseInterface.setData(response.getData());
                responseInterface.setMessage(response.getMessage());
                responseInterface.setSuccess(response.getSuccessful());
                return ResponseEntity.status(400).body(responseInterface);
            }
            responseInterface.setData(response.getData());
            responseInterface.setMessage(response.getMessage());
            responseInterface.setSuccess(response.getSuccessful());
            return ResponseEntity.status(200).body(responseInterface);
        }catch (Exception e){
            responseInterface.setSuccess(false);
            responseInterface.setMessage(e.getMessage());
            return ResponseEntity.status(500).body(responseInterface);
        }
    }

    @GetMapping(value = "father/getByUUID", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseInterface> GetByFatherByUUID(@Valid @RequestBody AnimalFather animalFather){
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            CommunicationInterface response = animalFatherInterface.getByUUID(animalFather);
            if (!response.getSuccessful()){
                responseInterface.setData(response.getData());
                responseInterface.setMessage(response.getMessage());
                responseInterface.setSuccess(response.getSuccessful());
                return ResponseEntity.status(400).body(responseInterface);
            }
            responseInterface.setData(response.getData());
            responseInterface.setMessage(response.getMessage());
            responseInterface.setSuccess(response.getSuccessful());
            return ResponseEntity.status(200).body(responseInterface);
        }catch (Exception e){
            responseInterface.setSuccess(false);
            responseInterface.setMessage(e.getMessage());
            return ResponseEntity.status(500).body(responseInterface);
        }
    }

    @GetMapping(value = "father/getByFedeganCode", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseInterface> GetByFedeganCode(@Valid @RequestBody AnimalFather animalFather){
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            CommunicationInterface response = animalFatherInterface.getByFedeganCode(animalFather);
            if(!response.getSuccessful()){
                responseInterface.setMessage(response.getMessage());
                responseInterface.setData(response.getData());
                responseInterface.setSuccess(response.getSuccessful());
                return ResponseEntity.status(400).body(responseInterface);
            }
            responseInterface.setData(response.getData());
            responseInterface.setMessage(response.getMessage());
            responseInterface.setSuccess(response.getSuccessful());
            return ResponseEntity.status(200).body(responseInterface);
        }catch (Exception e){
            responseInterface.setSuccess(false);
            responseInterface.setMessage(e.getMessage());
            return ResponseEntity.status(500).body(responseInterface);
        }
    }

    @PutMapping(value = "father/edit", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseInterface> EditFather(@Valid @RequestBody AnimalFather animalFather){
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            CommunicationInterface response = animalFatherInterface.editFather(animalFather);
            if(!response.getSuccessful()){
                responseInterface.setMessage(response.getMessage());
                responseInterface.setData(response.getData());
                responseInterface.setSuccess(response.getSuccessful());
                return ResponseEntity.status(400).body(responseInterface);
            }
            responseInterface.setData(response.getData());
            responseInterface.setMessage(response.getMessage());
            responseInterface.setSuccess(response.getSuccessful());
            return ResponseEntity.status(200).body(responseInterface);
        }catch (Exception e){
            responseInterface.setSuccess(false);
            responseInterface.setMessage(e.getMessage());
            return ResponseEntity.status(500).body(responseInterface);
        }
    }

    @DeleteMapping(value = "father/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseInterface> DeleteFather(@Valid @RequestBody AnimalFather animalFather){
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            CommunicationInterface response = animalFatherInterface.deleteFather(animalFather);
            if(!response.getSuccessful()){
                responseInterface.setMessage(response.getMessage());
                responseInterface.setData(response.getData());
                responseInterface.setSuccess(response.getSuccessful());
                return ResponseEntity.status(400).body(responseInterface);
            }
            responseInterface.setData(response.getData());
            responseInterface.setMessage(response.getMessage());
            responseInterface.setSuccess(response.getSuccessful());
            return ResponseEntity.status(200).body(responseInterface);
        }catch (Exception e){
            responseInterface.setSuccess(false);
            responseInterface.setMessage(e.getMessage());
            return ResponseEntity.status(500).body(responseInterface);
        }
    }
}
