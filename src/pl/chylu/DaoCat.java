package pl.chylu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DaoCat {
    public static List<Cat> catList = new ArrayList<>();
    public static void addCat(Cat cat) throws Exception {
        catList.add(cat);
    }
    public static List<Cat> returnCatParameter() {
        return catList;
    }
    public static void checkCatSizeList() {
        System.out.println("W bazie danych występuje " + catList.size() + " futrzaków gotowych do walki!\n");
    }
    public static void fightCat (Cat cat, Cat cat2) throws InterruptedException {
        if (cat == cat2) {
            System.out.println("Przecież kot się nie rozdwoi do walki.\n");
        } else {
            Random random = new Random();
            int countWhoPouch = 0;
            boolean fightContinue = true;
            int tempHpCat = cat.getHpCat();
            int tempHpCat2 = cat2.getHpCat();
            while (fightContinue) {
                int chanceToPouch = random.nextInt(101);
                if (chanceToPouch >= 50) {
                    if ((countWhoPouch&1)==0) {
                        tempHpCat2 = tempHpCat2 - cat.getSkill();
                        System.out.println(cat.getName() + " zadał " + cat.getSkill() + " kotowi " + cat2.getName() + ". Zostało mu już tylko " + tempHpCat2 +"\n");
                    } else {
                        tempHpCat = tempHpCat - cat2.getSkill();
                        System.out.println(cat2.getName() + " zadał " + cat2.getSkill() + " kotowi " + cat.getName() + ". Zostało mu już tylko " + tempHpCat +"\n");
                    }
                } else {
                    if ((countWhoPouch&1)==0) {
                        System.out.println("Haha! Kot " + cat.getName() + " chybił!\n");
                    }
                    else  {
                        System.out.println("Haha! Kot " + cat2.getName() + " chybił!\n");
                    }
                }
                countWhoPouch++;
                if (tempHpCat <= 0) {
                    fightContinue = false;
                    System.out.println("Kot " + cat2.getName() + " wygrał z kotem " + cat.getName() + " i zostało mu jeszcze " + tempHpCat2 + " życia.\n");
                    cat2.setSkill(cat2.getSkill() + 1);
                } else if (tempHpCat2 <= 0) {
                    fightContinue = false;
                    System.out.println("Kot " + cat.getName() + " wygrał z kotem " + cat2.getName() + " i zostało mu jeszcze " + tempHpCat + " życia.\n");
                    cat.setSkill(cat.getSkill() + 1);
                }
                Thread.sleep(1300);
            }
        }
    }
}
