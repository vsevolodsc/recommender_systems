import java.io.*;
import java.util.*;

/**
 *
 * Created by Vsevolods Caka on 13/02/2017.
 */
public class Main {
    private static List<List<Integer>> fileIn = new ArrayList<>();

    public static void main(String[] args)throws IOException {
        int n = 150;
        read_file();
        //START:: DO NOT TOUCH
        Parser parser = new Parser(fileIn);
        Prediction pred_naive = new Prediction(parser);
        Prediction pred_nn = new Prediction(parser,n);
        //END:: DO NOT TOUCH

        Output out = null;

        out = pred_naive.leave_one_out_naive();
        System.out.println(out.getRmse());
        System.out.println(out.getCoverage());
        //test_user_stat(parser);
        //test_item_stat(parser);
        //test_naive();
        //test_knn();
        //test_resnicks();


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
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");
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
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

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
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

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
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

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
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser,30);
        output=null;
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_knn();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing knn with nn size = 30");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

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
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser,40);
        output=null;
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_knn();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing knn with nn size = 40");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser,45);
        output=null;
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_knn();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing knn with nn size = 45");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser,50);
        output=null;
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_knn();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing knn with nn size = 50");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser,55);
        output=null;
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_knn();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing knn with nn size = 55");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser,60);
        output=null;
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_knn();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing knn with nn size = 60");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser,65);
        output=null;
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_knn();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing knn with nn size = 70");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser,70);
        output=null;
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_knn();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing knn with nn size = 70");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        parser = new Parser(fileIn);
        output=null;
        pred = new Prediction(parser,75);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_knn();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Testing knn with nn size = 75");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser, 80);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_knn();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Testing knn with nn size = 80");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser, 85);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_knn();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Testing knn with nn size = 85");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser, 90);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_knn();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Testing knn with nn size = 90");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

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
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

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
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

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
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

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
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser,30);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing resnick with nn size = 30");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

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
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser,40);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing resnick with nn size = 40");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser,45);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing resnick with nn size = 45");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser,50);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing resnick with nn size = 50");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser,55);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing resnick with nn size = 55");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser,60);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing resnick with nn size = 60");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser,65);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing resnick with nn size = 65");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser,70);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing resnick with nn size = 70");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        output=null;
        pred = new Prediction(parser,75);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Testing resnick with nn size = 75");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser, 80);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Testing resnick with nn size = 80");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser, 85);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Testing resnick with nn size = 85");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser, 90);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Testing resnick with nn size = 90");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser, 95);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Testing resnick with nn size = 95");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser, 100);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Testing resnick with nn size = 95");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser, 105);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Testing resnick with nn size = 105");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        pred = new Prediction(parser, 110);
        total_time10=0;
        for(int i=0; i<10;i++){
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 +=runTime;
        }
        System.out.println("Testing resnick with nn size = 105");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");
        total_time10=0;

        pred = new Prediction(parser,150);
        for(int i=0; i<10;i++) {
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing resnick with nn size = 150");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

        total_time10=0;
        pred = new Prediction(parser,170);
        for(int i=0; i<10;i++) {
            long startTime = System.currentTimeMillis();
            output = pred.leave_one_out_resnicks();
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            total_time10 += runTime;
        }
        System.out.println("Testing resnick with nn size = 170");
        System.out.println("RMSE = "+ output.getRmse());
        System.out.println("Coverage = "+ output.getCoverage());
        System.out.println("Average runtime: "+total_time10/10/1000+" seconds\n");

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

    private static void print_user_stat(Parser pars) throws IOException{
        String header = "user_id,mean,median,std_dev,min,max";
        char nw = '\n';
        char cm = ',';
        FileWriter fw = new FileWriter("/csv_out/user_stats.csv");
        fw.append(header);
        fw.append(nw);
        List<User> users = new ArrayList<>();
        for(Map.Entry<Integer, HashMap<Integer, Integer>> en: pars.list_users().entrySet()){
            User temp = new User(en.getKey(), en.getValue());
            users.add(temp);
        }
        for(User usr: users){
            fw.append(String.valueOf(usr.get_usr_id()));
            fw.append(cm);
            fw.append(String.valueOf(usr.object_mean()));
            fw.append(cm);
            fw.append(String.valueOf(usr.object_median()));
            fw.append(cm);
            fw.append(String.valueOf(usr.std_dev()));
            fw.append(cm);
            fw.append(String.valueOf(usr.getMin_rating()));
            fw.append(cm);
            fw.append(String.valueOf(usr.getMax_rating()));
            fw.append(nw);
            fw.flush();
        }
        fw.close();
    }

    private static void print_item_stat(Parser pars) throws IOException{
        String header = "user_id,mean,median,std_dev,min,max";
        char nw = '\n';
        char cm = ',';
        FileWriter fw = new FileWriter("/csv_out/item_stats.csv");
        fw.append(header);
        fw.append(nw);
        List<Item> items = new ArrayList<>();
        for(Map.Entry<Integer, HashMap<Integer, Integer>> en: pars.list_items().entrySet()){
            Item temp = new Item(en.getKey(), en.getValue());
            items.add(temp);
        }
        for(Item itm: items){
            itm.print_item();
        }
        for(Item itm: items){
            fw.append(String.valueOf(itm.get_item_id()));
            fw.append(cm);
            fw.append(String.valueOf(itm.object_mean()));
            fw.append(cm);
            fw.append(String.valueOf(itm.object_median()));
            fw.append(cm);
            fw.append(String.valueOf(itm.std_dev()));
            fw.append(cm);
            fw.append(String.valueOf(itm.getMin_rating()));
            fw.append(cm);
            fw.append(String.valueOf(itm.getMax_rating()));
            fw.append(nw);
            fw.flush();
        }
        fw.close();
    }

}
