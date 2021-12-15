package pl.chylu;

public class Cat {
    private String name;
    private int skill;
    private int age;
    private int hpCat;

    public Cat(String name, int skill, int age) {
        this.name = name;
        this.skill = skill;
        this.age = age;
        hpCat = (2*skill) + (age > 8 ? 1 : 3) + 30;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHpCat() {
        return hpCat;
    }

    public void setHpCat(int hpCat) {
        this.hpCat = hpCat;
    }

    @Override
    public String toString() {
        return  "Imie kota = " + name +
                ", umiejętności = " + skill +
                ", wiek = " + age +
                ", zatem ma życia = " + hpCat +
                ".";
    }
}