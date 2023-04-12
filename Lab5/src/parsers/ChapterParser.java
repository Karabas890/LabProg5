package parsers;

import com.google.gson.*;
import data.Chapter;
import data.Coordinates;

import java.lang.reflect.Type;

public class ChapterParser implements JsonDeserializer<Chapter> {

    @Override
    public Chapter deserialize(JsonElement jsonElement, Type type,
                                   JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String chapterName;
        try {
            chapterName = jsonObject.get("name").getAsString();
        } catch (NumberFormatException e) {
            chapterName = null;
        }
        if(chapterName==null ||chapterName.trim().isEmpty() ){
            System.out.println("Not correct chapterName in file");
            System.exit(0);
        }
        String parentLegion;
        try {
             parentLegion = jsonObject.get("parentLegion").getAsString();
        } catch (NumberFormatException e) {
            parentLegion = null;
        }
        return new Chapter(chapterName, parentLegion);
    }

}
