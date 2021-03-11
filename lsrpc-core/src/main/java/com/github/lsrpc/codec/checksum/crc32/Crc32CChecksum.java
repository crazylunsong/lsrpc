package com.github.lsrpc.codec.checksum.crc32;


import com.github.lsrpc.codec.checksum.Checksum;

/**
 * 纯净的CRC32-C的Java实现，100以下的小字节数组性能比crc32快
 */
public class Crc32CChecksum implements Checksum {

    @Override
    public byte getTypeId() {
        return CRC32C;
    }

    @Override
    public long compute(final byte[] data, final int offset, final int length) {
        Crc32C crc32c = new Crc32C();
        crc32c.update(data, 0, data.length);
        return crc32c.getValue();
    }

}
