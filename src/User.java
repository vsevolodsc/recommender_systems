import java.util.*;

/**
 * Created by Vsevolods Caka - 13340321 on 07/02/2017.
 *
 */
public class User implements Statistics{
    private int user_id;
    private HashMap<Integer, Integer> item_rating;

    User(int user, HashMap<Integer, Integer> in){
        user_id = user;
        item_rating = in;
    }

    public double object_mean(){
        int sum = 0;
        for(int i: get_usr_ratings()){
            sum += i;
        }
        return sum/get_usr_ratings().size();
    }

    public double object_median(){
        List<Integer> sort = new ArrayList<>(get_usr_ratings());
        Collections.sort(sort);
        return sort.get((int)Math.ceil(get_usr_ratings().size()/2));
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
        return user_id;
    }

    Set<Integer> get_usr_items(){
        return item_rating.keySet();
    }

    Collection<Integer> get_usr_ratings(){
        return item_rating.values();
    }

    void print_user(){
        System.out.println("User id: "+get_usr_id());
        System.out.println("Mean rating: "+object_mean());
        System.out.println("Median rating: "+object_median());
        System.out.println("Max rating: "+getMax_rating());
        System.out.println("Min rating: "+getMin_rating());
        System.out.println("Standard deviation: "+std_dev()+"\n");
    }

}
