package action;

import org.json.simple.ItemList;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TestJson {

    public static void main(String[] args) throws ParseException {

        //����
        JSONObject obj = new JSONObject();
       /* obj.put(1, 26);
        obj.put("name", "nanmeiying");
        System.out.println(obj.toJSONString());*/
        //���� 1
       /* JSONParser jsonParser = new JSONParser();
        obj = (JSONObject) jsonParser.parse("{\"1\":26,\"name\":\"nanmeiying\"}");
        System.out.println(obj.get("1"));*/
        //���� 2
        obj = (JSONObject) JSONValue.parse("{\"1\":26,\"name\":\"nanmeiying\"}");
        System.out.println(obj.toJSONString());


    }
}
