package fr.iutvalence.dut.info.m3105.tdd;

public class StackOfNonNegativeIntegers
{
	public static final int DEFAULT_CAPACITY = 10;
	
	private final int capacity;

	private int size;

	public StackOfNonNegativeIntegers()
	{
		this.capacity = DEFAULT_CAPACITY;
		this.size = 0;
	}
	
	public StackOfNonNegativeIntegers(int capacity)
	{
		this.capacity = capacity;
		this.size = 0;
	}
	
	public int getSize()
	{
		return this.size;
	}

	public int getCapacity()
	{
		return this.capacity;
	}

	public void pop() throws EmptyStackException
	{
		throw new EmptyStackException();
	}

	public void push(int element) throws NegativeIntegerException
	{
		if (element < 0)
			throw new NegativeIntegerException();
	
		this.size += 1;
	}
}
