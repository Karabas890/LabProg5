package commands;

import application.CollectionManager;

import java.util.HashMap;
import java.util.Map;

public class HelpCommand extends Command {

    private final Map<String, String> tutorial;

    public HelpCommand(CollectionManager collectionManager) {
        super(collectionManager);
        tutorial = new HashMap<>();
        tutorial.put("help", " - вывести справку по доступным командам");
        tutorial.put("info", " - вывести в стандартный поток вывода информацию о коллекции");
        tutorial.put("show", " - вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        tutorial.put("add {element} ", " - добавить новый элемент в коллекцию");
        tutorial.put("update id {element}", " - обновить значение элемента коллекции, id которого равен заданному");
        tutorial.put("remove_by_id id", " - удалить элемент из коллекции по его id");
        tutorial.put("clear", " - очистить коллекцию");
        tutorial.put("save", " - сохранить коллекцию в файл");
        tutorial.put("execute_script file_name", " - считать и исполнить скрипт из указанного файла. В скрипте " +
                "содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        tutorial.put("exit", " - завершить программу (без сохранения в файл)");
        tutorial.put("remove_head", " - вывести первый элемент коллекции и удалить его");
        tutorial.put("add_if_min {element}", "добавить новый элемент в коллекцию, если его значение меньше, " +
                "чем у наименьшего элемента этой коллекции");
        tutorial.put("history", " - вывести последние 5 команд (без их аргументов)");
        tutorial.put("count_less_than_health health ", " - вывести количество элементов, значение поля health которых " +
                "меньше заданного");
        tutorial.put("filter_contains_name name ", " - вывести элементы, значение поля name которых содержит " +
                "заданную подстроку");
        tutorial.put("print_field_descending_weapon_type", " - вывести значения поля weaponType всех элементов в " +
                "порядке убывания");
    }

    public String execute() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> pair : tutorial.entrySet()) {
            stringBuilder.append(pair.getKey()).append(pair.getValue()).append("\n");
        }
        return stringBuilder.toString();
    }

}
