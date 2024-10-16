package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static util.MyLogger.log;

public class BoundedQueueV1 implements BoundedQueue {

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV1(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        if (queue.size() == max) {
            log("[put] 큐가 가득 참, 버림: " + data);
            return;
        }
        queue.offer(data);
    }

    @Override
    public synchronized String take() {
        if (queue.isEmpty()) {
            log("[take] 큐가 비어있음");
            return null;
        }

        return queue.poll();
    }

    @Override
    public String toString() {
        // 원칙적으로 synchronized를 추가해야하지만, 간단한 예제를 위해서 생략한다
        return queue.toString();
    }
}
