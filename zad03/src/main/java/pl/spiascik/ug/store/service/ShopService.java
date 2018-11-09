package pl.spiascik.ug.store.service;

import pl.spiascik.ug.store.domain.Cloth;

import java.util.ArrayList;

public class ShopService {
    private static ArrayList<Cloth> basket = new ArrayList<Cloth>();

    public static ArrayList<Cloth> getBasket(){
        return basket;
    }

    public static Cloth getCloth(int id) {
        return basket.get(id);
    }

    public static void addToBasket(int id){
//        removeFromBasket(id);
        basket.add(ClothService.getCloth(id));
    }

    public static void removeFromBasket(int id){
        for(Cloth cloth: basket){
            if(cloth.getId() == id){
                basket.remove(id);
                break;
            }
        }
    }
}
