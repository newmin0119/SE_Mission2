package test;

import Books.BookManager;
import Books.BookManager.*;

public class PerformanceTest {
    private static void test(int minId, int maxId){
        System.out.println("Test Id " + minId + " to " + maxId);
        PerformanceTestTarget performanceTestTarget = new PerformanceTestTarget(minId, maxId);
        System.out.println("\tTest minimum Id");
        System.out.println("\t\tSearchBook: " + performanceTestTarget.testSearchBook(minId));
        System.out.println("\t\tSearch_bs: " + performanceTestTarget.testSearch_bs(minId));

        System.out.println("\tTest maximum Id");
        System.out.println("\t\tSearchBook: " + performanceTestTarget.testSearchBook(maxId-1));
        System.out.println("\t\tSearch_bs: " + performanceTestTarget.testSearch_bs(maxId-1));

        int midId = (maxId + minId) / 2;
        System.out.println("\tTest middle Id");
        System.out.println("\t\tSearchBook: " + performanceTestTarget.testSearchBook(midId));
        System.out.println("\t\tSearch_bs: " + performanceTestTarget.testSearch_bs(midId));
    }

    public static void main(String[] args) {
        // ID: 0~100
        test(0,10000);

        // ID: 0~1000
        test(0,1000000);

        // ID: 0~10000
        test(0,10000000);
    }
}