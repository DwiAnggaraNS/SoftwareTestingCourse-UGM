public class Largest {

    public static int largestNumberInArray(int[] numbers) {
        // Inisiasi nilai max dengan nilai terbesar
        int largest = Integer.MAX_VALUE;

        // Looping untuk mencari nilai max
        for (int i = 0; i < numbers.length-1; i++) {
            if (numbers[i] > largest) {
                largest = numbers[i];
            }
        }

        // Mengembalikan nilai max
        return largest;
    }
}
