package application;

public class Main {

    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager(args[0]);
        CommandReader commandReader = new CommandReader();
        commandReader.work(collectionManager);
    }

}