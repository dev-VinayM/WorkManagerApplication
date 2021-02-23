# WorkManagerApplication - An Android Project to demostrate the use of WorkManager Jetpack Library.

WorkManager is not for task that needs to be run in a background thread but don`t need to survive process death - for such tasks, use coroutines or RxJava

WorkManager Provides : <br />
	1) Chaining Tasks - Parallel execution of tasks and Sequential Execution of tasks <br />
	2) Status updates <br />
	3) Constraints <br />
	4) Minimum resource usage <br />
	5) Support Different versions <br />
	6) Asynchronous Tasks <br />
  	7) Periodic Tasks <br />
  
  There can be two types of work requests : <br />
	1) Periodic Work Request (e.g.: updating data from server regularly) <br />
  	2) One Time Work Request (e.g.: uploading a file) <br />
  
  Below are the four steps of scheduling a task using WorkManager : <br />
	1) Create a worker class <br />
	2) Create a work request <br />
	3) Enqueue the request <br />
	4) Get the status updates <br />

  A work can have four states : <br />
	1) Blocked <br />
	2) Enqueued <br />
	3) Running <br />
	4) Succeeded <br />
