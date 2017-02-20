import java.util.*;

/**
 * Created by Vsevolods Caka - 13340321 on 07/02/2017.
 */
public class User implements Statistics{
    private Map.Entry<Integer, HashMap<Integer, Integer>> usr;

    User(Map.Entry<Integer, HashMap<Integer, Integer>> in){
        usr = in;
    }

    public double object_mean(){
        int sum = 0;
        for(int i: get_usr_ratings()){
            sum += i;
        }
        return sum/get_usr_ratings().size();
    }

    public double object_median(){
        return get_usr_ratings().get((int)Math.ceil(get_usr_ratings().size()/2));
    }

    public double std_dev(){
        double mean = object_mean();
        double sum = 0;
        for(int i: get_usr_ratings()) {
            sum += Math.pow((i - mean),2.0);
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
        return usr.getKey();
    }

    public List<Integer> get_usr_items(){
        HashMap<Integer,Integer> hm= usr.getValue();
        return new ArrayList<>(hm.keySet());
    }

    public List<Integer> get_usr_ratings(){
        HashMap<Integer,Integer> hm= usr.getValue();
        return new ArrayList<>(hm.values());
    }
}
