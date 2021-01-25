package decathlon;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeMap;

import static decathlon.DecathlonCompetition.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DecathlonTest {

    String read_test_file_name = "test_datas.csv";
    String write_test_file_name = "test_output_datas.xml";

    @Test
    public void playerTest() {
        Score score = new Score(1.1, 2.2, 3.3, 4.4, 5.5, 6.6,
                7.7, 8.8, 9.9, 10.10);
        Player player = new Player("Samat", "Zhambyl", score);
        assertFalse(Objects.isNull(player.getTotal_score()));
    }

    @Test
    public void improvisation() throws IOException, CsvException, JAXBException {
        String[] datas = {"John Smith;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5.25.72 \n",
                "Jane Doe;13.04;4.53;7.79;1.55;64.72;18.74;24.20;2.40;28.20;6.50.76 \n",
                "Jaan Lepp;13.75;4.84;10.12;1.50;68.44;19.18;30.85;2.80;33.88;6.22.75 \n",
                "Foo Bar;13.43;4.35;8.64;1.50;66.06;19.05;24.89;2.20;33.48;6.51.01\n",
                "Samat Zhambyl;13.04;4.53;7.79;1.55;64.72;18.74;24.20;2.40;28.20;6.50.76 \n"};
        FileWriter writer = new FileWriter(read_test_file_name);
        for (String s : datas) {
            writer.write(s);
        }
        writer.close();

        CSVReader csv_file = getCSVFile(read_test_file_name);
        TreeMap<Integer, ArrayList<Player>> player_orders = defineCompetitionScore(csv_file);
        csv_file.close();

        writeToXmlFile(player_orders, write_test_file_name);
        assertTrue(Files.exists(Paths.get(write_test_file_name)));
    }

}
