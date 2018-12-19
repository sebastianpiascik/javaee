package pl.spiascik.ug.clothesapp.util;

import pl.spiascik.ug.clothesapp.domain.Cloth;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class ClothesResponse {

    private List<Cloth> cloth = new ArrayList<Cloth>();

    public List<Cloth> getCloth() {
        return cloth;
    }

    public void setCloth(List<Cloth> cloth) {
        this.cloth = cloth;
    }
}
