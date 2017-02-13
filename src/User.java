import java.util.HashMap;

/**
 * Created by Vsevolods Caka - 13340321 on 07/02/2017.
 */
public class User implements Statistics{
    private HashMap<HashMap<Integer, Integer>, Integer> usr;
    User(){
        //Key - a hashmap with
        //          key: Item
        //          value: Rating
        //Value - User id
        set_user();
    }

    public double item_mean(){
        return 0;
    }

    public double item_median(){
        return 0;
    }

    public double std_dev(){
        return 0;
    }

    public int getMax_rating(){
        return 0;
    }

    public int getMin_rating(){
        return 0;
    }

    private void set_user(){

    }
    public HashMap<HashMap<Integer, Integer>, Integer> get_item(){
        return this.usr;
    }
}
