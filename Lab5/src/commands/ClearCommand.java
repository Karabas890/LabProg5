package commands;

import application.CollectionManager;
import data.SpaceMarine;

import java.util.LinkedList;

public class ClearCommand extends Command {

    public ClearCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public String execute() {
        LinkedList<SpaceMarine> collection = collectionManager.getCollection();
        collection.clear();
        return "Collection has been cleaned!\n";
    }

}
