package br.com.well.api.amazon.core.domain.dto.auth;

import br.com.well.api.amazon.core.domain.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
