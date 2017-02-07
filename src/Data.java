import java.util.List;

/**
 * Created by Vsevolods Caka - 13340321 on 07/02/2017.
 */
/*This class is responsible for /csv file manipulation and basic statistics*/
public class Data {
    Data(String filename){
        read_csv(filename);
    }
    public List<List<Integer>> read_csv(String filename){
        List<List<Integer>> data = null;
        return data;
    }

    public int count_users(List<List<Integer>> data){
        return 0;
    }

    public int count_items(List<List<Integer>> data){
        return 0;
    }

    public int count_ratings(List<List<Integer>> data){
        return 0;
    }



}
