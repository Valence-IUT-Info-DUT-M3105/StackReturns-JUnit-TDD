unit-testing-stack-example
==========================

Example of using JUnit to write test for existing code.

The stack is a simple data structure that allows to handle elements following a LIFO (Last In First Out) principle.
It provides simple operation allowing to add an element (push), remove an element (pop) or view the last added element (view).
 
Design rules for this stack :

- the stack contains only positive or null integers.
- the stack has a limited capacity, that can be set at creation (if not, the default value is 10). The capacity value can be obtained by calling getCapacity
- after creation, the stack is empty
- the number of integers currently stored in the stack can be obtained by calling getSize
- calling push on a full stack must raise an exception
- calling push with a negative integer must raise an exception
- calling pop or view on an empty stack must raise an exception
