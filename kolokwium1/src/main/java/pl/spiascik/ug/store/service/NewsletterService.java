package pl.spiascik.ug.store.service;

import pl.spiascik.ug.store.domain.Cloth;
import pl.spiascik.ug.store.domain.Newsletter;

import java.util.ArrayList;

public class NewsletterService {
    private static ArrayList<Newsletter> newsletters = new ArrayList<Newsletter>();

    public static ArrayList<Newsletter> getNewsletters(){
        return newsletters;
    }

    public static void addNewNewsletters(Newsletter n){
        newsletters.add(n);
    }


    public static void removeNewsletter(int id){
        for(Newsletter n : newsletters){
            if(n.getId() == id){
                newsletters.remove(n);
                break;
            }
        }
    }


    public static void removeNewsletter(Newsletter newsl){
        newsletters.remove(newsl);
    }
}
