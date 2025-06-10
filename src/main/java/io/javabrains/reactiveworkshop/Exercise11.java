package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.time.Duration;

/**
 * Exercise 11: Conditional and Dynamic Transformations
 * 
 * This exercise focuses on conditional operators and dynamic stream switching:
 * - takeWhile, skipWhile, takeUntil, skipUntil
 * - Conditional transformations
 * - Dynamic stream switching based on content
 * 
 * @author openhands
 */
public class Exercise11 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux(), ReactiveSources.temperatureFlux(),
        // ReactiveSources.extendedUserFlux(), and ReactiveSources.categoryFlux()

        System.out.println("=== Exercise 11: Conditional and Dynamic Transformations ===\n");

        // 1. Take numbers while they are less than 5
        System.out.println("1. TakeWhile - numbers less than 5:");
        // TODO: Write code here
        // ReactiveSources.intNumbersFlux()
        //     .takeWhile(i -> i < 5)
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 2. Skip numbers while they are less than 5, then take the rest
        System.out.println("2. SkipWhile - skip numbers less than 5:");
        // TODO: Write code here
        // ReactiveSources.intNumbersFlux()
        //     .skipWhile(i -> i < 5)
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 3. Take temperatures until we find one above 22 degrees
        System.out.println("3. TakeUntil - temperatures until > 22:");
        // TODO: Write code here
        // ReactiveSources.temperatureFlux()
        //     .takeUntil(temp -> temp > 22.0)
        //     .subscribe(temp -> System.out.println(temp + "°C"));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 4. Skip temperatures until we find one above 22 degrees
        System.out.println("4. SkipUntil - skip temperatures until > 22:");
        // TODO: Write code here
        // ReactiveSources.temperatureFlux()
        //     .skipUntil(temp -> temp > 22.0)
        //     .subscribe(temp -> System.out.println(temp + "°C"));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 5. Conditional transformation - different processing based on value
        System.out.println("5. Conditional transformation based on number value:");
        // TODO: Write code here
        // ReactiveSources.intNumbersFlux()
        //     .take(8)
        //     .map(i -> {
        //         if (i % 2 == 0) {
        //             return "Even: " + i + " (squared: " + (i * i) + ")";
        //         } else {
        //             return "Odd: " + i + " (cubed: " + (i * i * i) + ")";
        //         }
        //     })
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 6. Dynamic stream switching based on category
        System.out.println("6. Dynamic processing based on category:");
        // TODO: Write code here
        // ReactiveSources.categoryFlux()
        //     .flatMap(category -> {
        //         switch (category) {
        //             case "A":
        //                 return Flux.just("Priority: HIGH - " + category);
        //             case "B":
        //                 return Flux.just("Priority: MEDIUM - " + category);
        //             case "C":
        //                 return Flux.just("Priority: LOW - " + category);
        //             default:
        //                 return Flux.just("Priority: UNKNOWN - " + category);
        //         }
        //     })
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 7. Filter and transform users based on name length
        System.out.println("7. Conditional user processing based on name length:");
        // TODO: Write code here
        // ReactiveSources.extendedUserFlux()
        //     .filter(user -> user.getFirstName().length() > 5)
        //     .map(user -> user.getFirstName().toUpperCase() + " (Long name)")
        //     .switchIfEmpty(Flux.just("No users with long names found"))
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 8. Take elements while condition is met, with timeout
        System.out.println("8. TakeWhile with timeout fallback:");
        // TODO: Write code here
        // ReactiveSources.intNumbersFlux()
        //     .takeWhile(i -> i < 15)  // This should take all elements
        //     .timeout(Duration.ofSeconds(5))
        //     .onErrorReturn(-999)
        //     .subscribe(
        //         value -> System.out.println("Value: " + value),
        //         error -> System.out.println("Error: " + error.getMessage()),
        //         () -> System.out.println("Completed successfully")
        //     );

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 9. Conditional stream merging
        System.out.println("9. Conditional stream merging:");
        // TODO: Write code here
        // Flux<String> stream1 = ReactiveSources.fastStringFlux();
        // Flux<String> stream2 = ReactiveSources.slowStringFlux();
        // 
        // ReactiveSources.intNumbersFlux()
        //     .take(1)
        //     .flatMap(firstNumber -> {
        //         if (firstNumber % 2 == 0) {
        //             System.out.println("First number is even, using fast stream");
        //             return stream1;
        //         } else {
        //             System.out.println("First number is odd, using slow stream");
        //             return stream2;
        //         }
        //     })
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 10. Complex conditional pipeline with multiple branches
        System.out.println("10. Complex conditional pipeline:");
        // TODO: Write code here
        // ReactiveSources.temperatureFlux()
        //     .map(temp -> {
        //         if (temp < 18.0) return "COLD: " + temp + "°C - Heat up!";
        //         else if (temp > 23.0) return "HOT: " + temp + "°C - Cool down!";
        //         else return "PERFECT: " + temp + "°C - Just right!";
        //     })
        //     .groupBy(msg -> msg.split(":")[0])  // Group by temperature category
        //     .flatMap(group -> 
        //         group.collectList().map(list -> 
        //             group.key() + " temperatures: " + list.size() + " readings"
        //         )
        //     )
        //     .subscribe(System.out::println);

        System.out.println("\nPress a key to end");
        System.in.read();
    }
}