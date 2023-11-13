package finlandia.finlandia.Controllers;

import finlandia.finlandia.DAO.AnimalColor.AnimalColorInterface;
import finlandia.finlandia.Interfaces.ResponseInterface;
import finlandia.finlandia.Models.AnimalColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animalColor")
public class AnimalColorController {
    @Autowired
    private AnimalColorInterface animalColorInterface;


    @PostMapping("/addAnimalColor")
    public ResponseEntity<ResponseInterface> addAnimalColor(@RequestBody AnimalColor animalColor) {
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            if (animalColor.getAnimalColor() == null) {
                responseInterface.setMessage("Animal color is required");
                responseInterface.setSuccess(false);
                responseInterface.setData(null);
                return ResponseEntity.status(412).body(responseInterface);
            }
            Boolean mergeColorAnimal = animalColorInterface.addAnimalColor(animalColor);
            if (!mergeColorAnimal) {
                responseInterface.setMessage("Animal color already exists");
                responseInterface.setSuccess(false);
                responseInterface.setData(null);
                return ResponseEntity.status(412).body(responseInterface);
            }
            responseInterface.setMessage("Animal color added");
            responseInterface.setSuccess(true);
            responseInterface.setData(animalColor);
            return ResponseEntity.status(200).body(responseInterface);

        } catch (Exception e) {
            responseInterface.setMessage("Error: " + e.getMessage());
            responseInterface.setSuccess(false);
            responseInterface.setData(null);
            return ResponseEntity.status(500).body(responseInterface);
        }

    }

    @PostMapping("/getAnimalColorByUUID")
    public ResponseEntity<ResponseInterface> getAnimalColorByUUID(@RequestBody AnimalColor animalColor) {
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            if (animalColor.getIdAnimalColor() == null) {
                responseInterface.setMessage("Animal color UUID is required");
                responseInterface.setSuccess(false);
                responseInterface.setData(null);
                return ResponseEntity.status(412).body(responseInterface);
            }
            AnimalColor animalColorFromDb = animalColorInterface.getAnimalColorByUUID(animalColor);
            if (animalColorFromDb == null) {
                responseInterface.setMessage("Animal color UUID not found");
                responseInterface.setSuccess(false);
                responseInterface.setData(null);
                return ResponseEntity.status(404).body(responseInterface);
            }
            responseInterface.setMessage("Animal color found");
            responseInterface.setSuccess(true);
            responseInterface.setData(animalColorFromDb);
            return ResponseEntity.status(200).body(responseInterface);
        } catch (Exception e) {
            responseInterface.setMessage("Error: " + e.getMessage());
            responseInterface.setSuccess(false);
            responseInterface.setData(null);
            return ResponseEntity.status(500).body(responseInterface);

        }
    }

    @PostMapping("/getAnimalColorByAnimalColor")
    public ResponseEntity<ResponseInterface> getAnimalColorByAnimalColor(@RequestBody AnimalColor animalColor) {
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            if (animalColor.getAnimalColor() == null) {
                responseInterface.setMessage("Animal color is required");
                responseInterface.setSuccess(false);
                responseInterface.setData(null);
                return ResponseEntity.status(412).body(responseInterface);
            }
            AnimalColor animalColorFromDB = animalColorInterface.getAnimalColorByAnimalColor(animalColor);
            if (animalColorFromDB == null) {
                responseInterface.setMessage("Animal color not found");
                responseInterface.setSuccess(false);
                responseInterface.setData(null);
                return ResponseEntity.status(404).body(responseInterface);
            }
            responseInterface.setMessage("Animal color found");
            responseInterface.setSuccess(true);
            responseInterface.setData(animalColorFromDB);
            return ResponseEntity.status(200).body(responseInterface);
        } catch (Exception e) {
            responseInterface.setMessage("Error: " + e.getMessage());
            responseInterface.setSuccess(false);
            responseInterface.setData(null);
            return ResponseEntity.status(500).body(responseInterface);
        }


    }

    @PutMapping("/updateAnimalColor")
    public ResponseEntity<ResponseInterface> updateAnimalColor(@RequestBody AnimalColor animalColor) {
        ResponseInterface responseInterface = new ResponseInterface();
        try {
            if (animalColor.getIdAnimalColor() == null || animalColor.getAnimalColor() == null) {
                responseInterface.setMessage("Animal color UUID is required");
                responseInterface.setSuccess(false);
                responseInterface.setData(null);
                return ResponseEntity.status(412).body(responseInterface);
            }
            Boolean updateAnimalColor = animalColorInterface.updateAnimalColor(animalColor);
            if (!updateAnimalColor) {
                responseInterface.setMessage("Animal color not found");
                responseInterface.setSuccess(false);
                responseInterface.setData(null);
                return ResponseEntity.status(404).body(responseInterface);
            }
            responseInterface.setMessage("Animal color updated");
            responseInterface.setSuccess(true);
            responseInterface.setData(animalColor);
            return ResponseEntity.status(200).body(responseInterface);
        } catch (Exception e) {
            responseInterface.setMessage("Error: " + e.getMessage());
            responseInterface.setSuccess(false);
            responseInterface.setData(null);
            return ResponseEntity.status(500).body(responseInterface);
        }
    }

}
