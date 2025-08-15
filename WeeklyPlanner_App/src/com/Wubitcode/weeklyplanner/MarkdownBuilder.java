package com.Wubitcode.weeklyplanner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MarkdownBuilder {

    public static String build(String weekLabel, List<String> tasks) {
        StringBuilder sb = new StringBuilder();

        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        sb.append("# Weekly Plan — ").append(weekLabel).append("\n\n");
        sb.append("_Generated: ").append(today).append(" with WeeklyPlanner_App_\n\n");

        sb.append("## Tasks\n");
        for (String t : tasks) {
            sb.append("- [ ] ").append(t).append("\n");
        }
        sb.append("\n");

        String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        sb.append("## Schedule\n");
        sb.append("| Day | Focus |\n");
        sb.append("|-----|-------|\n");
        for (int i = 0; i < days.length; i++) {
            String task = tasks.get(i % tasks.size());
            sb.append("| ").append(days[i]).append(" | ").append(task).append(" |\n");
        }
        sb.append("\n");

        sb.append("## Notes\n");
        sb.append("- Wins:\n");
        sb.append("- Blockers:\n");
        sb.append("- Next Week Prep:\n");

        return sb.toString();
    }
}
