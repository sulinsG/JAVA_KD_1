package service;

import models.*;

import java.util.ArrayList;
import java.util.Date;

public class MainService {

    public static ArrayList<Animal> animalList = new ArrayList<>();
    public static ArrayList<FeedProduct> feedProductList = new ArrayList<>();


    public static void main(String[] args) {
        animalList.add(new Reptile("Ķirzaka", "Mušas", CanItJump.NO, Type.SHELLED_EGGS));
        animalList.add(new Reptile("Krokodils", "Gaļa", CanItJump.NO, Type.SHELLED_EGGS));
        animalList.add(new Reptile());


        animalList.add(new Bug("Vabole", "Gaļa", "Jebkādi", DoesItEatOtherBugs.YES));
        animalList.add(new Bug("Muša", "Gaļa", "Silti", DoesItEatOtherBugs.YES));
        animalList.add(new Bug());

        feedProductList.add(new FeedProduct());
        feedProductList.add(new FeedProduct("Gaļa", new Date(2022, 10, 15), 100));
        feedProductList.add(new FeedProduct("Mušas", new Date(2022, 6, 4), 50));

      ArrayList<Reptile> reptileArrayList =  getAllReptiles();
        for (Reptile temp: reptileArrayList
             ) {
            System.out.println(temp);
        }

        for (int i = 3; i < 5; i++) {
            if(isNeedForBugFoodOrder((Bug)animalList.get(4)) == false)
            {
                System.out.println(animalList.get(i).getTitle() +" doesn't needs more food");
            }
        }

       if(isPossibleToFeedAllBugs()== true)
       {
           System.out.println("All of the bugs can be fed");
       }
       else
           System.out.println("All of the bugs cannot be fed");
    }

    // funkcija pievieno Reptilus reptilu sarakstam
    public static boolean createNewReptile(String title, String food, CanItJump canItJump, Type type) {
        Reptile reptile = new Reptile(title, food, canItJump, type);
        if (animalList.contains(reptile)) {
            return false;
        } else {
            animalList.add(reptile);
            return true;
        }
    }

    // funkcija atgriez sarakstu ar reptiliem no kopeja dzivnieku masiva
    public static ArrayList<Reptile> getAllReptiles() {
        ArrayList<Reptile> reptileList = new ArrayList<>();
        for (Animal temp : animalList) {
            if (temp.getClass().getName() == "models.Reptile") {
                reptileList.add((Reptile) temp);
            }
        }
        return reptileList;

    }

    public static Reptile getReptileById(int reptileId) {
        if (reptileId > 0 && reptileId < 100000) {
            for (Animal temp : animalList) {
                if (temp.getClass().getName() == "models.Reptile" && temp.getId() == reptileId) {
                    return (Reptile) temp;
                }
            }
        }
        return new Reptile();
    }


    /*
            this.animalCode = (super.getClass().getName().substring(0,1) + // panemam 1 burtu no klases nosaukuma
        "_" + super.getId() + "_" + super.getTitle());
 Piemēram, Z_3_Kaķis.

     */
    public static Reptile getReptileByAnimalCode(String animalCode) {
        if (!animalCode.isEmpty() && animalCode.matches("[A-ZĀĒŪĪĻĶĢŠŽČŅ]{1}_[/d]{1,6}_[A-ZĀĒŪĪĻĶĢŠŽČŅ]{1}[a-zēūīāšģķļņčž]+")) {
            for (Animal temp : animalList) {
                if (temp.getClass().getName() == "models.Reptile" && temp.getAnimalCode() == animalCode) {
                    return (Reptile) temp;
                }
            }
        }
        return new Reptile();

    }

    //TODO
    public static boolean updateReptileById(int reptileId, String title, String food, CanItJump canItJump, Type type) {

        if (reptileId > 0 && reptileId < 100000) {
            for (Animal temp : animalList) {
                if (temp.getClass().getName() == "models.Reptile" && temp.getId() == reptileId) {
                    temp.setTitle(title);
                    temp.setFood(food);
                    super.
                    //.setCanItJump();
                    return true;
                }
            }
        }
            return false;
    }


    public static boolean deleteReptileById(int reptileId) {
        if (reptileId > 0 && reptileId < 100000) {
            for (Animal temp : animalList) {
                if (temp.getClass().getName() == "models.Reptile" && temp.getId() == reptileId) {
                    animalList.remove(temp);
                    return true;
                }
            }

        }
        return false;
    }

    public static int howManyFeedUnitsForBugs(Bug bug)
    {
        //veic aprekinu, cik daudz baribas vienibas palikusas attiecigajam dzivniekam
        if(bug != null)
        {
            String bugFood = bug.getFood();
            for (FeedProduct temp: feedProductList) {
                if(temp.getTitle() == bugFood)
                {
                    return temp.getQuantity();
                }
            }

        }

        return 0;
    }

    //parbauda vai ir iespejams pabarot VISUS kukainus
    public static boolean isPossibleToFeedAllBugs()
    {
        for (Animal temp: animalList) {
            if(temp.getClass().getName() == "models.Bug")
            {
                if(howManyFeedUnitsForBugs((Bug)temp) > 0)
                    continue;

                else
                    return false;

                /*
                for (FeedProduct food: feedProductList) {
                    if(temp.getFood() == food.getTitle())
                    {

                    }


                }

                 */
            }

        }
    return true;
    }

    public static boolean isNeedForBugFoodOrder(Bug bug)
    {
        if(howManyFeedUnitsForBugs(bug) >= 5)
            return false;
        else
            return true;


    }
}