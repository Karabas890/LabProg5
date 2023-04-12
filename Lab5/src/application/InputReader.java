package application;

import data.*;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputReader {

    CollectionManager collectionManager;
    private int counter;

    public InputReader(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
        this.counter = this.collectionManager.getMaxID() + 1;
    }

    private int generateID() {
        int copy = counter;
        counter++;
        return copy;
    }

    public String receiveName() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Enter a space marine name: ");
                String name = scanner.nextLine();
                if (name == null || name.trim().isEmpty()) {
                    System.out.println("Not correct name, try again");
                    continue;
                }
                return name;
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program successfully finished!");
            System.exit(0);
            return null;
        }
    }
    public String receiveName(String name) {

        try {


                if (name == null || name.trim().isEmpty()) {
                    System.out.println("Not correct name");
                    System.exit(0);
                }
                return name;
            }
         catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program successfully finished!");
            System.exit(0);
            return null;
        }
    }

    public float receiveX() {

        try {
            while (true) {
                System.out.println("Enter X coordinate:");
                Scanner scanner = new Scanner(System.in);
                float x;
                try {
                    x = scanner.nextFloat();
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("Not correct X, try again");
                    continue;
                }
                if (x <= -298) {
                    System.out.println("Not correct X, try again");
                    continue;
                }
                return x;
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program successfully finished!");
            System.exit(0);
            return 0;
        }
    }
    public float receiveX(float x) {

        try {
            while (true) {




                if (x <= -298) {
                    System.out.println("Not correct X");
                    System.exit(0);
                    return 0;
                }
                return x;
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program successfully finished!");
            System.exit(0);
            return 0;
        }
    }

    public int receiveY() {

        try {

            while (true) {
                System.out.println("Enter Y coordinate:");
                Scanner scanner = new Scanner(System.in);
                int y;
                try {
                    y = scanner.nextInt();
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("Not correct Y, try again");
                    continue;
                }
                if (y <= -126) {
                    System.out.println("Not correct Y, try again");
                    continue;
                }
                return y;
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program successfully finished!");
            System.exit(0);
            return 0;
        }
    }
    public int receiveY(int y) {

        try {






                if (y <= -126) {
                    System.out.println("Not correct Y");
                    System.exit(0);

                }
                return y;
            }
         catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program successfully finished!");
            System.exit(0);
            return 0;
        }
    }

    public Coordinates receiveCoordinates() {
        return new Coordinates(receiveX(), receiveY());
    }
    public Coordinates receiveCoordinates(float x,int y) {
        return new Coordinates(receiveX(x), receiveY(y));
    }

    private String receiveCreationDate() {
        return LocalDate.now().toString();
    }

    public Integer receiveHealth() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Enter a health of space marine: ");
                Integer health = scanner.nextInt();
                if (health == null || health <= 0) {
                    System.out.println("Not correct health, try again");
                    continue;
                }
                return health;
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program successfully finished!");
            System.exit(0);
            return 0;
        }
    }
    public Integer receiveHealth(Integer health) {
        Scanner scanner = new Scanner(System.in);
        try {


                if (health == null || health <= 0) {
                    System.out.println("Not correct health");
                    System.exit(0);

                }
                return health;
            }
         catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program successfully finished!");
            System.exit(0);
            return 0;
        }
    }

    public String receiveAchievements() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter achievements: ");
            String achievements = scanner.nextLine();
            return achievements;
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program successfully finished!");
            System.exit(0);
            return null;
        }
    }
    public String receiveAchievements(String achievements) {

        try {

            return achievements;
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program successfully finished!");
            System.exit(0);
            return null;
        }
    }
    public AstartesCategory receiveAstartesCategory() {
        try {
            while (true) {
                System.out.println("Enter AstartesCategory. Choose value from list:");
                System.out.println("1. SCOUT;");
                System.out.println("2. AGGRESSOR;");
                System.out.println("3. TACTICAL;");
                System.out.println("4. CHAPLAIN;");
                System.out.println("5. APOTHECARY.");
                System.out.println("Enter a string from list or it's number in list: ");
                Scanner scanner = new Scanner(System.in);
                String s = scanner.nextLine();
                String capsString = s.toUpperCase(Locale.ROOT);
                switch (capsString) {
                    case "SCOUT":
                    case "1":
                        return AstartesCategory.SCOUT;
                    case "AGGRESSOR":
                    case "2":
                        return AstartesCategory.AGGRESSOR;
                    case "TACTICAL":
                    case "3":
                        return AstartesCategory.TACTICAL;
                    case "CHAPLAIN":
                    case "4":
                        return AstartesCategory.CHAPLAIN;
                    case "APOTHECARY":
                    case "5":
                        return AstartesCategory.APOTHECARY;
                    default:
                        System.out.println("Please enter a string from list or it's number in list");
                        break;
                }
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program successfully finished!");
            System.exit(0);
            return null;
        }
    }
    public AstartesCategory receiveAstartesCategory(String astartesCategory) {
        try {


            astartesCategory = astartesCategory.toUpperCase(Locale.ROOT);
            switch (astartesCategory) {
                case "SCOUT":
                case "1":
                    return AstartesCategory.SCOUT;
                case "AGGRESSOR":
                case "2":
                    return AstartesCategory.AGGRESSOR;
                case "TACTICAL":
                case "3":
                    return AstartesCategory.TACTICAL;
                case "CHAPLAIN":
                case "4":
                    return AstartesCategory.CHAPLAIN;
                case "APOTHECARY":
                case "5":
                    return AstartesCategory.APOTHECARY;
                default:
                    System.out.println("Please enter a string from list or it's number in list");
                    System.exit(0);
                    return null;

            }

        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program successfully finished!");
            System.exit(0);
            return null;
        }
    }


    public Weapon receiveWeapon() {
        try {
            while (true) {
                System.out.println("Enter weapon. Choose value from list:");
                System.out.println("1. BOLT_RIFLE;");
                System.out.println("2. COMBI_FLAMER;");
                System.out.println("3. FLAMER.");
                System.out.println("Enter a string from list or it's number in list: ");
                Scanner scanner = new Scanner(System.in);
                String s = scanner.nextLine();
                String capsString = s.toUpperCase(Locale.ROOT);
                switch (capsString) {
                    case "BOLT_RIFLE":
                    case "1":
                        return Weapon.BOLT_RIFLE;
                    case "COMBI_FLAMER":
                    case "2":
                        return Weapon.COMBI_FLAMER;
                    case "FLAMER":
                    case "3":
                        return Weapon.FLAMER;
                    default:
                        System.out.println("Please enter a string from list or it's number in list");
                        break;
                }
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program successfully finished!");
            System.exit(0);
            return null;
        }
    }
    public Weapon receiveWeapon(String weapon) {
        try {


            weapon = weapon.toUpperCase(Locale.ROOT);
            switch (weapon) {
                case "BOLT_RIFLE":
                case "1":
                    return Weapon.BOLT_RIFLE;
                case "COMBI_FLAMER":
                case "2":
                    return Weapon.COMBI_FLAMER;
                case "FLAMER":
                case "3":
                    return Weapon.FLAMER;
                default:
                    System.out.println("Please enter a string from list or it's number in list");
                    System.exit(0);
                    return null;

            }

        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program successfully finished!");
            System.exit(0);
            return null;
        }
    }

    public String receiveChapterName() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Enter a chapter name: ");
                String chapterName = scanner.nextLine();
                if (chapterName == null || chapterName.trim().isEmpty()) {
                    continue;
                }
                return chapterName;
            }
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program successfully finished!");
            System.exit(0);
            return null;
        }
    }
    public String receiveChapterName(String chapterName) {

        try {

                if (chapterName == null || chapterName.trim().isEmpty()) {
                    System.out.println("Not correct chapterName");
                    System.exit(0);
                }
                return chapterName;
            }
         catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program successfully finished!");
            System.exit(0);
            return null;
        }
    }

    public String receiveParentLegion() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter a parentLegion: ");
            String parentLegion = scanner.nextLine();
            return parentLegion;
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program successfully finished!");
            System.exit(0);
            return null;
        }
    }
    public String receiveParentLegion(String parentLegion) {

        try {

            return parentLegion;
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Program successfully finished!");
            System.exit(0);
            return null;
        }
    }
    public Chapter receiveChapter() {
        return new Chapter(receiveChapterName(), receiveParentLegion());
    }
    public Chapter receiveChapter(String chapterName,String parentLegion) {
        return new Chapter(receiveChapterName(chapterName), receiveParentLegion(parentLegion));
    }

    public SpaceMarine receiveSpaceMarine() {
        return new SpaceMarine(
                generateID(),
                receiveName(),
                receiveCoordinates(),
                receiveCreationDate(),
                receiveHealth(),
                receiveAchievements(),
                receiveAstartesCategory(),
                receiveWeapon(),
                receiveChapter()
        );
    }
    public  SpaceMarine receiveSpaceMarine(String name, float x,int y, int health, String achievements,
                                          String astartesCategory,String weapon, String chapterName,String parentLegion) {
        return new SpaceMarine(
                generateID(),
                receiveName(name),
                receiveCoordinates(x,y),
                receiveCreationDate(),
                receiveHealth(health),
                receiveAchievements(achievements),
                receiveAstartesCategory(astartesCategory),
                receiveWeapon(weapon),
                receiveChapter(chapterName, parentLegion)
        );
    }




}
