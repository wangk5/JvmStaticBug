// [PASSES] Test JvmStatic when called from Java

public class Main {
    public static void main(String[] args) {
        int index = SingletonClassExample.getCount();
        System.out.printf("The index starts at: %d", index);
    }
}