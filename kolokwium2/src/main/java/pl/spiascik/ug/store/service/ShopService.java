package pl.spiascik.ug.store.service;

import pl.spiascik.ug.store.domain.Chocolate;

import java.util.ArrayList;

public class ShopService {
    private static ArrayList<Chocolate> basket = new ArrayList<Chocolate>();

    public static ArrayList<Chocolate> getBasket(){
        return basket;
    }

    public static Chocolate getChocolate(int id) {
        return basket.get(id);
    }

    public static void addToBasket(int id){
        basket.add(ChocolateService.getChocolate(id));
    }

    public static void removeFromBasket(int id){
        for(Chocolate cloth: basket){
            if(cloth.getId() == id){
                basket.remove(id);
                break;
            }
        }
    }
}
