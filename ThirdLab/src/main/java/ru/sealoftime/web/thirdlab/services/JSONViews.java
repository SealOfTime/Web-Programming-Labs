package ru.sealoftime.web.thirdlab.services;

import lombok.SneakyThrows;
import ru.sealoftime.web.thirdlab.model.HistoryEntry;

import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.io.StringWriter;
import java.util.Map;

@Stateless
public class JSONViews {

    @SneakyThrows
    public String generatePointResponse(HistoryEntry entry){
        JsonObjectBuilder pointResponse = Json.createObjectBuilder();
        pointResponse.add("x", entry.getX());
        pointResponse.add("y", entry.getY());
        pointResponse.add("r", entry.getR());
        pointResponse.add("isIn", entry.isInside());

        try(var sw = new StringWriter()){
            Json.createWriter(sw).writeObject(pointResponse.build());
            return sw.toString();
        }
    }

    @SneakyThrows
    public String generateErrorMessages(Map<String, String> errors){
        var array = Json.createArrayBuilder();

        errors.forEach((origin, err)->
            array.add(generateErrorMessage(origin, err)));

        try(var sw = new StringWriter()) {
            Json.createWriter(sw).writeArray(array.build());
            return sw.toString();
        }
    }

    @SneakyThrows
    public String generateErrorMessageForNullErrors(){
        var array = Json.createArrayBuilder();
        array.add(generateErrorMessage("global", "No filters were called"));

        try(var sw = new StringWriter()) {
            Json.createWriter(sw).writeArray(array.build());
            return sw.toString();
        }

    }
    private JsonObject generateErrorMessage(String origin, String error){
        var json = Json.createObjectBuilder();
        json.add("for", origin);
        json.add("errorMessage", error);
        return json.build();
//        return String.format(
//                "{" +
//                "\"for\": \"%s\"" +
//                "\"errorMessage\": \"%s\"" +
//                "}", origin, error);
    }
}
