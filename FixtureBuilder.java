import java.util.ArrayList;
import java.util.LinkedList;

public class FixtureBuilder {
    public static void fixtureBuild(ArrayList<String> teams) {
        if (teams.size() % 2 != 0) teams.add("Bye");

        ArrayList<String> teamList = new ArrayList<>();

        int rank;
        while (teamList.size() < teams.size()) {
            rank = (int) (Math.random() * teams.size());
            if (!teamList.contains(teams.get(rank))) {
                teamList.add(teams.get(rank));
            }
        }

        ArrayList<ArrayList<int[]>> fixture = new ArrayList<>();
        LinkedList<Integer> teamsBackup = new LinkedList<>();

        for (int p = 0; p < teamList.size(); p++) {
            teamsBackup.add(p);
        }

        for (int i = 1; i <= 2 * (teamList.size() - 1); i++) {
            ArrayList<int[]> week = new ArrayList<>();

            for (int j = 0; j < teamList.size() / 2; j++) {
                int[] match = new int[2];
                match[(i + 1) % 2] = teamsBackup.get(j);
                match[i % 2] = teamsBackup.get(teamList.size() - 1 - j);
                week.add(match);
            }

            fixture.add(week);

            teamsBackup.add(1, teamsBackup.remove(teamsBackup.size() - 1));
        }

        printFixture(teamList, fixture);
    }

    public static void printFixture(ArrayList<String> teamList, ArrayList<ArrayList<int[]>> fixture) {
        System.out.println("\nTeams:");

        for (String s : teamList) {
            if (!s.equals("Bye")) {
                System.out.println("- " + s);
            }
        }

        for (int i = 0; i < fixture.size(); i++) {
            System.out.println("");
            System.out.println("Week " + (i + 1) + ":");
            for (int m = 0; m < fixture.get(i).size(); m++) {
                System.out.println(teamList.get(fixture.get(i).get(m)[0])
                        + " vs " + teamList.get(fixture.get(i).get(m)[1]));
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> teams = new ArrayList<>();
        teams.add("Galatasaray");
        teams.add("Bursaspor");
        teams.add("Fenerbahçe");
        teams.add("Beşiktaş");
        teams.add("Başakşehir");
        teams.add("Trabzonspor");
        teams.add("Ankaragücü");

        fixtureBuild(teams);
    }
}
