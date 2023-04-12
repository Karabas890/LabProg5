package commands;

import application.CollectionManager;

public class InfoCommand extends Command {

    public InfoCommand(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public String execute() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Type of collection: ");
        stringBuilder.append(collectionManager.getCollection().getClass());
        stringBuilder.append("\n");

        stringBuilder.append("Date of initialization: ");
        stringBuilder.append(collectionManager.getInitializationDate());
        stringBuilder.append("\n");

        stringBuilder.append("Size of collection: ");
        stringBuilder.append(collectionManager.getCollection().size());
        stringBuilder.append("\n");

        return stringBuilder.toString();

    }
}
