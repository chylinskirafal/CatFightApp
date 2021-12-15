package pl.chylu;

public class Main {

    public static void main(String[] args) throws Exception {

        boolean shouldContinue = true;
        while (shouldContinue) {
            menu();
            int switchValue = ConsoleReader.readInt();
            switch (switchValue) {
                case 1:
                    subMenu();
                    break;
                case 2:
                    for (Cat cat : DaoCat.returnCatParameter()) {
                        System.out.println(cat);
                    }
                    System.out.println();
                    break;
                case 3:
                    infoCatFighterers();
                    DaoCat.fightCat(chooseCatToFight(), chooseCatToFight2());
                    break;
                case 4:
                    DaoCat.checkCatSizeList();
                    break;
                case 5:
                    for (int i = 0; i < 20; i++)
                        System.out.println();
                    break;
                case 0:
                    System.out.println("\nZamknięcie programu. Życzę miłego dnia!");
                    shouldContinue = false;
                    break;
                default:
                    System.out.println("Głupi jesteś? Masz wybrać cyfrę od 0 do 3!\n");
                    break;
            }
        }
    }

    private static void menu() {
        System.out.println("Wprowadź 1, aby dodać kota.\nWprowadź 2, aby sprawdzić parametry kotów.\nWprowadź 3, aby przeprowadzić walkę kotów\nWprowadź 4, aby sprawdzić ile jest dostępnych kotów.\nWprowadź 5, aby wyczyścić konsolę.\nWprowadź 0, aby wyjść!");
    }
    private static void subMenu() throws Exception {
        System.out.println("Wybrano opcję dodaj kota\n");
        System.out.println("Zajmiemy się tworzeniem nowego kota.\nZacznijmy od podania jego imienia: ");
        String nameCat = ConsoleReader.readString();
        System.out.println("Doskonale! Dodajmy teraz numer umiejętności kota: ");
        int skillCat = ConsoleReader.readInt();
        System.out.println("Super, już tylko zostało nam wpisać wiek naszego futrzaka: ");
        int ageCat = ConsoleReader.readInt();
        DaoCat.addCat(new Cat(nameCat, skillCat, ageCat));

    }
    private static void infoCatFighterers() {
        System.out.println("Wybierz, który z kotów stanie do walki: ");
        int fighter = 0;
        for (Cat element : DaoCat.catList){
            System.out.println("Zawodnik numer " + fighter + " to: " + element.getName());;
            fighter++;
        }
    }
    private static Cat chooseCatToFight() throws Exception {
        System.out.println("Wybierz numer zawodnika");
        int fighterCat = ConsoleReader.readInt();
        return DaoCat.catList.get(fighterCat);
    }
    private static Cat chooseCatToFight2() throws Exception {
        System.out.println("Wybierz numer drugiego zawodnika");
        int fighterCat = ConsoleReader.readInt();
        return DaoCat.catList.get(fighterCat);
    }
}