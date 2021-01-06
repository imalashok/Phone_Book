import java.util.List;
import java.util.concurrent.*;


class FutureUtils {

    public static int executeCallableObjects(List<Future<Callable<Integer>>> items) {
        int result = 0;

        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            for (int i = items.size() - 1; i >= 0; i--) {
                result += executor.submit(items.get(i).get()).get();
            }
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("Exception");
        }

        executor.shutdown();

        return result;
    }

}