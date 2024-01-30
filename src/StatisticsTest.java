import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {
    Statistics statistics = new Statistics("data.csv");

    StatisticsTest() throws FileNotFoundException {
    }

    @org.junit.jupiter.api.Test
    void getGoalscorers() {
        Set<String> goalScoreres = statistics.getGoalscorers();
        assertEquals(8, goalScoreres.size());
    }

    @org.junit.jupiter.api.Test
    void getGoalScorersWithTotal() {
        Map<String, Integer> goalScorersWithTotal = statistics.getGoalScorersWithTotal();
        assertEquals(8, goalScorersWithTotal.size());
    }

    @org.junit.jupiter.api.Test
    void getNumberOfGoals() {
        Map<String, Integer> goalScorersWithTotal = statistics.getGoalScorersWithTotal();
        int højlundGoals = goalScorersWithTotal.get("Højlund");
        assertEquals(7, højlundGoals);
    }
}