package trees;

import lombok.Data;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@Data
public class N_aryNode {

    private List<N_aryNode> node;
    private String value;

    public N_aryNode(String value) {
        this.value = value;
        this.node = new LinkedList<>();
    }

    @Override
    public String toString() {
        return value + " : ";
    }

}
