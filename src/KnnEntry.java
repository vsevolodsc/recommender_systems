import java.util.HashMap;
import java.util.List;

/**
 *
 * Created by Vsevolods Caka on 17/02/2017.
 */
public class KnnEntry {
    private int user;
    private HashMap<Integer, Double> neighbours;
    KnnEntry(int target, HashMap<Integer, Double> n){
        user = target;
        neighbours = n;
    }

    public int get_user(){
        return user;
    }
    public HashMap<Integer, Double> get_neighbours(){
        return neighbours;
    }
    public void print_knn(){
        System.out.println("User: "+user);
        System.out.println(neighbours.toString());
    }
}
