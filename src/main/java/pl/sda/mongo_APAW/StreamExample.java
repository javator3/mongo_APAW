package pl.sda.mongo_APAW;

import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {


        Stream<String> aa = Stream.of("aa", "bb", "casa", "tewte");

        aa
                .map(v -> v.length())
                .forEach(v -> System.out.println(v));

        Integer integer = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .min((v1, v2) -> Integer.compare(v1, v2))
                .orElse(0);
        System.out.println(integer);
    }
}
