package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.time.Duration;

/**
 * Exercise 10: Complex Pipeline Transformations
 * 
 * This exercise focuses on advanced transformation operators:
 * - flatMap vs concatMap vs switchMap
 * - Nested stream handling
 * - Parallel processing patterns
 * 
 * @author openhands
 */
public class Exercise10 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux(), ReactiveSources.extendedUserFlux()
        // and ReactiveSources.delayedStringMono()

        System.out.println("=== Exercise 10: Complex Pipeline Transformations ===\n");

        // 1. Use flatMap to transform each number into a delayed string and print results
        // Notice the order - flatMap doesn't preserve order due to async nature
        System.out.println("1. FlatMap transformation (async, unordered):");
        // TODO: Write code here
        // ReactiveSources.intNumbersFlux()
        //     .take(5)
        //     .flatMap(i -> ReactiveSources.delayedStringMono("Number: " + i, Duration.ofMillis(100 * (6 - i))))
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 2. Use concatMap to transform each number into a delayed string and print results
        // Notice the order - concatMap preserves order by waiting for each inner stream
        System.out.println("2. ConcatMap transformation (async, ordered):");
        // TODO: Write code here
        // ReactiveSources.intNumbersFlux()
        //     .take(5)
        //     .concatMap(i -> ReactiveSources.delayedStringMono("Number: " + i, Duration.ofMillis(100 * (6 - i))))
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 3. Use switchMap to transform numbers - each new emission cancels the previous inner stream
        System.out.println("3. SwitchMap transformation (cancels previous):");
        // TODO: Write code here
        // ReactiveSources.intNumbersFlux()
        //     .take(5)
        //     .switchMap(i -> ReactiveSources.delayedStringMono("Number: " + i, Duration.ofMillis(800)))
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 4. Transform each user into a flux of their name characters using flatMap
        System.out.println("4. Nested stream handling - user names to characters:");
        // TODO: Write code here
        // ReactiveSources.extendedUserFlux()
        //     .take(3)
        //     .flatMap(user -> Flux.fromArray(user.getFirstName().split(""))
        //         .map(c -> user.getFirstName() + ": " + c))
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 5. Use flatMap with maxConcurrency to limit parallel processing
        System.out.println("5. FlatMap with limited concurrency:");
        // TODO: Write code here
        // ReactiveSources.intNumbersFlux()
        //     .take(8)
        //     .flatMap(i -> ReactiveSources.delayedStringMono("Processed: " + i, Duration.ofMillis(500)), 2)
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 6. Chain multiple transformations: filter -> map -> flatMap -> reduce
        System.out.println("6. Complex pipeline chain:");
        // TODO: Write code here
        // ReactiveSources.intNumbersFlux()
        //     .filter(i -> i % 2 == 0)  // Only even numbers
        //     .map(i -> i * i)          // Square them
        //     .flatMap(i -> Flux.range(1, i).take(3))  // Create range for each squared number
        //     .reduce(0, Integer::sum)   // Sum all results
        //     .subscribe(result -> System.out.println("Final sum: " + result));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 7. Transform users to their initials using nested operations
        System.out.println("7. User initials transformation:");
        // TODO: Write code here
        // ReactiveSources.extendedUserFlux()
        //     .take(5)
        //     .map(user -> user.getFirstName().charAt(0) + "." + user.getLastName().charAt(0) + ".")
        //     .collectList()
        //     .subscribe(initials -> System.out.println("All initials: " + initials));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 8. Demonstrate the difference between map and flatMap with error handling
        System.out.println("8. Error handling in transformations:");
        // TODO: Write code here
        // Flux.just("1", "2", "invalid", "4", "5")
        //     .flatMap(s -> {
        //         try {
        //             int num = Integer.parseInt(s);
        //             return Mono.just("Parsed: " + num);
        //         } catch (NumberFormatException e) {
        //             return Mono.just("Error parsing: " + s);
        //         }
        //     })
        //     .subscribe(System.out::println);

        System.out.println("\nPress a key to end");
        System.in.read();
    }
}