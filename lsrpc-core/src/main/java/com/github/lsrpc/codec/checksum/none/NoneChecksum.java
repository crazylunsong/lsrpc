package com.github.lsrpc.codec.checksum.none;


import com.github.lsrpc.codec.checksum.Checksum;

/**
 * 不做校验和
 */
public class NoneChecksum implements Checksum {
    @Override
    public long compute(final byte[] data, final int offset, final int length) {
        return 0;
    }

    @Override
    public byte getTypeId() {
        return NONE;
    }
}
