package decathlon;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class ScoresXML {
    private List<Player> players;

    public ScoresXML() {}

    public ScoresXML(List<Player> players) {
        this.players = players;
    }

    @XmlElement
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
