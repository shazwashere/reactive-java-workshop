package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * This class is a source of reactive streams used in the exercises.
 * DO NOT MODIFY THIS CODE
 *
 * @author koushikkothagal
 */
public class ReactiveSources {

    public static Flux<String> stringNumbersFlux() {
        return Flux.just("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten")
                .delayElements(Duration.ofSeconds(1));
    }

    public static Flux<Integer> intNumbersFlux() {
        return Flux
                .range(1, 10)
                .delayElements(Duration.ofSeconds(1));
    }

    public static Flux<Integer> intNumbersFluxWithException() {
        return Flux
                .range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .map(e -> {
                    if (e == 5) throw new RuntimeException("An error happened in the flux");
                    return e;
                });
    }

    public static Mono<Integer> intNumberMono() {
        return Mono.just(42)
                .delayElement(Duration.ofSeconds(1));
    }

    public static Flux<User> userFlux() {
        return Flux.just(
                new User(1, "Lionel", "Messi"),
                new User(2, "Cristiano", "Ronaldo"),
                new User(2, "Diego", "Maradona"),
                new User(4, "Zinedine", "Zidane"),
                new User(5, "Jürgen", "Klinsmann"),
                new User(6, "Gareth", "Bale")
        ).delayElements(Duration.ofSeconds(1));
    }

    public static Mono<User> userMono() {
        return Mono.just(
                new User(1, "Lionel", "Messi")
        ).delayElement(Duration.ofSeconds(1));

    }

    public static Flux<String> unresponsiveFlux() {
        return Flux.never();
    }

    public static Mono<String> unresponsiveMono() {
        return Mono.never();
    }

    public static Flux<Integer> intNumbersFluxWithRepeat() {
        return Flux
                .just(1, 2, 1, 1, 3, 2, 4, 5, 1)
                .delayElements(Duration.ofSeconds(1));
    }

    // Additional sources for advanced pipeline transformer exercises

    public static Flux<String> fastStringFlux() {
        return Flux.just("fast1", "fast2", "fast3", "fast4", "fast5")
                .delayElements(Duration.ofMillis(100));
    }

    public static Flux<String> slowStringFlux() {
        return Flux.just("slow1", "slow2", "slow3")
                .delayElements(Duration.ofSeconds(2));
    }

    public static Flux<Integer> evenNumbersFlux() {
        return Flux.range(2, 10)
                .filter(n -> n % 2 == 0)
                .delayElements(Duration.ofMillis(500));
    }

    public static Flux<Integer> oddNumbersFlux() {
        return Flux.range(1, 10)
                .filter(n -> n % 2 == 1)
                .delayElements(Duration.ofMillis(300));
    }

    public static Flux<String> categoryFlux() {
        return Flux.just("A", "B", "A", "C", "B", "A", "C", "C", "B")
                .delayElements(Duration.ofMillis(200));
    }

    public static Flux<Double> temperatureFlux() {
        return Flux.just(20.5, 21.0, 19.8, 22.3, 18.9, 23.1, 17.5, 24.0)
                .delayElements(Duration.ofMillis(800));
    }

    public static Flux<String> errorProneFlux() {
        return Flux.just("data1", "data2", "error", "data3", "data4")
                .delayElements(Duration.ofMillis(300))
                .map(s -> {
                    if (s.equals("error")) throw new RuntimeException("Simulated error");
                    return s.toUpperCase();
                });
    }

    public static Flux<User> extendedUserFlux() {
        return Flux.just(
                new User(1, "Lionel", "Messi"),
                new User(2, "Cristiano", "Ronaldo"),
                new User(3, "Diego", "Maradona"),
                new User(4, "Zinedine", "Zidane"),
                new User(5, "Jürgen", "Klinsmann"),
                new User(6, "Gareth", "Bale"),
                new User(7, "Pelé", "Santos"),
                new User(8, "Johan", "Cruyff"),
                new User(9, "Franz", "Beckenbauer"),
                new User(10, "Ronaldinho", "Gaúcho")
        ).delayElements(Duration.ofMillis(400));
    }

    public static Flux<Integer> burstyNumbersFlux() {
        return Flux.concat(
                Flux.range(1, 3).delayElements(Duration.ofMillis(100)),
                Flux.range(4, 3).delayElements(Duration.ofSeconds(2)),
                Flux.range(7, 3).delayElements(Duration.ofMillis(100))
        );
    }

    public static Mono<String> delayedStringMono(String value, Duration delay) {
        return Mono.just(value).delayElement(delay);
    }

    public static Flux<String> intervalStringFlux() {
        return Flux.interval(Duration.ofMillis(500))
                .take(8)
                .map(i -> "interval-" + i);
    }
}
