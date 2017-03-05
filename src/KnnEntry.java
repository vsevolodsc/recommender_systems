import java.util.List;

/**
 * Created by vsevo on 04/03/2017.
 */
public class KnnEntry {
    private int user;
    private List<Integer> neighbours;
    KnnEntry(int target, List<Integer> n){
        user = target;
        neighbours = n;
    }

    public int get_user(){
        return user;
    }
    public List<Integer> get_neighbours(){
        return neighbours;
    }
    public void print_knn(){
        System.out.println("User: "+user);
        System.out.println(neighbours.toString());
    }
}
