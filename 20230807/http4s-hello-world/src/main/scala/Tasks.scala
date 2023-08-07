var tasks = List(Task(id = 1, title = "밥먹기"), Task(id = 2, title = "빨래하기"))

def listTasks() =
  tasks

def findTask(taskId: Int) =
  tasks.find(_.id == taskId)

def createTask(task: Task) =
  tasks = tasks.appended(task)

def deleteTask(taskId: Int) =
  tasks = tasks.filter(t => t.id != taskId)

def updateTask(taskId: Int, source: Task) =
  tasks = tasks.map(task =>
    if (task.id == taskId)
      Task(id = taskId, title = source.title)
    else task
  )
