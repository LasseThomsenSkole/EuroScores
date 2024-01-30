import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatchResultFileReader {
    private String fileName;
    public MatchResultFileReader(String fileName){
        this.fileName = fileName;
    }

    public List<MatchResult> readFile() throws FileNotFoundException {
        List<MatchResult> matchResults = new ArrayList<>();
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextLine()){
            List<String> goalscorers = new ArrayList<>();
            String[] splittedData = scanner.nextLine().split(";");
            String teams = splittedData[0];
            if (splittedData.length == 2){
                goalscorers = List.of(splittedData[1].split(","));
            }
            MatchResult matchResult = new MatchResult(teams, goalscorers);
            matchResults.add(matchResult);
        }
        return matchResults;
    }
}
