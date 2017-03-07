/**
 *
 * Created by Vsevolods Caka on 28/02/2017.
 */
public class Output {
    private double rmse =0;
    private double coverage =0;

    Output(double error, double cov){
        rmse=error;
        coverage=cov;
    }

    public double getRmse(){
        return rmse;
    }
    public double getCoverage(){
        return coverage;
    }
}
