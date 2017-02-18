package br.com.caelum.uberdist.beans;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by nando on 17/02/17.
 */
@Named
@SessionScoped
public class TemaBean implements Serializable {

    private Map<String, String> temas;

    private String tema = "afterdark";

    public TemaBean(){
        temas = new TreeMap<>();

        temas.put("Afterdark", "afterdark");
        temas.put("Afternoon", "afternoon");
        temas.put("Afterwork", "afterwork");
        temas.put("Aristo", "aristo");
        temas.put("Black-Tie", "black-tie");
        temas.put("Blitzer", "blitzer");
        temas.put("Bluesky", "bluesky");
        temas.put("Casablanca", "casablanca");
        temas.put("Cupertino", "cupertino");
        temas.put("Cruze", "cruze");
        temas.put("Dark-Hive", "dark-hive");
        temas.put("Dot-Luv", "dot-luv");
        temas.put("Eggplant", "eggplant");
        temas.put("Excite-Bike", "excite-bike");
        temas.put("Flick", "flick");
        temas.put("Glass-X", "glass-x");
        temas.put("Hot-Sneaks", "hot-sneaks");
        temas.put("Home", "home");
        temas.put("Humanity", "humanity");
        temas.put("Le-Frog", "le-frog");
        temas.put("Midnight", "midnight");
        temas.put("Mint-Choc", "mint-choc");
        temas.put("Overcast", "overcast");
        temas.put("Pepper-Grinder", "pepper-grinder");
        temas.put("Redmond", "redmond");
        temas.put("Rocket", "rocket");
        temas.put("Sam", "sam");
        temas.put("Smoothness", "smoothness");
        temas.put("South-Street", "south-street");
        temas.put("Start", "start");
        temas.put("Sunny", "sunny");
        temas.put("Swanky-Purse", "swanky-purse");
        temas.put("Trontastic", "trontastic");
        temas.put("UI-Darkness", "ui-darkness");
        temas.put("UI-Lightness", "ui-lightness");
        temas.put("Vader", "vader");
    }

    public Map<String, String> getTemas() {
        return temas;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}
