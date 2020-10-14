import java.io.Console;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

public class Index {

    private static int ready = 0;

    public static void main(String[] args) throws IOException{

        //Não posso instanciar diretamente, pois é privado. Logo
        //preciso pedir ao sistema para devolver um console para mim.
        Console console = System.console();

        if(console == null) {
            System.out.println("Console inacessível");
            return;
        }

        Index.println("Bem - Vindo ao chapeu seletor!");

        ArrayList<String> movies = Index.getAllMovies(console);

        Collections.shuffle(movies);

        int selectedMovie = Index.selectMovie(movies.size());

        System.out.println("Esse foi o filme escolhido: " + movies.get(selectedMovie));
    }

    private static void println(String text) {
        System.out.println(text);
    }

    private static ArrayList<String> getAllMovies(Console console) {

        ArrayList<String> arrayList = new ArrayList<String>();

        do {

            String movie = console.readLine("Digite o nome de um filme: ");

            arrayList.add(movie);

            int shouldKeep = Integer.parseInt(console.readLine("Você deseja continuar? 1/0 "));

            if(shouldKeep == 0)
                Index.ready = 1;

        } while (Index.ready == 0);

        return  arrayList;

    }

    private static int selectMovie(int arrayLength) {

        int max = arrayLength - 1;
        int min = 0;
        double result = Math.random();

        result *= (max - min + 1) + min;

        return (int) result;

    }

}
