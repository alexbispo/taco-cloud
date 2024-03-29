package taco.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import taco.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
