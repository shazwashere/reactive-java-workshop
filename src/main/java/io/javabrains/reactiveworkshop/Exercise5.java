package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberFlux() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
//        ReactiveSources.intNumbersFlux().subscribe(
//                number -> System.out.println(number),
//                error -> System.out.println(error.getMessage()),
//                () -> System.out.println("Completion event received.")
//        );

//        ReactiveSources.userMono().subscribe(
//                user -> System.out.println(user),
//                error -> System.out.println(error.getMessage()),
//                () -> System.out.println("Completion event received.")
//        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());
        System.out.println("Press a key to end");
        System.in.read();
    }

    static class MySubscriber<T> extends BaseSubscriber<T> {
        public void hookOnSubscribe(Subscription subscription) {
            System.out.println("Subscribed.");
            request(10);
        }

        public void hookOnNext(T value) {
            System.out.println(value.toString() + " -- received.");
            request(10);
        }

        public void hookOnComplete() {
            System.out.println("Completed.");
       }
    }

}