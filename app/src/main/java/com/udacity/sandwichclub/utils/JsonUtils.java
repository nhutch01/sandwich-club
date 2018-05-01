package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {
    public static final String KEY_NAME = "name";
    public static final String KEY_MAIN_NAME = "mainName";
    public static final String KEY_ALSO_KNOW_AS = "alsoKnownAs";
    public static final String KEY_PLACE_OF_ORIGIN = "placeOfOrigin";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_INGREDIENTS = "ingredients";

    public static Sandwich parseSandwichJson(String json) {
        try{
            JSONObject jsonObject = new JSONObject(json);
            JSONObject name = jsonObject.optJSONObject(KEY_NAME);
            String mainName = name.optString(KEY_MAIN_NAME);
            JSONArray alsoKnownAsJSONAry = name.optJSONArray(KEY_ALSO_KNOW_AS);
            ArrayList<String> alsoKnownAsStringAry = new ArrayList<>();

            for(int i=0; i<alsoKnownAsJSONAry.length();i++){
                alsoKnownAsStringAry.add(alsoKnownAsJSONAry.getString(i));
            }

            String placeOfOrigin = jsonObject.optString(KEY_PLACE_OF_ORIGIN);
            String description = jsonObject.optString(KEY_DESCRIPTION);
            String image = jsonObject.optString(KEY_IMAGE);

            JSONArray ingredientsJSONAry = jsonObject.optJSONArray(KEY_INGREDIENTS);
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
