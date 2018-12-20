package pl.spiascik.ug.store.service;

import pl.spiascik.ug.store.domain.Chocolate;

import java.util.ArrayList;

public class ShopService {
    private ArrayList<Chocolate> basket = new ArrayList<Chocolate>();

    public ArrayList<Chocolate> getBasket(){
        return basket;
    }

    public Chocolate getChocolate(int id) {
        return basket.get(id);
    }

    public void addToBasket(int id){
        basket.add(ChocolateService.getChocolate(id));
    }

    public void removeFromBasket(int id){
        for(Chocolate chocolate: basket){
            if(chocolate.getId() == id){
                basket.remove(chocolate);
                break;
            }
        }
    }
}
