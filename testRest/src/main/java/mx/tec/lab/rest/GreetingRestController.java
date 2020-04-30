package mx.tec.lab.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.tec.lab.dto.Goodbye;
import mx.tec.lab.dto.Greeting;

@RestController
public class GreetingRestController {

	private static final String template = "Hello, %s!";
	private static final String template2 = "Goodbye, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	@RequestMapping("/goodbye")
	public Goodbye goodbye(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Goodbye(counter.incrementAndGet(), String.format(template2, name));
	}
}
