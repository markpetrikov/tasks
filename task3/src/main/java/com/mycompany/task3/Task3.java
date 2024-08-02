/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.task3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Objects;

public class Task3 {

    private static JSONArray values;

    private static void recursion(JSONArray testsOrValues, JSONArray arr) {
        Iterator tovItr = testsOrValues.iterator();
        while (tovItr.hasNext()) {
            JSONObject tov = (JSONObject) tovItr.next();
            
            JSONObject n = new JSONObject();
            
            Object id = tov.get("id");
            n.put("id", id);
            
            n.put("title", tov.get("title"));

            if (tov.containsKey("value")) {
                Object value = "";
                Iterator valuesItr = values.iterator();
                while (valuesItr.hasNext()) {
                    JSONObject tmp = (JSONObject) valuesItr.next();
                    if (Objects.equals(id, tmp.get("id"))) {
                        value = tmp.get("value");
                        break;
                    }
                }
                n.put("value", value);
            }

            if (tov.containsKey("values")) {
                JSONArray arr2 = new JSONArray();
                recursion((JSONArray) tov.get("values"), arr2);
                n.put("values", arr2);
            }
            arr.add(n);
        }
    }

    public static void main(String[] args) {
        try {
            Path path = Path.of(args[0]);
            String string = Files.readString(path);
            Object obj = new JSONParser().parse(string);
            JSONObject jo = (JSONObject) obj;
            values = (JSONArray) jo.get("values");

            path = Path.of(args[1]);
            string = Files.readString(path);
            obj = new JSONParser().parse(string);
            jo = (JSONObject) obj;
            JSONArray tests = (JSONArray) jo.get("tests");
            
            JSONArray arr = new JSONArray();
            recursion(tests, arr);
            jo = new JSONObject();
            jo.put("report", arr);
            
            path = Path.of(args[2]);
            Files.write(path, jo.toJSONString().getBytes(), StandardOpenOption.CREATE);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
