package com.nnlight.common;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

public class DigesterUtil {
    public static String digestSHA256(String orinalPwd) {
        Digester sha256 = new Digester(DigestAlgorithm.SHA256);

        return sha256.digestHex(orinalPwd);
    }

    public static void main(String[] args) {
        System.out.println(digestSHA256("adminadmin"));
    }
}
