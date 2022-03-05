package com.project.moviedateServer.services;

import com.gargoylesoftware.htmlunit.WebClient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class WebScrapper {

    public void rottenTomatoScrapper(){
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        try{
            String searchUrl = "https://www.rottentomatoes.com/top/bestofrt/top_100_";

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedate?useSSL=false","root","Pass123word$");

            PreparedStatement query = con.prepareStatement("SELECT genre FROM moviedate.genre_list");
            ResultSet resultSet = query.executeQuery();

            ArrayList<String> genres = new ArrayList<>();

            while (resultSet.next()){
                genres.add(resultSet.getString("genre"));
                String genre = resultSet.getString("genre");
                genre = genre.toLowerCase().replaceAll(" ","_").replaceAll("&","");
                genre = searchUrl+genre+"_movies/";
                System.out.println(genre);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
