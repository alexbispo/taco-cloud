package taco.data;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import taco.Ingredient;
import taco.Ingredient.Type;

@Slf4j
@Configuration
public class DataConfig implements CommandLineRunner {
	
	private final IngredientRepository ingredientRepository;
	
	@Autowired
	public DataConfig(IngredientRepository ingredientRepository) {
		this.ingredientRepository =  ingredientRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("=============================== Starting Inserts in Ingredients Table... =============================");
		
		ingredientRepository.deleteAll();
		
		List<Ingredient> ingredients = Arrays.asList(
		  new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
		  new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
		  new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
		  new Ingredient("CARN", "Carnitas", Type.PROTEIN),
		  new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
		  new Ingredient("LETC", "Lettuce", Type.VEGGIES),
		  new Ingredient("CHED", "Cheddar", Type.CHEESE),
		  new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
		  new Ingredient("SLSA", "Salsa", Type.SAUCE),
		  new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
		);
		
		ingredientRepository.saveAll(ingredients);
		
		log.info("=============================== Finish Inserts in Ingredients Table. =============================");
	}

}
