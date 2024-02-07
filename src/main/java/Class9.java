import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Class9 {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(
                        URI.create("https://v2.jokeapi.dev/joke/Any?safe-mode"))
                .build();


        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Joke joke = new Gson().fromJson(response.body(), Joke.class);

        if(joke.getType().equals("single")){
            System.out.println("ONLINER INCOMMING");
            System.out.println(joke.getJoke());
        } else{
            System.out.println(joke.getSetup());
            System.out.println(joke.getDelivery());
        }

        while(true){
            System.out.println("Hi");
        }

    }

}
