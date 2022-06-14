package Spam;

/**
 *
 * @author Marvin Chin Yi Kai
 */

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;
import de.daslaboratorium.machinelearning.classifier.Classifier;

public class RepostDetection {
    
    // Create a new bayes classifier with string categories and string features.
    static Classifier<String, String> repost = new BayesClassifier<String, String>();
    
    public RepostDetection() {
        // remember the last 100 learned classifications
        repost.setMemoryCapacity(100);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
