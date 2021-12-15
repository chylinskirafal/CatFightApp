package pl.chylu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DaoCat {
    public static List<Cat> catList = new ArrayList<>();
    public static void addCat(Cat cat) {
        catList.add(cat);
    }
    public static List<Cat> returnCatParameter() {
        return catList;
    }
    public static void fightCat (Cat cat, Cat cat2) throws InterruptedException {
        DaoUIText.fightCoreEngineUI(cat, cat2);
    }

    public static void forceCleaningOfConsoles() {
        DaoUIText.forceCleaningOfConsoles();
    }
}