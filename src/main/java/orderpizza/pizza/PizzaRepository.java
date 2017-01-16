package orderpizza.pizza;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



/**
 * @author Nalla Senthilnathan (https://github.com/mapteb/approach2cleancode)
 * 
 */
public interface PizzaRepository extends JpaRepository<PizzaEntity, Integer> {

	/**
	 * Find all pizza items selected by the customer
	 * @param customerid 
	 * @return List<PizzaEntity>
	 */
    List<PizzaEntity> findByCustomerid(int customerid);
    
	/**
	 * Save one pizza item customized by the customer
	 * @param customerid
	 * @return PizzaEntity
	 */
    PizzaEntity save(PizzaEntity pizzaEntity);

	/**
	 * Delete all data handled by the repository
	 * @param customerid
	 * @return void
	 */
    void deleteAll();
    
    
}
