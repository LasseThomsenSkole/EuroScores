import java.io.FileNotFoundException;
import java.util.*;

public class Statistics {
    private final List<MatchResult> matchResults;
    public Statistics(String fileName) throws FileNotFoundException {
        this.matchResults = new MatchResultFileReader(fileName).readFile();
    }
    public Set<String> getGoalscorers(){
        Set<String> goalscores = new HashSet<>();
        for (MatchResult matchResult:matchResults){
            goalscores.addAll(matchResult.getGoalScorers());
        }
        return goalscores;
    }
    public Map<String, Integer> getGoalScorersWithTotal(){
        Map<String, Integer> goalScorersWithTotal = new HashMap<>();

        for (MatchResult matchResult :matchResults){
            for (String goalScore : matchResult.getGoalScorers()){
                if (goalScorersWithTotal.containsKey(goalScore)){
                    Integer goals = goalScorersWithTotal.get(goalScore) + 1;
                    goalScorersWithTotal.replace(goalScore, goals);
                }else{
                    goalScorersWithTotal.putIfAbsent(goalScore, 1);
                }
            }
        }
        return goalScorersWithTotal;
    }

    public int getNumberOfGoals(String goalScorer, Map<String, Integer> goalScores){
        return goalScores.get(goalScorer);
    }
}
