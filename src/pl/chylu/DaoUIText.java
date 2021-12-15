package pl.chylu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DaoUIText {
    public static void fightCoreEngineUI(Cat cat, Cat cat2) throws InterruptedException {
        if (cat == cat2) {
            DaoUIText.falseToCloneCatInfo();
        } else {
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
                        System.out.println(cat.getName() + listDodgeText[random.nextInt(11)]);
                    }
                    else  {
                        System.out.println(cat2.getName() + listDodgeText[random.nextInt(11)]);
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
        infoTextList.add(5, "Doskonale! Dodajmy teraz numer umiejętności kota: ");
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