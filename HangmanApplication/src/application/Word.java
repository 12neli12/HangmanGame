package application;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class WordManager {
    private Map<String, String> wordHintMap;
    private Random random;

    public WordManager() {
        wordHintMap = new HashMap<>();
        
        wordHintMap.put("apple", "A red or green fruit");
        wordHintMap.put("java", "A programming language");
        wordHintMap.put("banana", "A yellow fruit");
        wordHintMap.put("table", "furniture");
        wordHintMap.put("cat", "pet");
        wordHintMap.put("chair", "seating");
        wordHintMap.put("book", "reading");
        wordHintMap.put("car", "vehicle");
        wordHintMap.put("sun", "celestial body");
        wordHintMap.put("dog", "animal");
        wordHintMap.put("house", "residence");
        wordHintMap.put("tree", "plant");
        wordHintMap.put("shoe", "footwear");
        wordHintMap.put("bird", "feathered creature");
        wordHintMap.put("clock", "timepiece");
        wordHintMap.put("hand", "bodypart");
        wordHintMap.put("cloud", "atmospheric phenomenon");
        wordHintMap.put("cake", "dessert");
        wordHintMap.put("bell", "musical instrument");
        wordHintMap.put("key", "unlock");
        wordHintMap.put("coin", "currency");

        random = new Random();
    }

    public Map.Entry<String, String> getRandomWordAndHint() {
        int randomIndex = random.nextInt(wordHintMap.size());
        return (Map.Entry<String, String>) wordHintMap.entrySet().toArray()[randomIndex];
    }
}