import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class DynamicTestSuite {

	@Test
	void test_Add(){
		assertEquals(5, 3 + 2);
	}

	@Test
	void test_Divide(){
		assertEquals(5, 25 /5);
	}

	@Execution(ExecutionMode.CONCURRENT)
	@TestFactory
	Collection<DynamicTest> dynamicTestsFromCollections(){
		return asList(
		  dynamicTest( "1st dynamic test ", () -> assertTrue(true) ),
		  dynamicTest(" 2st dynamic test" , ()  -> assertEquals(5 , 25/5))
		);
	}


	//NOTE: https://javabydeveloper.com/junit-5-dynamic-tests-testfactory-with-examples/

	@Execution(ExecutionMode.SAME_THREAD)
	@TestFactory
	Collection<DynamicContainer> dynamicContainerFromCollection() {

		return asList(
		  dynamicContainer(
			"1st root container",
			asList(
			  dynamicContainer(
				"1st Dynamic Container",
				asList(
				  dynamicTest("1A dynamic test",
				              () -> assertTrue(MathUtil.isPrime(13))),
				  dynamicTest("1B dynamic test",
				              () -> assertEquals(5, MathUtil.devide(25, 5)))
				)), // end of 1st container

			  dynamicContainer(
				"2nd Dynamic Container",
				asList(
				  dynamicTest("2A dynamic test",
				              () -> assertTrue(MathUtil.isPrime(13))),
				  dynamicTest("2B dynamic test",
				              () -> assertEquals(5, MathUtil.devide(25, 5)))
				)) // end of 2nd container
			)
		  ), // End of 1st root container

		  dynamicContainer(
			"2nd root container",
			asList(
			  dynamicContainer(
				"3rd Dynamic Container",
				asList(
				  dynamicTest("3A dynamic test",
				              () -> assertTrue(isPrime.test(13))),
				  dynamicTest("3B dynamic test",
				              () -> assertEquals(5, MathUtil.devide(25, 5)))
				)), // end of 3rd container

			  dynamicContainer(
				"4th Dynamic Container",
				asList(
				  dynamicTest("4A dynamic test",
				              () -> assertTrue(isPrime.test(13))),
				  dynamicTest("4B dynamic test",
				              () -> assertEquals(5, divide.apply(25, 5)))
				)) // end of 4th container
			)
		  ) // End of 2nd root container

		); // End of complete List
	}

	final Predicate<Integer> isPrime = (v) -> true;
	final BiFunction<Integer, Integer, Integer> divide = (t1, t2) -> t1 / t2;
}



@Deprecated
class MathUtil{
	static boolean isPrime(final long value ) {
		System.out.println(value);
		return true;
    }
    
    static int devide(int i , int b ) {
		return i/b;
    }
  }