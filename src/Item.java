import java.util.*;

/**
 * Created by Vsevolods Caka - 13340321 on 07/02/2017.
 */

public class Item implements Statistics{
private Map.Entry<Integer, HashMap<Integer, Integer>> item;    //Key - Item ID,

    Item(Map.Entry<Integer, HashMap<Integer, Integer>> in){
        item = in;
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

        return item.getKey();
    }

    public List<Integer> get_item_users(){
        HashMap<Integer,Integer> hm= item.getValue();
        return new ArrayList<>(hm.keySet());
    }

    public List<Integer> get_item_ratings() {
        HashMap<Integer, Integer> hm = item.getValue();
        return new ArrayList<>(hm.values());
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
