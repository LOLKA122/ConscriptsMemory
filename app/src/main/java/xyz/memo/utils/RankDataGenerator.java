package xyz.memo.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Random;

import xyz.memo.R;

public class RankDataGenerator {
    public JSONObject generate() throws JSONException {
        JSONObject jsonObject = new JSONObject();

        int correctAnswerBtn = new Random().nextInt(3)+1;
        int correctAnswer = new Random().nextInt(20)+1;
        int correctRes = getResourceById(correctAnswer);
        String correctRank = getRankById(correctAnswer);

        jsonObject.put("correct", correctAnswerBtn);
        jsonObject.put("res", correctRes);

        for (int i = 1; i<=4; i++){
            if(correctAnswerBtn == i){
                jsonObject.put(String.valueOf(i), correctRank);
            }else{
                while(true){
                    String rank = getRankById(new Random().nextInt(20)+1);
                    boolean valueExists = false;
                    for (Iterator<String> it = jsonObject.keys(); it.hasNext(); ) {
                        String key = it.next();
                        if (jsonObject.getString(key).equals(rank)) {
                            valueExists = true;
                            break;
                        }
                    }

                    if (!valueExists && !correctRank.equals(rank)) {
                        jsonObject.put(String.valueOf(i), rank);
                        break;
                    }
                }

            }
        }

        return jsonObject;
    }


    private String getRankById(int index){
        String string = "Рядовой";
        switch(index){
            case 2:
                string = "Ефрейтор";
                break;
            case 3:
                string = "Мл. Сержант";
                break;
            case 4:
                string = "Сержант";
                break;
            case 5:
                string = "Ст. Сержант";
                break;
            case 6:
                string = "Старшина";
                break;
            case 7:
                string = "Прапорщик";
                break;
            case 8:
                string = "Ст. Прапорщик";
                break;
            case 9:
                string = "Мл. Лейтенант";
                break;
            case 10:
                string = "Лейтенант";
                break;
            case 11:
                string = "Ст. Лейтенант";
                break;
            case 12:
                string = "Капитан";
                break;
            case 13:
                string = "Майор";
                break;
            case 14:
                string = "Подполковник";
                break;
            case 15:
                string = "Полковник";
                break;
            case 16:
                string = "Генерал майор";
                break;
            case 17:
                string = "Генерал лейтенант";
                break;
            case 18:
                string = "Генерал полковник";
                break;
            case 19:
                string = "Генерал армии";
                break;
            case 20:
                string = "Маршал армии";
                break;
        }
        return string;
    }

    private Integer getResourceById(int index){
        int id = R.drawable.ryadovoj_1;
        switch(index){
            case 2:
                id = R.drawable.efrejtor_2;
                break;
            case 3:
                id = R.drawable.sershant_jr_3;
                break;
            case 4:
                id = R.drawable.sershant_4;
                break;
            case 5:
                id = R.drawable.sershant_sr_5;
                break;
            case 6:
                id = R.drawable.starshina_6;
                break;
            case 7:
                id = R.drawable.praporshik_7;
                break;
            case 8:
                id = R.drawable.praporshik_sr_8;
                break;
            case 9:
                id = R.drawable.lejtenant_jr_9;
                break;
            case 10:
                id = R.drawable.lejtenant_10;
                break;
            case 11:
                id = R.drawable.lejtenant_sr_11;
                break;
            case 12:
                id = R.drawable.captain_12;
                break;
            case 13:
                id = R.drawable.major_13;
                break;
            case 14:
                id = R.drawable.podpolkovnik_14;
                break;
            case 15:
                id = R.drawable.polkovnik_15;
                break;
            case 16:
                id = R.drawable.general_major_16;
                break;
            case 17:
                id = R.drawable.general_lejtenant_17;
                break;
            case 18:
                id = R.drawable.general_polkovnik_18;
                break;
            case 19:
                id = R.drawable.army_general_19;
                break;
            case 20:
                id = R.drawable.army_marshal_20;
                break;
        }
        return id;
    }

}
