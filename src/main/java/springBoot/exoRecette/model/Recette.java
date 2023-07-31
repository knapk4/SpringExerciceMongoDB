package springBoot.exoRecette.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
@Getter @Setter @Document(collection = "recettes")
public class Recette {
    @Id private String id;
    @Field("name") private String nom;
    private String description;
    private List<Quantite> quantites;
    private List<Instruction> instructions;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Recette{");
        sb.append("id='").append(id).append('\'');
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", quantites=").append(quantites);
        sb.append(", instructions=").append(instructions);
        sb.append('}');
        return sb.toString();
    }
}
