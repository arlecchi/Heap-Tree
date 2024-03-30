import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbersInput = new ArrayList<>();
        ArrayList<Integer> numbersOutput = new ArrayList<>();
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                numbersInput.add(number);
            }
            scanner.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Integer[] numbersArray = numbersInput.toArray(new Integer[0]);
        int arrSize = numbersArray.length;

        MyMaxHeap heap = new MyMaxHeap(arrSize);
        for(int i = 0; i<arrSize; i++){
            heap.insert(numbersArray[i]);
        }
        while(heap.getSize() > 0){
            numbersOutput.add(heap.popMaxHeap());
        }
        String filePath = "output.txt";
        try{
            FileWriter outputWriter = new FileWriter(filePath);
            for(Integer number:numbersOutput){
                outputWriter.write(number.toString() + "\n");
            }
            outputWriter.close();
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}