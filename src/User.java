import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Vsevolods Caka - 13340321 on 07/02/2017.
 */
public class User implements Statistics{
    private HashMap<Integer, HashMap<Integer, Integer>> usr;

    User(HashMap<Integer, HashMap<Integer, Integer>> in){
        usr = in;
    }

    public double item_mean(){
        int sum = 0;
        for(int i: get_usr_ratings()){
            sum += i;
        }
        return sum/get_usr_ratings().size();
    }

    public double item_median(){
        return get_usr_ratings().get((int)Math.ceil(get_usr_ratings().size()/2));
    }

    public double std_dev(){
        double mean = item_mean();
        int sum = 0;
        for(int i: get_usr_ratings()) {
            sum += (i - mean);
        }
        return Math.sqrt(sum/get_usr_ratings().size());
    }

    public int getMax_rating(){
        return Collections.max(get_usr_ratings());
    }

    public int getMin_rating(){
        return Collections.min(get_usr_ratings());
    }

    public int get_usr_id(){
        for(int key: usr.keySet()){
            return key;
        }
        return 0;
    }

    public List<Integer> get_usr_items(){
        for(HashMap<Integer,Integer> hm: usr.values()){
            return new ArrayList<>(hm.keySet());
        }
        return null;
    }

    public List<Integer> get_usr_ratings(){
        for(HashMap<Integer,Integer> hm: usr.values()){
            return new ArrayList<>(hm.values());
        }
        return null;
    }
}
