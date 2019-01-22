package pl.spiascik.ug.clothesapp.util;

import pl.spiascik.ug.clothesapp.domain.Wearer;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class WearersResponse {

    private List<Wearer> wearer = new ArrayList<Wearer>();

    public List<Wearer> getWearer() {
        return wearer;
    }

    public void setWearer(List<Wearer> wearer) {
        this.wearer = wearer;
    }
}
