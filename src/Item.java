import java.util.*;

/**
 *
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
        List<Integer> sort = new ArrayList<>(get_item_ratings());
        Collections.sort(sort);
        return sort.get((int)Math.ceil(get_item_ratings().size()/2));
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

    public Item get_item(){
        return this;
    }

    public int get_item_id(){
        return item_id;
    }

    public Set<Integer> get_item_users(){
        return user_rating.keySet();
    }

    public Collection<Integer> get_item_ratings() {
        return user_rating.values();
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

    public void print_item(){
        System.out.println("Item id: "+get_item_id());
        System.out.println("Mean rating: "+object_mean());
        System.out.println("Median rating: "+object_median());
        System.out.println("Max rating: "+getMax_rating());
        System.out.println("Min rating: "+getMin_rating());
        System.out.println("Standard deviation: "+std_dev()+"\n");
    }

}
