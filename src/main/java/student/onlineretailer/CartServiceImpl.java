package student.onlineretailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

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
}
