package flappybird;

import java.io.*;

public class LeaderBoard {
    private String filePath = new File(".").getAbsolutePath() + "/leaderboard.txt";
    private BufferedReader br = null;
    private BufferedWriter bw = null;

    public LeaderBoard() {
        File f = new File(filePath);
        if (!f.exists()) {
            try {
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath));
                osw.write("0");
                osw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int load() {
        int vaule = 0;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            vaule = Integer.parseInt(br.readLine());
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vaule;
    }

    public void save(int v) {
        int vaule = load();
        if (v > vaule) {
            try {
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
                bw.write(String.valueOf(v));
                bw.flush();
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
