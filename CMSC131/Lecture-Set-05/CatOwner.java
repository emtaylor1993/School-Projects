public class CatOwner {
    private String name;
    private Cat pet;

    public CatOwner(String nameIn, Cat petIn) {
        pet = new Cat(petIn);
        name = nameIn;
    }

    public CatOwner(CatOwner otherGuy) {
        name = otherGuy.name;
        pet = otherGuy.pet;
    }

    public void walkPet() {
        pet.beEatenByADog();
    }

    public String toString() {
        return name + "[" + pet + "]";
    }
}
