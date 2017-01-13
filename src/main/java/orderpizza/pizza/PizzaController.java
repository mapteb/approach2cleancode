package orderpizza.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import orderpizza.pizza.PizzaEntity;
import orderpizza.pizza.PizzaRepository;

/**
 * @author Nalla Senthilnathan (https://github.com/mapteb/approach2cleancode)
 *
 */


@RestController
public class PizzaController {
	
	@Autowired
	private PizzaRepository pizzaRepository;


	@CrossOrigin
    @RequestMapping(value="/pizza", method = RequestMethod.POST)
	ResponseEntity<String> addPizzzaItemToUserCart(@RequestBody PizzaEntity input) {
		
        //TODO: identify the user and add pizza to user's cart using PizzaRepository
		//      For this demo use customerid=1
		input.setCustomerid(1);
		PizzaEntity pe =pizzaRepository.save(input);
		
        return ResponseEntity.noContent().build();
    }
	
	@CrossOrigin
    @RequestMapping(value="/cart/items/count", method = RequestMethod.GET)
	ResponseEntity<String> getPizzaItemsCountInUserCart() {
		
        //TODO: identify the user and get pizza items count in the user's cart using PizzaRepository
		//      For this demo use customerid=1
		int count = pizzaRepository.findByCustomerid(1).size();
		
		String res = "{\"count\":"+count+"}";
		
        return new ResponseEntity<String>(res, HttpStatus.OK);
    }	
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<String> handleAll(Exception ex, WebRequest request) {
	    return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
