/*
 * OFxPERA API
 * Philippines Open Finance API Implementation for PERA
 *
 * OpenAPI spec version: 0.0.5
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.api;

import io.swagger.client.model.Error;
import io.swagger.client.model.InlineResponse200;
import io.swagger.client.model.InlineResponse2001;
import io.swagger.client.model.InlineResponse2002;
import io.swagger.client.model.InlineResponse2003;
import io.swagger.client.model.OauthAuthBody;
import org.junit.Test;
import org.junit.Ignore;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * API tests for OAuthApi
 */
@Ignore
public class OAuthApiTest {

    private final OAuthApi api = new OAuthApi();

    /**
     * Authorization endpoint
     *
     * OpenID Connect authorization endpoint that initiates the authorization flow
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void authorizeOAuthTest() throws Exception {
        String clientId = null;
        String responseType = null;
        List<String> scope = null;
        String redirectUri = null;
        String state = null;
        String codeChallenge = null;
        String codeChallengeMethod = null;
        String prompt = null;
        String nonce = null;
        api.authorizeOAuth(clientId, responseType, scope, redirectUri, state, codeChallenge, codeChallengeMethod, prompt, nonce);

        // TODO: test validations
    }
    /**
     * Token endpoint
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getOAuthTokenTest() throws Exception {
        String grantType = null;
        String code = null;
        String redirectUri = null;
        String clientId = null;
        String refreshToken = null;
        InlineResponse2001 response = api.getOAuthToken(grantType, code, redirectUri, clientId, refreshToken);

        // TODO: test validations
    }
    /**
     * Optional OpenID Connect UserInfo Endpoint
     *
     * OpenID Connect UserInfo Endpoint that returns information about the authenticated user. 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void getUserInfoTest() throws Exception {
        InlineResponse2003 response = api.getUserInfo();

        // TODO: test validations
    }
    /**
     * Optional token introspection
     *
     * Endpoint for validating and retrieving metadata about an access token. Returns information about whether the token is active, its associated client, user, scopes, and expiration details. This endpoint allows resource servers to verify tokens before granting access to protected resources. 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void introspectTokenTest() throws Exception {
        String token = null;
        InlineResponse2002 response = api.introspectToken(token);

        // TODO: test validations
    }
    /**
     * [Phase 2] PAR-based Authorization API for FI-initiated onboarding
     *
     * POST version of the authorization API that initiates the authorization flow\&quot;
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void oAuthPARTest() throws Exception {
        OauthAuthBody body = null;
        InlineResponse200 response = api.oAuthPAR(body);

        // TODO: test validations
    }
}
