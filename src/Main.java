import java.io.*;
import java.util.*;

/**
 *
 * Created by Vsevolods Caka on 13/02/2017.
 */
public class Main {
    private static List<List<Integer>> fileIn = new ArrayList<>();

    public static void main(String[] args)throws IOException {
        read_file();
        test_naive();
        test_knn();
        test_resnicks();
    }

    private static void test_naive() throws IOException{
        Parser parser = new Parser(fileIn);
        Prediction pred = new Prediction(parser);
        double total_time10=0;
        Output output=null;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_naive();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing naive approach");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/1000+" seconds\n");
    }

    private static void test_knn() throws IOException{
        Parser parser = new Parser(fileIn);
        Output output=null;
        Prediction pred = new Prediction(parser,10);
        double total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_knn();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Testing knn with nn size = 10");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/1000+" seconds");

        pred = new Prediction(parser,15);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_knn();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Testing knn with nn size = 15");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/1000+" seconds");

        pred = new Prediction(parser,20);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_knn();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Testing knn with nn size = 20");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/1000+" seconds");

        pred = new Prediction(parser,25);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_knn();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Testing knn with nn size = 25");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/1000+" seconds");

        pred = new Prediction(parser,35);
        output=null;
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_knn();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing knn with nn size = 35");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/1000+" seconds");
    }

    private static void test_resnicks() throws IOException{
        Parser parser = new Parser(fileIn);
        Output output=null;

        Prediction pred = new Prediction(parser,10);
        double total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing resnick with nn size = 10");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/1000+" seconds");

        pred = new Prediction(parser,15);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing resnick with nn size = 15");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/1000+" seconds");

        pred = new Prediction(parser,20);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Testing resnick with nn size = 20");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/1000+" seconds");

        pred = new Prediction(parser,25);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing resnick with nn size = 25");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/1000+" seconds");

        pred = new Prediction(parser,35);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing resnick with nn size = 35");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/1000+" seconds");
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
