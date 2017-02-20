import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.*;

/**
 * Created by vsevo on 13/02/2017.
 */
public class Main {
    private static List<List<Integer>> fileIn = new ArrayList<>();

    public static void main(String[] args)throws IOException {
        read_file();
        Parser parser = new Parser(fileIn);
        List<User> users = populate_users(parser);
        List<Item> items = populate_items(parser);

        for(User temp: users){
            System.out.println(temp.std_dev());
        }


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

    private static void read_file() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("src/100k.csv"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] elts = line.split(",");
            if (elts.length < 4)
                throw new RuntimeException("line to short");
            List<Integer> token = new ArrayList<>();
            token.add(0, Integer.valueOf(elts[0]));
            token.add(1, Integer.valueOf(elts[1]));
            token.add(2, Integer.valueOf(elts[2]));
            fileIn.add(token);
        }
    }
    public static void print_file(){
        for(int i = 0; i < fileIn.size(); i++){
            System.out.println(fileIn.get(i));
        }
    }
}
