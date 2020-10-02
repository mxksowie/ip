# User Guide

A quick overview of how to use Duke, a CLI-based task manager.

## Adding tasks

Duke supports 3 different types of tasks

### Todos
The vanilla type of task, requiring just a description of it.
e.g. Read a book.
Example of usage:

```
todo Read a book
```

Expected outcome:

```
Got it. I've added this task :
   [T][✘] read a book
  Now you have 1 tasks in the list.
  ```

### Deadlines
Tasks with both a descriptor and a deadline.
e.g. Read a book by midnight

Example of usage:
```
deadline read a book by midnight
```

Expected outcome:
```
Got it. I've added this task :
   [D][✘] read a book (by: midnight)
  Now you have 2 tasks in the list.
```

### Events
Tasks with a descriptor and venue and/or time.
e.g. read a book at the library

Example of usuage:
```
event read a book at the library
```
Expected outcome:
```
Got it. I've added this task :
   [E][✘] read a book (at: the library)
  Now you have 3 tasks in the list
```

## Viewing the List and Finding tasks

To view all the tasks in your list, use the `list` command.

Example of usuage:
```
list
```

Expected outcome:
```
Here are the tasks in your list:
1. [T][✘] read a book 
2. [D][✘] read a book (by: midnight)
3. [E][✘] read a book (at: the library)
Now you have 3 tasks in the list.
```


### Finding a task
Find all tasks that contain a certain phrase or word using the `find` command.

Example of usuage:
```
find book
```

Expected outcome:
```
Here are the matching tasks in your list:
1. [T][✘] read a book
2. [D][✘] read a book (by: midnight)
3. [E][✘] read a book (at: the library)
```

## Managing tasks

Tasks can be deleted and marked as complete.

### Completing a task
Tasks are marked complete using the `done` keyword

Example of usuage:
```
done 1
```

Expected outcome:
```
Nice! I've marked this task as done:
     [T][✓] read a book
```


### Deleting a task
Tasks are deleted using the `delete` keyword

Example of usuage:
```
delete 1
```

Expected outcome:
```
  Noted. I've removed this task:
    [T][✓] read a book
  Now you have 2 tasks in the list.
 ```

## Closing Duke

Finally, to end the application, use the `bye` keyword

Example of usuage:
```
bye
```

Expected outcome:
```
Bye. Hope to see you again soon!
```
