import java.io.*;
import java.security.spec.ECField;
import java.util.*;

/**
 * Created by vsevo on 22/02/2017.
 */
public class Prediction {
    private HashMap<Integer, HashMap<Integer, Integer>> users = new HashMap<>();
    private HashMap<Integer, HashMap<Integer, Integer>> items = new HashMap<>();
    private FileWriter l1o_csv = null;
    private final String COMMA_DELIM = ",";
    private final String NEWLINE_DELIM = "\n";
    private final String header = "user_id,item_id,actual_rating,predicted_rating,RMSE";

    public Prediction(Parser parser){
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
        for(Map.Entry<Integer, HashMap<Integer, Integer>> en: users.entrySet()){
            int key = en.getKey();
            if(key != user_id){
                if(en.getValue().entrySet().size() > 1){
                    if(en.getValue().containsKey(item_id)) {
                        count++;
                        sum += en.getValue().get(item_id);
                    }
                }
            }
        }if(count==0){
            return 0.0;
        }
        return sum/count;
    }

    public double leave_one_out() throws IOException {
        //Returns the average rmse
        File l1o = new File("./L10-out.csv");
        if(l1o.exists()){
            l1o.delete();
        }
        l1o_csv = new FileWriter("./L10-out.csv");
        l1o_csv.append(header);
        l1o_csv.append(NEWLINE_DELIM);
        int count =0;
        int total_rmse=0;
        for(int i=0; i<get_user_ids().size(); i++){
            for(int j=0; j<get_item_ids().size(); j++) {
                try{
                    int rating = getUsers().get(i).get(j);
                    double rmse = Math.abs(mean_item_rating(i, j) - rating);
                    total_rmse += rmse;
                    l1o_csv.append(String.valueOf(i));
                    l1o_csv.append(COMMA_DELIM);
                    l1o_csv.append(String.valueOf(j));
                    l1o_csv.append(COMMA_DELIM);
                    l1o_csv.append(String.valueOf(mean_item_rating(i, j)));
                    l1o_csv.append(COMMA_DELIM);
                    l1o_csv.append(String.valueOf(rating));
                    l1o_csv.append(COMMA_DELIM);
                    l1o_csv.append(String.valueOf(rmse));
                    l1o_csv.append(NEWLINE_DELIM);
                    count++;
                }catch (Exception e){
                }
            }
        }
        l1o_csv.flush();
        l1o_csv.close();
        return (double)total_rmse/count;
    }

    public Set<Integer> get_user_ids(){
        return users.keySet();
    }

    public Set<Integer> get_item_ids(){
        return items.keySet();
    }

    public HashMap<Integer, List<Integer>> generate_neighbours(int user, int neigh_size){
        //K-NN implemetation - in hashmap: key->target_user, value->N closest neighbours
        HashMap<Integer, List<Integer>> output = new HashMap<>();
        List<Integer> knn = new ArrayList<>();
        HashMap<Integer, Integer> user_val = users.get(user);


        return output;
    }

    public double euclid_distance(HashMap<Integer, Integer> target,HashMap<Integer, Integer> users){
        double distance =0;
        List<Integer> target_items = new ArrayList<>(target.keySet());
        List<Integer> user_items = new ArrayList<>(users.keySet());
        List<Integer> common = new ArrayList<>(target_items);
        common.retainAll(user_items);
        double dist=0;
        for(int i: common){
            dist += Math.pow(target.get(i)-users.get(i),2);
        }
        return dist/common.size();
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
