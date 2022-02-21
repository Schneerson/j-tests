package Helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.Character.isLowerCase;

public class SearchResultAnalysisHelper {

    static boolean isAllValuesTrue(boolean[] massive) {
        for (boolean b : massive) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    static boolean isEvenOneValueTrue(boolean[] massive) {
        for (boolean b : massive) {
            if (b) {
                return true;
            }
        }
        return false;
    }

    static String changeFirstLetter (String word) {
        if (isLowerCase(word.charAt(0))) {
            return word.substring(0, 1).toUpperCase() + word.substring(1);
        }
        else {
            return word.substring(0, 1).toLowerCase() + word.substring(1);
        }
    }

    static String[] makeWholeMassiveLowerCase (String[] massive){
        String [] lowerCaseMassive = new String[massive.length];
        for (int i =0; i< massive.length; i++) {
            lowerCaseMassive[i] = massive[i].toLowerCase();
        }
        return lowerCaseMassive;
    }

    static String[] makeWholeMassiveUpperCase (String[] massive){
        String [] upperCaseMassive = new String[massive.length];
        for (int i =0; i< massive.length; i++) {
            upperCaseMassive[i] = massive[i].toUpperCase();
        }
        return upperCaseMassive;
    }

    static String[] createDifferentVariantsOfTags(String[] exceptedTags) {
        String[] allTags = new String[exceptedTags.length * 4];
        for (int i = 0; i < exceptedTags.length; i++) {
            allTags[i] = changeFirstLetter(exceptedTags[i]);
            allTags[i + exceptedTags.length] = exceptedTags[i];
            allTags[i + 2 * exceptedTags.length] = makeWholeMassiveUpperCase(exceptedTags)[i];
            allTags[i + 3 * exceptedTags.length] = makeWholeMassiveLowerCase(exceptedTags)[i];
        }
        return allTags;
    }

    public static boolean checkOneTagWithOneName (String name, String exceptedTag) {
        Pattern pattern = Pattern.compile(exceptedTag);
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }

    public static boolean checkAllTagsForOneName (String name, String[] exceptedTags) {
        boolean[] isInName = new boolean[exceptedTags.length];
        for (int i = 0; i < isInName.length; i++) {
            isInName[i] = checkOneTagWithOneName(name, exceptedTags[i]);
        }
        return isEvenOneValueTrue(isInName);
    }

    public static boolean isInSearch(String[] searchResults, String[] exceptedTags) {
        String[] allTags = createDifferentVariantsOfTags(exceptedTags);
        boolean[] isInSearchResult = new boolean[searchResults.length];

        for (int i = 0; i < isInSearchResult.length; i++) {
            isInSearchResult[i] = checkAllTagsForOneName(searchResults[i],allTags);
        }
        return isAllValuesTrue(isInSearchResult);
    }


}
