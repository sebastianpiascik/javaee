package pl.spiascik.ug.store.service;

import pl.spiascik.ug.store.domain.Chocolate;

import java.util.ArrayList;

public class ChocolateService {
    private static int idCounter = 0;

    public static ArrayList<Chocolate> chocolates = new ArrayList<Chocolate>();


    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        ChocolateService.idCounter = idCounter;
    }

    public static Chocolate getChocolate(int id) {
        return chocolates.get(id);
    }

    public static ArrayList<Chocolate> getAllChocolates(){
        return chocolates;
    }

    public static void addChocolate(Chocolate chocolate) {
        chocolate.setId(getIdCounter());
        chocolates.add(chocolate);
        setIdCounter(getIdCounter() + 1);
    }
}
