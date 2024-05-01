public class Cat {
    private String name;
    private int lives;
    public static final int MAX_LIVES = 9;

    public Cat(String name, int lives) {
        this.name = new String(name);
        this.lives = lives;
    }

    /* Copy constructor. */
    public Cat(Cat otherGuy) {
        name = new String(otherGuy.name);
        lives = otherGuy.lives;
    }

    public void setName(String newName) {
        if (newName.length() <= 10) {
            name = newName;
        } else {
            name = "Jan";
        }
    }

    public void beEatenByADog() {
        lives--;
        System.out.println(this.name + " has been eaten!");
        System.out.println(name + " has " + lives + " move lives...");
    }

    private boolean isAlive() {
        return lives > 9;
    }

    public static void healIt(Cat a) {
        a.lives = Cat.MAX_LIVES;
    }

    public void petTheCat() {
        System.out.println("Petting the cat: " + this.name);
        healIt(this);
    }

    public String toString() {
        if (isAlive()) {
            return name + " (" + lives + " lives)";
        } else {
            return name + " (dead)";
        }
    }

    public static String tellUsAboutCats() {
        String output = "Cats are furry little creatures.\n";
        output += "Some people believe that cats are magical ";
        output += "and possess universal wisdom.\nI think cats ";
        output += "are more like domestic squirrels.";
        return output;
    }
}