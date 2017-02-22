import java.util.*;

/**
 * Created by vsevo on 22/02/2017.
 */
public class Populate {
    private HashMap<Integer, HashMap<Integer, Integer>> users = new HashMap<>();
    private HashMap<Integer, HashMap<Integer, Integer>> items = new HashMap<>();
    public Populate(Parser parser){
        users = populate_users(parser);
        items = populate_items(parser);
    }

    private static HashMap<Integer, HashMap<Integer,Integer>> populate_users(Parser parser){
        return parser.list_users();
    }

    private static HashMap<Integer, HashMap<Integer,Integer>> populate_items(Parser parser){
        return parser.list_items();
    }

    public HashMap<Integer, HashMap<Integer, Integer>> getUsers(){
        return users;
    }

    public HashMap<Integer, HashMap<Integer, Integer>> getItems(){
        return items;
    }

    public double mean_item_rating(int user_id, int item_id){
        int sum =0;
        int count = 0;
        Iterator it = users.keySet().iterator();
        while(it.hasNext()){
            if((int)it.next()!= user_id){
                if(users.has_ratedItem(item_id)){
                    count++;
                    sum += u.get_itemrating(item_id);
                }
            }
        }if(count==0){
            return 0.0;
        }
        System.out.println("Hi");
        return sum/count;
    }

    public Set<Integer> get_user_ids(){
        return users.keySet();
    }

    public Set<Integer> get_item_ids(){
        return items.keySet();
    }

    public int cant_predict(){
        int count =0;
        for(int i: get_user_ids()){
            for(int j: get_item_ids()){
                if(mean_item_rating(i,j)==0){
                    count++;
                }
            }
        }
        return count;
    }

    public double coverage(){
       double denom = get_item_ids().size()*get_user_ids().size();
        double count =0;
        for(int i=0; i<get_user_ids().size(); i++){
            for(int j=0; j<get_item_ids().size(); j++){
                if(mean_item_rating(i,j)==0.0){
                    count++;
                }
            }
        }
        double numer = denom-count;
        return numer/denom;
    }

    public double density(){
        double denom = get_item_ids().size()*get_user_ids().size();
        return 100000/denom;
    }


}
