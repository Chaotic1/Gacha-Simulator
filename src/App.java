import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int counter = 0;
        int choice = 0;
        boolean state = true;

        System.out.println(
                "Pick a choice... \n 1. FGO Gacha\n 2. Arknights Gacha\n 3. Blue Archive Gacha\n 4. CSGO Knife Case Opening\n 5. Exit");
        System.out.print("Choice: ");
        choice = scan.nextInt();

        switch (choice) {
            case 1:
                while (state) {
                    System.out.println("How many times do you wanna gacha?");
                    int amount = scan.nextInt();
                    for (int i = 0; i < amount; i++) {
                        System.out.println("Choose how many times do you want to roll... (1x |10x)");
                        System.out.print("Choice: ");
                        int roll = scan.nextInt();

                        if (roll == 1 || roll == 10) {
                            if (roll == 1) {
                                FGORoll(roll);
                                counter++;
                                if (counter == 10) {
                                    FGORoll(roll);
                                    counter = 0;
                                }
                            } else if (roll == 10) {
                                for (int y = 0; y < roll + 1; y++) {
                                    FGORoll(roll);
                                    System.out.println();
                                }
                            }

                        } else {
                            System.out.println("Invalid Input. Please Pick Again.");
                            amount = amount + 1;
                        }
                    }

                    System.out.println("Do you want to roll again? [Y/N]");
                    System.out.print("Choice: ");
                    String str = scan.next();

                    if (str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("y")) {
                        state = true;
                    } else {
                        state = false;
                        System.out.println("See you soon!");
                        main(args);
                    }
                }
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
        }

    }

    private static void FGORoll(int roll) throws IOException {
        Random rand = new Random();
        double chance5Star = 5.00;
        double chance4Star = 15.00;
        double chance3Star = 80.00;
        String servant = null;
        String ce = null;

        List<String> servants5Stars = Files.readAllLines(new File("5StarServantsList.txt").toPath(),
                Charset.defaultCharset());

        List<String> servants4Stars = Files.readAllLines(new File("4StarServantsList.txt").toPath(),
                Charset.defaultCharset());

        List<String> servants3Stars = Files.readAllLines(new File("3StarServantsList.txt").toPath(),
                Charset.defaultCharset());

        List<String> ce5Stars = Files.readAllLines(new File("5StarCEList.txt").toPath(),
                Charset.defaultCharset());

        List<String> ce4Stars = Files.readAllLines(new File("4StarCEList.txt").toPath(),
                Charset.defaultCharset());

        List<String> ce3Stars = Files.readAllLines(new File("3StarCEList.txt").toPath(),
                Charset.defaultCharset());

        double rollChance1 = rand.nextDouble(100.00);

        if (rollChance1 <= chance5Star) {
            double rollChance2 = rand.nextDouble(chance5Star);
            if (rollChance2 <= 1.00) {
                int picker = rand.nextInt(servants5Stars.size());
                servant = servants5Stars.get(picker) + " (Servant) {*****}";

            } else if (1.00 < rollChance2 && rollChance2 <= 5.00) {
                int picker = rand.nextInt(ce5Stars.size());
                ce = ce5Stars.get(picker) + " (CE) {*****}";

            }
        } else if (/* chance5Star + 0.01 <= rollChance1 */ rollChance1 <= chance4Star) {
            double rollChance2 = rand.nextDouble(chance4Star);
            if (rollChance2 <= 3.00) {
                int picker = rand.nextInt(servants4Stars.size());
                servant = servants4Stars.get(picker) + " (Servant) {****}";

            } else if (3.00 < rollChance2 && rollChance2 <= 15.00) {
                int picker = rand.nextInt(ce4Stars.size());
                ce = ce4Stars.get(picker) + " (CE) {****}";

            }
        } else /* if (chance4Star + 0.01 <= rollChance1 && rollChance1 <= chance3Star) */ {
            double rollChance2 = rand.nextDouble(chance3Star);
            if (rollChance2 <= 39.98) {
                int picker = rand.nextInt(servants3Stars.size());
                servant = servants3Stars.get(picker) + " (Servant) {***}";

            } else if (39.98 < rollChance2 && rollChance2 <= 80.00) {
                int picker = rand.nextInt(ce3Stars.size());
                ce = ce3Stars.get(picker) + " (CE) {***}";

            }
        }

        if (servant != null) {
            System.out.println(servant);
        } else if (ce != null) {
            System.out.println(ce);
        }
    }
}