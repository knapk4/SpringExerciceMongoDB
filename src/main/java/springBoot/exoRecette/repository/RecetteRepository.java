package springBoot.exoRecette.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springBoot.exoRecette.model.Recette;
@Repository
public interface RecetteRepository extends MongoRepository<Recette, String> {

}
