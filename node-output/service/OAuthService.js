'use strict';


/**
 * Authorization endpoint
 * OpenID Connect authorization endpoint that initiates the authorization flow
 *
 * client_id String Client identifier issued to the client during registration
 * response_type String Must be set to \"code\" for authorization code flow
 * scope List Space-separated list of requested scope values, OFxPERA requires openid to be included to maintain compatibility with OIDC.
 * redirect_uri String URI to return the user to after authorization is complete
 * state String Opaque value to maintain state between request and callback
 * code_challenge String Code challenge for PKCE (optional)
 * code_challenge_method String Code challenge method for PKCE (optional)
 * prompt String Prompt for the authorization request (optional)
 * nonce String Random value used to prevent replay attacks (optional)
 * no response value expected for this operation
 **/
exports.authorizeOAuth = function(client_id,response_type,scope,redirect_uri,state,code_challenge,code_challenge_method,prompt,nonce) {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}


/**
 * Token endpoint
 *
 * returns inline_response_200_1
 **/
exports.getOAuthToken = function() {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "access_token" : "access_token",
  "refresh_token" : "refresh_token",
  "scope" : "scope",
  "id_token" : "id_token",
  "token_type" : "Bearer",
  "expires_in" : 0
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Optional OpenID Connect UserInfo Endpoint
 * OpenID Connect UserInfo Endpoint that returns information about the authenticated user. 
 *
 * returns inline_response_200_3
 **/
exports.getUserInfo = function() {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "sub" : "sub",
  "email_verified" : true,
  "name" : "name",
  "phone_number_verified" : true,
  "phone_number" : "phone_number",
  "given_name" : "given_name",
  "family_name" : "family_name",
  "email" : ""
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Optional token introspection
 * Endpoint for validating and retrieving metadata about an access token. Returns information about whether the token is active, its associated client, user, scopes, and expiration details. This endpoint allows resource servers to verify tokens before granting access to protected resources. 
 *
 * token String 
 * returns inline_response_200_2
 **/
exports.introspectToken = function(token) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "scope" : "scope",
  "active" : true,
  "exp" : 0,
  "iat" : 6,
  "client_id" : "client_id",
  "username" : "username"
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * [Phase 2] PAR-based Authorization API for FI-initiated onboarding
 * POST version of the authorization API that initiates the authorization flow\"
 *
 * body Oauth_auth_body 
 * returns inline_response_200
 **/
exports.oAuthPAR = function(body) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "request_uri" : "http://example.com/aeiou"
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}

