package taco;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Taco {

	private static final String INGREDIENTS_VALIDATION_MESSAGE = "You must choose at least  1 ingredient";
	
	@NotNull
	@Size(min=5, message="Name must be at least 5 characters long")
	private String name;
	
	@NotNull(message = INGREDIENTS_VALIDATION_MESSAGE)
	@Size(min=1, message= INGREDIENTS_VALIDATION_MESSAGE)
	private List<String> ingredients;
}
