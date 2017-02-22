import java.util.*;

/**
 * Created by Vsevolods Caka - 13340321 on 07/02/2017.
 */

public class Item implements Statistics{
    private int item_id;
    private HashMap<Integer, Integer> user_rating;    //Key - Item ID,

    Item(int item, HashMap<Integer, Integer> in){
        item_id = item;
        user_rating = in;
    }

    public double object_mean(){
        int sum = 0;
        for(int i: get_item_ratings()){
            sum += i;
        }
        return sum/get_item_ratings().size();
    }

    public double object_median(){
        return get_item_ratings().get((int)Math.ceil(get_item_ratings().size()/2));
    }

    public double std_dev(){
        double mean = object_mean();
        int sum = 0;
        for(int i: get_item_ratings()) {
            sum += Math.pow((i - mean),2);
        }
        return Math.sqrt(sum/get_item_ratings().size());
    }

    public int getMax_rating(){
        return Collections.max(get_item_ratings());
    }

    public int getMin_rating(){
        return Collections.min(get_item_ratings());
    }

    public Map.Entry<Integer, HashMap<Integer, Integer>> get_item(){
        return this.item;
    }

    public int get_item_id(){
        return item_id;
    }

    public Set<Integer> get_item_users(){
        return user_rating.keySet();
    }

    public List<Integer> get_item_ratings() {
        List<Integer> rating = new ArrayList<>();
        for(int i: user_rating.values()){
            rating.add(i);
        }
        return rating;
    }

    public int total_ratings(int rating){
        int count =0;
        for (int i: get_item_ratings()){
            if(i==rating){
                count++;
            }
        }
        return count;
    }


}
