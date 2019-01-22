package pl.spiascik.ug.clothesapp.util;

import pl.spiascik.ug.clothesapp.domain.Type;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class TypesResponse {

    private List<Type> type = new ArrayList<Type>();

    public List<Type> getType() {
        return type;
    }

    public void setType(List<Type> type) {
        this.type = type;
    }
}
