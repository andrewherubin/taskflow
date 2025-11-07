/*
 * AuthResponse - Data Transfer Object for authentication responses.
 */

package io.github.andrewherubin.taskflow.dto;

public class AuthResponse {
    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
