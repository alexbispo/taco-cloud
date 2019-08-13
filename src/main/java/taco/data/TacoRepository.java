package taco.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import taco.Taco;

@Repository
public interface TacoRepository extends CrudRepository<Taco, Long> {

}
