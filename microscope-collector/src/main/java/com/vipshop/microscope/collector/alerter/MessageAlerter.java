package com.vipshop.microscope.collector.alerter;

import com.vipshop.microscope.thrift.Span;
import com.vipshop.microscope.client.exception.ExceptionData;
import com.vipshop.microscope.client.metric.MetricData;
import com.vipshop.microscope.client.system.SystemData;

/**
 * Message Alert API.
 *
 * @author Xu Fei
 * @version 1.0
 */
public class MessageAlerter {

    private MessageAlerter() {

    }

    private static final class MessageAlerterHolder {
        private static final MessageAlerter MESSAGE_ALERTER = new MessageAlerter();
    }

    public static MessageAlerter getMessageAlerter() {
        return MessageAlerterHolder.MESSAGE_ALERTER;
    }

    public void alert(Span span) {
    }

    public void alert(ExceptionData exception) {
    }

    public void alert(MetricData metrics) {

    }

    public void alert(SystemData system) {}

    public void alertAppLog(String logs){}

    public void alertGCLog(String logs){}

}
