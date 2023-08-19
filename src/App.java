import java.util.*;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many times do you wanna gacha?");
        int amount = scan.nextInt();

        int counter = 0;

        for (int i = 0; i < amount; i++) {
            System.out.println("Choose how many times do you want to roll... (1x |10x)");
            System.out.print("Choice: ");
            int roll = scan.nextInt();

            if (roll == 1 || roll == 10) {
                if (roll == 1) {
                    Chance(roll);
                    counter++;
                    if (counter == 10) {
                        Chance(roll);
                        counter = 0;
                    }
                } else if (roll == 10) {
                    for (int y = 0; y < roll + 1; y++) {
                        Chance(roll);
                        System.out.println();
                    }
                }

            } else {
                System.out.println("Invalid Input. Please Pick Again.");
                amount = amount + 1;
            }
        }
    }

    private static void Chance(int roll) {
        Random rand = new Random();
        double chance5Star = 5.00;
        double chance4Star = 15.00;
        double chance3Star = 80.00;
        String servant = null;
        String ce = null;

        List<String> servants5Stars = new ArrayList<>(
                List.of("Artoria Pendragon", "Altera", "Mordred", "Dioscuri", "Orion", "Nikola Tesla",
                        "Arjuna", "Napoleon", "Minamoto no Tametomo", "Karna", "Artoria Pendragon (Lancer)",
                        "Enkidu", "Bradamante", "Vritra", "Bhima", "Francis Drake", "Queen Medb", "Ozymandias",
                        "Quetzalcoatl", "Achilles", "Europa", "Odysseus", "Nemo", "Tai Gong Wang", "Zhuge Liang",
                        "Tamamo no Mae", "Xuanzang Sanzang", "Scheherazade", "Anastasia", "Jack the Ripper",
                        "Osakabehime", "Li Shuwen", "Vlad III", "Nightingale", "Cu Chullain (Alter)", "Xiang Yu",
                        "Galatea", "Jeanne d'Arc", "Nitocris Alter", "Jinako Carigri", "Sitonai"));

        List<String> servants4Stars = new ArrayList<>(
                List.of("Artoria Pendragon (Alter)", "Nero Claudius", "Siegfried", "Chevalier d'Eon", "Rama",
                        "Lancelot (Saber)", "Gawain", "Suzuka Gozen", "Yagyu Munenori", "Diarmuid Ua Duibhne (Saber)",
                        "Lanling Wang", "Lakshimibai", "Watanabe no Tsuna", "Barghest", "Roland", "EMIYA", "Atalanta",
                        "Tristan", "EMIYA (Alter)", "Tomoe Gozen", "Chiron", "Asvatthaman", "Baobhan Sith", "Zenobia",
                        "Elizabeth Bathory", "Artoria Pendragon (Lancer Alter)", "Fionn mac Cumhaill",
                        "Li Shuwen (Lancer)",
                        "Vlad III (EXTRA)", "Medusa (Lancer)", "Parvati", "Nezha", "Valkyrie", "Qin Liangyu", "Caenis",
                        "Percival", "Don Quixote", "Marie Antoinette", "Martha", "Anne Bonny & Mary Read", "Astolfo",
                        "Dobrynya Nikitich", "Huang Feihu", "Medea (Lily)", "Nursery Rhyme", "Helena Blavatsky",
                        "Thomas Edison",
                        "Nitocris", "Gilgamesh (Caster)", "Circe", "Queen of Sheba", "Stheno", "Carmilla",
                        "EMIYA (Assassin)",
                        "Yan Qing", "Wu Zetian", "Mochizuki Chiyome", "Kato Danzo", "Consort Yu", "Hercales",
                        "Lancelot",
                        "Tamamo Cat", "Frankenstein", "Beowulf", "Ibaraki Douji", "Pethesilea", "Atalanta (Alter)",
                        "Kreimhild",
                        "Duryodhana", "Astrea", "Gorgon", "Hessian Lobo", "Hephaestion", "Tenochtitlan"));

        List<String> servants3Stars = new ArrayList<>(
                List.of("Gaius Julius Caesar", "Gilles de Rais (Saber)", "Fergus mac Roich", "Bedivere", "Robin Hood",
                        "Euryale",
                        "David", "Kid Gil", "Billy the Kid", "Tawara Touta", "William Tell", "Cu Chullain",
                        "Cu Chullain (Prototype)",
                        "Hector", "Romulus", "Diarmuid Ua Duibhne", "Jaguar Man", "Hozoin Inshun", "Medusa", "Boudica",
                        "Ushiwakamaru",
                        "Alexander", "Christopher Columbus", "Red Hare", "Mandricardo", "Medea", "Gilles de Rais",
                        "Mephistopheles",
                        "Cu Chullain (Caster)", "Paracelsus von Hohenheim", "Charles Babbage", "Geronimo", "Avicebron",
                        "Asclepius",
                        "Zhang Jue", "Jing Ke", "Henry Jekyll & Hyde", "Hassan of the Hundred Faces", "Fuma Kotaro",
                        "Hassan of the Serenity",
                        "Lu Bu Fengxian", "Darius III", "Kiyohime", "Antonio Salieri", "Xu Fu"));

        List<String> ce5Stars = new ArrayList<>(
                List.of("Formal Craft", "Imaginary Around", "Limited Zero Over", "Kaleidoscope", "Heaven's Feel",
                        "Prisma Cosmos", "The Black Grail",
                        "Victor of the Moon", "Another Ending", "Fragments of 2030", "500 Years Dedication",
                        "Vessel of the Saint", "Origin Bullet", "Before Awakening", "Volumen Hydrargyrum",
                        "Ideal Holy King"));

        List<String> ce4Stars = new ArrayList<>(
                List.of("Iron-Willed Training", "Primeval Curse", "Projection", "Gandr", "Verdant Sound of Destruction",
                        "Gem Magecraft: Antumbra",
                        "Be Elegant", "Imaginary Number Magecraft", "Divine Banquet", "Angel's Song", "With One Strike",
                        "Code Cast", "Knight's Pride",
                        "Necromancy", "Awakened Will", "Golden Millenium Tree", "Innocent Maiden", "Gentle Affection",
                        "Art of Death", "Art of the Poisonous Snake", "Record Holder", "Holy Shroud of Magdalene",
                        "Seal Designation Enforcer"));

        List<String> ce3Stars = new ArrayList<>(
                List.of("Azoth Blade", "Inverted Moon of the Heavens", "Fragarach", "Battle of Camlann",
                        "Jeweled Sword Zelretch", "Extremly Spicy Mapo Tofu", "Bygone Dream", "Ath nHabla",
                        "Bronze-Link Manipulator", "Self Geas Scroll", "Beast of Billows", "Lugh's Halo",
                        "Stuffed Lion", "Hermitage", "Motored Cuirassier", "Storch Ritter", "Elixir of Love",
                        "Ryudoji Temple", "Clock Tower", "Demon Boar", "Anchors Aweigh", "Mooncell Automaton",
                        "Parted Sea", "Dragonkin", "The Crimson Black Keys", "The Verdant Black Keys",
                        "The Azure Black Keys", "False Attendant's Writings", "Azoth Blade"));

        double rollChance1 = rand.nextDouble(100.00);

        if (rollChance1 <= chance5Star) {
            double rollChance2 = rand.nextDouble(chance5Star);
            if (rollChance2 <= 1.00) {
                int picker = rand.nextInt(servants5Stars.size());
                servant = servants5Stars.get(picker) + " (Servant) {*****}";

            } else if (1.00 < rollChance2 || rollChance2 <= 4.00) {
                int picker = rand.nextInt(ce5Stars.size());
                ce = ce5Stars.get(picker) + " (CE) {*****}";

            }
        } else if (/* chance5Star + 0.01 <= rollChance1 */ rollChance1 <= chance4Star) {
            double rollChance2 = rand.nextDouble(chance4Star);
            if (rollChance2 <= 3.00) {
                int picker = rand.nextInt(servants4Stars.size());
                servant = servants4Stars.get(picker) + " (Servant) {****}";

            } else if (3.00 < rollChance2 || rollChance2 <= 12.00) {
                int picker = rand.nextInt(ce4Stars.size());
                ce = ce4Stars.get(picker) + " (CE) {****}";

            }
        } else /* if (chance4Star + 0.01 <= rollChance1 && rollChance1 <= chance3Star) */ {
            double rollChance2 = rand.nextDouble(chance3Star);
            if (rollChance2 <= 39.98) {
                int picker = rand.nextInt(servants3Stars.size());
                servant = servants3Stars.get(picker) + " (Servant) {***}";

            } else if (39.98 < rollChance2 || rollChance2 <= 80.00) {
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