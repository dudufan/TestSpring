package df.thrift.shared;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.*;
import org.apache.thrift.transport.TTransport;
import org.slf4j.MDC;

import java.util.UUID;

public class TBidBinaryProtocol extends TBinaryProtocol {
    private static final long NO_LENGTH_LIMIT = -1;

    public TBidBinaryProtocol(TTransport trans) {
        super(trans);
    }

    public TBidBinaryProtocol(TTransport trans, boolean strictRead, boolean strictWrite) {
        super(trans, strictRead, strictWrite);
    }

    public TBidBinaryProtocol(TTransport trans, long stringLengthLimit, long containerLengthLimit) {
        super(trans, stringLengthLimit, containerLengthLimit);
    }

    public TBidBinaryProtocol(TTransport trans, long stringLengthLimit, long containerLengthLimit, boolean strictRead, boolean strictWrite) {
        super(trans, stringLengthLimit, containerLengthLimit, strictRead, strictWrite);
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
        protected long stringLengthLimit_;
        protected long containerLengthLimit_;
        protected boolean strictRead_;
        protected boolean strictWrite_;

        public Factory() {
            this(false, true);
        }

        public Factory(boolean strictRead, boolean strictWrite) {
            this(strictRead, strictWrite, NO_LENGTH_LIMIT, NO_LENGTH_LIMIT);
        }

        public Factory(long stringLengthLimit, long containerLengthLimit) {
            this(false, true, stringLengthLimit, containerLengthLimit);
        }

        public Factory(boolean strictRead, boolean strictWrite, long stringLengthLimit, long containerLengthLimit) {
            stringLengthLimit_ = stringLengthLimit;
            containerLengthLimit_ = containerLengthLimit;
            strictRead_ = strictRead;
            strictWrite_ = strictWrite;
        }
        public TProtocol getProtocol(TTransport trans) {
            return new TBidBinaryProtocol(trans, stringLengthLimit_, containerLengthLimit_, strictRead_, strictWrite_);
        }
    }
}
