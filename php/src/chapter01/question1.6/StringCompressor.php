<?php

class StringCompressor {
    public static function compress($original) {
        $originalLength = strlen($original);
        $compressedTokens = [];
        $compressedLength = 0;
        $lastChar = null;
        $sameCharCount = 0;
        for ($i=0; $i<$originalLength; $i++) {
            $char = $original[$i];
            if ($lastChar !== null && $char !== $lastChar) {
                $compressedToken = $lastChar . $sameCharCount;
                $compressedLength += strlen($compressedToken);
                if ($compressedLength >= $originalLength) {
                    return $original;
                }
                $compressedTokens[] = $compressedToken;
                $sameCharCount = 1;
            } else {
                $sameCharCount++;
            }
            $lastChar = $char;
        }
        // if the buffer isn't empty, flush it
        if ($sameCharCount > 0) {
            $compressedToken = $lastChar . $sameCharCount;
            $compressedLength += strlen($compressedToken);
            if ($compressedLength >= $originalLength) {
                return $original;
            }
            $compressedTokens[] = $compressedToken;
        }
        return implode($compressedTokens);
    }
}