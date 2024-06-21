package com.stevenbui.flashcode.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess ( final HttpServletRequest request, final HttpServletResponse response,
            final Authentication authentication ) throws ServletException, IOException {
        final boolean isAdmin = authentication.getAuthorities().stream().anyMatch( grantedAuthority -> grantedAuthority
                .getAuthority().equals( "ROLE_ADMIN" ) );

        if ( isAdmin ) {
            setDefaultTargetUrl( "/assortments" );
        }
        else {
            setDefaultTargetUrl( "/assortments" );
        }
        super.onAuthenticationSuccess( request, response, authentication );
    }

}
