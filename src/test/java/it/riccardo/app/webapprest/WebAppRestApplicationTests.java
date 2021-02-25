package it.riccardo.app.webapprest;

import it.riccardo.app.webapprest.config.BeansConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@ContextConfiguration(classes = BeansConfig.class)
class WebAppRestApplicationTests {

	@Test
	@Disabled
	void test() {
		assertTrue(true);
	}

}
