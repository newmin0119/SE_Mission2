package performanceTest;


public class PerformanceTest {
    private static void test(int minId, int maxId){
        System.out.println("Test Id " + minId + " to " + maxId);
        PerformanceTestTarget performanceTestTarget = new PerformanceTestTarget(minId, maxId);
        System.out.println("\tTest minimum Id");
        System.out.println("\t\tSearchBook: " + performanceTestTarget.testSearchBook(minId) + "ms");
        System.out.println("\t\tSearch_bs: " + performanceTestTarget.testSearch_bs(minId) + "ms");

        System.out.println("\tTest maximum Id");
        System.out.println("\t\tSearchBook: " + performanceTestTarget.testSearchBook(maxId-1) + "ms");
        System.out.println("\t\tSearch_bs: " + performanceTestTarget.testSearch_bs(maxId-1) + "ms");

        int midId = (maxId + minId) / 2;
        System.out.println("\tTest middle Id");
        System.out.println("\t\tSearchBook: " + performanceTestTarget.testSearchBook(midId) + "ms");
        System.out.println("\t\tSearch_bs: " + performanceTestTarget.testSearch_bs(midId) + "ms");
    }

    public static void main(String[] args) {
        // ID: 0~200000
        test(0,200000);
    }
}