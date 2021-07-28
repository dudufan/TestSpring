package df.thrift.shared;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.*;
import org.apache.thrift.transport.TTransport;
import org.slf4j.MDC;

import java.util.UUID;

public class TBidCompactProtocol extends TCompactProtocol {
    private final static long NO_LENGTH_LIMIT = -1;

    public TBidCompactProtocol(TTransport transport, long stringLengthLimit, long containerLengthLimit) {
        super(transport, stringLengthLimit, containerLengthLimit);
    }

    public TBidCompactProtocol(TTransport transport) {
        super(transport);
    }

    public void writeMessageBegin(TMessage message) throws TException {
        super.writeMessageBegin(message);
        String bid = MDC.get("bid");
        if (bid == null) {
            bid = UUID.randomUUID().toString();
        }
//        writeString(bid);
        Attach attach = new Attach();
        attach.putToHeaders("bid", bid);
        attach.write(this);
    }
    public TMessage readMessageBegin() throws TException {
        TMessage message = super.readMessageBegin();
//        String bid = readString();
        Attach attach = new Attach();
        attach.read(this);
        MDC.put("bid", attach.getHeaders().get("bid"));
        return message;
    }

    /**
     * Factory
     */
    public static class Factory implements TProtocolFactory{
        private final long stringLengthLimit_;
        private final long containerLengthLimit_;

        public Factory() {
            this(NO_LENGTH_LIMIT, NO_LENGTH_LIMIT);
        }

        public Factory(long stringLengthLimit) {
            this(stringLengthLimit, NO_LENGTH_LIMIT);
        }

        public Factory(long stringLengthLimit, long containerLengthLimit) {
            this.containerLengthLimit_ = containerLengthLimit;
            this.stringLengthLimit_ = stringLengthLimit;
        }

        public TProtocol getProtocol(TTransport trans) {
            return new TBidCompactProtocol(trans, stringLengthLimit_, containerLengthLimit_);
        }
    }
}
