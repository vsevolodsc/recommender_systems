import java.util.HashMap;
import java.util.List;

/**
 * Created by Vsevolods Caka - 13340321 on 07/02/2017.
 */

public class Item implements Statistics{
    private HashMap<HashMap<Integer, Integer>, Integer> item;
    //Key - a hashmap with
    //          key: User Int
    //          value: Rating
    //Value - item_id
    Item(List<List<Integer>> data){
        set_item();
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

    public void set_item(){

    }
    public HashMap<HashMap<Integer, Integer>, Integer> get_item(){
        return this.item;
    }
}
