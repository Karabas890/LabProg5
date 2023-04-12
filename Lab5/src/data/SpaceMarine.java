package data;

import java.time.LocalDate;
import java.util.Objects;

public class SpaceMarine implements Comparable<SpaceMarine> {
    private int id;                             // Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name;                        // Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates;            // Поле не может быть null
    private String creationDate;   // Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer health;                     // Поле не может быть null, Значение поля должно быть больше 0
    private String achievements;                // Поле может быть null
    private AstartesCategory category;          // Поле не может быть null
    private Weapon weaponType;                  // Поле не может быть null
    private Chapter chapter;                    // Поле может быть null

    public SpaceMarine() {}

    public SpaceMarine(int id, String name, Coordinates coordinates, String creationDate,
                       Integer health, String achievements, AstartesCategory category,
                       Weapon weaponType, Chapter chapter) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.health = health;
        this.achievements = achievements;
        this.category = category;
        this.weaponType = weaponType;
        this.chapter = chapter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getCreationDate() {
        return creationDate.toString();
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public AstartesCategory getCategory() {
        return category;
    }

    public void setCategory(AstartesCategory category) {
        this.category = category;
    }

    public Weapon getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(Weapon weaponType) {
        this.weaponType = weaponType;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceMarine that = (SpaceMarine) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(coordinates, that.coordinates)
                && Objects.equals(creationDate, that.creationDate) && Objects.equals(health, that.health) &&
                Objects.equals(achievements, that.achievements) && category == that.category
                && weaponType == that.weaponType && Objects.equals(chapter, that.chapter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, health, achievements, category, weaponType, chapter);
    }

    @Override
    public String toString() {
        return "SpaceMarine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", health=" + health +
                ", achievements='" + achievements + '\'' +
                ", category=" + category +
                ", weaponType=" + weaponType +
                ", chapter=" + chapter +
                '}';
    }

    @Override
    public int compareTo(SpaceMarine another) {
        /*
        this > o  => positive number
        this == o => 0
        this < o  => negative number
         */
        if (this.getId() > another.getId()) {
            return 1;
        } else if (this.getId() == another.getId()) {
            return 0;
        } else {
            return -1;
        }
    }
}