import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class TSK_2
{
    static int CheckNumbers(String param)
    {
        Scanner iScanner = new Scanner(System.in);
        while (true)
        {
            System.out.printf(param + ": ");
            if (iScanner.hasNextInt() == true)
            {
                int number = iScanner.nextInt();
                if (number > 0)
                {
                    iScanner.close();
                    return number;
                }
                else System.out.println("Число введено неправильно.");
            }
            else System.out.println("Число введено неправильно.");
            iScanner.next();
        }
    }
    static void BubbleSorting(int[] array)
    {
        boolean check = false;
        int temp;
        while(!check)
        {
            check = true;
            for (int i = 0; i < array.length-1; i++)
            {
                if(array[i] > array[i+1])
                {
                    check = false;
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    try (FileWriter log = new FileWriter("log.txt", true))
                    {
                        log.write(Arrays.toString(array));
                        log.append('\n');
                    }
                    catch(IOException ex)
                    {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
    static int[] ArrayGen(int number)
    {
        int [] array = new int [number];
        for (int i = 0; i < number; i++)
        {
            array[i] = (int)Math.floor(Math.random() * 100);
        }
        return array;
    }
    
    public static void main(String[] args)
    {
        int [] array = ArrayGen(CheckNumbers("Введите число элементов в массиве"));
        System.out.println("Сгенерирован массив:");
        System.out.println(Arrays.toString(array));
        System.out.println("Отсортированный массив:");
        BubbleSorting(array);
    }
}