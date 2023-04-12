package parsers;

import com.google.gson.*;
import data.Coordinates;

import java.lang.reflect.Type;

public class CoordinatesParser implements JsonDeserializer<Coordinates> {

    @Override
    public Coordinates deserialize(JsonElement jsonElement, Type type,
                                   JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Float x;
        try {
            x = jsonObject.get("x").getAsFloat();
        } catch (NumberFormatException e) {
            x = null;
        }
        if(x==null || x<-298){
            System.out.println("Not correct X in file");
            System.exit(0);
        }
        Integer y;
        try {
            y = jsonObject.get("y").getAsInt();
        } catch (NumberFormatException e) {
            y = null;
        }
        if(y==null || y<-126){
            System.out.println("Not correct Y in file");
            System.exit(0);
        }
        return new Coordinates(x, y);
    }
}
