package io.javabrains.moviecatalogservice;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MovieCatalogServiceApplicationTests {

	@Test
	@Disabled("Not implemented yet")
	void shouldShowSimpleAssertion() {
		assertEquals(2, 1);
	}

	@Test
	@DisplayName("Should demonstrate a simple assertion")
	void contextLoads() {
		assertEquals(1,1);
	}

	@Test
	@DisplayName("Should check all items in the list")
	void shouldCheckAllItemsInTheList() {
		List<Integer> numbers = List.of(2, 3, 5, 7);
		Assertions.assertAll(() -> assertEquals(2, numbers.get(0)),
				() -> assertEquals(3, numbers.get(1)),
				() -> assertEquals(5, numbers.get(2)),
				() -> assertEquals(7, numbers.get(3)));
	}

	@Test
	@DisplayName("Should only run the test if some criteria are met")
	void shouldOnlyRunTheTestIfSomeCriteriaAreMet() {
		Assumptions.assumeTrue(Fixture.apiVersion() > 10);
		assertEquals(1, 1);
	}

	@ParameterizedTest
//	@ParameterizedTest(name = "{0}")
	@DisplayName("Should create shapes with different numbers of sides")
	@ValueSource(ints = {3, 4, 5, 8, 14})
	void shouldCreateShapesWithDifferentNumbersOfSides(int expectedNumberOfSides) {
//		Shape shape = new Shape(expectedNumberOfSides);
//		assertEquals(expectedNumberOfSides, shape.numberOfSides());
	}


}
