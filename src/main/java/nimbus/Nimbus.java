package nimbus;

import nimbus.ui.Ui;
import nimbus.storage.Storage;
import nimbus.task.Task;
import nimbus.task.TaskList;
import nimbus.exception.NimbusException;
import nimbus.parser.Command;
import nimbus.parser.Parser;
import nimbus.task.Deadline;
import nimbus.task.Event;
import nimbus.task.Todo;

public class Nimbus {

    private final Ui ui;
    private TaskList taskList;
    private final Storage storage;
    private static final String path = "data/tasks.txt";

    public Nimbus() {
        this.ui = new Ui();
        this.storage = new Storage(path);
    }

    public void run() {
        ui.showWelcome();
        boolean isRunning = true;

        try{
            this.taskList = new TaskList(storage.readFromFile());
            ui.showTasksLoaded(taskList.getSize());
        } catch (NimbusException e) {
            ui.printError(e);
            this.taskList = new TaskList();
        }

        while (isRunning) {
            String input = ui.readCommand();
            try {
                Command command = Parser.parseCommand(input);
                String arguments = Parser.parseArguments(input);
                switch (command) {
                    case LIST -> ui.printTaskList(taskList);
                    case MARK -> {
                        int taskNumber = Parser.parseIndex(arguments);
                        taskList.markTask(taskNumber);
                        ui.printMarkTask(taskList.getTask(taskNumber));
                    }
                    case UNMARK -> {
                        int taskNumber = Parser.parseIndex(arguments);
                        taskList.unmarkTask(taskNumber);
                        ui.printUnmarkTask(taskList.getTask(taskNumber));
                    }
                    case DELETE -> {
                        int taskNumber = Parser.parseIndex(arguments);
                        Task deletedTask = taskList.removeTask(taskNumber);
                        ui.printDeleteTask(deletedTask, taskList);
                    }
                    case TODO -> {
                        Todo todo = Parser.parseTodo(arguments);
                        taskList.addTask(todo);
                        ui.printAddTask(todo, taskList);
                    }
                    case DEADLINE -> {
                        Deadline deadline = Parser.parseDeadline(arguments);
                        taskList.addTask(deadline);
                        ui.printAddTask(deadline, taskList);
                    }
                    case EVENT -> {
                        Event event = Parser.parseEvent(arguments);
                        taskList.addTask(event);
                        ui.printAddTask(event, taskList);
                    }
                    case BYE -> {
                        isRunning = false;
                    }
                    case UNKNOWN -> {
                        throw new NimbusException("I'm sorry, I don't know what that means.");
                    }
                }
            } catch (NimbusException e) {
                ui.printError(e);
            }
        }
        try {
            storage.writeToFile(taskList.getTasks());
            ui.showTasksSaved(taskList.getSize());
        } catch (NimbusException e) {
            ui.printError(e);
        }
        ui.showExitMessage();
    }
    public static void main(String[] args) {
        new Nimbus().run();
    }
}