package br.com.well.api.amazon.core.model.dtos.auth;

import br.com.well.api.amazon.core.model.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
