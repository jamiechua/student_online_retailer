package student.onlineretailer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		CartService cartservice = ctx.getBean(CartService.class);
		cartservice.addItemToCart(1, 1);
		cartservice.addItemToCart(1, 1);
		cartservice.addItemToCart(2, 1);
		cartservice.addItemToCart(3, 1);
		cartservice.addItemToCart(4, 1);
		cartservice.removeItemFromCart(4);
		Map<Integer, Integer> cart = cartservice.getAllItemsInCart();

		System.out.println("Items bought: ");
		for(var id:cart.keySet()){
			System.out.printf("Item id: %d, Quantity: %d \n", id, cart.get(id));
		}

		System.out.println("Total cost of cart: $"+cartservice.calculateCartCost());
	}

	@Bean
	public Map<Integer, Item> catalog(){
		Map<Integer, Item> ct = new HashMap<>();
		ct.put(1, new Item(1, "Tissue box", 1.0));
		ct.put(2, new Item(2, "Mop", 6.5));
		ct.put(3, new Item(3, "Cup", 3.5));
		ct.put(4, new Item(4, "Chair", 25.9));
		return ct;
	}


}
