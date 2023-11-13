package finlandia.finlandia.Models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "finlandia_user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idUser;
    @Column
    private String userName;
    private String userLastName;
    private String email;
    private String phone;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Animal> animal;
}
