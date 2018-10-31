package pl.spiascik.ug.store.service;

import pl.spiascik.ug.store.domain.Cloth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClothService {
    private static int idCounter = 0;
    public static ArrayList<Cloth> clothes = new ArrayList<Cloth>();

    public static Cloth getCloth(int id) {
        return clothes.get(id);
    }

    public static ArrayList<Cloth> getAllClothes(){
        return clothes;
    }

    public static void addCloth(Cloth cloth) {
        cloth.setId(idCounter);
        clothes.add(cloth);
        idCounter++;
    }
}
