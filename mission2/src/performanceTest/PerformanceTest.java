package performanceTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The {@code PerformanceTest} class is used for performance testing, analyzing differences between
 * binary search and linear search.It is executed automatically when built in Jenkins.

 *
 * @see PerformanceTestTarget
 *
 * @author 이상혁
 */
public class PerformanceTest {

    /**
     * The main method that initiates the performance test.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {

        printTestStart();
        // ID: 0~200000
        test(0,200000);

        printTestEnd();
    }

    /**
     * Performs the test on the specified range of IDs and logs the results.
     *
     * @param minId The minimum ID for the test range.
     * @param maxId The maximum ID for the test range.
     */
    private static void test(int minId, int maxId){
        PerformanceTestTarget performanceTestTarget = new PerformanceTestTarget(minId, maxId);
        int midId = (maxId + minId) / 2;

        write("+=+=+=+=+=+=+=+=+=  performance test result +=+=+=+=+=+=+=+=+=+=+=+=");
        write("*\tRange of test data is from %d to %d\n*", minId, maxId);
        write("*\tTest minimum Id : %d", minId);
        write(performanceTestTarget.testSearchBook(minId), performanceTestTarget.testSearch_bs(minId));

        write("*\tTest maximum Id : %d", maxId - 1);
        write(performanceTestTarget.testSearchBook(maxId-1), performanceTestTarget.testSearch_bs(maxId-1));

        write("*\tTest middle Id : %d", midId);
        write(performanceTestTarget.testSearchBook(midId),  performanceTestTarget.testSearch_bs(midId));
        write("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
    }

    /**
     * Logs the linear and binary search times.
     *
     * @param linearTime The time taken by the linear search.
     * @param binaryTime The time taken by the binary search.
     */
    private static void write(long linearTime, long binaryTime) {
        write("*\t\tLinear search time(searchBook) : %d ms", linearTime);
        write("*\t\tBinary search time(search_bs) : %d ms", binaryTime);
    }

    /**
     * Logs a message.
     *
     * @param str The message to be logged.
     */
    private static void write(String str) {
        System.out.println(str);
    }

    /**
     * Logs a formatted message.
     *
     * @param format The format string.
     * @param args   The arguments referenced by the format specifiers in the format string.
     */
    public static void write(String format, Object... args) {
        write(String.format(format, args));
    }

    /**
     * Logs the start of the test with a timestamp.
     */
    private static void printTestStart() {
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(DateTimeFormatter.ofPattern("yy.MM.dd HH:mm:ss"));
        write("Test start at %s in Jenkins Server / http://jack8226.ddns.net:3006", formattedDateTime);
    }

    /**
     * Logs the end of the test with a timestamp.
     */
    private static void printTestEnd() {
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(DateTimeFormatter.ofPattern("yy.MM.dd HH:mm:ss"));
        write("Test end at %s", formattedDateTime);
    }
}