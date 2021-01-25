package decathlon;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.*;

public class DecathlonCompetition {
    public static void main(String[] args) throws IOException, CsvException, JAXBException {
        String file_name = getFileName();
        CSVReader csv_file = getCSVFile(file_name);
        TreeMap<Integer, ArrayList<Player>> player_orders = defineCompetitionScore(csv_file);

        writeToXmlFile(player_orders, "total_result.xml");
    }

    public static CSVReader getCSVFile(String file_name) throws FileNotFoundException {
        return new CSVReader(new FileReader(file_name));
    }

    public static String getFileName() throws IOException {
        System.out.print("Enter file name: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public static TreeMap<Integer, ArrayList<Player>> defineCompetitionScore(CSVReader file) throws IOException, CsvException {
        TreeMap<Integer, ArrayList<Player>> players = new TreeMap<>();
        List<String[]> rows = file.readAll();
        Player player;
        ArrayList<Player> tmpPlayer;
        for (String[] s : rows) {
            if (!s[0].isEmpty()) {
                player = deSerializePlayerObj(s[0]);
                if (players.containsKey(player.getTotal_score())) {
                    tmpPlayer = players.get(player.getTotal_score());
                    tmpPlayer.add(player);
                    players.replace(player.getTotal_score(), tmpPlayer);
                } else {
                    players.put(player.getTotal_score(), new ArrayList<>(Collections.singletonList(player)));
                }
            }
        }

        return players;
    }

    public static Player deSerializePlayerObj(String row) {
        String[] datas = row.split(";");
        String[] fio = datas[0].split(" ");

        double m_100 = Double.parseDouble(datas[1]);
        double long_jump = Double.parseDouble(datas[2]);
        double shut_put = Double.parseDouble(datas[3]);
        double high_jump = Double.parseDouble(datas[4]);
        double m_400 = Double.parseDouble(datas[5]);
        double hurdles_110m = Double.parseDouble(datas[6]);
        double discus_throw = Double.parseDouble(datas[7]);
        double pole_vault = Double.parseDouble(datas[8]);
        double javelin_throw = Double.parseDouble(datas[9]);
        String[] m_1500_split = datas[10].split("\\.", 2);
        double m_1500 = Double.parseDouble(m_1500_split[0]) * 60.0 + Double.parseDouble(m_1500_split[1]);

        Score s = new Score(m_100, long_jump, shut_put, high_jump, m_400, hurdles_110m, discus_throw, pole_vault,
                javelin_throw, m_1500);

        return new Player(fio[0], fio[1], s);
    }

    public static void writeToXmlFile(TreeMap<Integer, ArrayList<Player>> result, String write_file_name) throws JAXBException, FileNotFoundException {

        JAXBContext contextOjb = JAXBContext.newInstance(ScoresXML.class);
        Marshaller marshaller = contextOjb.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        ArrayList<Player> list = new ArrayList<>();

        int position = 1;
        String position_str = "";
        for (Map.Entry<Integer, ArrayList<Player>> score : result.entrySet()) {
            for (Player player : score.getValue()) {
                if (score.getValue().size() == 1) {
                    position_str = String.format("%d", position);
                } else {
                    position_str = String.format("%d-%d", position, position + (score.getValue().size()) - 1);
                }
                player.setPosition(position_str);
                list.add(player);
            }
            position += score.getValue().size();
        }

        ScoresXML scoresXML = new ScoresXML(list);
        marshaller.marshal(scoresXML, new FileOutputStream(write_file_name));

        System.out.println("Success!!!");

    }
}
