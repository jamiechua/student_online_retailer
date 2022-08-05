package student.onlineretailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    @Value("${contactEmail}")
    private String email;

    @Value("${onlineRetailer.salesTaxRate}")
    private double salesTaxRate;

    @Value("${onlineRetailer.deliveryCharge.normal}")
    private double normal;

    @Value("${onlineRetailer.deliveryCharge.threshold}")
    private double threshold;

    @Autowired
    private Map<Integer, Item> catalog;

    @Autowired
    private CartRepository repository;

    @Override
    public void addItemToCart(int id, int quantity){
        if(catalog.containsKey(id)){
            repository.add(id, quantity);
        }
    }
    @Override
    public void removeItemFromCart(int id){
        repository.remove(id);
    }
    @Override
    public Map<Integer, Integer> getAllItemsInCart(){
        return repository.getAll();
    }
    @Override
    public double calculateCartCost(){
        Map<Integer, Integer> ct = repository.getAll();
        double cost=0.0;
        for(var id:ct.keySet()){
            double price = catalog.get(id).getPrice();
            int quantity = ct.get(id);
            cost += price * quantity;
        }
        return cost;
    }

    public void printEmail(){
        System.out.println("Company email: " + email);
    }

    public void printProperties(){
        System.out.println("Sales tax rate: " + salesTaxRate);
        System.out.println("Normal delivery charge: " + normal);
        System.out.println("Threshold delivery charge: " + threshold);
    }
}
