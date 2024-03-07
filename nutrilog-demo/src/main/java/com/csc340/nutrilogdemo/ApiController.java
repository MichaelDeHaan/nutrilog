package com.csc340.nutrilogdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ApiController {
    public static void getFoodInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("*********Input*********");
        System.out.print("Enter a food item: ");
        String input = sc.nextLine();

        String apiKey = "ndFnGHpfbnvo2eG1BhcUKEJOoqWu7yWe2PVJzTvW";

        try {
            String url = "https://api.nal.usda.gov/fdc/v1/foods/search?api_key=" + apiKey + "&query=" + input;
            // Used to consume the API
            RestTemplate restTemplate = new RestTemplate();
            // Used to parse the JSON to/from Java objects
            // First step to use JsonNode
            ObjectMapper mapper = new ObjectMapper();

            // Sends the request and gets the result as a string
            String jsonInfo = restTemplate.getForObject(url, String.class);
            // Turns the json into a tree for some reason
            JsonNode array = mapper.readTree(jsonInfo);

            //TODO: Error checking
            JsonNode foods = array.get("foods");
            JsonNode firstFoodItem = foods.get(0);
            JsonNode ingredients = firstFoodItem.get("ingredients");
            System.out.println(ingredients);

        } catch (JsonProcessingException ex) {
            Logger.getLogger(NutrilogDemoApplication.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error in getFoodInfo");
        }
    }
}
