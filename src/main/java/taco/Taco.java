package taco;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Taco {

	private static final String INGREDIENTS_VALIDATION_MESSAGE = "You must choose at least  1 ingredient";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min=5, message="Name must be at least 5 characters long")
	private String name;

	@ManyToMany(targetEntity = Ingredient.class)
//	@NotNull(message = INGREDIENTS_VALIDATION_MESSAGE)
	@Size(min=1, message= INGREDIENTS_VALIDATION_MESSAGE)
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime createdAt;
	
	@PrePersist
	void setTimeStamps() {
		this.createdAt = LocalDateTime.now();
	}
}
