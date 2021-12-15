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
        if (cat == cat2) {
            DaoService.falseToCloneCatInfo();
        } else {
            DaoService.fightCoreEngine(cat, cat2);
        }
    }

    public static void forceCleaningOfConsoles() {
        for (int i = 0; i < 20; i++)
            System.out.println();
    }
}
