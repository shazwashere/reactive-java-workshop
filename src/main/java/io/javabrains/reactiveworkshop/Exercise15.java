package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

/**
 * Exercise 15: Custom Operators and Advanced Patterns
 * 
 * This exercise focuses on creating custom operators and advanced reactive patterns:
 * - Custom transformation operators
 * - Compose and transform operators
 * - Advanced error handling patterns
 * - Performance optimization patterns
 * 
 * @author openhands
 */
public class Exercise15 {

    public static void main(String[] args) throws IOException {

        System.out.println("=== Exercise 15: Custom Operators and Advanced Patterns ===\n");

        // 1. Custom operator using transform()
        System.out.println("1. Custom operator - add logging and timing:");
        // TODO: Write code here
        // ReactiveSources.intNumbersFlux()
        //     .take(5)
        //     .transform(logAndTime("NumberProcessing"))
        //     .subscribe(value -> System.out.println("Final result: " + value));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 2. Custom operator using compose() for Flux
        System.out.println("2. Custom Flux operator - batch processing:");
        // TODO: Write code here
        // ReactiveSources.extendedUserFlux()
        //     .take(6)
        //     .compose(batchProcess(3))
        //     .subscribe(batch -> System.out.println("Processed batch: " + batch));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 3. Retry with exponential backoff
        System.out.println("3. Advanced retry pattern - exponential backoff:");
        // TODO: Write code here
        // createFailingMono()
        //     .retryWhen(reactor.util.retry.Retry.backoff(3, Duration.ofMillis(100)))
        //     .subscribe(
        //         value -> System.out.println("Success: " + value),
        //         error -> System.out.println("Final failure: " + error.getMessage())
        //     );

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 4. Circuit breaker pattern
        System.out.println("4. Circuit breaker pattern:");
        // TODO: Write code here
        // Flux.range(1, 10)
        //     .flatMap(i -> createSometimesFailingMono(i)
        //         .onErrorReturn("CIRCUIT_OPEN_" + i))
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 5. Custom caching operator
        System.out.println("5. Custom caching operator:");
        // TODO: Write code here
        // Flux<String> cachedFlux = ReactiveSources.slowStringFlux()
        //     .transform(cache(Duration.ofSeconds(5)))
        //     .share();  // Share the subscription
        // 
        // System.out.println("First subscription:");
        // cachedFlux.subscribe(value -> System.out.println("Sub1: " + value));
        // 
        // // Simulate delay before second subscription
        // Mono.delay(Duration.ofSeconds(2))
        //     .then(Mono.fromRunnable(() -> System.out.println("Second subscription:")))
        //     .subscribe();
        // 
        // Mono.delay(Duration.ofSeconds(3))
        //     .thenMany(cachedFlux)
        //     .subscribe(value -> System.out.println("Sub2: " + value));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 6. Rate limiting operator
        System.out.println("6. Rate limiting operator:");
        // TODO: Write code here
        // ReactiveSources.fastStringFlux()
        //     .repeat(2)
        //     .transform(rateLimit(2, Duration.ofSeconds(1)))  // Max 2 per second
        //     .subscribe(value -> System.out.println("Rate limited: " + value + " at " + java.time.LocalTime.now()));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 7. Custom error recovery with fallback chain
        System.out.println("7. Fallback chain pattern:");
        // TODO: Write code here
        // createFailingFlux()
        //     .onErrorResume(error -> {
        //         System.out.println("Primary failed, trying fallback 1");
        //         return createSometimesFailingFlux();
        //     })
        //     .onErrorResume(error -> {
        //         System.out.println("Fallback 1 failed, trying fallback 2");
        //         return Flux.just("FALLBACK_VALUE_1", "FALLBACK_VALUE_2");
        //     })
        //     .subscribe(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 8. Custom operator for conditional processing
        System.out.println("8. Conditional processing operator:");
        // TODO: Write code here
        // ReactiveSources.intNumbersFlux()
        //     .take(8)
        //     .transform(conditionalProcess(i -> i % 2 == 0, i -> i * i, i -> i * 3))
        //     .subscribe(value -> System.out.println("Conditionally processed: " + value));

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 9. Metrics collection operator
        System.out.println("9. Metrics collection operator:");
        // TODO: Write code here
        // MetricsCollector metrics = new MetricsCollector();
        // 
        // ReactiveSources.temperatureFlux()
        //     .transform(collectMetrics(metrics))
        //     .subscribe(
        //         value -> System.out.println("Temperature: " + value + "°C"),
        //         error -> System.out.println("Error: " + error.getMessage()),
        //         () -> {
        //             System.out.println("\nMetrics Summary:");
        //             System.out.println("  Total elements: " + metrics.getTotalElements());
        //             System.out.println("  Total errors: " + metrics.getTotalErrors());
        //             System.out.println("  Processing time: " + metrics.getProcessingTimeMs() + "ms");
        //         }
        //     );

        System.out.println("\n" + "=".repeat(50) + "\n");

        // 10. Advanced parallel processing with custom scheduler
        System.out.println("10. Advanced parallel processing:");
        // TODO: Write code here
        // ReactiveSources.extendedUserFlux()
        //     .take(8)
        //     .parallel(2)  // Split into 2 parallel streams
        //     .runOn(reactor.core.scheduler.Schedulers.parallel())
        //     .map(user -> {
        //         // Simulate heavy processing
        //         try { Thread.sleep(200); } catch (InterruptedException e) {}
        //         return user.getFirstName().toUpperCase() + "_PROCESSED";
        //     })
        //     .sequential()  // Merge back to single stream
        //     .subscribe(result -> System.out.println("Parallel result: " + result));

        System.out.println("\nPress a key to end");
        System.in.read();
    }

    // Custom operator implementations

    public static <T> Function<Flux<T>, Flux<T>> logAndTime(String operationName) {
        return flux -> flux
            .doOnSubscribe(sub -> System.out.println("[" + operationName + "] Starting..."))
            .doOnNext(item -> System.out.println("[" + operationName + "] Processing: " + item))
            .doOnComplete(() -> System.out.println("[" + operationName + "] Completed"))
            .doOnError(error -> System.out.println("[" + operationName + "] Error: " + error.getMessage()));
    }

    public static <T> Function<Flux<T>, Flux<java.util.List<T>>> batchProcess(int batchSize) {
        return flux -> flux
            .buffer(batchSize)
            .map(batch -> {
                System.out.println("Processing batch of size: " + batch.size());
                return batch;
            });
    }

    public static <T> Function<Flux<T>, Flux<T>> cache(Duration duration) {
        return flux -> flux
            .cache(duration)
            .doOnSubscribe(sub -> System.out.println("Cache: New subscription"));
    }

    public static <T> Function<Flux<T>, Flux<T>> rateLimit(int maxPerSecond, Duration window) {
        return flux -> flux
            .zipWith(Flux.interval(window.dividedBy(maxPerSecond)))
            .map(Tuple2::getT1);
    }

    public static <T> Function<Flux<T>, Flux<T>> conditionalProcess(
            java.util.function.Predicate<T> condition,
            java.util.function.Function<T, T> trueProcessor,
            java.util.function.Function<T, T> falseProcessor) {
        return flux -> flux
            .map(item -> condition.test(item) ? trueProcessor.apply(item) : falseProcessor.apply(item));
    }

    public static <T> Function<Flux<T>, Flux<T>> collectMetrics(MetricsCollector metrics) {
        return flux -> flux
            .doOnSubscribe(sub -> metrics.startTiming())
            .doOnNext(item -> metrics.incrementElements())
            .doOnError(error -> metrics.incrementErrors())
            .doOnTerminate(() -> metrics.stopTiming());
    }

    // Helper methods for creating test streams
    private static Mono<String> createFailingMono() {
        return Mono.fromCallable(() -> {
            if (Math.random() < 0.7) {
                throw new RuntimeException("Random failure");
            }
            return "SUCCESS";
        });
    }

    private static Mono<String> createSometimesFailingMono(int value) {
        return Mono.fromCallable(() -> {
            if (value % 3 == 0) {
                throw new RuntimeException("Failure for value: " + value);
            }
            return "Success: " + value;
        });
    }

    private static Flux<String> createFailingFlux() {
        return Flux.error(new RuntimeException("Primary service unavailable"));
    }

    private static Flux<String> createSometimesFailingFlux() {
        return Flux.error(new RuntimeException("Fallback service also unavailable"));
    }

    // Metrics collector helper class
    static class MetricsCollector {
        private long totalElements = 0;
        private long totalErrors = 0;
        private long startTime = 0;
        private long endTime = 0;

        public void startTiming() { startTime = System.currentTimeMillis(); }
        public void stopTiming() { endTime = System.currentTimeMillis(); }
        public void incrementElements() { totalElements++; }
        public void incrementErrors() { totalErrors++; }

        public long getTotalElements() { return totalElements; }
        public long getTotalErrors() { return totalErrors; }
        public long getProcessingTimeMs() { return endTime - startTime; }
    }
}