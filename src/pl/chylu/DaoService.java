package pl.chylu;

import java.util.Random;

public class DaoService {
    public static void fightCoreEngine(Cat cat, Cat cat2) throws InterruptedException {
        Random random = new Random();
        int countWhoPouch = 0;
        boolean fightContinue = true;
        int tempHpCat = cat.getHpCat();
        int tempHpCat2 = cat2.getHpCat();
        while (fightContinue) {
            int chanceToPouch = random.nextInt(101);
            if (chanceToPouch >= 50) {
                if ((countWhoPouch &1)==0) {
                    tempHpCat2 = tempHpCat2 - ((cat.getSkill())/2);
                    System.out.println(cat.getName() + " zadał " + ((cat.getSkill())/2) + " obrażeń kotowi " + cat2.getName() + ". Zostało mu już tylko " + tempHpCat2 +" życia.\n");
                } else {
                    tempHpCat = tempHpCat - ((cat2.getSkill())/2);
                    System.out.println(cat2.getName() + " zadał " + ((cat2.getSkill())/2) + " obrażeń kotowi " + cat.getName() + ". Zostało mu już tylko " + tempHpCat +" życia.\n");
                }
            } else {
                if ((countWhoPouch &1)==0) {
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
            Thread.sleep(1000);
        }
    }
    public static void falseToCloneCatInfo() {
        System.out.println("Przecież kot się nie rozdwoi do walki.\n");}
    public static void checkCatSizeList() {
        System.out.println("W bazie danych występuje " + DaoCat.catList.size() + " futrzaków gotowych do walki!\n");
    }

    public static void getEndInfo() {
        System.out.println("\nZamknięcie programu. Życzę miłego dnia!");
    }

    public static void errorChooseOptionMenu() {
        System.out.println("Głupi jesteś? Masz wybrać cyfrę od 0 do 5!\n");
    }
    public static void menu() {
        System.out.println("Wprowadź 1, aby dodać kota.\nWprowadź 2, aby sprawdzić parametry kotów.\nWprowadź 3, aby przeprowadzić walkę kotów\nWprowadź 4, aby sprawdzić ile jest dostępnych kotów.\nWprowadź 5, aby wyczyścić konsolę.\nWprowadź 0, aby wyjść!");
    }
    public static void subMenu() throws Exception {
        System.out.println("Wybrano opcję dodaj kota\n");
        System.out.println("Zajmiemy się tworzeniem nowego kota.\nZacznijmy od podania jego imienia: ");
        String nameCat = ConsoleReader.readString();
        System.out.println("Doskonale! Dodajmy teraz numer umiejętności kota: ");
        int skillCat = ConsoleReader.readInt();
        System.out.println("Super, już tylko zostało nam wpisać wiek naszego futrzaka: ");
        int ageCat = ConsoleReader.readInt();
        DaoCat.addCat(new Cat(nameCat, skillCat, ageCat));

    }
    public static void infoCatFighterers() {
        System.out.println("Wybierz, który z kotów stanie do walki: ");
        int fighter = 0;
        for (Cat element : DaoCat.catList){
            System.out.println("Zawodnik numer " + fighter + " to: " + element.getName());
            fighter++;
        }
    }
    public static Cat chooseCatToFight() throws Exception {
        System.out.println("Wybierz numer zawodnika");
        int fighterCat = ConsoleReader.readInt();
        return DaoCat.catList.get(fighterCat);
    }
    public static Cat chooseCatToFight2() throws Exception {
        System.out.println("Wybierz numer drugiego zawodnika");
        int fighterCat = ConsoleReader.readInt();
        return DaoCat.catList.get(fighterCat);
    }
}
