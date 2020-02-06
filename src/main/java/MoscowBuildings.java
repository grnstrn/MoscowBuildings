import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MoscowBuildings {



        public static void main(String[] args) throws IOException, FileNotFoundException {
            FileInputStream inputStream = new FileInputStream("c:/java/DataForTesting/moscow-buildings.csv");
            int length = inputStream.available();
            byte [] data = new byte[length];

            inputStream.read(data);
            String text = new String(data);

            ArrayList<String[]> lineWords = new ArrayList<>();

            String [] lines = text.split("\n");
            for(String line : lines) {
                String[] words = line.split(",");
                lineWords.add(words);
            }

            HashMap<String,Integer> map = new HashMap<String, Integer>();
            for(String[] words : lineWords){
                if(map.containsKey(words[9])){
                    Integer k = map.get(words[9]);
                    k = k + 1;
                    map.put(words[9],k);
                }else{


                    map.put(words[9], 1);
                }
            }

            for(String key : map.keySet()){
                System.out.println("Год: " + key + " Количество: " + map.get(key));
            }

        }
    }


