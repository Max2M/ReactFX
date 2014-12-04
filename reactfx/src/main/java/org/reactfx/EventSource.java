package org.reactfx;


/**
 * EventSource is an EventSink that serves also as an EventStream - every value
 * pushed to EventSource is immediately emitted by it.
 * @param <T> type of values this EventSource accepts and emits.
 */
public class EventSource<T>
extends EventStreamBase<Subscriber<? super T>>
implements EventStream<T>, EventSink<T> {

    /**
     * Make this event stream immediately emit the given value.
     */
    @Override
    public final void push(T value) {
        notifyObservers(s -> s.onEvent(value));
    }
}
