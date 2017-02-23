import java.util.HashMap;
import java.util.List;

/**
 * Created by vsevo on 23/02/2017.
 */
public class L10 {

    public double rmse(List<Integer> predicted, List<Integer> actual){
        if(predicted.size()!=actual.size()){
            return 0;
        }
        int sum =0;
        for(int i=0; i<predicted.size(); i++){
            sum += Math.pow(predicted.get(i)-actual.get(i), 2);
        }
        return Math.sqrt(sum/predicted.size());
    }

    public void leave_one_out(Populate pop){
        HashMap<Integer, HashMap<Integer, Integer>> users = pop.getUsers();
        
    }
}
