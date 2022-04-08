package models;

public class Animal {
    private int id;
    private String title;
    protected  String animalCode;
    private String food;
    private static int animalCounter = 0;


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAnimalCode() {
        return animalCode;
    }

    public String getFood() {
        return food;
    }



    public void setId() {
        this.id = animalCounter++;
    }

    public void setTitle(String title) {
        if(!title.isEmpty() && title.matches("[A-ZĀĒŪĪĻĶĢŠŽČŅ]{1}[a-zēūīāšģķļņčž]+"))
        {
            this.title = title;
        }
        else
            this.title = "Unknown";
    }


    public void setFood(String food) {
        if(!food.isEmpty() && food.matches("[A-ZĀĒŪĪĻĶĢŠŽČŅ]{1}[a-zēūīāšģķļņčž]+"))
        {
            this.food = food;
        }
        else
            this.food = "Unknown";
    }

    public Animal() {
        setId();
        setTitle("Unknown");
        setFood("Unknown");
    }
    public Animal(String title, String food)
    {
        setId();
        setTitle(title);
        setFood(food);
    }

    @Override
    public String toString() {
        return "models.Animal{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", animalCode='" + animalCode + '\'' +
                ", food='" + food + '\'' +
                '}';
    }
}
