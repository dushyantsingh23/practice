package trees;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import util.InputUtil;

//serialize an N-ary tree
public class SerializeN_aryTree {

    public static void main(String[] args) {

        N_aryNode nNode = createTree();

        //jsonSerialize(nNode);
    }

    private static N_aryNode createTree() {
        Integer totalNodes = InputUtil.getInteger();
        Integer size = InputUtil.getInteger();

        Integer string_length = 5;

        N_aryNode root = new N_aryNode(InputUtil.getRandomString(string_length));
        N_aryNode node = root;
        for (int i = 1; i < totalNodes; i++) {
            Integer subNodes = 1 + InputUtil.getRandomInteger(size);
            for (int j = 0; j < subNodes; j++) {
                root.getNode().add(new N_aryNode(InputUtil.getRandomString(string_length)));
            }
            root = root.getNode().get(InputUtil.getRandomInteger(subNodes == 0 ? 1 : subNodes));

        }
        printTree(node);
        return node;
    }

    private static void printTree(N_aryNode node) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println(objectMapper.writeValueAsString(node));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
