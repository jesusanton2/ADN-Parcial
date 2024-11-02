package parcialdesarrollo.ADN.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mutante implements Serializable {
    @Id
    @GeneratedValue
    private  long id;

    private String dna;

    private boolean isMutante;
}
