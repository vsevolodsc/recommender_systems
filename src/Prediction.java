import java.io.*;
import java.util.*;

/**
 *
 * Created by vsevo on 22/02/2017.
 */
class Prediction {
    private HashMap<Integer, HashMap<Integer, Integer>> users = new HashMap<>();
    private HashMap<Integer, HashMap<Integer, Integer>> items = new HashMap<>();
    private FileWriter l1o_csv = null;
    private final String COMMA_DELIM = ",";
    private final String NEWLINE_DELIM = "\n";
    private final String header = "user_id,item_id,actual_rating,predicted_rating,RMSE";
    private List<KnnEntry> users_nn = new ArrayList<>();
    private int nearest_n_size=0;
    Prediction(Parser parser, int nn_size){
        users = populate_users(parser);
        items = populate_items(parser);
        nearest_n_size=nn_size;
        populate_knn();

    }
    /*START: Setup*/
    private void populate_knn(){
        for(int i=1; i<=942; i++){
            users_nn.add(knn_single(i,nearest_n_size));
        }
    }
    private static HashMap<Integer, HashMap<Integer,Integer>> populate_users(Parser parser){
        return parser.list_users();
    }

    private static HashMap<Integer, HashMap<Integer,Integer>> populate_items(Parser parser){
        return parser.list_items();
    }

    private HashMap<Integer, HashMap<Integer, Integer>> getUsers(){
        return users;
    }
    @SuppressWarnings("unused")
    public HashMap<Integer, HashMap<Integer, Integer>> getItems(){
        return items;
    }

    private Set<Integer> get_user_ids(){
        return users.keySet();
    }

    private Set<Integer> get_item_ids(){
        return items.keySet();
    }
    /*END: Setup*/

    /*START: Stats*/
    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
    public double density(){
        double denom = get_item_ids().size()*get_user_ids().size();
        return 100000/denom;
    }
    /*END: Stats*/

    /*START: Naive Rating prediction*/
    private double mean_item_rating(int user_id, int item_id){
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
    @SuppressWarnings("unused")
    public double leave_one_out_naive() throws IOException {
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
                    l1o_csv.append(String.valueOf(rating));
                    l1o_csv.append(COMMA_DELIM);
                    l1o_csv.append(String.valueOf(mean_item_rating(i, j)));
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
    /*END: Naive Rating Prediction*/

    /*START: K-nearest-neighbours(KNN) prediction approach*/
    private KnnEntry knn_single(int user, int neigh_size){
        //K-NN implementation - in hashmap: key->target_user, value->N closest neighbours
        TreeMap<Double, Integer> distances = new TreeMap<>(); //where key it the distance and value is user id
        //with this strat, I wont have to sort it to get n closest users
        HashMap<Integer, Integer> target = users.get(user);
        for(Map.Entry<Integer, HashMap<Integer, Integer>> itr: users.entrySet()){
            if(itr.getKey()==user){
                continue;
            }
            HashMap<Integer, Integer> temp = itr.getValue();
            double distance = euclid_distance(target, temp);
            distances.put(distance, itr.getKey());
        }
        HashMap<Double, Integer> out_prep = retrieve_n_fromlist(distances, neigh_size);
        HashMap<Integer, Double> out = flip_hashmap(out_prep);
        return new KnnEntry(user, out);
    }

    private double euclid_distance(HashMap<Integer, Integer> target,HashMap<Integer, Integer> users){
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

    private double mean_item_rating_knn(KnnEntry u, int item){
        HashMap<Integer, Double> nn = u.get_neighbours();
        HashMap<Integer, HashMap<Integer, Integer>> knn_users = new HashMap<>();
        for(int i: nn.keySet()){
            knn_users.put(i, users.get(i));
        }
        int count =0;
        int sum =0;
        for(Map.Entry<Integer, HashMap<Integer, Integer>> en: knn_users.entrySet()){
            if(en.getValue().containsKey(item)){
                count++;
                sum += en.getValue().get(item);
            }
        }
        return sum/count;
    }

    private HashMap<Double, Integer> retrieve_n_fromlist(Map<Double, Integer> in, int n){
        HashMap<Double, Integer> output = new HashMap<>();
        for(Map.Entry<Double, Integer> i: in.entrySet()){
            if(output.size()<n){
                output.put(i.getKey(),i.getValue());
            }else{
                break;
            }
        }
        return output;
    }

    double leave_one_out_knn() throws IOException{
        //Returns the average rmse
        String file_string = "./L1O_knn_"+nearest_n_size+".csv";
        l1o_csv = new FileWriter(file_string);
        l1o_csv.append(header);
        l1o_csv.append(NEWLINE_DELIM);
        int count =0;
        int total_rmse=0;
        for(int i=0; i<get_user_ids().size(); i++){
            for(int j=0; j<get_item_ids().size(); j++) {
                try{
                    int rating = getUsers().get(i).get(j);
                    double mean_rating = mean_item_rating_knn(users_nn.get(i),j);
                    double rmse = Math.abs(mean_rating- rating);
                    total_rmse += rmse;
                    l1o_csv.append(String.valueOf(i));
                    l1o_csv.append(COMMA_DELIM);
                    l1o_csv.append(String.valueOf(j));
                    l1o_csv.append(COMMA_DELIM);
                    l1o_csv.append(String.valueOf(rating));
                    l1o_csv.append(COMMA_DELIM);
                    l1o_csv.append(String.valueOf(mean_rating));
                    l1o_csv.append(COMMA_DELIM);
                    l1o_csv.append(String.valueOf(rmse));
                    l1o_csv.append(NEWLINE_DELIM);
                    count++;
                    l1o_csv.flush();
                }catch (Exception e){
                }
            }
        }
        l1o_csv.close();
        return (double)total_rmse/count;
    }

    private HashMap<Integer, Double> flip_hashmap(HashMap<Double, Integer> in){
        HashMap<Integer, Double> out = new HashMap<>();
        for(Map.Entry<Double, Integer> i: in.entrySet()){
            out.put(i.getValue(),i.getKey());
        }
        return out;
    }
    /*END: K-nearest-neighbours(KNN) prediction approach*/

}
