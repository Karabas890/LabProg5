package parsers;

import com.google.gson.*;
import data.Chapter;
import data.Coordinates;
import data.SpaceMarine;

import java.lang.reflect.Type;
import java.util.LinkedList;

public class SpaceMarinesParser implements JsonDeserializer<LinkedList<SpaceMarine>> {

    @Override
    public LinkedList<SpaceMarine> deserialize(JsonElement json, Type type, JsonDeserializationContext
            jsonDeserializationContext) throws JsonParseException {
        LinkedList<SpaceMarine> collection = new LinkedList<>();
        JsonArray jsonArray = json.getAsJsonArray();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(SpaceMarine.class, new SpaceMarineParser())
                .registerTypeAdapter(Chapter.class,     new ChapterParser())
                .registerTypeAdapter(Coordinates.class, new CoordinatesParser())
                .registerTypeAdapter(LinkedList.class,  new SpaceMarinesParser()).create();
        for (JsonElement element : jsonArray) {
            SpaceMarine spaceMarine = gson.fromJson(element, SpaceMarine.class);
                collection.add(spaceMarine);
        }
        return collection;
    }


}
