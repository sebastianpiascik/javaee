package pl.spiascik.ug.clothesapp.util;

import pl.spiascik.ug.clothesapp.domain.Manufacturer;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class ManufacturersResponse {

    private List<Manufacturer> manufacturer = new ArrayList<Manufacturer>();

    public List<Manufacturer> getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(List<Manufacturer> manufacturer) {
        this.manufacturer = manufacturer;
    }
}
