package Spam;

/**
 * Implementing Spam Detection using Bayes classification Method
 * @author Marvin Chin Yi Kai
 */

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;
import de.daslaboratorium.machinelearning.classifier.Classifier;

/* INTERFACE
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

/*
Issue: Spam detection is inaccurate as no good facebook spam dataset is available
To do: Find a good facebook spam dataset
*/
public class SpamDetection {    
    // Create a new bayes classifier with string categories and string features.
    static Classifier<String, String> bayes = new BayesClassifier<String, String>();

    public SpamDetection() {
        // remember the last 1000000 learned classifications
        bayes.setMemoryCapacity(1000000);
        
        // training model
        try {            
            Scanner fb = new Scanner(new File("src\\main\\resources\\DataSet\\FBdata.txt"));
            fb.useDelimiter(",,,");
            while(fb.hasNext()) {
                String str = fb.nextLine();
                learnNegative(str);
            }
            fb.close();   
            
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
                      
            Scanner twhm = new Scanner(new File("src\\main\\resources\\DataSet\\twitterham.txt"));
            while(twhm.hasNext()) {
                String str = twhm.nextLine();
                learnNegative(str);
            }
            twhm.close();          
            
            Scanner twsp = new Scanner(new File("src\\main\\resources\\DataSet\\twitterspam.txt"));
            while(twsp.hasNext()) {
                String str = twsp.nextLine();
                learnPositive(str);
            }  
            twsp.close();    
            
            Scanner emhm = new Scanner(new File("src\\main\\resources\\DataSet\\emailham.txt"));
            while(emhm.hasNext()) {
                String str = emhm.nextLine();
                learnNegative(str);
            }
            emhm.close();          
            
            Scanner emsp = new Scanner(new File("src\\main\\resources\\DataSet\\emailspam.txt"));
            while(emsp.hasNext()) {
                String str = emsp.nextLine();
                learnPositive(str);
            }  
            emsp.close();            
        } catch (Exception e) {
            System.out.println("Error in Training Model");
        }
    }

    // Content labelled as SPAM
    public void learnPositive(String str) {
        String[] positiveText = str.split("\\s");
        bayes.learn("positive", Arrays.asList(positiveText));
    }
    
    // Content labelled as not SPAM
    public void learnNegative(String str) {
        String[] negativeText = str.split("\\s");
        bayes.learn("negative", Arrays.asList(negativeText));
    }
    
    public boolean classifySpam(String str) {
        String[] unknownText = str.split("\\s");
        return bayes.classify(Arrays.asList(unknownText)).getCategory().equals("positive");
    }
    
    public static void main(String[] args) {
        SpamDetection spam = new SpamDetection();
        
        int count = 0;
        int tru = 0;
        int fal = 0;
        
        try {
            Scanner sc = new Scanner(new File("src\\main\\resources\\DataSet\\emailspam.txt"));
            while(sc.hasNext()) {
                String temp = sc.nextLine();
                System.out.println(spam.classifySpam(temp) + "  " +temp);
                if(spam.classifySpam(temp)) tru++;
                else fal++;
                count++;
            } 
        } catch (Exception e) {
            System.out.println("Error in Testing model");
        }
        
        System.out.println("");
        System.out.println(count);
        System.out.println("True count: " + tru);
        System.out.println("False count: " + fal);
        System.out.println("");
        
        String str = "Is this a spam";
        System.out.println(str);
        System.out.println(spam.classifySpam(str));
        System.out.println("");
    }   
}
