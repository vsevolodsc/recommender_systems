import java.util.*;

/**
 * Created by Vsevolods Caka - 13340321 on 07/02/2017.
 */

public class Item implements Statistics{
private HashMap<Integer, HashMap<Integer, Integer>> item;    //Key - Item ID,
    Item(){
        set_item();
    }

    public double item_mean(){
        int sum = 0;
        for(int i: get_item_ratings()){
            sum += i;
        }
        return sum/get_item_ratings().size();
    }

    public double item_median(){
        return get_item_ratings().get((int)Math.ceil(get_item_ratings().size()/2));
    }

    public double std_dev(){
        
        return 0;
    }

    public int getMax_rating(){
        return Collections.max(get_item_ratings());
    }

    public int getMin_rating(){
        return Collections.min(get_item_ratings());
    }

    public void set_item(){

    }
    public HashMap<Integer, HashMap<Integer, Integer>> get_item(){
        return this.item;
    }

    public int get_item_id(){
        for(int key: item.keySet()){
            return key;
        }
        return 0;
    }

    public List<Integer> get_item_users(){
        for(HashMap<Integer,Integer> hm: item.values()){
            return new ArrayList<>(hm.keySet());
        }
        return null;
    }

    public List<Integer> get_item_ratings(){
        for(HashMap<Integer,Integer> hm: item.values()){
            return new ArrayList<>(hm.values());
        }
        return null;
    }
}
