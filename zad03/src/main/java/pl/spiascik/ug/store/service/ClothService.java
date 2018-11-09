package pl.spiascik.ug.store.service;

import pl.spiascik.ug.store.domain.Cloth;

import java.util.ArrayList;

public class ClothService {
    private static int idCounter = 0;

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        ClothService.idCounter = idCounter;
    }

    public static ArrayList<Cloth> clothes = new ArrayList<Cloth>();

    public static Cloth getCloth(int id) {
        return clothes.get(id);
    }

    public static ArrayList<Cloth> getAllClothes(){
        return clothes;
    }

    public static void addCloth(Cloth cloth) {
        cloth.setId(getIdCounter());
        clothes.add(cloth);
        setIdCounter(getIdCounter() + 1);
    }
}
