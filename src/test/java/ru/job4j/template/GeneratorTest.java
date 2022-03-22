package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GeneratorTest {

    @Ignore
    @Test
    public void produce() {
        Generator generator = new GeneratorImpl();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        String rsl = generator.produce(template, args);
        assertThat(rsl, is("I am a Petr Arsentev, Who are you? "));
    }

    @Ignore
    @Test(expected = NullPointerException.class)
    public void whenKeyIsNotExist() {
        Generator generator = new GeneratorImpl();
        String template = "I am a ${name}, Who are ${subject}?,  What are you ${action}";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        String rsl = generator.produce(template, args);
    }

    @Ignore
    @Test(expected = Exception.class)
    public void whenExtraKey() {
        Generator generator = new GeneratorImpl();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        args.put("action", "doing");
        String rsl = generator.produce(template, args);
    }
}