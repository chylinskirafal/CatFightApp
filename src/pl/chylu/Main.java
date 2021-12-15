package pl.chylu;

public class Main {

    public static void main(String[] args) throws Exception {
        DaoUIText.loadUIList();

        boolean shouldContinue = true;
        while (shouldContinue) {
            DaoUIText.menu();
            int switchValue = ConsoleReader.readInt();
            switch (switchValue) {
                case 1:
                    DaoUIText.subMenu();
                    break;
                case 2:
                    for (Cat cat : DaoCat.returnCatParameter()) {
                        System.out.println(cat);
                    }
                    System.out.println();
                    break;
                case 3:
                    DaoUIText.infoCatFighterers();
                    DaoCat.fightCat(DaoUIText.chooseCatToFight(), DaoUIText.chooseCatToFight2());
                    break;
                case 4:
                    DaoUIText.checkCatSizeList();
                    break;
                case 5:
                    DaoCat.forceCleaningOfConsoles();
                    break;
                case 0:
                    DaoUIText.getEndInfo();
                    shouldContinue = false;
                    break;
                default:
                    DaoUIText.errorChooseOptionMenu();
                    break;
            }
        }
    }
}