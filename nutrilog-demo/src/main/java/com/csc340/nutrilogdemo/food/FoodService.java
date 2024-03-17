package com.csc340.nutrilogdemo.food;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class FoodService {
    private static final String apiKey = "ndFnGHpfbnvo2eG1BhcUKEJOoqWu7yWe2PVJzTvW";
    private static final String secondAPIKey = "yCTWYwVF2hHfhgkItFebnhOYILMQg5MI3KBlss6p";
    public void updateFood(Food food) {
        JsonNode foodDetails = search();
        JsonNode ingredients = foodDetails.get("ingredients");
        food.setIngredients(ingredients.toString());
        JsonNode nutrients = foodDetails.get("foodNutrients");
        JsonNode proteinContent = null;
        JsonNode fatContent = null;
        JsonNode carbContent = null;
        for (JsonNode nutrient : nutrients){
            String nutrientName = nutrient.get("nutrientName").asText();
            if (nutrientName.equals("Protein")){
                proteinContent = nutrient.get("value");
            }
            if (nutrientName.equals("Total lipid (fat)")){
                fatContent = nutrient.get("value");
            }
            if (nutrientName.equals("Carbohydrate, by difference")){
                carbContent = nutrient.get("value");
            }
        }
        if (proteinContent != null) {
            food.setProteinContent(proteinContent.asText());
        }
        if (fatContent != null) {
            food.setFatContent(fatContent.asText());
        }
        if (carbContent != null) {
            food.setCarbContent(carbContent.asText());
        }
    }

    private String getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("*********Input*********");
        System.out.print("Enter a food item: ");
        String input = sc.nextLine();
        return input;
    }

    /**
     * Returns the first occurance of a food Item
     *
     * @return The first food object as a JsonNode
     */
    private JsonNode search() {
        String input = getInput();
        JsonNode returnNode;
        try {
            String url = "https://api.nal.usda.gov/fdc/v1/foods/search?api_key=" + secondAPIKey + "&query=" + input;
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jsonInfo = restTemplate.getForObject(url, String.class);
            JsonNode array = mapper.readTree(jsonInfo);

            //TODO: Error checking
            JsonNode foods = array.get("foods");
            returnNode = foods.get(0);
            return returnNode;

        } catch (JsonProcessingException ex) {
            Logger.getLogger(FoodController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error in getFoodInfo");
            return null;
        }
    }
}
