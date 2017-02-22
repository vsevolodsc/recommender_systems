import java.util.*;

/**
 * Created by vsevo on 22/02/2017.
 */
public class Populate {
    private List<User> users = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    public Populate(Parser parser){
        users = populate_users(parser);
        items = populate_items(parser);
    }

    private static List<User> populate_users(Parser parser){
        List<User> users = new ArrayList<>();
        for(Map.Entry<Integer, HashMap<Integer, Integer>> temp: parser.list_users().entrySet()){
            User usr = new User(temp);
            users.add(usr);
        }
        return users;
    }

    private static List<Item> populate_items(Parser parser){
        List<Item> items = new ArrayList<>();
        for(Map.Entry<Integer, HashMap<Integer, Integer>> temp: parser.list_items().entrySet()){
            Item itm = new Item(temp);
            items.add(itm);
        }
        return items;
    }

    public List<User> getUsers(){
        return users;
    }

    public List<Item> getItems(){
        return items;
    }

    public double mean_item_rating(int user_id, int item_id){
        int sum =0;
        int count = 0;
        for(User usr: users){
            if(usr.get_usr_id()!= user_id){
                if(usr.has_ratedItem(item_id)){
                    count++;
                    sum += usr.get_itemrating(item_id);
                }
            }
        }if(count==0){
            System.out.println(item_id+" : ");
            return 0.0;
        }
        return sum/count;
    }

    public List<Integer> get_user_ids(){
        List<Integer> user_ids = new ArrayList<>();
        for(User usr: users){
            user_ids.add(usr.get_usr_id());
        }
        return user_ids;
    }

    public List<Integer> get_item_ids(){
        List<Integer> item_ids = new ArrayList<>();
        for(Item itm: items){
            item_ids.add(itm.get_item_id());
        }
        return item_ids;
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
        double count =1;
        for(Item it: items){
            if(it.get_item_users().size()==1){
                count++;
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
