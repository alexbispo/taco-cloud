package taco.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import taco.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
