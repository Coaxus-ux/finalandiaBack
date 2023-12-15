package finlandia.finlandia.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOAnimalParent {
    UUID idAnimalParent;
    String fedeganCode;
}
