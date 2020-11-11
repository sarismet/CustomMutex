[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)


# TestAndSet

  - I implemented anoher class to control and manage both requesting critical sections and turns.
  - isNotFreeToEnterCS takes a parameter which is the id of thread and if it is able to enter to CS then the method returns false to get out of the bussy waiting.
  - The isNotFreeToEnterCS is ModifiedTestAndTest class and there are 2 variables which are myvalue and turn. The two are initialized -1. myvalue is defined to express wheter or not a thread is in CS such that if a thread is in CS then myvalue is 1 and the other thread cannot enter into the CS until myvalue is 0. We have 2 thread. If turn is 0 then thread with id 2 can enter into the CS once myvlue is 0. When turn is 1 the condition is the same.
  - In isNotFreeToEnterCS we check first if the turn is -1 which means that CS is being executed for the first time. We get the CS and set the myvalue 1 and give the turn to the other thread. If the turn is not -1 and the turn is the thread that requesting (we check thşs by turn == i%2 if thread id is 1 and turn is 1 1== 1 check. If the thread has the turn then we check if CS is available by if (!(testAndSet(1) == 1)). If it is available which means that myvalue is 0 then if go into if and change the turn. If we get into "if" then myvalue is set 1. The method always returns false to get out of busy waiting if we get into one of the if or else if statements. Otherwise it returns to keep being in busy waiting.)
  - To release the lock we just use classic TestAndSet by giving 0 to set myvalue 0 meaning that CS is available to be executed.
