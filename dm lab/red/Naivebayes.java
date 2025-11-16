package red;

import java.util.*;

public class Naivebayes {

    String weather;
    String temp;
    String play;

    Naivebayes(String weather, String temp, String play) {
        this.temp = temp;
        this.weather = weather;
        this.play = play;
    }

    public static void main(String[] args) {
        List<Naivebayes> data = Arrays.asList(

                new Naivebayes("Sunny", "Hot", "No"),
                new Naivebayes("Sunny", "Mild", "No"),
                new Naivebayes("Overcast", "Hot", "Yes"),
                new Naivebayes("Rainy", "Mild", "Yes"),
                new Naivebayes("Rainy", "Cool", "Yes"),
                new Naivebayes("Rainy", "Cool", "No")

        );
        Map<String, Integer> classCount = new HashMap<>();
        for (Naivebayes r : data) {
            classCount.put(r.play, classCount.getOrDefault(r.play, 0) + 1);
        }
        int total = data.size();

        Map<String, Integer> weatheryes = new HashMap<>();
        Map<String, Integer> weatherno = new HashMap<>();
        Map<String, Integer> tempyes = new HashMap<>();
        Map<String, Integer> tempno = new HashMap<>();

        for (Naivebayes r : data) {
            if (r.play.equals("Yes")) {
                weatheryes.put(r.weather, weatheryes.getOrDefault(r.weather, 0) + 1);
                tempyes.put(r.temp, tempyes.getOrDefault(r.temp, 0) + 1);

            } else {
                weatherno.put(r.weather, weatherno.getOrDefault(r.weather, 0) + 1);
                tempno.put(r.temp, tempno.getOrDefault(r.temp, 0) + 1);

            }
        }
        String testweather = "Sunny";

        String testtemp = "Cool";

        double pweatheryes = weatheryes.getOrDefault(testweather, 0) / (double) classCount.get("Yes");
        double pweatherno = weatherno.getOrDefault(testweather, 0) / (double) classCount.get("No");

        double ptempyes = tempyes.getOrDefault(testtemp, 0) / (double) classCount.get("Yes");
        double ptempno = tempno.getOrDefault(testtemp, 0) / (double) classCount.get("No");

        double pYes = classCount.get("Yes") / (double) total;
        double pNo = classCount.get("No") / (double) total;
        double posterieryes = pYes * pweatheryes * ptempyes;
        double posteriorno = pNo * pweatherno * ptempno;
        if (posterieryes > posteriorno) {
            System.out.println("play yes ");
        } else {
            System.out.println("play no");
        }
    }

}
