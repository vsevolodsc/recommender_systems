/**
 *
 * Created by Vsevolods Caka on 28/02/2017.
 * Helper class for L1O output parsing
 */
public class Output {
    private double rmse =0;
    private double coverage =0;

    Output(double error, double cov){
        rmse=error;
        coverage=cov;
    }

    double getRmse(){
        return rmse;
    }
    double getCoverage(){
        return coverage;
    }
}
