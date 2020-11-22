package kristinaia.com.devopsexam;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class DevopsExamApplicationTests {

	@Test
	public void testHomepage() {
		Controller controller = new Controller();
		String result = controller.homepage();
		assertEquals(result, "HOMEPAGE");
	}

	@Test
	public void testPerson(){
		Controller controller =	new Controller();
		String result = controller.home();
		assertEquals(result, "not the HOMEPAGE");
	}

}
