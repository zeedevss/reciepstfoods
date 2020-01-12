package com.example.foodmeal.data;

import com.example.foodmeal.Author;
//import com.example.foodmeal.R;

import java.util.ArrayList;

public class AuthorData {

    private static String[] nameAuthor = {
            "Muhamad Husein Assidiq",
            "Tabah Noviawan",
            "Zara Chandra Pradevi",
            "Silvia Atika Sari"
    };

    private static String[] emailAuthor = {
            "huseinazidix12@gmail.com",
            "tabahnoviawan@gmail.com",
            "zarachandra@gmail.com",
            "silviaatika@gmail.com"
    };

    private static String[] igAuthor = {
            "husein_adx",
            "tabahnoviawan",
            "zarachandra",
            "silviaatika"
    };

//    private static int[] imageAuthor = {
//            R.drawable.avatar,
//            R.drawable.avatar,
//            R.drawable.avatar,
//            R.drawable.avatar
//    };

    public static ArrayList<Author> getListAuthor() {
        ArrayList<Author> list = new ArrayList<>();
        for(int position = 0; position < nameAuthor.length; position++) {
            Author author = new Author();
            author.setNameAuthor(nameAuthor[position]);
            author.setEmailAuthor(emailAuthor[position]);
            author.setIgAuthor(igAuthor[position]);
            //author.setImageAuthor(imageAuthor[position]);
            list.add(author);
        }
        return list;
    }
}
