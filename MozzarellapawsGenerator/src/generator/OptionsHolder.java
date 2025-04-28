package generator;

public class OptionsHolder {

    /*
     * Greetings ought to be followed with an exclamation point.
     */
    public static String[] greetings = { "Hi chat", "Hey guys", "Howdy", "Wassup", "Hello", "Hi there", "Hey there",
            "Hola", "Hi", "Hey", "Howdy-doo", "Aloha", "Sup", "Welcome", "Hey chat" };

    public static String[] reactions = { "Hey, that's got a ring to it!", "Not bad!", "I like it!", "Ohhhh yeahhhh!",
            "Hm. Alright then.", "Oh. Uhh... moving on.", "Well that is... something.", "What a mouthful!",
            "Can I be honest with you? I hate this one." };

    /*
     * Pulled from https://en.wikipedia.org/wiki/List_of_cheeses on 4/27/2025.
     */
    public static String[] allCheeses = { "Mozzarella", "Bouhezza", "Kemariya", "Wagasi", "Ayibe", "Caravane", "Kwaito",
            "Chechil", "Lori", "Tel-Panir", "Chhana", "Byaslag", "Chura-Kampo", "Chura-Loenpa", "Nguri", "Rubing",
            "Rushan", "Imeruli", "Sulguni", "Tenili", "Bandel", "Paneer", "Khoa", "Kalari", "Kalimpong", "Qudam",
            "Dangke", "Sakura", "Imsil", "Susu-Masam", "Byaslag", "Flower-of-Rajya", "Chhurpi", "Kesong-Puti",
            "Djathë-I-Bardhë", "Kaçkavall", "Djathë=Pice", "Gjizë", "Urdhë", "Bachensteiner", "Bergkäse", "Brimsen",
            "Gelundener-Käse", "Lüneberg", "Montafoner-Sauerkäse", "Mondseer", "Moosbacher", "Staazer", "Steirerkäse",
            "Tyrolean-Grey", "Brussels", "Chimay", "Herve", "LeWavreumont", "Maredsous", "Passendale", "Remoudou",
            "Rodoric", "Livno", "Herzegovina", "Trappista", "Travnički", "Bosnian-Smoked", "Cherni-Vit", "Urdă",
            "Kashkaval", "Sirene", "Paški-Sir", "Paška-Skuta", "Škripavac", "Basa", "Krčki-Sir", "Grobnički-Sir",
            "Dinarski-Sir", "Dinarski-Sir-Iz-Maslinove-Komine", "Sir-Iz-Mišine", "Težački-Sir-Iz-Maslinove-Komine",
            "Lećevački-Sir", "Liburnski-Sir", "Istarska-Skuta", "Dubrovački-Sir", "Tounjski-Sir", "Prgica", "Dimsi",
            "Caprilo", "Capron", "Ovidur", "Akkawi", "Anari", "Halloumi", "Kefalotyri", "Abertam", "Blaťácké-Zlato",
            "Olomoucké-Syrečky", "Hermelín", "Danbo", "Danablu", "Esrom", "Fynbo", "Havarti", "Maribo", "Molbo", "Saga",
            "Samsø", "Tybo", "Vesterhavsost", "Atleet", "Eesti-Juust", "Kadaka-Juust", "Aura", "Lappi", "Leipäjuusto",
            "Oltermanni", "Raejuusto", "Anthotyros", "Chloro", "Feta", "Graviera", "Kasseri", "Kefalograviera",
            "Kefalotyri", "Kopanisti", "Malaka", "Manouri", "Metsovone", "Myzithra", "Tyrozouli", "Xynomizithra",
            "Xynotyro", "Formaela", "Galotyri", "Kalathaki", "Katiki", "Ladotyri", "Pichtogalo-Chanion", "Sfela",
            "Xygalo", "Gran-Castelli", "Liptauer", "Orda", "Pálpusztai", "Oázis", "Balaton", "Karaván", "Pannónia",
            "Höfðingi", "Fried-Camembert", "Šar", "Jāņi", "Džiugas", "Ġbejna", "Cașcaval", "Urdă", "Brânză",
            "Brânză-de-vaci", "Kolašinski-Sir", "Pljevaljski-Sir", "Podgorički-Sir", "Nikšićki-Kozji-Sir",
            "Njeguški-Sir", "Kashkaval", "Urdă", "Belo-Sirenje", "Brunost", "Gamalost", "Geitost", "Heidal",
            "Nøkkelost", "Norvegia", "Pultost", "Snøfrisk", "Bałtycki", "Bryndza", "Bryndza-Podhalańska", "Bundz",
            "Bursztyn", "Edamski", "Gołka", "Gryficki", "Hauskyjza", "Kortowski", "Koryciński", "Królewski", "Liliput",
            "Lechicki", "Łowicki", "Lubuski", "Mazurski", "Morski", "Oscypek", "Przeworski", "Radamer", "Redykołka",
            "Rokpol", "Słupski-Chłopczyk", "Twaróg", "Tylżycki", "Zamojski", "Zgorzelecki", "Castelo-Branco",
            "Queijo-de-Nisa", "Queijo-do-Pico", "Queijo-de-Azeitão", "São-Jorge", "Serra-da-Estrela", "Trás-os-Montes",
            "Requeijão", "Saloio", "Santarém", "Serpa", "Brânză-de-Burduf", "Brânză-de-Suhaia", "Brânză-de-Vaci", "Caș",
            "Kravská-Hrudka", "Korbáčiky", "Oštiepok", "Parenica", "Urda", "Tvaroh", "Encián", "Plesnivec", "Mohant",
            "Tolminc", "Bohinc-Jože", "Nanoški", "Planinski", "Ädelost", "Blå-Gotland", "Grevé", "Gräddost",
            "Herrgårdsost", "Hushållsost", "Moose", "Prästost", "Svecia", "Västerbottensost", "Bilozhar", "Bukovynskyi",
            "Bryndza", "Dobrodar", "Smetankovyi", "Syr", "Ukrainskyi", "Vurda", "Banbury", "Cheddar", "Stilton",
            "Stinking-Bishop", "Areesh", "Baramily", "Domiati", "Halumi", "Istanboly", "Mish", "Rumi", "Lighvan",
            "Talesh", "Mahali", "Kupe-Paniri", "Tzfatit-Kashah", "Tzfatit-Triah", "Labneh", "Kashkawal", "Qishta",
            "Halloumi", "Hemed", "Kedem", "Knaaan", "Hermon", "Khalla", "Arrabah", "Kafrit", "Akkawi", "Areesh",
            "Baladi", "Basket", "Charkassiye", "Jameed", "Jibneh-Arabieh", "Jibne-Baida", "Kashkawan", "Majdoule",
            "Nabulsi", "Shelal", "Surke-or-Shanklish", "Abaza", "Antep-Peyniri", "Armola-Peyniri", "Arnavut",
            "Beyaz-Peynir", "Çamur", "Çeçil", "Çökelek", "Çömlek-Peyniri", "Dil-Peyniri", "Edirne", "Ezine-Peyniri",
            "Füme-Çerkes-Peyniri", "Hellim", "Kars-Gravyeri", "Kaşar", "Keçi-Peyniri", "Kirli-Hanım",
            "Kopanisti-Peyniri", "Küflü-Peynir", "Lor", "Malakan-Peyniri", "Mihaliç-Peyniri", "Obruk", "Örgü",
            "Salamura", "Sayas", "Süzme-Yoğurt", "Telli-Peynir", "Tulum", "Van-Otlu-Peyniri", "Bleu-Bénédictin",
            "Cheddar", "Curd", "Oka", "Pikauba", "Palmito", "Turrialba", "Cuajada", "Crema", "Enredo", "Queto",
            "Quesillo", "Adobera", "Añejo", "Asadero", "Chiapas", "Chihuahua", "Cotija", "Criollo", "Lingallin",
            "Oaxaca", "Queso-Crema", "Queso-De-Cuajo", "Queso-Fresco", "Queso-Panela", "Requesón", "Quesillo",
            "Bergenost", "Brick", "Colby", "Colby-Jack", "Colorado-Blackie", "Creole-Cream", "Humboldt-Fog",
            "Liederkranz", "Monterey-Jack", "Muenster", "Nacho", "Pepper-Jack", "Pinconning", "Provel", "Red-Hawk",
            "String", "Teleme", "Cottage", "Cremoso", "Criollo", "Goya", "Reggianito", "Sardo", "Chubut", "Tandil",
            "Mar-del-Plata", "Tafi-del-Valle", "Cuartirolo", "Provoleta", "Queso-de-Maquina", "Chaqueño", "Menonita",
            "Catupiry", "Minas", "Queijo-Coalho", "Queijo-de-Colônia", "Queijo-Meia-Cura", "Queijo-Canastra",
            "Queijo-Cobocó", "Queijo-do-Reino", "Queijo-do-Serro", "Queijo-Manteiga", "Queijo-Prato", "Requeijão",
            "Chanco", "Panquehue", "Renaico", "Queso-Campesino", "Queso-Costeño", "Cuajada", "Queso-Paipa",
            "Queso-Pera", "Quesillo", "Queso-7-Cueros", "Paraguay", "Allpachaca", "Queso-Andino", "Queso-Fresco",
            "Colonia", "Cuartirolo", "Danbo", "Sándwich", "Termal", "Yamandú", "Zapicán", "Guayanés", "Queso-Crineja",
            "Queso-de-Mano", "Queso-Llanero", "Queso-Palmita", "Queso-Parma-de-Barinitas", "Queso-Telita", "Tresse",
            "Big-Woods-Blue", "Morcella", "Swiss" };

    public static String[] commonCheeses = { "Mozzarella", "Feta", "Cheddar", "Stilton", "Halloumi", "Cheddar", "Cream",
            "Colby", "Colby-Jack", "Monterey-Jack", "Muenster", "Nacho", "Pepper-Jack", "Provolone", "String",
            "Cottage", "Swiss" };

    public static String[] allBodyParts = { "paws", "fangs", "claws", "tail", "pelt", "fur", "heart", "whiskers",
            "stripes", "nose", "face", "ears", "fluff", "mouth", "eyes", "head", "shoulders", "knees", "toes", "ankles",
            "feet", "beans", "lungs", "kidneys", "stomach", "tummy", "eyebrows", "hairs", "forehead", "eyelids",
            "eyelashes", "lashes", "lips", "cheeks", "nostrils", "teeth", "chin", "neck", "throat", "biceps",
            "forearms", "palms", "fingers", "nails", "chest", "belly", "belly-Button", "hips", "waist", "butt",
            "thighs", "calves" };

    public static String[] reasonableBodyParts = { "paws", "fangs", "claws", "tail", "pelt", "fur", "whiskers", "nose",
            "face", "ears", "fluff", "mouth", "toes", "tummy", "cheeks", "belly" };

    /**
     * Returns a String greeting, ending in an exclamation point.
     * 
     * @return String greeting
     */
    public static String getGreeting() {
        return RandomSelector.getRandomFromArray(greetings) + "!";
    }
    
    /**
     * Returns a String reaction to a name.
     * 
     * @return String reaction
     */
    public static String getReaction() {
        return RandomSelector.getRandomFromArray(reactions);
    }

    /**
     * Returns a wordified and capitalized version of a number to be used for a first name.
     * 
     * @return String number in word form
     */
    public static String getNumber(int min, int max) {
        int number = RandomSelector.getRandomIntInRange(min, max);
        return NumToWordConverter.convert(number);
    }

    /**
     * Returns the String name of a type of cheese.
     * 
     * @param  includeAll if true, will choose from all cheeses, else chooses from common ones
     * @return            String type of cheese
     */
    public static String getCheese(boolean includeAll) {
        if (includeAll) {
            return RandomSelector.getRandomFromArray(allCheeses);
        } else {
            return RandomSelector.getRandomFromArray(commonCheeses);
        }
    }

    /**
     * Returns the String name of a body part an anthropomorphic cat could have.
     * 
     * @param  includeAll if true, will choose from all body parts, else chooses from reasonable ones
     * @return            String name of a body part
     */
    public static String getBodyPart(boolean includeAll) {
        if (includeAll) {
            return RandomSelector.getRandomFromArray(allBodyParts);
        } else {
            return RandomSelector.getRandomFromArray(reasonableBodyParts);
        }
    }

}
