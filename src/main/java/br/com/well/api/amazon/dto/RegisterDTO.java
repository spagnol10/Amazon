package br.com.well.api.amazon.dto;

import br.com.well.api.amazon.model.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
