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
		fail("NegativeIntegerException expected");
	}
}
