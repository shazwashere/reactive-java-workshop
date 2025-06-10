package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.time.Duration;

/**
 * Exercise 13: Combining and Merging Streams
 * 
 * This exercise focuses on stream combination operators:
 * - Zip operations
 * - Merge operations
 * - CombineLatest operations
 * - Concat operations
 * - StartWith and concatWith
 * 
 * @author openhands
 */
public class Exercise13 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.evenNumbersFlux(), ReactiveSources.oddNumbersFlux(),
        // ReactiveSources.fastStringFlux(), ReactiveSources.slowStringFlux(),
        // and ReactiveSources.extendedUserFlux()

        System.out.println("=== Exercise 13: Combining and Merging Streams ===\n");

        // 1. Zip two streams together - pairs elements by position
        System.out.println("1. Zip - combine even and odd numbers by position:");
        // TODO: Write code here
        // Flux<Integer> evens = ReactiveSources.evenNumbersFlux().take(5);
        // Flux<Integer> odds = ReactiveSources.oddNumbersFlux().take(5);
        // 
        // evens.zipWith(odds)
        //     .map(tuple -> "Even: " + tuple.getT1() + ", Odd: " + tuple.getT2())
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 2. Zip with a custom combinator function
        System.out.println("2. Zip with combinator - sum even and odd numbers:");
        // TODO: Write code here
        // Flux<Integer> evens = ReactiveSources.evenNumbersFlux().take(4);
        // Flux<Integer> odds = ReactiveSources.oddNumbersFlux().take(4);
        // 
        // Flux.zip(evens, odds, (even, odd) -> even + odd)
        //     .map(sum -> "Sum: " + sum)
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 3. Merge streams - interleave elements as they arrive
        System.out.println("3. Merge - interleave fast and slow streams:");
        // TODO: Write code here
        // Flux<String> fast = ReactiveSources.fastStringFlux();
        // Flux<String> slow = ReactiveSources.slowStringFlux();
        // 
        // Flux.merge(fast, slow)
        //     .subscribe(value -> System.out.println("Merged: " + value));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 4. Concat streams - append one after the other
        System.out.println("4. Concat - append slow stream after fast stream:");
        // TODO: Write code here
        // Flux<String> fast = ReactiveSources.fastStringFlux();
        // Flux<String> slow = ReactiveSources.slowStringFlux();
        // 
        // Flux.concat(fast, slow)
        //     .subscribe(value -> System.out.println("Concatenated: " + value));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 5. CombineLatest - combine latest values from each stream
        System.out.println("5. CombineLatest - combine latest from two streams:");
        // TODO: Write code here
        // Flux<String> letters = Flux.just("A", "B", "C").delayElements(Duration.ofMillis(800));
        // Flux<Integer> numbers = Flux.range(1, 5).delayElements(Duration.ofMillis(500));
        // 
        // Flux.combineLatest(letters, numbers, (letter, number) -> letter + number)
        //     .subscribe(combined -> System.out.println("Combined: " + combined));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 6. StartWith - prepend elements to a stream
        System.out.println("6. StartWith - prepend elements:");
        // TODO: Write code here
        // ReactiveSources.intNumbersFlux()
        //     .take(5)
        //     .startWith(-1, 0)
        //     .subscribe(value -> System.out.println("With prefix: " + value));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 7. ConcatWith - append another stream
        System.out.println("7. ConcatWith - append additional elements:");
        // TODO: Write code here
        // ReactiveSources.fastStringFlux()
        //     .concatWith(Flux.just("EXTRA1", "EXTRA2"))
        //     .subscribe(value -> System.out.println("With suffix: " + value));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 8. Zip three streams together
        System.out.println("8. Zip three streams - users, numbers, and categories:");
        // TODO: Write code here
        // Flux<User> users = ReactiveSources.extendedUserFlux().take(4);
        // Flux<Integer> numbers = ReactiveSources.intNumbersFlux().take(4);
        // Flux<String> categories = ReactiveSources.categoryFlux().take(4);
        // 
        // Flux.zip(users, numbers, categories)
        //     .map(tuple -> String.format("User: %s, Number: %d, Category: %s", 
        //         tuple.getT1().getFirstName(), tuple.getT2(), tuple.getT3()))
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 9. Merge with error handling - one stream fails
        System.out.println("9. Merge with error handling:");
        // TODO: Write code here
        // Flux<String> goodStream = ReactiveSources.fastStringFlux();
        // Flux<String> errorStream = ReactiveSources.errorProneFlux()
        //     .onErrorReturn("ERROR_RECOVERED");
        // 
        // Flux.merge(goodStream, errorStream)
        //     .subscribe(
        //         value -> System.out.println("Merged with error handling: " + value),
        //         error -> System.out.println("Error in merge: " + error.getMessage())
        //     );

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 10. Complex combination - zip, then merge with another stream
        System.out.println("10. Complex combination - zip then merge:");
        // TODO: Write code here
        // Flux<String> zipped = Flux.zip(
        //     ReactiveSources.evenNumbersFlux().take(3),
        //     ReactiveSources.oddNumbersFlux().take(3),
        //     (even, odd) -> "Pair(" + even + "," + odd + ")"
        // );
        // 
        // Flux<String> additional = Flux.just("BONUS1", "BONUS2", "BONUS3")
        //     .delayElements(Duration.ofMillis(600));
        // 
        // Flux.merge(zipped, additional)
        //     .subscribe(value -> System.out.println("Complex result: " + value));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 11. Conditional merging based on first element
        System.out.println("11. Conditional merging:");
        // TODO: Write code here
        // ReactiveSources.intNumbersFlux()
        //     .take(1)
        //     .flatMap(firstNumber -> {
        //         if (firstNumber % 2 == 0) {
        //             return Flux.merge(
        //                 ReactiveSources.evenNumbersFlux().take(3),
        //                 Flux.just(999, 888)
        //             );
        //         } else {
        //             return Flux.concat(
        //                 ReactiveSources.oddNumbersFlux().take(3),
        //                 Flux.just(777, 666)
        //             );
        //         }
        //     })
        //     .subscribe(value -> System.out.println("Conditional result: " + value));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 12. Race condition - first stream to emit wins
        System.out.println("12. First (race) - first stream to emit wins:");
        // TODO: Write code here
        // Flux<String> stream1 = Flux.just("FAST_WINNER").delayElements(Duration.ofMillis(100));
        // Flux<String> stream2 = Flux.just("SLOW_LOSER").delayElements(Duration.ofMillis(500));
        // Flux<String> stream3 = Flux.just("MEDIUM").delayElements(Duration.ofMillis(300));
        // 
        // Flux.first(stream1, stream2, stream3)
        //     .subscribe(winner -> System.out.println("Race winner: " + winner));

        System.out.println("\nPress a key to end");
        System.in.read();
    }
}