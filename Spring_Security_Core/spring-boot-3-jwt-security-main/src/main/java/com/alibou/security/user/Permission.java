package com.alibou.security.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    // ADMIN_READ: This is the enum constant representing the specific permission.
    // "admin:read": This is the string value associated with the ADMIN_READ permission.
    // It follows the format of <resource>:<operation>, where admin represents the resource and read represents the operation.
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    MANAGER_READ("management:read"),
    MANAGER_UPDATE("management:update"),
    MANAGER_CREATE("management:create"),
    MANAGER_DELETE("management:delete")

    ;

    @Getter
    private final String permission;
}
