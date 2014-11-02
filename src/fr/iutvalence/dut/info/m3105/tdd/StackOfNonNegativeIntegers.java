package fr.iutvalence.dut.info.m3105.tdd;

public class StackOfNonNegativeIntegers
{
	public static final int DEFAULT_CAPACITY = 10;
	
	private final int capacity;

	private int size;
	
	private int[] elements;

	public StackOfNonNegativeIntegers()
	{
		this.capacity = DEFAULT_CAPACITY;
		this.size = 0;
		this.elements = new int[this.capacity];
	}
	
	public StackOfNonNegativeIntegers(int capacity)
	{
		this.capacity = capacity;
		this.size = 0;
		this.elements = new int[this.capacity];
	}
	
	public int getSize()
	{
		return this.size;
	}

	public int getCapacity()
	{
		return this.capacity;
	}

	public int pop() throws EmptyStackException
	{
		raiseExceptionIfstackIsEmpty();
		
		decrementSize();
		
		return this.elements[this.size];
	}

	private void raiseExceptionIfstackIsEmpty() throws EmptyStackException
	{
		if (this.size == 0) 
			throw new EmptyStackException();
	}

	private void decrementSize()
	{
		this.size -= 1;		
	}

	public int view() throws EmptyStackException
	{
		raiseExceptionIfstackIsEmpty();
		
		return this.elements[this.size-1];
	}

	public void push(int element) throws NegativeIntegerException
	{
		raiseExceptionIfElementIsNegative(element);
		
		this.elements[this.size] = element;
		incrementSize();
	}

	private void incrementSize()
	{
		this.size += 1;
	}

	private void raiseExceptionIfElementIsNegative(int element) throws NegativeIntegerException
	{
		if (element < 0)
			throw new NegativeIntegerException();
	}
}
