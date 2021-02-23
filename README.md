# WorkManagerApplication - An Android Project to demostrate the use of WorkManager Jetpack Library.
About WorkManager :

WorkManager is not for task that needs to be run in a background thread but don`t need to survive process death - for such tasks, use coroutines or RxJava

WorkManager Provides :
	1) Chaining Tasks - Parallel execution of tasks and Sequential Execution of tasks
	2) Status updates
	3) Constraints
	4) Minimum resource usage
	5) Support Different versions
	6) Asynchronous Tasks
  7) Periodic Tasks
  
  There can be two types of work requests :
	1) Periodic Work Request (e.g.: updating data from server regularly)
  2) One Time Work Request (e.g.: uploading a file)
  
  Below are the four steps of scheduling a task using WorkManager :
	1) Create a worker class
	2) Create a work request
	3) Enqueue the request
	4) Get the status updates

  A work can have four states :
	1) Blocked
	2) Enqueued
	3) Running
	4) Succeeded
