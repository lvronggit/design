StampedLock  

Java 在 1.8 这个版本里，
提供了一种叫 StampedLock 的锁，它的性能就比读写锁还要好.
StampedLock 支持的三种锁模式我们先来看看在使用上 
StampedLock 和上一篇文章讲的 ReadWriteLock 有哪些区别。
ReadWriteLock 
支持两种模式：一种是读锁，一种是写锁。
而 StampedLock 支持三种模式，分别是：写锁、悲观读锁和乐观读。
其中，写锁、悲观读锁的语义和 ReadWriteLock 的写锁、读锁的语义非常类似，
允许多个线程同时获取悲观读锁，但是只允许一个线程获取写锁，写锁和悲观读锁是互斥的。
不同的是：StampedLock 里的写锁和悲观读锁加锁成功之后，都会返回一个 stamp；
然后解锁的时候，需要传入这个 stamp。相关的示例代码如下


StampedLock 的性能之所以比 ReadWriteLock 还要好，其关键是 StampedLock 支持乐观读的方式。
ReadWriteLock 支持多个线程同时读，但是当多个线程同时读的时候，所有的写操作会被阻塞；
而 StampedLock 提供的乐观读，是允许一个线程获取写锁的，也就是说不是所有的写操作都被阻塞。



CountDownLatch和CyclicBarrier  // 线程一致性锁


CountDownLatch 和 CyclicBarrier 是 Java 并发包提供的两个非常易用的线程同步工具类，
这两个工具类用法的区别在这里还是有必要再强调一下：
CountDownLatch 主要用来解决一个线程等待多个线程的场景，
可以类比旅游团团长要等待所有的游客到齐才能去下一个景点；
而 CyclicBarrier 是一组线程之间互相等待，更像是几个驴友之间不离不弃。
除此之外 CountDownLatch 的计数器是不能循环利用的，也就是说一旦计数器减到 0，
再有线程调用 await()，该线程会直接通过。
但 CyclicBarrier 的计数器是可以循环利用的，而且具备自动重置的功能，
一旦计数器减到 0 会自动重置到你设置的初始值。
除此之外，CyclicBarrier 还可以设置回调函数，可以说是功能丰富。
本章的示例代码中有两处用到了线程池，你现在只需要大概了解即可，
因为线程池相关的知识咱们专栏后面还会有详细介绍。
另外，线程池提供了 Future 特性，我们也可以利用 Future 特性来实现线程之间的等待，
这个后面我们也会详细介绍。

并发容器
https://static001.geekbang.org/resource/image/a2/1d/a20efe788caf4f07a4ad027639c80b1d.png












