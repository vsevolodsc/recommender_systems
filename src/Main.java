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
        //test_naive();
        //test_knn();
    }

    private void test_naive() throws IOException{
        Parser parser = new Parser(fileIn);
        Prediction pred = new Prediction(parser,5);
        double total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            pred.leave_one_out_naive();
            long endTime   = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Average runtime of 10 L1o tests: "+total_time10/1000+" seconds");
    }

    private void test_knn() throws IOException{
        Parser parser = new Parser(fileIn);
        Prediction pred = new Prediction(parser,5);
        double total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            pred.leave_one_out_knn();
            long endTime   = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Average runtime of 10 L1o tests of knn approach with k=5 : "+total_time10/1000+" seconds");
        pred = new Prediction(parser,10);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            pred.leave_one_out_knn();
            long endTime   = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Average runtime of 10 L1o tests of knn approach with k=10 : "+total_time10/1000+" seconds");
        pred = new Prediction(parser,15);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            pred.leave_one_out_knn();
            long endTime   = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Average runtime of 10 L1o tests of knn approach with k=15 : "+total_time10/1000+" seconds");
        pred = new Prediction(parser,20);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            pred.leave_one_out_knn();
            long endTime   = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Average runtime of 10 L1o tests of knn approach with k=20 : "+total_time10/1000+" seconds");
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
