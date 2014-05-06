package com.vipshop.microscope.collector.disruptor;

import com.lmax.disruptor.EventHandler;
import com.vipshop.microscope.collector.storager.MessageStorager;
import com.vipshop.microscope.common.util.ThreadPoolUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;

/**
 * Metric store handler.
 *
 * @author Xu Fei
 * @version 1.0
 */
public class MetricStorageHandler implements EventHandler<MetricEvent> {

    public static final Logger logger = LoggerFactory.getLogger(MetricStorageHandler.class);

    private final MessageStorager messageStorager = MessageStorager.getMessageStorager();

    private final int size = Runtime.getRuntime().availableProcessors() * 1;
    private final ExecutorService metricsStorageWorkerExecutor = ThreadPoolUtil.newFixedThreadPool(size, "metrics-saveLog-worker-pool");

    @Override
    public void onEvent(final MetricEvent event, long sequence, boolean endOfBatch) throws Exception {
        metricsStorageWorkerExecutor.execute(new Runnable() {
            @Override
            public void run() {
                messageStorager.save(event.getResult());
            }
        });
    }


}