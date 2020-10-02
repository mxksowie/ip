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

### Advanced usage: Finding dated tasks
Deadline and Event tasks support dated deadlines/times.
Creating a dated deadline or event involves using an ISO date as the deadline/time.

To find such a dated deadline or time, use the `dated` command with a valid ISO date.

Example of usuage:
```
deadline read a book by 2020-10-04
dated 2020-10-04
```

Expected outcomes:
```
Got it. I've added this task :
   [D][✘] read a book (at: 04/10/2020)
  Now you have 4 tasks in the list.
```
```
Here are the matching tasks in your list:
1. [D][✘] read a book (at: 04/10/2020)
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

## Troubleshooting
Here are a list of common errors that might arise during usage

### Invalid keywords or missing details
Error Messages:
```
You need to tell me more about what you want to do.
Sorry. I don't know what that means
```
Issue: You need to enter a valid command or keyword pre-fix such as `list` or `todo` followed by a descriptor.
This is likely caused by a mispelled keyword or missing phrase.

### Invalid Indexing
Error Messages:
```
You need to provide me with an integer index.

I couldn't delete the task at position 6
I think you don't have that many tasks in your list.
```
Issue: `delete` and `done` require an integer index within the range of the list. This index starts from 1.

### Invalid Date
Error Message:
```
Sorry, I could not figure out that date. It needs to be in ISO format.
```
Issue: The date provided is not in ISO format, which is YYYY-MM-DD (note the number of digits).
This is similarly the issue when dated tasks such as `deadline` and `event` do not reformat your ISO date into a DD/MM/YYYY format.

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
