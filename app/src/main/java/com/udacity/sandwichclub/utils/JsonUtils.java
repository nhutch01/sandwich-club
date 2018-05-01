package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try{
            JSONObject jsonObject = new JSONObject(json);
            JSONObject name = jsonObject.optJSONObject("name");
            String mainName = name.optString("mainName");
            JSONArray alsoKnownAsJSONAry = name.optJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAsStringAry = new ArrayList<>();

            for(int i=0; i<alsoKnownAsJSONAry.length();i++){
                alsoKnownAsStringAry.add(alsoKnownAsJSONAry.getString(i));
            }

            String placeOfOrigin = jsonObject.optString("placeOfOrigin");
            String description = jsonObject.optString("description");
            String image = jsonObject.optString("image");

            JSONArray ingredientsJSONAry = jsonObject.optJSONArray("ingredients");
            ArrayList<String> ingredientsStringAry = new ArrayList<>();

            for(int i=0; i<ingredientsJSONAry.length();i++){
                ingredientsStringAry.add(ingredientsJSONAry.getString(i));
            }

            return new Sandwich(mainName,alsoKnownAsStringAry,placeOfOrigin,description,image,ingredientsStringAry);
        }catch(JSONException e){
            e.printStackTrace();
            return null;
        }

    }
}
