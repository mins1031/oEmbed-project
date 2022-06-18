package com.min.oEmbedproject.v2.oembeded.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlatformResponse<T> {

    T platformOembededResponse;

    public PlatformResponse(T platformOembededResponse) {
        this.platformOembededResponse = platformOembededResponse;
    }
}
