package commands;

import application.CollectionManager;
import data.SpaceMarine;

import java.util.LinkedList;

public class ShowCommand extends Command {

    public ShowCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public String execute() {
        StringBuilder stringBuilder = new StringBuilder();
        LinkedList<SpaceMarine> collection = collectionManager.getCollection();
        for (SpaceMarine spaceMarine : collection) {
            stringBuilder.append(spaceMarine.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

}
