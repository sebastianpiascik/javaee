package pl.spiascik.ug.store.service;

import pl.spiascik.ug.store.domain.Cloth;

import java.util.ArrayList;

public class ShopService {
    public static ArrayList<Cloth> basket = new ArrayList<Cloth>();

    public static ArrayList<Cloth> getBasket(){
        return basket;
    }

    public static void addToBasket(int id){
        removeFromBasket(id);
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
