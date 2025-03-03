'use strict';

var utils = require('../utils/writer.js');
var Discovery = require('../service/DiscoveryService');

module.exports.deleteClientRegistration = function deleteClientRegistration (req, res, next) {
  Discovery.deleteClientRegistration()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.getClientRegistration = function getClientRegistration (req, res, next) {
  Discovery.getClientRegistration()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.getJwks = function getJwks (req, res, next) {
  Discovery.getJwks()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.getOpenIdConfiguration = function getOpenIdConfiguration (req, res, next) {
  Discovery.getOpenIdConfiguration()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.registerClient = function registerClient (req, res, next, body) {
  Discovery.registerClient(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.updateClientRegistration = function updateClientRegistration (req, res, next, body) {
  Discovery.updateClientRegistration(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
