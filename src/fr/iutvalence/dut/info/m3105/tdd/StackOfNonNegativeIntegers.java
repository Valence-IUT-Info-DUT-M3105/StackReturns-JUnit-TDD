package fr.iutvalence.dut.info.m3105.tdd;

public class StackOfNonNegativeIntegers
{
	public static final int DEFAULT_CAPACITY = 10;
	
	private final int capacity;

	public StackOfNonNegativeIntegers()
	{
		this.capacity = DEFAULT_CAPACITY;
	}
	
	public StackOfNonNegativeIntegers(int capacity)
	{
		this.capacity = capacity;
	}
	
	public int getSize()
	{
		return 0;
	}

	public int getCapacity()
	{
		return this.capacity;
	}

	public void pop() throws EmptyStackException
	{
		throw new EmptyStackException();
	}
}
