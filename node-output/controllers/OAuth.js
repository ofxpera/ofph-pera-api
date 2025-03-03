'use strict';

var utils = require('../utils/writer.js');
var OAuth = require('../service/OAuthService');

module.exports.authorizeOAuth = function authorizeOAuth (req, res, next, client_id, response_type, scope, redirect_uri, state, code_challenge, code_challenge_method, prompt, nonce) {
  OAuth.authorizeOAuth(client_id, response_type, scope, redirect_uri, state, code_challenge, code_challenge_method, prompt, nonce)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.getOAuthToken = function getOAuthToken (req, res, next) {
  OAuth.getOAuthToken()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.getUserInfo = function getUserInfo (req, res, next) {
  OAuth.getUserInfo()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.introspectToken = function introspectToken (req, res, next, token) {
  OAuth.introspectToken(token)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.oAuthPAR = function oAuthPAR (req, res, next, body) {
  OAuth.oAuthPAR(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
