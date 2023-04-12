package application;

import commands.*;
import data.SpaceMarine;

import java.io.File;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CommandReader {


    public void work(CollectionManager collectionManager) {
        try {

            Scanner scanner = new Scanner(System.in);
            InputReader inputReader = new InputReader(collectionManager);
            ArrayList<String> history = new ArrayList<>();

            while (true) {
                System.out.println("Enter a command:");
                String command = scanner.nextLine();
                String[] splitCommand = command.split(" ", 2);
                if (history.size() < 5) {
                    history.add(splitCommand[0]);
                } else {
                    history.remove(0);
                    history.add(splitCommand[0]);
                }
                switch (splitCommand[0]) {
                    case "help":
                        HelpCommand helpCommand = new HelpCommand(collectionManager);
                        System.out.println(helpCommand.execute());
                        break;
                    case "info":
                        InfoCommand infoCommand = new InfoCommand(collectionManager);
                        System.out.println(infoCommand.execute());
                        break;
                    case "show":
                        ShowCommand showCommand = new ShowCommand(collectionManager);
                        if (collectionManager.getCollection().size() == 0) {
                            System.out.println("Collection is empty.");
                        } else {
                            System.out.println(showCommand.execute());
                        }
                        break;
                    case "add":
                        SpaceMarine spaceMarine = inputReader.receiveSpaceMarine();
                        AddCommand addCommand = new AddCommand(collectionManager);
                        System.out.println(addCommand.execute(spaceMarine));
                        break;
                    case "update":
                        if (splitCommand.length < 2) {
                            System.out.println("There are no command arguemnt. Chech [help] for reading command syntax");
                        } else {
                            UpdateCommand updateCommand = new UpdateCommand(collectionManager);
                            SpaceMarine spaceMarine1 = inputReader.receiveSpaceMarine();
                            int id = Integer.parseInt(splitCommand[1]);
                            System.out.println(updateCommand.execute(id, spaceMarine1));
                        }
                        break;
                    case "remove_by_id":
                        if (splitCommand.length < 2) {
                            System.out.println("There are no command arguemnt. Chech [help] for reading command syntax");
                        } else {
                            int id1 = Integer.parseInt(splitCommand[1]);
                            RemoveByIdCommand removeByIdCommand = new RemoveByIdCommand(collectionManager);
                            System.out.println(removeByIdCommand.execute(id1));
                        }
                        break;
                    case "clear":
                        System.out.println(new ClearCommand(collectionManager).execute());
                        break;
                    case "save":
                        collectionManager.save();
                        break;
                    case "execute_script":

                        if (splitCommand.length < 2) {
                            System.out.println("There are no command argument. Check [help] for reading command syntax");
                        } else {


                            File file = new File(splitCommand[1]);
                            if (file.exists() || file.canRead()) {

                                    ExecuteScriptCommand executeScriptCommand = new ExecuteScriptCommand(collectionManager);
                                    System.out.println(executeScriptCommand.execute(splitCommand[1]));
                                }
                             else {
                                System.out.println("Check permissions for script file.");
                            }
                        }
                        break;
                    case "exit":
                        System.out.println(new ExitCommand(collectionManager).execute());
                        System.exit(0);
                        break;
                    case "remove_head":
                        System.out.println(new RemoveHeadCommand(collectionManager).execute());
                        break;
                    case "add_if_min":
                        SpaceMarine spaceMarine2 = inputReader.receiveSpaceMarine();
                        System.out.println(new AddIfMinCommand(collectionManager).execute(spaceMarine2));
                        break;
                    case "history":
                        for (int i = history.size() - 1; i >= 0; i--) {
                            System.out.println(history.get(i));
                        }
                        break;
                    case "count_less_than_health":
                        if (splitCommand.length < 2) {
                            System.out.println("There are no command arguemnt. Chech [help] for reading command syntax");
                        } else {
                            CountLessThanHealthCommand countLessThanHealthCommand =
                                    new CountLessThanHealthCommand(collectionManager);
                            int health = Integer.parseInt(splitCommand[1]);
                            System.out.println(countLessThanHealthCommand.execute(health));
                        }
                        break;
                    case "filter_contains_name":
                        if (splitCommand.length < 2) {
                            System.out.println("There are no command arguemnt. Chech [help] for reading command syntax");
                        } else {
                            FilterContainsNameCommand filterContainsNameCommand =
                                    new FilterContainsNameCommand(collectionManager);
                            System.out.println(filterContainsNameCommand.execute(splitCommand[1]));
                        }
                        break;
                    case "print_field_descending_weapon_type":
                        PrintFieldDescendingWeaponTypeCommand printFieldDescendingWeaponTypeCommand =
                                new PrintFieldDescendingWeaponTypeCommand(collectionManager);
                        System.out.println(printFieldDescendingWeaponTypeCommand.execute());
                        break;
                    default:
                        System.out.println("Unknown command. Write [help] for receiving list of commands.");
                        break;

                }
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program finished successfully!");
        }
    }
}
