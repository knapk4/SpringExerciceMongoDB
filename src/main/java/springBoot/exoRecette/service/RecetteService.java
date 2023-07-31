package springBoot.exoRecette.service;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import springBoot.exoRecette.model.Recette;
import springBoot.exoRecette.repository.RecetteRepository;

import java.util.List;

@Service
public class RecetteService {

    private final RecetteRepository recetteRepository;

    private final MongoTemplate mongoTemplate;

    public RecetteService(RecetteRepository recetteRepository, MongoTemplate mongoTemplate) {
        this.recetteRepository = recetteRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public List<Recette> findAll(){
        return recetteRepository.findAll();
    }

    public Recette findById(String id){
        return recetteRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarte aux pommes not found"));
    }

    public Recette save(Recette recetteAuxPommes){
        return recetteRepository.save(recetteAuxPommes);
    }

    public void deleteById(String id){
        recetteRepository.deleteById(id);
    }

    public void deleteAll(){
        recetteRepository.deleteAll();
    }

    public Recette update(String id, Recette recette) {
        Query query = new Query(Criteria.where("_id").is(id));
        Recette recetteToUpdate = mongoTemplate.findOne(query, Recette.class);

        if (recette.getNom() != null) {
            recetteToUpdate.setNom(recette.getNom());
        }
        if (recette.getDescription() != null) {
            recetteToUpdate.setDescription(recette.getDescription());
        }
        if (recette.getQuantites() != null) {
            recetteToUpdate.setQuantites(recette.getQuantites());
        }
        if (recette.getInstructions() != null) {
            recetteToUpdate.setInstructions(recette.getInstructions());
        }

        return mongoTemplate.save(recetteToUpdate);
    }
}
