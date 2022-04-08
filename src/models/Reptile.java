package models;

public class Reptile extends Animal {
    private CanItJump canItJump;
    private Type type;

    public CanItJump getCanItJump() {
        return canItJump;
    }

    public Type getType() {
        return type;
    }


    public void generateAnimalCode()
    {
        this.animalCode = (super.getClass().getName().charAt(7) + // panemam 1 burtu no klases nosaukuma
        "_" + super.getId() + "_" + super.getTitle());
    }

    public void setCanItJump(CanItJump canItJump) {
        if(canItJump != null)
        {
            this.canItJump = canItJump;
        }
        else
            this.canItJump = CanItJump.NO;
    }

    public void setType(Type type) {
        if(canItJump != null)
        {
            this.type = type;
        }
        else
            this.type = Type.BEAR_LIVE_YOUNG;

    }

    public Reptile()
    {
        super();
        generateAnimalCode();
        setCanItJump(CanItJump.NO);
        setType(Type.BEAR_LIVE_YOUNG);

    }
    public Reptile(String title, String food, CanItJump canItJump, Type type)
    {
        super(title,food);
        generateAnimalCode();
        setCanItJump(canItJump);
        setType(type);
    }

    @Override
    public String toString() {
        return "Reptile{" +
                "animalCode='" + animalCode + '\'' +
                ", canItJump=" + canItJump +
                ", type=" + type +
                '}';
    }
}
