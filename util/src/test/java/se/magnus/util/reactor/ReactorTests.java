package se.magnus.util.reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ReactorTests {
    @Test
    public void TestFlux() {
        List<Integer> list = new ArrayList<>();

        Flux.just(1, 2, 3, 4)
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .log()
                .subscribe(n -> list.add(n));

        assertTrue(list.containsAll(List.of(4, 8)));
    }

    @Test
    public void TestFluxBlocking() {

        List<Integer> list = Flux.just(1, 2, 3, 4)
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .log()
                .collectList().block();

        assertTrue(list.containsAll(List.of(4, 8)));
    }
}
