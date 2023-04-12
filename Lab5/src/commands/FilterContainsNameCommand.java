package commands;

import application.CollectionManager;
import data.SpaceMarine;

import java.util.LinkedList;

public class FilterContainsNameCommand extends Command {

    public FilterContainsNameCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public String execute(String name) {
        LinkedList<SpaceMarine> collection = collectionManager.getCollection();
        StringBuilder stringBuilder = new StringBuilder();
        for (SpaceMarine spaceMarine : collection) {
            String name2 = spaceMarine.getName();
            boolean bl = name2.contains(name);
            if (bl == true) {
                stringBuilder.append(spaceMarine).append("\n");
            }
        }
        if (!stringBuilder.isEmpty()) {
            return stringBuilder.toString();
        } else {
            return "No such substring in any item name";
        }
    }
}
