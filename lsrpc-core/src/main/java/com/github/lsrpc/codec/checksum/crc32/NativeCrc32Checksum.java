package com.github.lsrpc.codec.checksum.crc32;


import com.github.lsrpc.codec.checksum.Checksum;

import java.nio.ByteBuffer;
import java.util.zip.CRC32;


/**
 * 本地的CRC32实现
 */
public class NativeCrc32Checksum implements Checksum {

    @Override
    public byte getTypeId() {
        return CRC32;
    }

    @Override
    public long compute(byte[] data, int offset, int length) {
        CRC32 crc32 = new CRC32();
        crc32.update(data, offset, length);
        return (int) crc32.getValue();
    }

    @Override
    public long compute(final ByteBuffer buffer) {
        CRC32 crc32 = new CRC32();
        crc32.update(buffer);
        return crc32.getValue();
    }
}
