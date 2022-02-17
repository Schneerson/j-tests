package helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class searchResultAnalysisHelper {

    static boolean isAllValuesTrue(boolean[] massive) {
        for (int i =  0; i < massive.length; i++) {
            if (!massive[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isInSearch(String[] searchResults, String exceptedTag) {
        boolean[] isInName = new boolean[searchResults.length];
        Pattern pattern = Pattern.compile(exceptedTag);
        for (int i =  0; i < searchResults.length; i++) {
            Matcher matcher = pattern.matcher(searchResults[i]);
            isInName[i] = matcher.find();
        }
        return isAllValuesTrue(isInName);
    }
}
