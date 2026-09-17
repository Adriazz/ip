# Nimbus User Guide

![Nimbus screenshot](Ui.png)

Nimbus is a **desktop chatbot for managing your tasks**, optimized for use via a Command Line Interface (CLI). If you can type fast, Nimbus can get your task management done faster than traditional GUI apps, while still giving you a clean interface to see what's going on.

* [Quick Start](#quick-start)
* [Features](#features)
  * [Adding a todo: `todo`](#adding-a-todo-todo)
  * [Adding a deadline: `deadline`](#adding-a-deadline-deadline)
  * [Adding an event: `event`](#adding-an-event-event)
  * [Listing all tasks: `list`](#listing-all-tasks-list)
  * [Marking a task as done: `mark`](#marking-a-task-as-done-mark)
  * [Unmarking a task: `unmark`](#unmarking-a-task-unmark)
  * [Finding tasks: `find`](#finding-tasks-find)
  * [Deleting a task: `delete`](#deleting-a-task-delete)
  * [Exiting the program: `bye`](#exiting-the-program-bye)
* [FAQ](#faq)
* [Command Summary](#command-summary)

--------------------------------------------------------------------------------------------------------------------

## Quick Start

1. Ensure you have Java 17 or above installed on your computer.
2. Download the latest `nimbus.jar` from the releases page.
3. Copy the file to the folder you want to use as the home folder for Nimbus.
4. Open a command terminal, `cd` into the folder you put the jar file in, and run `java -jar nimbus.jar`.
5. Type a command in the input box and press Enter to execute it. e.g. typing `list` and pressing Enter will show all your tasks.
6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

> **Notes on the command format**
> * Words in `UPPER_CASE` are parameters to be supplied by you.<br>
>   e.g. in `todo DESCRIPTION`, `DESCRIPTION` is a parameter which can be used as `todo return book`.
> * Task numbers used by `mark`, `unmark`, and `delete` refer to the index shown in the most recent `list` or `find` output, starting from 1.

### Adding a todo: `todo`

Adds a simple task with no date or time attached to Nimbus's task list.

Example: `todo return book`

Expected outcome:
```
Got it. I've added this task:
  [T][ ] return book
Now you have 1 task in the list.
```

### Adding a deadline: `deadline`

Adds a task that needs to be done by a specific date/time.

Example: `deadline submit report /by 2026-09-30 2359`

Expected outcome:
```
Got it. I've added this task:
  [D][ ] submit report (by: Sep 30 2026, 11:59 PM)
Now you have 2 tasks in the list.
```

### Adding an event: `event`

Adds a task that starts and ends at specific date/time.

Example: `event project meeting /from 2026-10-01 1400 /to 2026-10-01 1600`

Expected outcome:
```
Got it. I've added this task:
  [E][ ] project meeting (from: Oct 1 2026, 2:00 PM to: Oct 1 2026, 4:00 PM)
Now you have 3 tasks in the list.
```

### Listing all tasks: `list`

Shows a list of all tasks currently in Nimbus, in the order they were added.

Example: `list`

Expected outcome:
```
Here are the tasks in your list:
1. [T][ ] return book
2. [D][ ] submit report (by: Sep 30 2026, 11:59 PM)
3. [E][ ] project meeting (from: Oct 1 2026, 2:00 PM to: Oct 1 2026, 4:00 PM)
```

### Marking a task as done: `mark`

Marks the specified task as done.

Example: `mark 1`

Expected outcome:
```
Nice! I've marked this task as done:
  [T][X] return book
```

### Unmarking a task: `unmark`

Marks the specified task as not done.

Example: `unmark 1`

Expected outcome:
```
OK, I've marked this task as not done yet:
  [T][ ] return book
```

### Finding tasks: `find`

Finds tasks whose description contains the given keyword (case-insensitive).

Example: `find report`

Expected outcome:
```
Here are the matching tasks in your list:
1. [D][ ] submit report (by: Sep 30 2026, 11:59 PM)
```

### Deleting a task: `delete`

Deletes the specified task from Nimbus.

Example: `delete 3`

Expected outcome:
```
Noted. I've removed this task:
  [E][ ] project meeting (from: Oct 1 2026, 2:00 PM to: Oct 1 2026, 4:00 PM)
Now you have 2 tasks in the list.
```

### Exiting the program: `bye`

Exits Nimbus.

Example: `bye`

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another computer?<br>
**A**: Install Nimbus on the other computer and copy over the data file created after adding tasks on your first computer.

--------------------------------------------------------------------------------------------------------------------

## Command Summary

| Action | Format | Example |
|--------|--------|---------|
| Todo | `todo DESCRIPTION` | `todo return book` |
| Deadline | `deadline DESCRIPTION /by DATE_TIME` | `deadline submit report /by 2026-09-30 2359` |
| Event | `event DESCRIPTION /from START /to END` | `event project meeting /from 2026-10-01 1400 /to 2026-10-01 1600` |
| List | `list` | `list` |
| Mark | `mark INDEX` | `mark 1` |
| Unmark | `unmark INDEX` | `unmark 1` |
| Find | `find KEYWORD` | `find report` |
| Delete | `delete INDEX` | `delete 3` |
| Exit | `bye` | `bye` |
