# Week 6 Hands-On 3 - Thread Lifecycle Answers

## Part A - Predicted output (before running)

Main | Before start
TransferWorker-1 | STARTED
AuditLogger-1 | STARTED
AuditLogger-1 | DONE
TransferWorker-1 | DONE
Main | After join

Note: the exact interleaving of STARTED/DONE between the two threads is not
fully guaranteed by the JVM, since thread scheduling is decided by the OS,
not by the order start() was called in. What IS guaranteed is that
"Main | Before start" prints first and "Main | After join" prints last,
because of the two join() calls blocking main until both threads finish.

## Actual output when run

Main | Before start
AuditLogger-1 | STARTED
AuditLogger-1 | DONE
TransferWorker-1 | STARTED
TransferWorker-1 | DONE
Main | After join

The actual run shows AuditLogger-1 completing entirely before
TransferWorker-1 even started printing - a real demonstration that thread
execution order is not guaranteed by source code order, only the
Main | Before start (first) and Main | After join (last) guarantees hold,
exactly as predicted in the note above.

## Part B - Answers

**B1. What is the state of t1 while it is inside Thread.sleep(100)?**

t1 is in the TIMED_WAITING state. It is not running, not ready to run, and
not blocked on a lock - it is paused for a fixed duration and automatically
becomes runnable again once the 100ms elapses.

**B2. Can 'Main | After join' print BEFORE both workers print 'DONE'? Explain in one sentence.**

No - t1.join() and t2.join() force the main thread to block and wait until
each respective thread has completely finished executing, so
"Main | After join" cannot print until both "DONE" lines have already printed.

**B3. A colleague suggests replacing t1.start() with t1.run(). What is the consequence?**

Calling run() directly does not create a new thread at all - it just executes
the run() method's code synchronously on the current thread (main), so t1's
STARTED/DONE lines would print in-order on the main thread itself, with t2
never running concurrently alongside it, defeating the entire purpose of
using threads.