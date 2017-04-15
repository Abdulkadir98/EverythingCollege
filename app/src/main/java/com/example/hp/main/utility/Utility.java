package com.example.hp.main.utility;

import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import java.util.ArrayList;

/**
 * Created by santh on 2/23/2017.
 */

public class Utility {

    public static double predictionValue(ArrayList<Double> scores)
    {

        double tPercentValue = 2.132; //assuming 4 degrees of freedom and 95% lower bound confidence interval.
        int sampleSize=  scores.size(); //n value

        TDistribution tdistribution = new TDistribution((scores.size()-1));

//


        double t_percentage=tdistribution.density(tPercentValue); //t value

        //need to get mean and standard deviation


        double[] values_array = new double[sampleSize];


        for(int counter=0;counter<scores.size();counter++)
        {
            values_array[counter]=scores.get(counter).doubleValue();

        }

        Mean mean = new Mean();

        double meanVal = mean.evaluate(values_array); //mean

        StandardDeviation standardDeviation = new StandardDeviation();

        double stdDevVal = standardDeviation.evaluate(values_array); //standard deviation

        //Going to calculate lower bound

        double lowerBound = meanVal - (t_percentage*stdDevVal)*(1+(1/sampleSize));

        return lowerBound;








    }
}
