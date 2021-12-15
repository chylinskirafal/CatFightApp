package pl.chylu;

public class Main {

    public static void main(String[] args) throws Exception {

        boolean shouldContinue = true;
        while (shouldContinue) {
            DaoService.menu();
            int switchValue = ConsoleReader.readInt();
            switch (switchValue) {
                case 1:
                    DaoService.subMenu();
                    break;
                case 2:
                    for (Cat cat : DaoCat.returnCatParameter()) {
                        System.out.println(cat);
                    }
                    System.out.println();
                    break;
                case 3:
                    DaoService.infoCatFighterers();
                    DaoCat.fightCat(DaoService.chooseCatToFight(), DaoService.chooseCatToFight2());
                    break;
                case 4:
                    DaoService.checkCatSizeList();
                    break;
                case 5:
                    DaoCat.forceCleaningOfConsoles();
                case 0:
                    DaoService.getEndInfo();
                    shouldContinue = false;
                    break;
                default:
                    DaoService.errorChooseOptionMenu();
                    break;
            }
        }
    }
}