package com.java;


import java.util.HashMap;
import java.util.Map;

public class JsonModify {

    public static void main (String args[])
    {
        String jsonFile = "{\"serviceId\":\"selected-payment-approveVerify\",\"selectedRecords\":{\"{{headerId}}\":{\"queue\":\"pendingAuth\",\"headerRef\":\"{{headerRef}}\",\"headerVersion\":\"4\"}}}";
        Map<String, String> responseMetaData = new HashMap<String, String>();

        responseMetaData.put("headerId", "12345");
        responseMetaData.put("headerRef", "0101010");
//        responseMetaData.put("selectedRecords/{{headerId}}", "12345");
//        responseMetaData.put("selectedRecords/{{headerId}}/headerRef", "98765");

        String finalJson = editJson(jsonFile, responseMetaData);

        System.out.println(finalJson);

    }

    public static String editJson(String requestBody, Map<String, String> paymentElements) {
        requestBody = updateKey(requestBody, paymentElements);

//        if (paymentElements != null) {
//
//
//            for (Map.Entry<String, String> entry : paymentElements.entrySet())
//
//                if (requestBody.contains(entry.getKey()) || (requestBody.contains(StringUtils.substringBefore(entry.getKey(), "/")) && requestBody.contains(StringUtils.substringAfter(entry.getKey(), "/")))) {
//                    requestBody = updateValue(entry.getKey(), entry.getValue(), requestBody);
//                }
//
//
//        }
        return requestBody;
    }

    public static String updateKey(String requestBody, Map<String, String> paymentElements)
    {
        String[] val;
        if (paymentElements != null) {
            for (Map.Entry<String, String> entry : paymentElements.entrySet()) {
                val = entry.getKey().split("/");

                requestBody = (requestBody.contains("{{" + entry.getKey() + "}}") ? requestBody.replace("{{" + entry.getKey() + "}}", entry.getValue()) : requestBody);
            }
            return requestBody;
        }
        return requestBody;
    }

//    public String updateValue(String keyPath, String updateText, String jsonText) {
//        String[] keys = keyPath.split("/");
//        JsonParser jsonParser = new JsonParser();
//        JsonObject jsonObject = (JsonObject) jsonParser.parse(jsonText);
//        JsonObject returnVal = jsonObject; // This holds the ref to target json object
//        JsonPrimitive jp = new JsonPrimitive(updateText);
//        String finalKey = keys[keys.length - 1];
//        for (String key : keys) {
//
//            if (jsonObject.get(key) != null && jsonObject.get(key).isJsonObject()) {
//                jsonObject = (JsonObject) jsonObject.get(key);
//                jsonObject.remove(finalKey);
//                jsonObject.add(finalKey, jp);
//                return returnVal.toString();
//            } else if (jsonObject.get(finalKey) == null) {
//                return returnVal.toString();
//            }
//        }
//
//        jsonObject.remove(finalKey);
//        jsonObject.add(finalKey, jp);
//        return returnVal.toString();
//    }


}
