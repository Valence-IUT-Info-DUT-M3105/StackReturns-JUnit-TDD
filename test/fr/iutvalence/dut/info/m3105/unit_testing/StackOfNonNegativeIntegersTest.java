package fr.iutvalence.dut.info.m3105.unit_testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class StackOfNonNegativeIntegersTest
{
	@Test
	public void testNewStackWithoutParameter()
	{
		StackOfNonNegativeIntegers stackUnderTest = new StackOfNonNegativeIntegers();
		assertEquals(StackOfNonNegativeIntegers.DEFAULT_CAPACITY, stackUnderTest.getCapacity());
		assertEquals(0, stackUnderTest.getSize());
	}

	@Test
	public void testNewStackWithParameter()
	{
		this.testNewStackWithParameters(0, StackOfNonNegativeIntegers.DEFAULT_CAPACITY);

		this.testNewStackWithParameters(-1, StackOfNonNegativeIntegers.DEFAULT_CAPACITY);

		this.testNewStackWithParameters(1, 1);

		this.testNewStackWithParameters(10, 10);
	}

	private void testNewStackWithParameters(int initialParameterValue, int maximumNumberOfElementsAllowed)
	{
		StackOfNonNegativeIntegers stackUnderTest = new StackOfNonNegativeIntegers(initialParameterValue);
		assertEquals(maximumNumberOfElementsAllowed, stackUnderTest.getCapacity());
		assertEquals(0, stackUnderTest.getSize());
	}

	@Test
	public void testPushANegativeElementOnNonFullStack()
	{
		StackOfNonNegativeIntegers stackUnderTest = new StackOfNonNegativeIntegers(1);
		try
		{
			stackUnderTest.push(-1);
		}
		catch (NegativeElementException e)
		{
			assertEquals(0, stackUnderTest.getSize());
			return;
		}
		catch (FullStackException e)
		{
			
		}
		
		fail("NegativeElementException expected");
	}

	@Test
	public void testPushANonNegativeElementOnNonFullStack()
	{
		StackOfNonNegativeIntegers stackUnderTest = new StackOfNonNegativeIntegers(1);
		
		try
		{
			stackUnderTest.push(1);
		}
		catch (Exception e)
		{
			fail("Unexpected exception");
		}
		assertEquals(1, stackUnderTest.getSize());
	}

	@Test
	public void testPopOnEmptyStack()
	{
		StackOfNonNegativeIntegers stackUnderTest = new StackOfNonNegativeIntegers(1);
		try
		{
			stackUnderTest.pop();
		}
		catch (EmptyStackException e)
		{
			assertEquals(0, stackUnderTest.getSize());
			return;
		}
		fail("EmptyStackException expected");
	}

	@Test
	public void testInspectTopOfStackOnEmptyStack()
	{
		StackOfNonNegativeIntegers stackUnderTest = new StackOfNonNegativeIntegers(1);
		try
		{
			stackUnderTest.view();
		}
		catch (EmptyStackException e)
		{
			assertEquals(0, stackUnderTest.getSize());
			return;
		}
		fail("EmptyStackException expected");
	}

	@Test
	public void testPushANonNegativeElementOnFullStack()
	{
		StackOfNonNegativeIntegers stackUnderTest = new StackOfNonNegativeIntegers(1);
		try
		{
			stackUnderTest.push(1);
		}
		catch (Exception e)
		{
			fail("Unexpected exception");
		}
		
		
		try
		{
			stackUnderTest.push(2);
		}
		catch (FullStackException e)
		{
			assertEquals(1, stackUnderTest.getSize());
			return;
		}
		catch (NegativeElementException e)
		{			
		} 
		fail("Unexpected exception");
	}

	@Test
	public void testPushAndPop()
	{
		StackOfNonNegativeIntegers stackUnderTest = new StackOfNonNegativeIntegers(1);
		try
		{
			stackUnderTest.push(42);
		}
		catch (Exception e)
		{
			fail("Unexpected exception");
		}
		
		try
		{
			int value = stackUnderTest.pop();
			assertEquals (42, value);
			assertEquals(0, stackUnderTest.getSize());
		}
		catch (EmptyStackException e)
		{
			fail("Unexpected exception");
		}
	}

	@Test
	public void testPushAndInspectTopOfStack()
	{
		StackOfNonNegativeIntegers stackUnderTest = new StackOfNonNegativeIntegers(1);
		try
		{
			stackUnderTest.push(42);
		}
		catch (Exception e)
		{
			fail("Unexpected exception");
		}
		
		try
		{
			int value = stackUnderTest.view();
			assertEquals (42, value);
			assertEquals(1, stackUnderTest.getSize());
		}
		catch (EmptyStackException e)
		{
			fail("Unexpected exception");
		}
	}
}
