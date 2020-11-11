[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)


# TestAndSet

  - I implemented anoher method called isNotFreeToEnterCS to control and manage both requesting critical sections and turns.
  - isNotFreeToEnterCS takes a parameter which is the id of thread and if it is able to enter to CS then the method returns false to get out of the bussy waiting.
  - The isNotFreeToEnterCS is ModifiedTestAndTest class and there are 2 variables which are myvalue and turn. The two are initialized -1. myvalue is defined to express wheter or not a thread is in CS such that if a thread is in CS then myvalue is 1 and the other thread cannot enter into the CS until myvalue is 0. We have 2 thread. If turn is 0 then thread with id 2 can enter into the CS once myvlue is 0. When turn is 1 the condition is the same.
  - In isNotFreeToEnterCS we check first if the turn is -1 which means that CS is being executed for the first time. We get the CS and set the myvalue 1 and give the turn to the other thread. If the turn is not -1 and the turn is the thread that requesting (we check thşs by turn == i%2 if thread id is 1 and turn is 1 1== 1 check. If the thread has the turn then we check if CS is available by if (!(testAndSet(1) == 1)). If it is available which means that myvalue is 0 then if go into if and change the turn. If we get into "if" then myvalue is set 1. The method always returns false to get out of busy waiting if we get into one of the if or else if statements. Otherwise it returns to keep being in busy waiting.)
  - To release the lock we just use classic TestAndSet by giving 0 to set myvalue 0 meaning that CS is available to be executed.
  
 ## Does it meet the requirements.
 - Yes. We can provide mutual exclusion.If a thread is in CS then the other thread cannot get into CS since the thread in CS executed the testAndSet(1) and set the myvalue 1 and the other thread cannot go into CS since this.mylock.isNotFreeToEnterCS(threadId)) always returns true because no if-else if statements are executed as long as myvalue is 1. testAndSet(1) is always equal to 1 if CS is being executed by a tread.
 - Starvation is provided by managing turns. No thread can executed CS more than 1 in a row since when a thread executes CS it gives the turn to other thread and isNotFreeToEnterCS checks wheter or not the thread haf the turn.
 - Starvation and Mutual Exculusion are met. While a thread requests CS program first check if the turn is threads. If it is that so program checks if CS is being executed by executing (testAndSet(1) == 1). If myvalue is 1 meaning that someone is in CS then the statement is true and program does not allow the thread to get into CS.

# Swap
- The idea is the same as TestAndTest. We have a isNotFreeToEnterCS method that takes 1 parameter which is the id of thead. We request by using this method. If it returns false then we get into CS. If returns true then keep staying in while loop.
- In this part we use the swap to request CS. if the swaps method are 1,0 then we want CS. If parameters are 0 ,1 then we want to release the CS. 
- In the class we define isInCS and isCSFree. We initialized them as 0 and 1 repectively. If turn is -1 when we run isNotFreeToEnterCS method then we can go into CS and give the turn to the other thread and use swap(1,0). By swap (1,0) isInCS will be 1 and isCSFree will be 0. If turn is not -1 and the mod of thread's id equals to turn then we check if the other thread is in CS by checking "this.isInCS == 0 && this.isCSFree == 1". If all of them is true then we change the turn and swap(1,0) to set the variable.

 ## Does it meet the requirements.
- Starvation and Mutual Exculusion are met. The idea is the same as testAndSet. We always change the turn once a thread is in CS so starvation problem is removed. swap(1,0) is used to set isInCS and isCSFree 1 and 0 respectively. Then the other thread cannot get into CS since we check isInCS == 0 && isCSFree == 1 as requesting. As long as isInCS and isCSFree are 1, 0 then the other thread cannot enter CS. swap (0,1) is used to set isInCS and isCSFree 0, 1 respectively, which means that CS is not being executed. Even if a thread gets the turn it might not be able to get into CS if isInCS == 1 && isCSFree == 0 and these variables remain as these are until swap (0,1) is executed.

