package models;

public class Bug extends Animal{
    private String livingRequirements;
    private DoesItEatOtherBugs doesItEatOtherBugs;

    public String getLivingRequirements() {
        return livingRequirements;
    }

    public DoesItEatOtherBugs getDoesItEatOtherBugs() {
        return doesItEatOtherBugs;
    }

    public void generateAnimalCode()
    {
        this.animalCode = (super.getClass().getName().charAt(7) + // panemam 1 burtu no klases nosaukuma
                "_" + super.getId() + "_" + super.getTitle());
    }

    public void setLivingRequirements(String livingRequirements)
    {
        if(!livingRequirements.isEmpty() && livingRequirements.matches("[A-ZĀĒŪĪĻĶĢŠŽČŅ]{1}[a-zēūīāšģķļņčž]+"))
            this.livingRequirements = livingRequirements;
    }

    public void setDoesItEatOtherBugs(DoesItEatOtherBugs doesItEatOtherBugs) {
        if(doesItEatOtherBugs != null)
        {
            this.doesItEatOtherBugs = doesItEatOtherBugs;
        }
        else
            this.doesItEatOtherBugs = DoesItEatOtherBugs.OTHER;
    }


    public Bug() {
        super();
        generateAnimalCode();
        setLivingRequirements("Unknown");
        setDoesItEatOtherBugs(DoesItEatOtherBugs.OTHER);
    }

    public Bug(String title,  String food, String livingRequirements, DoesItEatOtherBugs doesItEatOtherBugs) {
        super(title, food);
        generateAnimalCode();
        setLivingRequirements(livingRequirements);
        setDoesItEatOtherBugs(doesItEatOtherBugs);
    }

    @Override
    public String toString() {
        return "Bug{" +
                "animalCode='" + animalCode + '\'' +
                ", livingRequirements='" + livingRequirements + '\'' +
                ", doesItEatOtherBugs=" + doesItEatOtherBugs +
                '}';
    }
}
