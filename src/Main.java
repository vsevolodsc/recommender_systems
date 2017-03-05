import com.sun.org.apache.xpath.internal.SourceTree;
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
        Prediction pred = new Prediction(parser);

        /*double total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            pred.leave_one_out();
            long endTime   = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Average runtime of 10 L1o tests: "+total_time10/1000+" seconds");*/
        for(int i=1; i<=100; i++) {
            pred.knn_single(i, 10).print_knn();
        }

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


    public static void euclid_distance(){
        double distance =0;
        List<Integer> target_items = new ArrayList<>();
        target_items.add(1);
        target_items.add(2);
        target_items.add(3);
        target_items.add(4);
        target_items.add(5);
        List<Integer> user_items = new ArrayList<>();
        user_items.add(1);
        user_items.add(3);
        user_items.add(4);
        user_items.add(6);
        user_items.add(7);
        List<Integer> common = new ArrayList<>(target_items);
        common.retainAll(user_items);

        for(int i: common){
            System.out.println(i);
        }

    }

}
