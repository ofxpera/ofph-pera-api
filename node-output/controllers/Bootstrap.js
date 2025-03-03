'use strict';

var utils = require('../utils/writer.js');
var Bootstrap = require('../service/BootstrapService');

module.exports.getParticipant = function getParticipant (req, res, next, participant_id) {
  Bootstrap.getParticipant(participant_id)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.listParticipants = function listParticipants (req, res, next) {
  Bootstrap.listParticipants()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.listProductByParticipant = function listProductByParticipant (req, res, next, participant_id) {
  Bootstrap.listProductByParticipant(participant_id)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.registerParticipant = function registerParticipant (req, res, next, body) {
  Bootstrap.registerParticipant(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.registerProduct = function registerProduct (req, res, next) {
  Bootstrap.registerProduct()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.updateParticipant = function updateParticipant (req, res, next, body) {
  Bootstrap.updateParticipant(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.updateProduct = function updateProduct (req, res, next, product_id) {
  Bootstrap.updateProduct(product_id)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
