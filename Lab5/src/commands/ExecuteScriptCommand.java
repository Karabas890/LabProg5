package commands;

import application.CollectionManager;
import application.InputReader;
import com.google.gson.JsonSyntaxException;
import data.SpaceMarine;
import java.util.ArrayList;
import java.io.*;
import java.util.LinkedList;

public class ExecuteScriptCommand extends Command {

    public ExecuteScriptCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }


    public String execute(String filepath) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)));) {


            while (true) {

                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                InputReader inputReader = new InputReader(collectionManager);
                String[] splitCommand = line.split(" ");

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

                        try {
                            String line0 = reader.readLine();
                            String name2 = line0;
                            String line1 = reader.readLine();
                            float x1 = Float.parseFloat(line1);
                            String line2 = reader.readLine();
                            int y1 = Integer.parseInt(line2);
                            String line3 = reader.readLine();
                            int health1 = Integer.parseInt(line3);
                            String line4 = reader.readLine();
                            String achievements = line4;
                            String line5 = reader.readLine();
                            String AstartesCategory1 = line5;
                            String line6 = reader.readLine();
                            String weapon1 = line6;
                            String line7 = reader.readLine();
                            String chapterName1 = line7;
                            String line8 = reader.readLine();
                            String parentLegion1 = line8;
                            SpaceMarine spaceMarineAdd = new SpaceMarine();
                            spaceMarineAdd = inputReader.receiveSpaceMarine(name2, x1, y1, health1, achievements, AstartesCategory1,
                                    weapon1, chapterName1, parentLegion1);
                            AddCommand addCommand = new AddCommand(collectionManager);
                            System.out.println(addCommand.execute(spaceMarineAdd));
                            break;

                        }catch (NumberFormatException e) {
                            // действия, которые нужно выполнить, если строку нельзя преобразовать в целое число
                            System.out.println("Not correct add arguments");
                            System.exit(0);
                        }







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
                            System.out.println("There are no command arguemnt. Chech [help] for reading command syntax");
                        } else {
                            collectionManager.setScriptLength();
                            if (collectionManager.scriptLength()>50){
                                System.out.println("Recursion detected. Program paused.");
                                collectionManager.setScriptLength(0);
                                System.exit(0);
                                break;
                            }




                            File file = new File(splitCommand[1]);
                            if (file.exists() || file.canRead()) {



                                    ExecuteScriptCommand executeScriptCommand = new ExecuteScriptCommand(collectionManager);

                                    executeScriptCommand.execute(splitCommand[1]);



                            } else {
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
                        System.out.println("History command in not available in the script.");
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
        } catch (IOException e) {
            System.out.println("There are some problems with the file.");
        }
        return "Script ended.";
    }
}
