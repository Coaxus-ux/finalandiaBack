package finlandia.finlandia.DAO.AnimalColor;

import finlandia.finlandia.Models.AnimalColor;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;

import java.util.List;

@Repository
@Transactional
public class AnimalColorImpl implements AnimalColorInterface {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Boolean addAnimalColor(AnimalColor animalColor) {
        try {
            AnimalColor animalColorFromDb = getAnimalColorByAnimalColor(animalColor);
            if (animalColorFromDb != null) {
                return false;
            }
            entityManager.merge(animalColor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public AnimalColor getAnimalColorByUUID(AnimalColor animalColor) {
        try {
            String query = "FROM AnimalColor WHERE idAnimalColor = :idAnimalColor";
            TypedQuery<AnimalColor> animalColorTypedQuery = entityManager.createQuery(query, AnimalColor.class);
            animalColorTypedQuery.setParameter("idAnimalColor", animalColor.getIdAnimalColor());
            List<AnimalColor> animalColorList = animalColorTypedQuery.getResultList();
            if (animalColorList.isEmpty()) {
                return null;
            }
            return animalColorList.get(0);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public AnimalColor getAnimalColorByAnimalColor(AnimalColor animalColor) {
        try {
            String query = "FROM AnimalColor WHERE LOWER(animalColor) = LOWER(:animalColor)";
            TypedQuery<AnimalColor> animalColorTypedQuery = entityManager.createQuery(query, AnimalColor.class);
            animalColorTypedQuery.setParameter("animalColor", animalColor.getAnimalColor());
            List<AnimalColor> animalColorList = animalColorTypedQuery.getResultList();
            if (animalColorList.isEmpty()) {
                return null;
            }
            return animalColorList.get(0);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean updateAnimalColor(AnimalColor animalColor) {
        try {
            AnimalColor animalColorFromDb = getAnimalColorByUUID(animalColor);
            if (animalColorFromDb == null) {
                return false;
            }
            animalColorFromDb.setAnimalColor(animalColor.getAnimalColor());
            entityManager.merge(animalColorFromDb);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
