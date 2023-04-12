package application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import data.Chapter;
import data.Coordinates;
import data.SpaceMarine;
import parsers.*;

import java.io.*;
import java.time.LocalDate;
import java.util.LinkedList;

public class CollectionManager {

    private LinkedList<SpaceMarine> collection;
    private LocalDate initializationDate;
    private String pathToFile;
    private int scriptLength;
    private final Gson gson = new GsonBuilder().
            registerTypeAdapter(SpaceMarine.class, new SpaceMarineParser())
            .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
            .registerTypeAdapter(Chapter.class, new ChapterParser())
            .registerTypeAdapter(Coordinates.class, new CoordinatesParser())
            .registerTypeAdapter(LinkedList.class, new SpaceMarinesParser()).create();

    public CollectionManager(String filepath) {
        this.pathToFile = filepath;
        collection = loadCollection(filepath);
        initializationDate = LocalDate.now();
    }

    public boolean checkPermissionsForWrite() {
        File file = new File(pathToFile);
        if (file.exists()  && file.canWrite()) {
            return true;
        } else {
            return false;
        }
    }
    public boolean checkPermissionsForRead() {
        File file = new File(pathToFile);
        if (file.exists() && file.canRead() ) {
            return true;
        } else {
            return false;
        }
    }

    private LinkedList<SpaceMarine> downloadCollection() {
        if (checkPermissionsForRead()) {
            File file = new File(pathToFile);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));) {
                String line;
                String data = "";
                String prevData = "";
                while ((line = reader.readLine()) != null) {
                    if (data.length() != 0) {
                        prevData = data + "\n";
                    }
                    data = prevData + line;
                }
                if (data.equals("")) {
                    return new LinkedList<SpaceMarine>();
                }
                if (pathToFile.equals("")) {
                    System.out.println("Wrong path to file!");
                    System.exit(1);
                }
                return gson.fromJson(data, LinkedList.class);
            } catch (JsonSyntaxException e) {
                System.out.println("Problems with parsing");
                return new LinkedList<SpaceMarine>();
            } catch (IOException e) {
                System.out.println("There are some problems with the file.");
            }
            return new LinkedList<>();
        } else {
            System.out.println("Access to file denied. Downloaded empty collection.");
            return new LinkedList<SpaceMarine>();
        }
    }

    public boolean checkSpaceMarine(SpaceMarine spaceMarine) {
        if (!(spaceMarine.getId() <= 0 ||
                spaceMarine.getName().equals("")) ||
                spaceMarine.getName() == null ||
                spaceMarine.getCoordinates().getX() <= -298 ||
                spaceMarine.getCoordinates().getY() <= -126 ||
                spaceMarine.getCreationDate() == null ||
                spaceMarine.getHealth() == null ||
                spaceMarine.getHealth() <= 0 ||
                spaceMarine.getCategory() == null ||
                spaceMarine.getWeaponType() == null ||
                spaceMarine.getChapter().getName() == null
        ) {
            return true;
        } else {
            return false;
        }
    }

    public LinkedList<SpaceMarine> loadCollection(String filepath) {
        LinkedList<SpaceMarine> rawCollection = downloadCollection();
        LinkedList<SpaceMarine> readyCollection = new LinkedList<>();
        for (SpaceMarine spaceMarine : rawCollection) {
            if (checkSpaceMarine(spaceMarine)) {
                readyCollection.add(spaceMarine);
            }
        }
        System.out.println(rawCollection.size() + " items was written from file.");
        System.out.println(readyCollection.size() + " items has been validated and added to collection");
        return readyCollection;
    }

    public void save() {
        if (checkPermissionsForWrite()) {
            String inFile = gson.toJson(collection);
            try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(pathToFile))) {
                writer.write(inFile);
            } catch (IOException fileNotFoundException) {
                System.err.println("Incorrect path to file. Please, check it and try again.");
            }
        } else {
            System.err.println("Incorrect path to file. Please, check it and try again.");
        }
    }

    public int scriptLength() {
        return scriptLength;
    }
    public void setScriptLength() {
        scriptLength=scriptLength+1;

    }
    public void setScriptLength(int a) {
        scriptLength=a;

    }

    public LinkedList<SpaceMarine> getCollection() {
        return collection;
    }

    public LocalDate getInitializationDate() {
        return initializationDate;
    }

    public int getMaxID() {
        int max = Integer.MIN_VALUE;
        for (SpaceMarine spaceMarine : collection) {
            if (spaceMarine.getId() > max) {
                max = spaceMarine.getId();
            }
        }
        if (max == Integer.MIN_VALUE) {
            return 1;
        }
        return max;
    }
}
