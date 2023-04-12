package parsers;

import com.google.gson.*;
import data.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SpaceMarineParser implements JsonDeserializer<SpaceMarine> {
    ArrayList<Integer> ids=new ArrayList<>();
    @Override
    public SpaceMarine deserialize(JsonElement jsonElement, Type type,
                                   JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Integer id;


        try {
            id = jsonObject.get("id").getAsInt();
            for(int i=0;i<ids.size();i++){
                if(id==ids.get(i)){
                    System.out.println("There are the same ids in the file");
                    System.exit(0);
                }
            }
            ids.add(id);
        } catch (NumberFormatException e) {
            id = null;
        }
        String name = jsonObject.get("name").getAsString();
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Not correct name in file");
            System.exit(0);
        }

        Coordinates coordinates = (Coordinates) jsonDeserializationContext
                .deserialize(jsonObject.get("coordinates"), Coordinates.class);
        String stringCreationDate = jsonObject.get("creationDate").getAsString();
      //  System.out.println(stringCreationDate);
        /*
        if(!(DateValidator.isValidDateFormat(stringCreationDate))){
            System.out.println("Not correct date in file");
            System.exit(0);
        }
         */try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate creationDate = LocalDate.parse(stringCreationDate, formatter);
        }catch(java.time.format.DateTimeParseException e){
            System.out.println("Not correct date in file");
            System.exit(0);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate creationDate = LocalDate.parse(stringCreationDate, formatter);
        Integer health;
        try {
            health = jsonObject.get("health").getAsInt();
        } catch (NumberFormatException e) {
            health = null;
        }
        if(health==null || health<0){
            System.out.println("Not correct health in file");
            System.exit(0);
        }
        String achievements = jsonObject.get("achievements").getAsString();
        String category = jsonObject.get("category").getAsString();

        if(!category.equals("SCOUT") && !category.equals("AGGRESSOR")&& !category.equals("TACTICAL")&& !category.equals("CHAPLAIN")&& !category.equals("APOTHECARY")){
            System.out.println("Not correct category in file");
            System.exit(0);
        }


        AstartesCategory astartesCategory = AstartesCategory.valueOf(jsonObject.get("category").getAsString());
        String weapon1 = jsonObject.get("weaponType").getAsString();
        if(!weapon1.equals("BOLT_RIFLE") && !weapon1.equals("COMBI_FLAMER")&& !weapon1.equals("FLAMER")){
            System.out.println("Not correct weapon in file");
            System.exit(0);
        }
        Weapon weapon = Weapon.valueOf(jsonObject.get("weaponType").getAsString());
        Chapter chapter = (Chapter) jsonDeserializationContext
                .deserialize(jsonObject.get("chapter"), Chapter.class);
        return new SpaceMarine(id, name, coordinates, creationDate.toString(), health, achievements, astartesCategory,
                weapon, chapter);
    }
}
