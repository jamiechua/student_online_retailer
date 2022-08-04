package student.onlineretailer;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartRepositoryImpl implements CartRepository{

    private Map<Integer, Integer> cart = new HashMap<>();

    @Override
    public void add(int itemId, int quantity){
        if(cart.containsKey(itemId)){
            Integer currentQuantity = cart.get(itemId);
            quantity+= currentQuantity;
        }
        cart.put(itemId, quantity);
    }
    @Override
    public void remove(int itemId){
        cart.remove(itemId);
    }
    @Override
    public Map<Integer, Integer> getAll(){
        return cart;
    }
}
