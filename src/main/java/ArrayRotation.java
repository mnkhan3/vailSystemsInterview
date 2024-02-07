import static java.util.Arrays.stream;
import static java.util.stream.IntStream.concat;
import static java.util.stream.IntStream.range;

public class ArrayRotation {

    public int[] rotateArray(int [] array, int position){
        if(position < 0){
            String errorMessage = "Rotating array by negative number is not allowed, please provide a positive number.";
            throw new IllegalArgumentException(errorMessage);
        }

        int length = array.length;
        position = position %  length;

        int[] numbersToRotateLeft = stream(array).limit(position).toArray();
        int[] restOfTheNumbers = range(position + 1, length + 1).toArray();

       return concat(stream(restOfTheNumbers), stream(numbersToRotateLeft)).toArray();
    }
}
