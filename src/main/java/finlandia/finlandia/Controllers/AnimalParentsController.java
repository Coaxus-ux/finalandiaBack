package finlandia.finlandia.Controllers;


import finlandia.finlandia.DAO.AnimalFather.AnimalFatherInterface;
import finlandia.finlandia.DAO.AnimalMother.AnimalMotherInterface;
import finlandia.finlandia.Interfaces.CommunicationInterface;
import finlandia.finlandia.Interfaces.ResponseInterface;
import finlandia.finlandia.Utils.DTOAnimalParent;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "animal_parents")
public class AnimalParentsController {
    @Autowired
    AnimalFatherInterface animalFatherInterface;

    @Autowired
    AnimalMotherInterface animalMotherInterface;

    @PostMapping(value = "father/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseInterface> createFather(@Valid @RequestBody DTOAnimalParent dtoAnimalParent){
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            CommunicationInterface response = animalFatherInterface.createAnimalFather(dtoAnimalParent);
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
    public ResponseEntity<ResponseInterface> GetByFatherByUUID(@Valid @RequestBody DTOAnimalParent dtoAnimalParent){
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            CommunicationInterface response = animalFatherInterface.getByUUID(dtoAnimalParent);
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
    public ResponseEntity<ResponseInterface> GetByFedeganCode(@Valid @RequestBody DTOAnimalParent dtoAnimalParent){
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            CommunicationInterface response = animalFatherInterface.getByFedeganCode(dtoAnimalParent);
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
    public ResponseEntity<ResponseInterface> EditFather(@Valid @RequestBody DTOAnimalParent dtoAnimalParent){
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            CommunicationInterface response = animalFatherInterface.editFather(dtoAnimalParent);
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
    public ResponseEntity<ResponseInterface> DeleteFather(@Valid @RequestBody DTOAnimalParent dtoAnimalParent){
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            CommunicationInterface response = animalFatherInterface.deleteFather(dtoAnimalParent);
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

    @PostMapping(value = "mother/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseInterface> CreateMother(@Valid @RequestBody DTOAnimalParent dtoAnimalParent){
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            CommunicationInterface response = animalMotherInterface.createMother(dtoAnimalParent);
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

    @GetMapping(value = "mother/getByUUID",consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseInterface> GetMotherByUUID(@Valid @RequestBody DTOAnimalParent dtoAnimalParent){
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            CommunicationInterface response = animalMotherInterface.getByUUID(dtoAnimalParent);
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

    @GetMapping(value = "mother/getByFedeganCode", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseInterface> GetMotherByFedeganCode(@Valid @RequestBody DTOAnimalParent dtoAnimalParent){
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            CommunicationInterface response = animalMotherInterface.getByMotherFedeganCode(dtoAnimalParent);
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

    @DeleteMapping(value = "mother/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseInterface> deleteMother(@Valid @RequestBody DTOAnimalParent dtoAnimalParent){
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            CommunicationInterface response = animalMotherInterface.deleteMother(dtoAnimalParent);
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

    @PutMapping(value = "mother/edit", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseInterface> editMother(@Valid @RequestBody DTOAnimalParent dtoAnimalParent){
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            CommunicationInterface response = animalMotherInterface.editMother(dtoAnimalParent);
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

    @GetMapping(value = "mother/getAll", produces = "application/json")
    public ResponseEntity<ResponseInterface> getAllMothers(){
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            CommunicationInterface response = animalMotherInterface.getAllMother();
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
