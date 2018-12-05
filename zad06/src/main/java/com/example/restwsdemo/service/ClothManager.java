package com.example.restwsdemo.service;

import com.example.restwsdemo.domain.Cloth;
import com.example.restwsdemo.domain.Person;

import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Singleton
public class ClothManager {

    private List<Cloth> db = Collections.synchronizedList(new ArrayList<Cloth>());

    public void addCloth(Cloth cloth) {
        db.add(cloth);
    }

    public void deleteCloth(Cloth cloth) {
        db.remove(cloth);
    }

    public Cloth getCloth(Integer id) {
        for (Cloth c : db){
            if(c.getId() == id)
                return c;
        }
        return new Cloth("default");
    }

    public List<Cloth> getAllClothes() {
        return db;
    }

    public void deleteAllClothes() {
        db.clear();
    }

}
