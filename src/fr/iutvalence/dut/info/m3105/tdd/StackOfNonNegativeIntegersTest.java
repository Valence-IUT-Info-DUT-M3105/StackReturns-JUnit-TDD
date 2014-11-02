package fr.iutvalence.dut.info.m3105.tdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackOfNonNegativeIntegersTest
{
	@Test
	public void creatingANewStackWithNoCapacityAsParameterShouldReturnAnEmptyStackWithDefaultCapacity()
	{
		StackOfNonNegativeIntegers stackUnderTest = new StackOfNonNegativeIntegers();
		assertEquals(stackUnderTest.getSize(), 0);
		assertEquals(stackUnderTest.getCapacity(), StackOfNonNegativeIntegers.DEFAULT_CAPACITY);
	}

	@Test
	public void creatingANewStackWithCapacityAsParameterShouldReturnAnEmptyStackWithGivenCapacity()
	{
		int capacity = 7;
		StackOfNonNegativeIntegers stackUnderTest = new StackOfNonNegativeIntegers(capacity);
		assertEquals(stackUnderTest.getSize(), 0);
		assertEquals(stackUnderTest.getCapacity(), capacity);
	}

	@Test
	public void callingPopOnAnEmptyStackShouldRaiseEmptyStackException()
	{
		StackOfNonNegativeIntegers stackUnderTest = new StackOfNonNegativeIntegers();
		try
		{
			stackUnderTest.pop();
		}
		catch (EmptyStackException e)
		{
			assertEquals(stackUnderTest.getSize(), 0);
			return;
		}
		fail("EmptyStackException expected");
	}

	@Test
	public void callingPushWithANegativeIntegerOnANonFullStackShouldRaiseNegativeIntegerException()
	{
		StackOfNonNegativeIntegers stackUnderTest = new StackOfNonNegativeIntegers();
		try
		{
			stackUnderTest.push(-42);
		}
		catch (NegativeIntegerException e)
		{
			assertEquals(stackUnderTest.getSize(), 0);
			return;
		}
		catch (FullStackException e)
		{
		}
		fail("NegativeIntegerException expected");
	}

	@Test
	public void callingPushWithANonNegativeIntegerOnANonFullStackIncreasesStackSize()
	{
		StackOfNonNegativeIntegers stackUnderTest = new StackOfNonNegativeIntegers();
		try
		{
			stackUnderTest.push(42);
		}
		catch (Exception e)
		{
			fail("Unexpected exception");
		}
		assertEquals(stackUnderTest.getSize(), 1);
	}

	@Test
	public void callingViewOnAnEmptyStackShouldRaiseEmptyStackException()
	{
		StackOfNonNegativeIntegers stackUnderTest = new StackOfNonNegativeIntegers();
		try
		{
			stackUnderTest.view();
		}
		catch (EmptyStackException e)
		{
			assertEquals(stackUnderTest.getSize(), 0);
			return;
		}
		fail("EmptyStackException expected");
	}

	@Test
	public void callingPushWithANonNegativeElementOnANonFullStackAndThenCallingPopShouldLetSizeUnchangedAndReturnElement()
	{
		StackOfNonNegativeIntegers stackUnderTest = new StackOfNonNegativeIntegers();
		try
		{
			int value = 42;
			stackUnderTest.push(value);
			assertEquals(stackUnderTest.pop(), value);
			assertEquals(stackUnderTest.getSize(), 0);
		}
		catch (Exception e)
		{
			fail("Unexpected exception");
		}
	}

	@Test
	public void callingPushWithANonNegativeElementOnANonFullStackAndThenCallingViewShouldIncreaseSizeAndReturnElement()
	{
		StackOfNonNegativeIntegers stackUnderTest = new StackOfNonNegativeIntegers();
		try
		{
			int value = 42;
			stackUnderTest.push(value);
			assertEquals(stackUnderTest.view(), value);
			assertEquals(stackUnderTest.getSize(), 1);
		}
		catch (Exception e)
		{
			fail("Unexpected exception");
		}
	}

	@Test
	public void callingPopSeveralTimesAfterCallingPushSeveralTimesOnANonFullStackShouldReturnElementsInReverseOrder()
	{
		StackOfNonNegativeIntegers stackUnderTest = new StackOfNonNegativeIntegers();
		try
		{
			int value41 = 41;
			int value42 = 42;
			int value43 = 43;
			stackUnderTest.push(value41);
			stackUnderTest.push(value42);
			stackUnderTest.push(value43);
			assertEquals(stackUnderTest.getSize(), 3);
			assertEquals(stackUnderTest.pop(), value43);
			assertEquals(stackUnderTest.pop(), value42);
			assertEquals(stackUnderTest.pop(), value41);
			assertEquals(stackUnderTest.getSize(), 0);
		}
		catch (Exception e)
		{
			fail("Unexpected exception");
		}
	}

	@Test
	public void callingPushWithANonNegativeIntegerOnAFullStackShouldRaiseFullStackException()
	{
		StackOfNonNegativeIntegers stackUnderTest = new StackOfNonNegativeIntegers(1);

		int value41 = 41;
		int value42 = 42;
		try
		{
			stackUnderTest.push(value41);
		}
		catch (Exception e)
		{
			fail("Unexpected exception");
		}
		
		try
		{
			stackUnderTest.push(value42);
		}
		catch (NegativeIntegerException e)
		{
			fail("Unexpected exception");
		}
		catch (FullStackException e)
		{
			assertEquals(stackUnderTest.getSize(), 1);
			return;
		}
		fail("FullStackException expected");	
	}

}
