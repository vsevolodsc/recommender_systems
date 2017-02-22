import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by vsevo on 13/02/2017.
 */
public class Parser {
    private List<List<Integer>> data = new ArrayList<>();

    Parser(List<List<Integer>> d){
        data = d;
    }

    public HashMap<Integer, HashMap<Integer, Integer>> list_items(){
        HashMap<Integer, HashMap<Integer, Integer>> out = new HashMap<>();
        for(List<Integer> entry: data){
            HashMap<Integer, Integer> temp= new HashMap<>();
            temp.put(entry.get(0), entry.get(2));
            if (out.get(entry.get(1))!=null) {
                out.get(entry.get(1)).put(entry.get(0), entry.get(2));
            }
            else{
                out.put(entry.get(1), temp);
            }
        }
        return out;
    }

    public HashMap<Integer, HashMap<Integer, Integer>> list_users(){
        HashMap<Integer, HashMap<Integer, Integer>> out = new HashMap<>();
        for(List<Integer> entry: data){
            HashMap<Integer, Integer> temp= new HashMap<>();
            temp.put(entry.get(1), entry.get(2));
            if (out.get(entry.get(0))!=null){
                out.get(entry.get(0)).put(entry.get(1), entry.get(2));
            }else{
                out.put(entry.get(0), temp);
            }
        }
        return out;
    }
}
