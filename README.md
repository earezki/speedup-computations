# speedup-computations
Sometimes you find yourself trying to squeeze the last bits of your cpu to give you some more milliseconds, Or you may hate the smell of a melting cpu because of an intensive calculation, Or maybe you are just a performance maniac, In all cases, this post is for you.
So let us say you are designing a banking application in which you have a Transaction entity, and let us say that the entity contains those simple fields.
```java
class Transaction {
	String uuid;
	double amount;
	String debitAccountNo;
	String creditAccountNo;
	int failureAttempts;
}
```
And then you have an account with a bunch of transactions
```java
class Account {
	...
	Transaction[] transactions;
	...
}
```
Now you are tasked to calculate the total amount of those transactions.
A simple solution would be:
```java
double sumAmount() {
	double result = 0.0;
	for (int i = 0; i < transactions.length; i++) {
    	result += transactions[i].amount;
	}
	return result;
}
```
(Do not attack me; I know this is not object oriented)
You test it and it works. Next day your colleagues start to complain about performance and giving there is millions of transactions, the profiler point your method. What are you going to do now? Hmm, let me see, Yeah I got it, Parallelism to the rescue, you take this great idea to your colleagues and they turn you down because the server is already filled with active threads.
Now what, well, you just need to better use your cycles.
Let’s change the structure of the Account entity.
```java
class Account {
	...
	double[] amounts;
	...
```
Then the calculation becomes:
```java
double sumAmount() {
	double result = 0.0;
	for (int i = 0; i < transactions.length; i++) {
    	result += transactions[i];
	}
	return result;
}
```
On my rusty machine and after warming the JVM for 1000 round, this implementation is around 6X faster than the previous one. (Test for yourselves working code on github https://github.com/earezki/speedup-computations)
Now why this is faster, the reason is that modern cpus works better when all the calculation is applied on data that is packed together, the cpu reads data from the memory in cache lines (which is around 64KB in most cpus) and store it in the L1 cache, the first example suffer a lot from cache miss, which means, the cpu reads a lot of data that doesn’t need, then throw it away and gets more data.
In Intel i7 5500 for example, reads from the L1 cache takes around 4 cycles for simple access where as a read from main memory takes around 120 cycles.
Now you have it, most of the time the overhead of the calculation in the first example is not worth the change to the second unless you work on a very restricted environment (Embedded system as an example). And just to be honest, I don’t think you’ll benefit from this approach in a large webapp, because other scheduled threads will pollute the cache anyway and your best bet is the shared large L3 cache (for Intel at least).
