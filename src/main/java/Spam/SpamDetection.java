package Spam;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;
import de.daslaboratorium.machinelearning.classifier.Classifier;

/*
Implementing Spam Detection using Bayes classification Method
*/

/* Interface
The abstract Classifier<T, K> serves as a base for the concrete BayesClassifier<T, K>. Here are its methods. Please also refer to the Javadoc.
    void reset() Resets the learned feature and category counts.
    Set<T> getFeatures() Returns a Set of features the classifier knows about.
    Set<K> getCategories() Returns a Set of categories the classifier knows about.
    int getCategoriesTotal() Retrieves the total number of categories the classifier knows about.
    int getMemoryCapacity() Retrieves the memory's capacity.
    void setMemoryCapacity(int memoryCapacity) Sets the memory's capacity. If the new value is less than the old value, the memory will be truncated accordingly.
    void incrementFeature(T feature, K category) Increments the count of a given feature in the given category. This is equal to telling the classifier, that this feature has occurred in this category.
    void incrementCategory(K category) Increments the count of a given category. This is equal to telling the classifier, that this category has occurred once more.
    void decrementFeature(T feature, K category) Decrements the count of a given feature in the given category. This is equal to telling the classifier that this feature was classified once in the category.
    void decrementCategory(K category) Decrements the count of a given category. This is equal to telling the classifier, that this category has occurred once less.
    int getFeatureCount(T feature, K category) Retrieves the number of occurrences of the given feature in the given category.
    int getFeatureCount(T feature) Retrieves the total number of occurrences of the given feature.
    int getCategoryCount(K category) Retrieves the number of occurrences of the given category.
    float featureProbability(T feature, K category) (implements IFeatureProbability<T, K>.featureProbability) Returns the probability that the given feature occurs in the given category.
    float featureWeighedAverage(T feature, K category) Retrieves the weighed average P(feature|category) with overall weight of 1.0 and an assumed probability of 0.5. The probability defaults to the overall feature probability.
    float featureWeighedAverage(T feature, K category, IFeatureProbability<T, K> calculator) Retrieves the weighed average P(feature|category) with overall weight of 1.0, an assumed probability of 0.5 and the given object to use for probability calculation.
    float featureWeighedAverage(T feature, K category, IFeatureProbability<T, K> calculator, float weight)Retrieves the weighed average P(feature|category) with the given weight and an assumed probability of 0.5 and the given object to use for probability calculation.
    float featureWeighedAverage(T feature, K category, IFeatureProbability<T, K> calculator, float weight, float assumedProbability) Retrieves the weighed average P(feature|category) with the given weight, the given assumed probability and the given object to use for probability calculation.
    void learn(K category, Collection<T> features) Train the classifier by telling it that the given features resulted in the given category.
    void learn(Classification<T, K> classification) Train the classifier by telling it that the given features resulted in the given category.
The BayesClassifier<T, K> class implements the following abstract method:
    Classification<T, K> classify(Collection<T> features) It will retrieve the most likely category for the features given and depends on the concrete classifier implementation.
*/

public class SpamDetection {    
    // Create a new bayes classifier with string categories and string features.
    static Classifier<String, String> bayes = new BayesClassifier<String, String>();

    public SpamDetection() {
        // remember the last 6000 learned classifications
        bayes.setMemoryCapacity(6000);
        
        try {          
            Scanner hm = new Scanner(new File("src\\main\\resources\\DataSet\\hamdata.txt"));
            while(hm.hasNext()) {
                String str = hm.nextLine();
                learnNegative(str);
            }
            hm.close();
            
            Scanner sp = new Scanner(new File("src\\main\\resources\\DataSet\\spamdata.txt"));
            while(sp.hasNext()) {
                String str = sp.nextLine();
                learnPositive(str);
            }  
            sp.close();          
        } catch (Exception e) {
            System.out.println("Error in Training Model");
        }
    }

    // Data labelled as SPAM
    public void learnPositive(String str) {
        String[] positiveText = str.split("\\s");
        bayes.learn("positive", Arrays.asList(positiveText));
    }
    
    // Data not labelled as SPAM
    public void learnNegative(String str) {
        String[] negativeText = str.split("\\s");
        bayes.learn("negative", Arrays.asList(negativeText));
    }
    
    public boolean classifySpam(String str) {
        String[] unknownText = str.split("\\s");
        if(bayes.classify(Arrays.asList(unknownText)).getCategory().equals("positive")) {
            return true;
        } else {
            return false;
        }
    }
}
