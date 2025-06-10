package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 14: Advanced Aggregation and Grouping
 * 
 * This exercise focuses on advanced aggregation operators:
 * - GroupBy operations
 * - Scan operations (running totals)
 * - Reduce with complex accumulators
 * - Custom collectors and aggregations
 * 
 * @author openhands
 */
public class Exercise14 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.extendedUserFlux(), ReactiveSources.temperatureFlux(),
        // ReactiveSources.categoryFlux(), and ReactiveSources.intNumbersFlux()

        System.out.println("=== Exercise 14: Advanced Aggregation and Grouping ===\n");

        // 1. Group users by first letter of their first name
        System.out.println("1. GroupBy - users by first letter of name:");
        // TODO: Write code here
        // ReactiveSources.extendedUserFlux()
        //     .groupBy(user -> user.getFirstName().charAt(0))
        //     .flatMap(group -> 
        //         group.collectList().map(users -> 
        //             "Letter '" + group.key() + "': " + 
        //             users.stream().map(User::getFirstName).toList()
        //         )
        //     )
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 2. Scan - running total of numbers
        System.out.println("2. Scan - running total:");
        // TODO: Write code here
        // ReactiveSources.intNumbersFlux()
        //     .take(8)
        //     .scan(0, Integer::sum)
        //     .subscribe(runningTotal -> System.out.println("Running total: " + runningTotal));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 3. Scan with custom accumulator - running statistics
        System.out.println("3. Scan with custom accumulator - running statistics:");
        // TODO: Write code here
        // ReactiveSources.temperatureFlux()
        //     .scan(new TemperatureStats(), (stats, temp) -> {
        //         TemperatureStats newStats = new TemperatureStats();
        //         newStats.count = stats.count + 1;
        //         newStats.sum = stats.sum + temp;
        //         newStats.min = Math.min(stats.min, temp);
        //         newStats.max = Math.max(stats.max, temp);
        //         newStats.average = newStats.sum / newStats.count;
        //         return newStats;
        //     })
        //     .skip(1)  // Skip initial empty stats
        //     .subscribe(stats -> System.out.println(
        //         String.format("Stats: count=%d, avg=%.1f°C, min=%.1f°C, max=%.1f°C", 
        //             stats.count, stats.average, stats.min, stats.max)
        //     ));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 4. Reduce with complex accumulator - word frequency
        System.out.println("4. Reduce - category frequency count:");
        // TODO: Write code here
        // ReactiveSources.categoryFlux()
        //     .reduce(new java.util.HashMap<String, Integer>(), (map, category) -> {
        //         map.put(category, map.getOrDefault(category, 0) + 1);
        //         return map;
        //     })
        //     .subscribe(frequencies -> {
        //         System.out.println("Category frequencies:");
        //         frequencies.forEach((category, count) -> 
        //             System.out.println("  " + category + ": " + count + " times")
        //         );
        //     });

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 5. GroupBy with aggregation - statistics per category
        System.out.println("5. GroupBy with aggregation - count per category:");
        // TODO: Write code here
        // ReactiveSources.categoryFlux()
        //     .groupBy(category -> category)
        //     .flatMap(group -> 
        //         group.count().map(count -> 
        //             "Category " + group.key() + ": " + count + " occurrences"
        //         )
        //     )
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 6. Collect into custom collection
        System.out.println("6. Custom collection - user names by length:");
        // TODO: Write code here
        // ReactiveSources.extendedUserFlux()
        //     .collect(
        //         () -> new java.util.TreeMap<Integer, List<String>>(),
        //         (map, user) -> {
        //             int length = user.getFirstName().length();
        //             map.computeIfAbsent(length, k -> new ArrayList<>())
        //                .add(user.getFirstName());
        //         }
        //     )
        //     .subscribe(namesByLength -> {
        //         System.out.println("Names grouped by length:");
        //         namesByLength.forEach((length, names) -> 
        //             System.out.println("  Length " + length + ": " + names)
        //         );
        //     });

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 7. Complex grouping - users by name length with statistics
        System.out.println("7. Complex grouping - user statistics by name length:");
        // TODO: Write code here
        // ReactiveSources.extendedUserFlux()
        //     .groupBy(user -> user.getFirstName().length())
        //     .flatMap(group -> 
        //         group.collectList().map(users -> {
        //             String names = users.stream()
        //                 .map(User::getFirstName)
        //                 .reduce((a, b) -> a + ", " + b)
        //                 .orElse("");
        //             return String.format("Length %d (%d users): %s", 
        //                 group.key(), users.size(), names);
        //         })
        //     )
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 8. Scan with emission control - emit only when threshold reached
        System.out.println("8. Conditional scan - emit when sum exceeds threshold:");
        // TODO: Write code here
        // ReactiveSources.intNumbersFlux()
        //     .take(10)
        //     .scan(0, Integer::sum)
        //     .filter(sum -> sum > 20)
        //     .take(3)  // Take first 3 that exceed threshold
        //     .subscribe(sum -> System.out.println("Sum exceeding 20: " + sum));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 9. Multi-level grouping - group by first letter, then by name length
        System.out.println("9. Multi-level grouping:");
        // TODO: Write code here
        // ReactiveSources.extendedUserFlux()
        //     .groupBy(user -> user.getFirstName().charAt(0))
        //     .flatMap(letterGroup -> 
        //         letterGroup
        //             .groupBy(user -> user.getFirstName().length())
        //             .flatMap(lengthGroup -> 
        //                 lengthGroup.collectList().map(users -> 
        //                     String.format("Letter '%s', Length %d: %s", 
        //                         letterGroup.key(), 
        //                         lengthGroup.key(),
        //                         users.stream().map(User::getFirstName).toList())
        //                 )
        //             )
        //     )
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 10. Advanced reduce - create summary object
        System.out.println("10. Advanced reduce - comprehensive summary:");
        // TODO: Write code here
        // ReactiveSources.temperatureFlux()
        //     .reduce(new TemperatureSummary(), (summary, temp) -> {
        //         summary.addTemperature(temp);
        //         return summary;
        //     })
        //     .subscribe(summary -> {
        //         System.out.println("Temperature Summary:");
        //         System.out.println("  Count: " + summary.getCount());
        //         System.out.println("  Average: " + String.format("%.1f°C", summary.getAverage()));
        //         System.out.println("  Range: " + String.format("%.1f°C - %.1f°C", summary.getMin(), summary.getMax()));
        //         System.out.println("  Above 20°C: " + summary.getAboveThreshold());
        //     });

        System.out.println("\nPress a key to end");
        System.in.read();
    }

    // Helper classes for complex aggregations
    static class TemperatureStats {
        int count = 0;
        double sum = 0.0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double average = 0.0;
    }

    static class TemperatureSummary {
        private int count = 0;
        private double sum = 0.0;
        private double min = Double.MAX_VALUE;
        private double max = Double.MIN_VALUE;
        private int aboveThreshold = 0;

        public void addTemperature(double temp) {
            count++;
            sum += temp;
            min = Math.min(min, temp);
            max = Math.max(max, temp);
            if (temp > 20.0) aboveThreshold++;
        }

        public int getCount() { return count; }
        public double getAverage() { return count > 0 ? sum / count : 0.0; }
        public double getMin() { return min; }
        public double getMax() { return max; }
        public int getAboveThreshold() { return aboveThreshold; }
    }
}