package hu.nive.ujratervezes.kepesitovizsga.uppercase;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class UpperCaseLetters {
    public int getNumberOfUpperCase(String fileName) {
        try (Stream<String> lines = Files.lines(Path.of(UpperCaseLetters.class.getResource("/" + fileName).toURI()))){
            return (int) lines
                    .flatMap(c -> c.chars().boxed())
                    .filter(Character::isUpperCase)
                    .count();

        } catch (IOException | URISyntaxException e) {
            throw new IllegalStateException("Cannot read file");
        }
    }
}
