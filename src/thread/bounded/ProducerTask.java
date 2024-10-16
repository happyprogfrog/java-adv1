package thread.bounded;

import static util.MyLogger.log;

public class ProducerTask implements Runnable {

    private BoundedQueue queue;
    private String request; // 큐에 담을 작업

    public ProducerTask(BoundedQueue queue, String request) {
        this.queue = queue;
        this.request = request;
    }

    @Override
    public void run() {
        log("[생산 시도] " + request + " -> " + queue);
        queue.put(request);
        log("[생산 완료] " + request + " -> " + queue);
    }
}
