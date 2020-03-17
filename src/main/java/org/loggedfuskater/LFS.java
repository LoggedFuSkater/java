package org.loggedfuskater;

import org.apache.commons.codec.binary.Hex;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class LFS {

    /**
     * Obfuscates the input string into a human readable hash.
     * @param input the input to obfuscate
     * @return the obfuscated string
     */
    public static String obf(String input) {
        return obf(input, 0);
    }

    /**
     * Obfuscates the input string into a human readable hash with 0-8 padding_bytes at the end.
     * @param input the input to obfuscate
     * @param paddingBytes number of bytes padded on the end 0-8
     * @return the obfuscated string
     */
    public static String obf(String input, int paddingBytes) {
        if (paddingBytes < 0) {
            paddingBytes = 0;
        } else if (paddingBytes > 8) {
            paddingBytes = 8;
        }
        MessageDigest sha1;
        try {
            sha1 = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
        byte[] hashBytes = sha1.digest(input.getBytes());

        int adverbsIndex = ByteBuffer.wrap(Arrays.copyOfRange(hashBytes, 0, 4)).order(ByteOrder.LITTLE_ENDIAN).getInt();
        int adjectivesIndex = ByteBuffer.wrap(Arrays.copyOfRange(hashBytes, 4, 8)).order(ByteOrder.LITTLE_ENDIAN).getInt();
        int nounsIndex = ByteBuffer.wrap(Arrays.copyOfRange(hashBytes, 8, 12)).order(ByteOrder.LITTLE_ENDIAN).getInt();

        byte[] padding = Arrays.copyOfRange(hashBytes, 12, 12 + paddingBytes);

        String adverb = Words.ADVERBS[(int)(Integer.toUnsignedLong(adverbsIndex) % Words.ADVERBS.length)];
        String adjective = Words.ADJECTIVES[(int)(Integer.toUnsignedLong(adjectivesIndex) % Words.ADJECTIVES.length)];
        String noun = Words.NOUNS[(int)(Integer.toUnsignedLong(nounsIndex) % Words.NOUNS.length)];

        return adverb + adjective + noun + Hex.encodeHexString(padding, false);
    }
}
