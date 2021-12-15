package pl.chylu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DaoUIText {
    private static Random random = new Random();
    private static int tempDamage = 0;

    public static void fightCoreEngineUI(Cat cat, Cat cat2) throws InterruptedException {
        if (cat == cat2) {
            DaoUIText.falseToCloneCatInfo();
        } else {
            int countWhoPouch = 0;
            int tempHpCat = cat.getHpCat();
            int tempHpCat2 = cat2.getHpCat();
            boolean fightContinue = true;
            while (fightContinue) {
                int chanceToPouch = random.nextInt(100);
                if ((countWhoPouch &1)==0) {
                    damageToChanceToPouch(chanceToPouch, cat.getSkill());
                    if (tempDamage != 0) {
                        tempHpCat2 = tempHpCat2 - tempDamage;
                        System.out.println(cat.getName() + " zadał " + tempDamage + " obrażeń kotowi " + cat2.getName() + ". Zostało mu już tylko " + tempHpCat2 +" życia.\n");
                    } else {
                        System.out.println(cat.getName() + listDodgeText[random.nextInt(12)]);
                    }
                } else {
                    damageToChanceToPouch(chanceToPouch, cat.getSkill());
                    if (tempDamage != 0) {
                        tempHpCat2 = tempHpCat2 - tempDamage;
                        System.out.println(cat2.getName() + " zadał " + tempDamage + " obrażeń kotowi " + cat.getName() + ". Zostało mu już tylko " + tempHpCat +" życia.\n");
                    } else {
                        System.out.println(cat2.getName() + listDodgeText[random.nextInt(12)]);
                    }
                }

                countWhoPouch = countWhoPouch + 1;
                fightContinue = endFightCat(tempHpCat, tempHpCat2, cat.getSkill(), cat2.getSkill(), cat.getName(), cat2.getName());
                Thread.sleep(1300);
                tempDamage = 0;
            }
        }
    }
    private static void damageToChanceToPouch(int chanceToPouch, int skillCat) {
        if (chanceToPouch >= 50 && chanceToPouch< 60) {
            tempDamage = skillCat / 3;
        } else if (chanceToPouch >= 60 && chanceToPouch < 97) {
            tempDamage = skillCat;
        } else if (chanceToPouch >= 97) {
            tempDamage = skillCat * 3;
        }
    }
    private static boolean endFightCat(int tempHpCat, int tempHpCat2, int skillFirstCat, int skillSecondCat, String nameFirstCat, String nameSecondCat) {
        if (tempHpCat <= 0) {
            System.out.println("Kot " + nameSecondCat + " wygrał z kotem " + nameFirstCat + " i zostało mu jeszcze " + tempHpCat2 + " życia.\n");
            return false;
        } else if (tempHpCat2 <= 0) {
            System.out.println("Kot " + nameFirstCat + " wygrał z kotem " + nameSecondCat + " i zostało mu jeszcze " + tempHpCat + " życia.\n");
            return false;
        } else
            return true;
    }

    public static void falseToCloneCatInfo() {
        System.out.println(infoTextList.get(10));}
    public static void checkCatSizeList() {
        System.out.println("W bazie danych występuje " + DaoCat.catList.size() + " futrzaków gotowych do walki!\n");
    }

    public static void getEndInfo() {
        System.out.println(infoTextList.get(8));
    }

    public static void errorChooseOptionMenu() {
        System.out.println(infoTextList.get(9));
    }
    public static void menu() {
        System.out.println(infoTextList.get(7));
    }
    public static void subMenu() throws Exception {
        System.out.println(infoTextList.get(3));
        System.out.println(infoTextList.get(4));
        String nameCat = ConsoleReader.readString();
        System.out.println(infoTextList.get(5));
        int skillCat = ConsoleReader.readInt();
        System.out.println(infoTextList.get(6));
        int ageCat = ConsoleReader.readInt();
        DaoCat.addCat(new Cat(nameCat, skillCat, ageCat));

    }
    public static void infoCatFighterers() {
        System.out.println(infoTextList.get(2));
        int fighter = 0;
        for (Cat element : DaoCat.catList){
            System.out.println("Zawodnik numer " + fighter + " to: " + element.getName());
            fighter++;
        }
    }
    public static Cat chooseCatToFight() throws Exception {
        System.out.println(infoTextList.get(0));
        int fighterCat = ConsoleReader.readInt();
        return DaoCat.catList.get(fighterCat);
    }
    public static Cat chooseCatToFight2() throws Exception {
        System.out.println(infoTextList.get(1));
        int fighterCat = ConsoleReader.readInt();
        return DaoCat.catList.get(fighterCat);
    }
    public static void forceCleaningOfConsoles() {
        for (int i = 0; i < 20; i++)
            System.out.println();
    }
    public static List<String> infoTextList = new ArrayList<>();

    public static void loadUIList() {
        infoTextList.add(0, "Wybierz numer zawodnika");
        infoTextList.add(1, "Wybierz numer drugiego zawodnika");
        infoTextList.add(2, "Wybierz, który z kotów stanie do walki: ");
        infoTextList.add(3, "Wybrano opcję dodaj kota\n");
        infoTextList.add(4, "Zajmiemy się tworzeniem nowego kota.\nZacznijmy od podania jego imienia: ");
        infoTextList.add(5, "Doskonale! Dodajmy teraz liczbę umiejętności kota: ");
        infoTextList.add(6, "Super, już tylko zostało nam wpisać wiek naszego futrzaka: ");
        infoTextList.add(7, """
                Wprowadź 1, aby dodać kota.
                Wprowadź 2, aby sprawdzić parametry kotów.
                Wprowadź 3, aby przeprowadzić walkę kotów
                Wprowadź 4, aby sprawdzić ile jest dostępnych kotów.
                Wprowadź 5, aby wyczyścić konsolę.
                Wprowadź 0, aby wyjść!""");
        infoTextList.add(8, "\nZamknięcie programu. Życzę miłego dnia!");
        infoTextList.add(9, "Głupi jesteś? Masz wybrać cyfrę od 0 do 5!\n");
        infoTextList.add(10, "Przecież kot się nie rozdwoi do walki.\n");
    }

    public static String[] listDodgeText = new String[] {
            " chybił. No nie mógł trafić nic innego niż powietrze.\n",
            " trafił powietrze. Ciekawe czy poczuł jakiś opór.\n",
            " pudło. Nawet Najman by uniknął tego ciosu.\n",
            " nie trafił.\n",
            " ociera się o drapak. Pamięta o walce?\n",
            " chce mleko. Nie może poczekać do końca walki?\n",
            " poszedł w tej rundzie do kuwety. Po powrocie zapomniał zaatakować.\n",
            " znudził się walką. Może czas na obiad?!\n",
            " przed walką sztachnął się kocimiętką, właśnie poczuł jej skutki.\n",
            " założył rękawiczki na łapy gdy nie trafił. Koniec zabawy.\n",
            " zasyczał na przeciwnika. Ciekawe czy wie, że to nie wygra walki.\n",
            " o mały włos minął się z łepkiem przeciwnika. Cóż, łapa nie trafiła. To nie wina kota.\n"
    };
}