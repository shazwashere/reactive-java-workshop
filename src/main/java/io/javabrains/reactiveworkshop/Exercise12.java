package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

/**
 * Exercise 12: Time-based Transformations
 * 
 * This exercise focuses on time-based operators:
 * - Window operations
 * - Buffer operations  
 * - Sample and throttle operations
 * - Delay and interval operations
 * 
 * @author openhands
 */
public class Exercise12 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intervalStringFlux(), ReactiveSources.burstyNumbersFlux(),
        // ReactiveSources.fastStringFlux(), and ReactiveSources.temperatureFlux()

        System.out.println("=== Exercise 12: Time-based Transformations ===\n");

        // 1. Buffer elements into groups of 3
        System.out.println("1. Buffer - group elements into batches of 3:");
        // TODO: Write code here
        // ReactiveSources.intNumbersFlux()
        //     .buffer(3)
        //     .subscribe(batch -> System.out.println("Batch: " + batch));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 2. Buffer elements for a time duration (2 seconds)
        System.out.println("2. Buffer by time - group elements every 2 seconds:");
        // TODO: Write code here
        // ReactiveSources.intervalStringFlux()
        //     .buffer(Duration.ofSeconds(2))
        //     .subscribe(batch -> System.out.println("Time batch: " + batch));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 3. Window elements into separate Flux streams of size 3
        System.out.println("3. Window - create separate streams of size 3:");
        // TODO: Write code here
        // ReactiveSources.intNumbersFlux()
        //     .take(9)
        //     .window(3)
        //     .flatMap(window -> 
        //         window.collectList().map(list -> "Window: " + list)
        //     )
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 4. Sample elements at regular intervals (every 1.5 seconds)
        System.out.println("4. Sample - take latest element every 1.5 seconds:");
        // TODO: Write code here
        // ReactiveSources.intervalStringFlux()
        //     .sample(Duration.ofMillis(1500))
        //     .subscribe(value -> System.out.println("Sampled: " + value + " at " + LocalTime.now()));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 5. Throttle first - emit first element then ignore subsequent for duration
        System.out.println("5. ThrottleFirst - emit first, then ignore for 1 second:");
        // TODO: Write code here
        // ReactiveSources.fastStringFlux()
        //     .repeat(3)  // Repeat the sequence 3 times
        //     .throttleFirst(Duration.ofSeconds(1))
        //     .subscribe(value -> System.out.println("Throttled: " + value + " at " + LocalTime.now()));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 6. Throttle latest - emit latest element after no emissions for duration
        System.out.println("6. ThrottleLast (debounce) - emit after 800ms of silence:");
        // TODO: Write code here
        // ReactiveSources.burstyNumbersFlux()
        //     .map(i -> "Number: " + i)
        //     .throttleLast(Duration.ofMillis(800))
        //     .subscribe(value -> System.out.println("Debounced: " + value + " at " + LocalTime.now()));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 7. Delay each element by a fixed duration
        System.out.println("7. Delay elements - add 500ms delay to each:");
        // TODO: Write code here
        // Flux.just("A", "B", "C", "D")
        //     .delayElements(Duration.ofMillis(500))
        //     .subscribe(value -> System.out.println("Delayed: " + value + " at " + LocalTime.now()));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 8. Delay subscription by a duration
        System.out.println("8. Delay subscription - wait 1 second before starting:");
        // TODO: Write code here
        // Flux.just("Immediate1", "Immediate2", "Immediate3")
        //     .delaySubscription(Duration.ofSeconds(1))
        //     .subscribe(value -> System.out.println("After delay: " + value + " at " + LocalTime.now()));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 9. Timeout - fail if no emission within time limit
        System.out.println("9. Timeout - fail if no emission within 2 seconds:");
        // TODO: Write code here
        // ReactiveSources.slowStringFlux()
        //     .timeout(Duration.ofSeconds(2))
        //     .onErrorReturn("TIMEOUT_FALLBACK")
        //     .subscribe(
        //         value -> System.out.println("Received: " + value),
        //         error -> System.out.println("Error: " + error.getMessage())
        //     );

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 10. Complex time-based pipeline: buffer, then process each batch with delay
        System.out.println("10. Complex time pipeline - buffer then delayed processing:");
        // TODO: Write code here
        // ReactiveSources.temperatureFlux()
        //     .buffer(Duration.ofSeconds(3))  // Buffer for 3 seconds
        //     .filter(batch -> !batch.isEmpty())  // Skip empty batches
        //     .flatMap(batch -> {
        //         double avg = batch.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        //         return Flux.just("Batch avg: " + String.format("%.1f", avg) + "°C (size: " + batch.size() + ")")
        //                   .delayElements(Duration.ofMillis(500));
        //     })
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 11. Combine interval with data stream
        System.out.println("11. Interval-driven processing:");
        // TODO: Write code here
        // Flux.interval(Duration.ofSeconds(1))
        //     .take(5)
        //     .zipWith(ReactiveSources.extendedUserFlux().take(5))
        //     .map(tuple -> "Tick " + tuple.getT1() + ": " + tuple.getT2().getFirstName())
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 12. Sliding window with overlap
        System.out.println("12. Sliding window - overlapping windows of size 3:");
        // TODO: Write code here
        // ReactiveSources.intNumbersFlux()
        //     .take(7)
        //     .window(3, 1)  // Window size 3, skip 1 (creates overlap)
        //     .flatMap(window -> 
        //         window.collectList().map(list -> "Sliding window: " + list)
        //     )
        //     .subscribe(System.out::println);

        System.out.println("\nPress a key to end");
        System.in.read();
    }
}