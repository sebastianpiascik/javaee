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
        cloth.setId(db.size());
        db.add(cloth);
    }

    public boolean updateCloth(int id, Cloth cloth) {
        if(db.get(id) != null){
            db.get(id).setName(cloth.getName());
            db.get(id).setProductionDate(cloth.getProductionDate());
            db.get(id).setPrice(cloth.getPrice());
            db.get(id).setWaterproof(cloth.isWaterproof());
            return true;
        } else
            return false;
    }

    public void deleteCloth(Cloth cloth) {
        db.remove(cloth);
    }

    public Cloth getCloth(Integer id) {
        for (Cloth c : db){
            if(c.getId() == id)
                return c;
        }
        return null;
    }

    public List<Cloth> getAllClothes() {
        return db;
    }

    public void deleteAllClothes() {
        db.clear();
    }

}
