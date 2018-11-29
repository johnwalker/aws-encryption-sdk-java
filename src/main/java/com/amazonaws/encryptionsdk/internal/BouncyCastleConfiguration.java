package com.amazonaws.encryptionsdk.internal;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;

/**
 * This API is internal and subject to change
 */
public class BouncyCastleConfiguration {
    static final BouncyCastleProvider INTERNAL_BOUNCY_CASTLE_PROVIDER;
    static {
        BouncyCastleProvider bouncyCastleProvider;
        try {
            bouncyCastleProvider = new BouncyCastleProvider();
            Security.addProvider(bouncyCastleProvider);
        } catch (final Throwable ex) {
            bouncyCastleProvider = null;
            // Swallow this error. We'll either succeed or fail later with reasonable
            // stacktraces.
        }
        INTERNAL_BOUNCY_CASTLE_PROVIDER = bouncyCastleProvider;
    }
}
